package autotradingsim.strategy;

import java.util.List;

/**
 * Created by Asher on 2015-10-30.<br>
 *
 * <p>Classes implementing this interface <b>arrange, validate, and store</b> sets of conditions and actions.</p>
 * <p>Members of this class do *not* produce decisions, but rather produce {@link IDecisionMaker IDecisionMaker}
 * objects to fulfill that responsibility.  Rules are blind to Stocks.</p>
 *
 */
public interface IRule {
    
    /**
     * Produces the decision-making object.<br>
     * (The {@link StrategyTester} should use this to get decisions for specific stocks on specific dates)<br>
     * @return A decision maker.
     */
    IDecisionMaker getDecisionMaker();

    /**
     * Provides a list of conditions for this IRule.
     * @return list of ICondition objects
     */
    List<ICondition> getConditions();

    /**
     * Provides a list of actions in this IRule.
     * @return list of IAction objects
     */
    List<IAction> getActions();

    /**
     * Provides a user-defined description for this IRule
     * @return User-defined description
     */
    String getDescription();

    String getName();

    RuleID getID();

    /**
     * A formalized summary of each of the conditions and actions included in this rule
     * @return
     */
    String getSummary();
}
