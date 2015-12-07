package autotradingsim.experiment;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Asher on 2015-11-18.
 */
public class Result implements Serializable{

	private static final long serialVersionUID = -6024793813081336526L;
	private LocalDate startDate;
    private int duration;
    // One-to-many relationships. (ie. One strategy for multiple Stock symbol.
    private Map<String, List<String>> strategyIDtoStockSymbol;
    private BigDecimal openingBalance;
    private BigDecimal closingBalance;
    private List<ResultDay> resultDays;
    private List<Map<String, Integer>> stocksToShares;

    private ExperimentResults observer;

    /**
     * Result is the output from each TimeSet from runExperiment
     * @param startDate
     * @param durationInDays
     * @param strategyToStock : Map<String, ArrayList<String>> of Strategy ID to List of Stock symbols.
     * @param openingBalance
     */
    public Result(LocalDate startDate, int durationInDays,
                  Map<String, List<String>> strategyToStock,
                  BigDecimal openingBalance){
    	if (openingBalance.compareTo(BigDecimal.ZERO)<= 0){
    		throw new IllegalArgumentException("Opening Balance cannot be 0 or less");
    	}
        this.startDate = startDate;
        this.duration = durationInDays;
        this.strategyIDtoStockSymbol = strategyToStock;
        this.openingBalance = openingBalance;
        this.resultDays = new ArrayList<ResultDay>();
        this.stocksToShares = new ArrayList<Map<String, Integer>>();

    }

    public void addStockstoToShares(Map<String, Integer> stocksToShares) {
    	this.stocksToShares.add(stocksToShares); 
    }

    public void addObserver(ExperimentResults experimentResults) {
        this.observer = experimentResults;
    }

    public void addResultDay(ResultDay resultDay){

        this.resultDays.add(resultDay);
        // Notify the ExperimentResults Class whenever ResultDay is added to Result
        // (i.e. When there are potential changes in # of stocks, ending cash balance, # of buy/sell actions
        this.observer.onUpdate(this, resultDay);
    }
    
    public List<ResultDay> getResultDays(){
    	return this.resultDays;
    }
    
    /**
     * 
     * @return BigDecimal: Value difference between opening and closing balances for whole set of resultDays.
     */
    public BigDecimal getBalanceRelativeChange(){
    	return this.getClosingBalance().subtract(getOpeningBalance());
    }
    
    /**
     * 
     * @return BigDecimal: Percentage difference between opening and closing balances for whole set of resultDays.
     */
    public BigDecimal getBalanceAbsoluteChange(){
    	return (this.getBalanceRelativeChange().divide(this.openingBalance)).multiply((BigDecimal.valueOf(100.00)));
	}
    
    public LocalDate getStartDate(){
    	return this.startDate;
    }
    
    public int getDurationInDays(){
    	return this.duration;
    }
    
    public LocalDate getEndDate(){
    	return this.startDate.plusDays(this.duration);
    }
    
    /**
     * 
     * @param strategyID
     * @return ArrayList<String>: List of stock symbols using this strategyID
     * @throws NullPointerException: If strategyID is null
     * @throws IllegalArgumentException: If strategyID does not exist in Result
     */
    public List<String> getStockForStrategy(String strategyID){
    	return this.strategyIDtoStockSymbol.get(strategyID);
    }
    
    public BigDecimal getOpeningBalance(){
    	return this.openingBalance;
    }
    
    public BigDecimal getClosingBalance(){
    	return this.closingBalance;
    }

    public void setClosingBalance(BigDecimal closingBalance) {
        this.closingBalance = closingBalance;
    }
}