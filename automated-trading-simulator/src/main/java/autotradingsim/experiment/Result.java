package autotradingsim.experiment;

import autotradingsim.stocks.IStock;
import autotradingsim.strategy.IDecision;
import autotradingsim.strategy.IStrategy;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Asher on 2015-11-18.
 */
public class Result {

    private LocalDate startDate;
    private int duration;
    private Map<String, ArrayList<String>> strategyIDtoStockSymbol;
    private BigDecimal openingBalance;
    private BigDecimal closingBalance;
    private List<ResultDay> resultDays;
    
    public Result(LocalDate startDate, int duration, 
    						Map<String, ArrayList<String>> strategyToStock,
    						BigDecimal opening){
        this.startDate = startDate;
        this.duration = duration;
        this.strategyIDtoStockSymbol = new HashMap<>();
        this.strategyIDtoStockSymbol = strategyToStock;
        this.resultDays = new ArrayList<ResultDay>();
    }

    public void addResultDay(ResultDay resultDay){
    	this.addResultDay(resultDay);
    }
    
    public List<ResultDay> getResultDays(){
    	return this.resultDays;
    }
    
    public BigDecimal getBalanceRelativeChange(){
    	return this.getOpeningBalance().subtract(this.getClosingBalance());
    }
    
    public BigDecimal getBalanceAbsoluteChange(){
    	return (this.getBalanceRelativeChange().divide(this.openingBalance)).multiply((BigDecimal.valueOf(100.00)));
	}
    
    public LocalDate getStartDate(){
    	return this.startDate;
    }
    
    public int getDurationInDays(){
    	return this.duration;
    }
    
    public ArrayList<String> getStockForStrategy(String strategyID){
    	return this.strategyIDtoStockSymbol.get(strategyID);
    }
    
    public BigDecimal getOpeningBalance(){
    	return this.openingBalance;
    }
    
    public BigDecimal getClosingBalance(){
    	return this.closingBalance;
    }
}