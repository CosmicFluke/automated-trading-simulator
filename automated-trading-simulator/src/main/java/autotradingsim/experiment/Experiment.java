package autotradingsim.experiment;

import autotradingsim.application.ITradingApplication;
import autotradingsim.application.TradingApplication;
import autotradingsim.stocks.*;
import autotradingsim.strategy.*;
import autotradingsim.util.Pair;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Asher on 2015-10-25.
 * Contributors: Bill, Shirley, Myung In (Justin)
 *
 * Experiments apply Strategies to particular stocksToShares over a set of time periods.
 *
 * Public Methods:
 *      ...
 *
 * Modifications on 2015-10-30
 * -changes to experiment constructor to include name
 */
public class Experiment implements IExperiment, Serializable {

    private static final long serialVersionUID = -7533956851982543038L;
    private String name;
    private BigDecimal cashBalance;
    private Map<String, Integer> stocksToShares;                // Pair of Stock symbol & its shares for user
    private transient ITradingApplication application;
    
    /**
     * Map<Stock symbol, Pair<startDate, endDate>>
     * Pair:
     * startDate is the IPO date. The first date(ie. IPO) for each Stock in the database.
     * endDate is the last date for each Stock in the database.
     */
    private Map<String, Pair<LocalDate, LocalDate>> stocksToFirstAndLastDate;

    private Set<String> strategies;
    private Map<String, List<String>> strategyToStocks;    // Map<Strategy, List<Stocks>>. One to many

    /**
     * Initialize the experiment constructor.
     * @param name name of the experiment
     */
    public Experiment(String name){
        this.name = name;
        this.stocksToShares = new HashMap<>();
        this.strategies = new HashSet<>();
        this.strategyToStocks = new HashMap<>();
        this.stocksToFirstAndLastDate = new HashMap<>();
        this.cashBalance = new BigDecimal(100000);
        
        this.application = TradingApplication.getInstance();
    }

    public void afterDeserialization() {
        this.application = TradingApplication.getInstance();
    }

    public BigDecimal getCashBalance() {
		return cashBalance;
	}

	public void setCashBalance(BigDecimal cashBalance) {
		this.cashBalance = cashBalance;
	}

	@Override
    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public Map<String, Integer> getStocksToShares() {
        return this.stocksToShares;
    }
    
    public Integer getShares(String stockID){
    	return this.stocksToShares.get(stockID);
    }
    
	public void setShares(String stockID, Integer shares) {
        if(this.stocksToShares.containsKey(stockID)){
            this.stocksToShares.put(stockID, shares);
        }else{
            throw new IllegalArgumentException("Experiment "+this.getName()+" does not contain this stock");
        }

	}

    /**
     * Add Stock symbol to the stocksToShares ArrayList, otherwise throw exception.
     *
     * @param symbol the symbol of a stock
     */
    private void addStock(String symbol){
        if (application.stockExists(symbol)) { // Check for existence of stock in Application
            if (!this.stocksToShares.containsKey(symbol)) {         // Check for existence of stock in this Experiment
                this.stocksToShares.put(symbol, 0);
                LocalDate startDate = application.getStock(symbol).getStartDate();
                LocalDate endDate = application.getStock(symbol).getEndDate();
                this.stocksToFirstAndLastDate.put(symbol, new Pair<>(startDate, endDate));
            }
        } else {
            throw new IllegalArgumentException("Stock symbol does not exist in the database!");
        }

    }
    @Override
    public Map<String, Pair<LocalDate, LocalDate>> getStockStartAndEndDates() {
        return this.stocksToFirstAndLastDate;
    }

    /**
     * Add Strategy id to the strategies List, otherwise throw exception
     * @param name the identifier id of the strategy
     */

    private void addStrategy(String name){
        if(application.getStrategy(name) != null){  //check existing might not be needed if trading application can check first
            strategies.add(name);
        }else{
            throw new IllegalArgumentException("Strategy name has not been defined!");
        }
    }

    @Override
    public Set<IStrategy> getAllStrategies(){
        return this.strategies.stream()     // Return set created from mapped stream of strategy names
                .map(name -> application.getStrategy(name))
                .collect(Collectors.toSet());
    }

    @Override
    public Set<IStock> getAllStocks(){
        return this.stocksToShares.keySet().stream()    // Return set created from mapped stream of stock names
                .map(symbol -> application.getStock(symbol))
                .collect(Collectors.toSet());
    }

