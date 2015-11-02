package autotradingsim.strategy;

import autotradingsim.stocks.IStock;

import java.util.Calendar;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Asher on 2015-10-29.
 *
 * IDecisionMakers make decisions for a given data set at a given time.  They produce collections of IDecision objects,
 * which tell collaborators which actions to take.
 *
 */
public interface IDecisionMaker {

    /**
     * This map can be used when deciding which stocks to assign to which rules.
     *
     * @return Map where keys are rule IDs and values are string descriptions of the corresponding strategies
     */
    Map<RuleID, String> getRules();

    /**
     * Assign a stock to the rule corresponding to the given rule ID.  Use {@link #getRules() getRules} for a map
     * containing the rules associated with this IDecisionMaker.
      * @param id Unique ID of the rule to which Stock will be assigned.
     * @param stock The Stock to assign to the given rule.
     */
    void assignStock(RuleID id, IStock stock);

    /**
     * Once stocks are assigned, this can be used to get an iterator that provides a list of
     * {@link IDecision IDecisions} for a given date.
     * @return A decision for this DecisionMaker.
     */
    Iterator<IDecision> getDecisions(Calendar date);

}
