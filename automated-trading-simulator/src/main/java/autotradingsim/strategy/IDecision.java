package autotradingsim.strategy;

import autotradingsim.strategy.rules.IAction;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Created by Asher on 2015-10-29.
 *
 * Contains information about a decision. Tells an {@link autotradingsim.experiment.Experiment Experiment} which
 * action to take.
 *
 */
public interface IDecision {

    LocalDate getDate();
    IAction.ActionType getActionType();
    int getQuantity(BigDecimal balance);
    String getStockSymbol();
    String getRuleSource();

}