    public void addTrial(String id, String symbol){

        if (application.getStock(symbol) == null) {
            throw new IllegalArgumentException("symbol is not in the database!");
        }

        if(!strategyToStocks.containsKey(id)){
            // strategy id does not exist
            this.addStrategy(id);
            this.addStock(symbol);
            this.strategyToStocks.put(id, new ArrayList<>(Collections.singletonList(symbol)));
        } else {
            this.addStock(symbol);
            this.strategyToStocks.get(id).add(symbol);
        }
    }

    @Override
    public Map<String, List<String>> getAllTrials() {
        return Collections.unmodifiableMap(strategyToStocks);
    }

    /**
     * Run the Experiment for the TradingApplication.
     * @param ts a time set
     * @return ArrayList<Result> for each TimeSet ts. Result is obtained for each TimeSet ts.
     */
    @Override
    public ExperimentResults runExperiment(TimeSet ts) {
        List<Result> resultList = new ArrayList<>();
        ExperimentResults experimentResults = new ExperimentResults(ts);
        
        // Save for restoring later
        BigDecimal startingBalance = getCashBalance();

        while (ts.hasNext()) { // For each TimeSet
        	LocalDate startDate = ts.next();
            LocalDate endDate = startDate.plusDays(ts.getDuration());
            
            Result result = new Result(startDate, ts.getDuration(), strategyToStocks, getCashBalance());
            result.addObserver(experimentResults);
            
            for(LocalDate currDate = startDate ; currDate.isBefore(endDate) ; currDate = currDate.plusDays(1)){
                ResultDay resultDay = new ResultDay(currDate, getCashBalance());

                for (Map.Entry<String, List<String>> entry : strategyToStocks.entrySet()) {    // For each strategy
                	IStrategy strategy = application.getStrategy(entry.getKey());

                    List<String> stocks = entry.getValue();
                    for (String stockID : stocks) {
                        
                    	IStrategyTester st = strategy.getNewTester();
                        st.setAll(application.getStock(stockID));
                        List<IDecision> decisions = st.testDate(currDate);
                        applyDecisions(decisions, resultDay);
                    }
                }
                
                result.addResultDay(resultDay);
                result.addStockstoToShares(stocksToShares);
            }
            result.setClosingBalance(getCashBalance());
            experimentResults.addResults(result);            
            
            
            // Reset to give next result a fresh start
            this.resetStockQuantity();
            setCashBalance(startingBalance);
            
        }
        return experimentResults;
    }

	private void applyDecisions(List<IDecision> decisions, ResultDay resultDay) {
		for (IDecision decision : decisions) { // For Each decision
			
			String stockID = decision.getStockSymbol();
			
			IStock stockObject = application.getStock(stockID);
			BigDecimal closingValue = stockObject.getDay(resultDay.getDate()).getValue();
			
			BigDecimal deltaShares = new BigDecimal(decision.getQuantity(getCashBalance(), getShares(stockID)));
			BigDecimal transactionValue = closingValue.multiply(deltaShares);
			
			switch(decision.getActionType())
			{
			case BUY:
				if(transactionValue.compareTo(cashBalance) < 0)
					deltaShares = transactionValue.remainder(cashBalance); // Clamp value to buying power
				
				setCashBalance(cashBalance.subtract(transactionValue));
				setShares(stockID, getShares(stockID) + deltaShares.intValue());
				break;
			
			case SELL:
				if(deltaShares.compareTo( new BigDecimal(getShares(stockID))) > 0)
					deltaShares = new BigDecimal(getShares(stockID)); // Clamp shares
				
				setCashBalance(cashBalance.add(transactionValue));
				setShares(stockID, getShares(stockID) - deltaShares.intValue());
				break;
				
			default:
				throw new RuntimeException("Invalid decision action type");	
			}
			
			resultDay.addDecision(decision);
			
			// shares based on decision stock ID
			resultDay.setNumShares(stockID, getShares(stockID));
		}
		// Update the closing balance of the result day
		resultDay.setClosingBalance(getCashBalance());
	}

    public void resetStockQuantity(){
        for (String key: this.stocksToShares.keySet()){
            this.stocksToShares.put(key, 0);
        }
    }

}