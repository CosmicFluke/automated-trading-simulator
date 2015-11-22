package autotradingsim.strategy;

import autotradingsim.stocks.IStock;
import autotradingsim.stocks.StockDay;

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
    public final IStock stock;
    public final IActionQuantity quantity;
    public final BigDecimal stockValue;
    public final IActionQuantity.ConfidenceFactor confidence;


    public Decision(LocalDate date, IAction.ActionType type, IStock IStock, IActionQuantity quantity,
                    IActionQuantity.ConfidenceFactor confidenceFactor, IRule ruleSource) {
        this.date = date;
        this.type = type;
        this.stock = IStock;
        this.stockValue = stock.getDay(date).getValue(StockDay.Values.CLOSE);
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
    public int getQuantity(BigDecimal balance) {
        return this.quantity.getValue(balance, stockValue, confidence);
    }

    @Override
    public String getStockSymbol() {
        return this.stock.getSymbol();
    }

    @Override
    public String getRuleSource() {
        return this.rule;
    }
}
