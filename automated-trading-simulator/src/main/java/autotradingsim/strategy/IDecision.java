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

    /**
     * <p>Get the quantity of shares associated with this decision.  The quantity may be implemented as a function of
     * cashBalance and numShares.</p>
     * @param cashBalance The current cash balance at the time the decision is made
     * @param numShares The number of shares currently owned at the time the decision is made (of the stock in
     * {@link #getStockSymbol()})
     * @return
     */
    int getQuantity(BigDecimal cashBalance, int numShares);
    String getStockSymbol();
    String getRuleSource();

}
