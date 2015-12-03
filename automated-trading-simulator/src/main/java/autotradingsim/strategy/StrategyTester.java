package autotradingsim.strategy;

import autotradingsim.stocks.IStock;
import autotradingsim.strategy.rules.RuleID;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by Asher on 2015-12-03.
 */
public interface StrategyTester {
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
     * Set only the rules without a stock assigned to evaluate using the given stock.
     * @param stock
     */
    void setAllUnset(IStock stock);

    /**
     * Set only the specified rule to evaluate using the given stock.
     * @param ruleID
     * @param stock
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
