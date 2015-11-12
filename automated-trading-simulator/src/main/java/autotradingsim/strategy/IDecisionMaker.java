package autotradingsim.strategy;

import autotradingsim.stocks.IStock;

import java.util.Calendar;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Asher on 2015-10-29.
 *
 * IDecisionMakers make decisions by applying a rule to a given data set at a given time.  They produce
 * collections of IDecision objects, which tell collaborators which actions to take.
 *
 */
public interface IDecisionMaker {

    /**
     * Assign a stock to the rule.
     * @param stock The Stock to assign to the given rule.
     */
    void assignStock(IStock stock);

    /**
     * Indicates whether this decision maker has a stock assigned
     * @return true iff a stock is assigned to this IDecisionMaker
     */
    boolean hasStockAssigned();

    /**
     * Once stocks are assigned, this can be used to get an iterator that provides a list of
     * {@link IDecision IDecisions} for a given date.
     * @return A decision for this DecisionMaker.
     */
    Iterator<IDecision> getDecisions(Calendar date);

}
