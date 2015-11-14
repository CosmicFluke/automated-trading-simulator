package autotradingsim.strategy;

import autotradingsim.stocks.IStock;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Calendar;

/**
 * Created by Asher on 2015-10-30.
 *
 * Implementing IDecision
 *
 */
public class Decision implements IDecision {

    private LocalDate date;
    private IAction.ActionType type;
    private IStock IStock;
    private IActionQuantity quantity;


    public Decision (LocalDate date, IAction.ActionType type, IStock IStock, IActionQuantity quantity) {
        this.date = date;
        this.type = type;
        this.IStock = IStock;
        this.quantity = quantity;
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
    public int getQuantity() {
        return this.quantity.getValue();
    }

    public int getQuantity(BigDecimal balance) {
        return this.quantity.getValue(balance);
    }

    @Override
    public String getStockSymbol() {
        return this.IStock.getSymbol();
    }
}
