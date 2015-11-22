package autotradingsim.strategy;

import autotradingsim.stocks.IStock;

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
    public final IStock IStock;
    public final IActionQuantity quantity;


    public Decision(LocalDate date, IAction.ActionType type, IStock IStock, IActionQuantity quantity,
                    IRule ruleSource) {
        this.date = date;
        this.type = type;
        this.IStock = IStock;
        this.quantity = quantity;
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
        return this.quantity.getValue(balance);
    }

    @Override
    public String getStockSymbol() {
        return this.IStock.getSymbol();
    }

    @Override
    public String getRuleSource() {
        return this.rule;
    }
}
