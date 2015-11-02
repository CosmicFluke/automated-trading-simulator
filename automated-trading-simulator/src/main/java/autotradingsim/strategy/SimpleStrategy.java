package autotradingsim.strategy;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * <p>Created by Asher on 2015-11-01.</p>
 *
 * <p>A simple IStrategy implementation for testing and MVP.  This is a read-only strategy --
 * attempting to add or remove rules will result in a NotImplementedException being thrown.</p>
 */
public class SimpleStrategy implements IStrategy {

    private IRule rule;
    private static String name = "Built-in Strategy 1 (Read-Only)";
    private static String description = "Simple read-only strategy that buys when a stock price is less than 100";

    public SimpleStrategy () {
        this.rule = new SimpleRule(
                new SimpleCondition(ICondition.Comparator.LEQ, new BigDecimal(100)),
                new SimpleAction(IAction.ActionType.BUY, 10));
    }

    @Override
    public Set<RuleID> getRules() {
        Set<RuleID> rules = new HashSet<>();
        rules.add(rule.getRuleID());
        return rules;
    }

    @Override
    public void addRule(IRule rule) {
        throw new NotImplementedException();
    }

    @Override
    public void deleteRule(RuleID rule) {
        throw new NotImplementedException();
    }

    @Override
    public String getRuleName(RuleID rule) {
        return (rule == this.rule.getRuleID()) ? this.rule.getDescription() : null;
    }

    @Override
    public String getRuleDescription(RuleID rule) {
        return (rule == this.rule.getRuleID()) ? this.rule.getDescription() : null;
    }

    @Override
    public String getRuleSummary(RuleID rule) {
        return (rule == this.rule.getRuleID()) ? this.rule.getSummary() : null;
    }

    @Override
    public IDecisionMaker getRuleDecisionMaker(RuleID rule) {
        return (rule == this.rule.getRuleID()) ? this.rule.getDecisionMaker() : null;
    }

    @Override
    public StrategyTester getNewTester() {
        return new SimpleStrategyTester((IStrategy) this);
    }

    @Override
    public int getID() {
        return name.hashCode();
    }
}
