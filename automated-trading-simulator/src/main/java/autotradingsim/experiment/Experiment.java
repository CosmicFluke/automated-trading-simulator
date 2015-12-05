package autotradingsim.experiment;

import autotradingsim.application.TradingApplication;
import autotradingsim.stocks.*;
import autotradingsim.strategy.*;
import autotradingsim.strategy.rules.IAction;
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
    private Map<String, Integer> stocksToShares;                // Pair of Stock symbol & its shares for user

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

    /**
     * Add Stock symbol to the stocksToShares ArrayList, otherwise throw exception.
     *
     * @param symbol the symbol of a stock
     */
    private void addStock(String symbol){
        if (TradingApplication.getInstance().stockExists(symbol)) { // Check for existence of stock in Application
            if (!this.stocksToShares.containsKey(symbol)) {         // Check for existence of stock in this Experiment
                this.stocksToShares.put(symbol, 0);
                LocalDate startDate = TradingApplication.getInstance().getStock(symbol).getStartDate();
                LocalDate endDate = TradingApplication.getInstance().getStock(symbol).getEndDate();
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
        if(TradingApplication.getInstance().getStrategy(name) != null){  //check existing might not be needed if trading application can check first
            strategies.add(name);
        }else{
            throw new IllegalArgumentException("Strategy name has not been defined!");
        }
    }

    @Override
    public Set<IStrategy> getAllStrategies(){
        return this.strategies.stream()     // Return set created from mapped stream of strategy names
                .map(name -> TradingApplication.getInstance().getStrategy(name))
                .collect(Collectors.toSet());
    }

    @Override
    public Set<IStock> getAllStocks(){
        return this.stocksToShares.keySet().stream()    // Return set created from mapped stream of stock names
                .map(symbol -> TradingApplication.getInstance().getStock(symbol))
                .collect(Collectors.toSet());
    }

    public void addTrial(String id, String symbol){

        if (TradingApplication.getInstance().getStock(symbol) == null) {
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
        ExperimentResults experimentResults = new ExperimentResults();
        IStrategy strategy;
        IStrategyTester st;
        IStock stock;

        // currentDate is set for each day from startDate in TimeSet for the length of duration
        LocalDate currentDate;
        LocalDate experimentStartDate;
        int duration;

        List<IDecision> decisions;
        IDecision decision;

        BigDecimal balance;
        int shares;

        while (ts.hasNext()) { // For each TimeSet
            experimentStartDate = ts.next();
            currentDate = experimentStartDate;
            duration = ts.getDuration();
            balance = BigDecimal.valueOf(100000);
            Result result = new Result(experimentStartDate, duration, strategyToStocks, balance);
//            System.out.println("trial: " + a);

            while (currentDate.isBefore(experimentStartDate.plusDays(duration))) {  // For each Day
                ResultDay resultDay = new ResultDay(currentDate, balance, balance);

                for (Map.Entry<String, List<String>> entry : strategyToStocks.entrySet()) {    // For each strategy
                    strategy = TradingApplication.getInstance().getStrategy(entry.getKey());

                    for (int i = 0; i < entry.getValue().size(); i++) {     // For each Stock
                        shares = 0;
                        stock = TradingApplication.getInstance().getStock(entry.getValue().get(i));
                        st = strategy.getNewTester();
                        st.setAll(stock);
//                        stock.getDay(currentDate);
//                        if (stock == null) {
                        decisions = st.testDate(currentDate);
                        Iterator<IDecision> decisionIter = decisions.iterator();
//                        System.out.println("Stock price " + stock.getDay(currentDate).getValue().toString() + " on " + currentDate.toString());
                        while (decisionIter.hasNext()) {        // For Each decision
                            decision = decisionIter.next();
                            resultDay.addDecision(decision);

                            if (decision.getActionType() == IAction.ActionType.BUY) {
                                // Buy Stocks for
                                shares = decision.getQuantity(balance, 0);
                                balance = balance.subtract(stock.getDay(currentDate).getValue().multiply(new BigDecimal(shares)));
                                this.stocksToShares.put(stock.getSymbol(), this.stocksToShares.get(stock.getSymbol()) + shares);
                                resultDay.setNumShares(stock.getSymbol(), this.stocksToShares.get(stock.getSymbol()) + shares);
//                                System.out.println("Bought shares : " + shares);
                            } else if (decision.getActionType() == IAction.ActionType.SELL) {
                                shares = decision.getQuantity(balance, 0);
                                if (shares > this.stocksToShares.get(stock.getSymbol())){
                                	shares = this.stocksToShares.get(stock.getSymbol());
                                	
                                }
                                this.stocksToShares.put(stock.getSymbol(), this.stocksToShares.get(stock.getSymbol()) - shares);
                                resultDay.setNumShares(stock.getSymbol(), this.stocksToShares.get(stock.getSymbol()) - shares);
                                balance = balance.add(stock.getDay(currentDate).getValue().multiply(new BigDecimal(shares)));

//                                System.out.println("Sold shares : " + shares);
                            }
                            
                        }
                        resultDay.setClosingBalance(balance);
                        result.addResultDay(resultDay);
                        result.addStockstoToShares(this.stocksToShares);
                    }
                }
                currentDate = currentDate.plusDays(1);
            }
            result.setClosingBalance(balance);
            experimentResults.addResults(result);
            this.resetStockQuantity();
        }
        return experimentResults;
    }

public void resetStockQuantity(){
	for (String key: this.stocksToShares.keySet()){
		this.stocksToShares.put(key, 0);
	}
}

//
//            // Go through all the trials, test each one. Output a chunk of results to file for each trial
//            for(int i  = 0; i < trials.size(); i++){
//                strategy = TradingApplication.getInstance().getStrategy(strategies.get(trials.get(i)[0]));
//                stock = TradingApplication.getInstance().getStock(stocksToShares.get(trials.get(i)[1]));
//                st = strategy.getNewTester();
//                st.setAll(stock);
//                duration = ts.getDuration();

                // Run once for every time snippet in the time set
//                while(ts.hasNext()){
//                    currentDate = ts.next();
//
//                    bw.write(name);
//                    bw.newLine();
//                    bw.write(stock.getSymbol());
//                    bw.newLine();
//                    bw.write(currentDate.toString());
//                    bw.newLine();
//
//                    balance = new BigDecimal(0);
//                    shares = 0;
//
//                    // Iterate through all the days in the time snippet
//                    for(int j = 0; j < duration; j++) {
//                        decisions = st.testDate(currentDate);
//                        Iterator<IDecision> itr = decisions.iterator();
//
//                        bw.write(balance.toString());
//                        bw.write("," + shares);
//
//                        while(itr.hasNext()){
//                            decision = (IDecision)itr.next();
//                            if(decision.getActionType() == IAction.ActionType.BUY){
//                                shares += decision.getQuantity();
//                                balance.subtract(stock.getDay(currentDate).getValue().multiply(new BigDecimal(shares)));
//                            }else if(decision.getActionType() == IAction.ActionType.SELL){
//                                shares -= decision.getQuantity();
//                                balance.add(stock.getDay(currentDate).getValue().multiply(new BigDecimal(shares)));
//                            }
//
//                            bw.write("," + decision.getActionType().toString() + "-" + decision.getQuantity());
//                        }
//                        bw.newLine();
//                        currentDate = currentDate.plusDays(1);
//                    }
//                    bw.newLine();
//                }
//            }
//
//        }catch(IOException e){
//            System.out.println(e);
//        }
//    }

//    public boolean runExperiment(){
//        try{
//            // Create the file writer with the given file ID as the name
//            BufferedWriter bw = new BufferedWriter(new FileWriter(System.getProperty("user.dir") + "/automated-trading-simulator/src/main/resources/DATA/RESULTS/" + name + ".txt"));
//
//            IStrategy strategy;
//            IStrategyTester st;
//            IStock stock;
//            LocalDate currentDate;
//            List<IDecision> decisions;
//            int duration;
//            IDecision decision;
//
//            BigDecimal balance;
//            int shares;
//
//            // Go through all the trials, test each one. Output a chunk of results to file for each trial
//            for(int[] trial: trials){
//                strategy = TradingApplication.getInstance().getStrategy(strategies.get(trial[0]));
//                stock = TradingApplication.getInstance().getStock(stocksToShares.get(trial[1]));
//                st = strategy.getNewTester();
//                st.setAll(stock);
//
//                currentDate = stock.getStartDate();
//                bw.write(strategy.getName()); bw.newLine();
//                bw.write(stock.getSymbol()); bw.newLine();
//                bw.write(currentDate.toString());
//                bw.newLine();
//
//                balance = new BigDecimal(100000);
//                shares = 0;
//
//                while(currentDate.isBefore(stock.getEndDate())){
//                    decisions = st.testDate(currentDate);
//                    Iterator itr = decisions.iterator();
//
//                    bw.write(currentDate.toString());
//                    bw.write("," + balance.toString());
//                    bw.write("," + shares);
//
//                    while(itr.hasNext()){
//                        decision = (IDecision)itr.next();
//                        if(decision.getActionType() == IAction.ActionType.BUY){
//                            shares += decision.getQuantity();
//                            balance = balance.subtract(stock.getDay(currentDate).getValue().multiply(new BigDecimal(shares)));
//                        }else if(decision.getActionType() == IAction.ActionType.SELL){
//                            shares -= decision.getQuantity();
//                            balance = balance.add(stock.getDay(currentDate).getValue().multiply(new BigDecimal(shares)));
//                        }
//
//                        bw.write("," + decision.getActionType().toString() + "-" + decision.getQuantity());
//                    }
//                    bw.newLine();
//                    currentDate = currentDate.plusDays(1);
//                }
//                bw.newLine();
//            }
//
//        }catch(IOException e){
//            System.out.println(e);
//            return false;
//        }
//        return true;
//    }
}