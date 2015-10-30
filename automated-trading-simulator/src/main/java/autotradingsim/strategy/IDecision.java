package autotradingsim.strategy;

import java.util.Calendar;

/**
 * Created by Asher on 2015-10-29.
 *
 * Contains information about a decision
 *
 */
public interface IDecision {

    public Calendar getDate();
    public IAction.ActionType getActionType();
    public int getQuantity();
    public String getStockSymbol();

}
