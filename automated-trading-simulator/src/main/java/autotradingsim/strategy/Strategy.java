package autotradingsim.strategy;

import autotradingsim.strategy.exceptions.DuplicateEntryException;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Asher on 2015-10-30.
 */
public class Strategy implements IStrategy {

    private Map<RuleID, IRule> rules;
    private String name;
    private String description;
    private static String defaultDescription = "This is a strategy.";

    @Override
    public Set<RuleID> getRules() {
        return new HashSet<>(this.rules.keySet());
    }

    @Override
    public void addRule(IRule rule) {
        if (rules.containsKey(rule.getRuleID())) {
            throw new DuplicateEntryException();
        }
    }

    @Override
    public void deleteRule(RuleID rule) {

    }

    @Override
    public String getRuleName(RuleID rule) {
        return null;
    }

    @Override
    public String getRuleDescription(RuleID rule) {
        return null;
    }

    @Override
    public String getRuleSummary(RuleID rule) {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public IDecisionMaker getRuleDecisionMaker(RuleID rule) {
        return null;
    }

    @Override
    public StrategyTester getNewTester() {
        return null;
    }

    // NOTHING TO SEE HERE

}
