package autotradingsim.strategy;

import autotradingsim.strategy.exceptions.DuplicateEntryException;
import autotradingsim.strategy.exceptions.RuleDoesNotExistException;
import autotradingsim.strategy.simpleimpl.SimpleAction;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * <p>Created by Asher on 2015-10-30.<br>
 * Work-in-progress</p>
 *
 * <p>More sophisticated implementation of the IStrategy interface.  Supports multiple rules.</p>
 * <p>Rules may be added directly.  All information about rules in a strategy must be accessed using RuleIDs.
 * Rule objects cannot be accessed directly, nor modified.  Rules may be removed using their RuleID as well, and
 * removal will return the rule.</p>
 * <p>To modify a rule, remove it from the strategy and re-add it once it has been modified.</p>
 *
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
        if (rules.containsKey(rule.getID())) {
            throw new DuplicateEntryException();
        }
        this.rules.put(rule.getID(), rule);
    }

    @Override
    public IRule removeRule(RuleID rule) {
        if (! this.rules.containsKey(rule)) {
            throw new RuleDoesNotExistException();
        }
        return this.rules.remove(rule);

    }

    @Override
    public String getRuleName(RuleID rule) {
        return this.rules.get(rule).getName();
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
