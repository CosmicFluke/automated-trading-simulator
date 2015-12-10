package autotradingsim.strategy;

import autotradingsim.application.TradingApplication;
import autotradingsim.stocks.StockDay;
import autotradingsim.strategy.rules.ConfidenceFactor;
import autotradingsim.strategy.rules.IAction;
import autotradingsim.strategy.rules.IActionQuantity;
import autotradingsim.strategy.rules.IRule;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Created by Asher on 2015-10-30.
 *
 * Implementing IDecision
 *
 */
public class Decision implements IDecision {

    public final String rule;
    public final LocalDate date;
    public final IAction.ActionType type;
    public final String stockSymbol;
    public final IActionQuantity quantity;
    public final ConfidenceFactor confidence;


    public Decision(LocalDate date, IAction.ActionType type, String stockSymbol, IActionQuantity quantity,
                    ConfidenceFactor confidenceFactor, IRule ruleSource) {
        this.date = date;
        this.type = type;
        this.stockSymbol = stockSymbol;
        this.quantity = quantity;
        this.confidence = confidenceFactor;
        this.rule = ruleSource.getName();
    }

    @Override
    public LocalDate getDate() {
        return this.date;
    }

    @Override
    public IAction.ActionType getActionType() {
        return this.type;
    }

    @Override
    public int getQuantity(BigDecimal cashBalance, int numShares) {
        return this.quantity.getValue(cashBalance, getStockValue(), numShares, confidence);
    }

    @Override
    public String getStockSymbol() {
        return stockSymbol;
    }

    @Override
    public String getRuleSource() {
        return this.rule;
    }

    public BigDecimal getStockValue() {
        if (TradingApplication.getInstance().getStock(stockSymbol) == null){
            throw new NullPointerException(
                    String.format("Decision was given invalid stock symbol: '%s' not found in Application",
                            stockSymbol));
        }
        return TradingApplication.getInstance().getStock(stockSymbol).getDay(date).getValue(StockDay.Values.CLOSE);
    }
    
    @Override
    public String toString(){
    	String actionType = "";
    	switch(this.type){
    	case BUY:
    		actionType = "BUY";
    		break;
    		
    	case SELL:
    		actionType = "SELL";
    		break;
    	
    	case SHORT:
    		actionType = "SHORT";
    		break;
    	
    	case COVER:
    		actionType = "COVER";
    		break;
    	default:
    		throw new IllegalArgumentException("type unsupported by toString");
    	}
    	return actionType + " " + this.stockSymbol;
    }
}
