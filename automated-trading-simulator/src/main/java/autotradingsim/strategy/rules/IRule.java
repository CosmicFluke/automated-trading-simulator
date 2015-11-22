package autotradingsim.strategy.rules;

import autotradingsim.strategy.StrategyTester;

import java.util.List;

/**
 * Created by Asher on 2015-10-30.<br>
 *
 * <p>Classes implementing this interface <b>arrange, validate, and store</b> sets of conditions and actions.</p>
 * <p>Members of this class do *not* produce decisions, but rather produce {@link IDecisionMaker IDecisionMaker}
 * objects to fulfill that responsibility.<br>
 * The actual ICondition and IAction objects contained in an IRule are not mutable, and thus can be accessed directly
 * through the {@link #getConditions()} and {@link #getActions()} methods.  However, in any implementation of IRule,
 * the Collections returned should not themselves be mutable.<br>
 * Rules are blind to Stocks.</p>
 *
 */
public interface IRule {
    
    /**
     * Produces a decision-making object for this rule.<br>
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
     * Add an action to this rule.
     * @param action
     */
    void addAction(IAction action);

    /**
     * Add a condition to this rule.
     * @param condition
     */
    void addCondition(ICondition condition);

    /**
     * Remove the specified action from this rule.
     * @param action
     */
    void removeAction(IAction action);

    /**
     * Remove the specified condition from this rule.
     * @param condition
     */
    void removeCondition(IAction condition);

    void setConfidenceThreshold(double thresh);

    double getConfidenceThreshold();

    /**
     * Provides a user-defined description for this IRule.  If no description was given, returns the default description.
     * @return User-defined description
     */
    String getDescription();

    /**
     * Returns a name for this rule.  If no name was given, returns a default name.
     * @return
     */
    String getName();

    /**
     * RuleIDs are used to get information about rules from Strategies.  They should be initialized in 
     * @return
     */
    RuleID getID();

    /**
     * A formalized summary of each of the conditions and actions included in this rule
     * @return
     */
    String getSummary();

    void setName(String name);

    void setDescription(String description);
}
