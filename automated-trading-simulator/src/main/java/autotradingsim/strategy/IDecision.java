package autotradingsim.strategy;

import java.util.Calendar;

/**
 * Created by Asher on 2015-10-29.
 *
 * Contains information about a decision. Tells an {@link autotradingsim.experiment.Experiment Experiment} which
 * action to take.
 *
 */
public interface IDecision {

    Calendar getDate();
    IAction.ActionType getActionType();
    int getQuantity();
    String getStockSymbol();

}
