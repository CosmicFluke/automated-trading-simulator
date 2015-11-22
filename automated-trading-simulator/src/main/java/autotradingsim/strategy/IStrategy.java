package autotradingsim.strategy;

import autotradingsim.strategy.rules.IDecisionMaker;
import autotradingsim.strategy.rules.IRule;
import autotradingsim.strategy.rules.RuleID;

import java.util.Set;

/**
 *  <p>A data type that stores a collection of rules.<br>
 *  Each Strategy instance represents a well-defined strategy.  Collaborators that want to *apply* strategies must use
 *  the getNewTester() method to get a StrategyTester object.</p>
 */
public interface IStrategy {

    /**
     * <p>Provides a set containing an ID for each rule in this strategy.  Use the getRule...() functions to get information about each rule ID.</p>
     * @return Set of RuleIDs associated with this Strategy
     */
    Set<RuleID> getRules();

    /**
     * Add a rule to this strategy.
     * @param rule
     */
    void addRule(IRule rule);

    /**
     * Delete a rule from this strategy
     * @param rule ID of the rule to be deleted.
     */
    IRule removeRule(RuleID rule);


    /**
     * User-entered string that uniquely identifies this strategy.
     * Any two strategies with the same name should have the same ID (see {@link #})
     * @param rule
     * @return
     */
    String getRuleName(RuleID rule);
    String getRuleDescription(RuleID rule);
    String getRuleSummary(RuleID rule);

    /**
     * Gets this IStrategy's name.  Names must be under 16 characters and can only use letters and numbers.<br>
     * TODO: Requirements not verified.
     * @return
     */
    String getName();

    String getDescription();

    IDecisionMaker getRuleDecisionMaker(RuleID rule);

    /**
     * Provides a new {@link StrategyTester} instance linked to this strategy. (Use this to run experiments with this strategy)
     * @return
     */
    StrategyTester getNewTester();

    /**
     * Get an integer identifier for this strategy.  Strategies with the same name will have the same ID.
     * @return
     */
    int getID();


}
