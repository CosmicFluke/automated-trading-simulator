package autotradingsim.strategy;

import autotradingsim.stocks.IStock;
import autotradingsim.strategy.rules.RuleID;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by Asher on 2015-12-03.
 */
public interface IStrategyTester {
    /**
     * Get the strategy ID associated with this tester.
     * @return
     */
    String getStrategy();

    /**
     * Set all rules to evaluate using the given stock.
     * @param stock
     */
    void setAll(IStock stock);

    /**
     * Assigns the given stock to only the rules in the strategy associated with this tester
     * <i>which do not currently have a stock assigned.</i>
     * @param stock The stock to be assigned to each available rule
     */
    void setAllUnset(IStock stock);

    /**
     * Assigns a stock to only the specified rule.
     * @param ruleID ID of the rule to assign a stock to
     * @param stock Stock to assign to the given rule
     */
    void setStockForRule(RuleID ruleID, IStock stock);

    /**
     * Produces a list of rules (by RuleID) which have no stock assigned for evaluation.
     * @return
     */
    List<RuleID> getUnassignedRules();

    /**
     * Get a set of decisions from this strategy for a given date.
     * @param currentDate
     * @return
     */
    List<IDecision> testDate(LocalDate currentDate);
}
