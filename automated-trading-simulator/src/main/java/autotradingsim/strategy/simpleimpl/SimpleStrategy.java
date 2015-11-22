package autotradingsim.strategy.simpleimpl;

import autotradingsim.strategy.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.security.InvalidParameterException;
import java.util.HashSet;
import java.util.Set;

/**
 * <p>Created by Asher on 2015-11-01.</p>
 *
 * <p>A simple IStrategy implementation for testing and MVP.  This is a read-only strategy --
 * attempting to add or remove rules will result in a NotImplementedException being thrown.</p>
 */
public class SimpleStrategy implements IStrategy, Serializable {

	private static final long serialVersionUID = 8779566290462507945L;
	private IRule rule;
    private String name;
    private String description;
    private static String defaultName = "BuiltInStrategy1";
    private static String defaultDescription = "Simple read-only strategy that buys when a stock price is less than 100";

    /**
     * Uses default values to build basic SimpleStrategy
     */
    public SimpleStrategy () {
        this(defaultName, defaultDescription,
                ICondition.Comparator.LEQ, new BigDecimal(100),
                IAction.ActionType.BUY, 10);
    }

    /**
     * Custom values for new SimpleStrategy
     * @param name
     * @param description
     * @param comp The comparator to be used in the single simple condition
     * @param operand The numerical operand to the comparison in the simple condition
     * @param action The action to take if the condition is met
     * @param quantity The quantity argument to the action
     */
    public SimpleStrategy (String name, String description,
                           ICondition.Comparator comp, BigDecimal operand,
                           IAction.ActionType action, int quantity) {
        setName(name);
        this.description = description;
        this.rule = new SimpleRule(new SimpleCondition(comp, operand), new SimpleAction(action, quantity));
    }

    private void setName(String name) {

        if (name == null) {
            throw new NullPointerException("Username was null");
        }

        if (name.length() > 32) {
            throw new IllegalArgumentException("Username exceeded length of 32");
        }

        if (name.matches(".*\\W+.*")) {
            throw new IllegalArgumentException("Username contains illegal characters");
        }

        if (name.isEmpty()) {
            throw new IllegalArgumentException("Username is an empty string");
        }

        if (name.matches("[ _]*")){
            throw new IllegalArgumentException("Username contains only whitespace");
        }

        this.name = name;

    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public Set<RuleID> getRules() {
        Set<RuleID> rules = new HashSet<>();
        rules.add(rule.getID());
        return rules;
    }

    @Override
    public void addRule(IRule rule) {
        throw new InvalidParameterException();
    }
    
	@Override
	public IRule getRule(RuleID rule) {
		if(rule == this.rule.getID())
			return this.rule;
		else
			return null;
	}

    @Override
    public IRule removeRule(RuleID rule) {
        return null;
    }

    @Override
    public String getRuleName(RuleID rule) {
        return (rule == this.rule.getID()) ? this.rule.getDescription() : null;
    }

    @Override
    public String getRuleDescription(RuleID rule) {
        return (rule == this.rule.getID()) ? this.rule.getDescription() : null;
    }

    @Override
    public String getRuleSummary(RuleID rule) {
        return (rule == this.rule.getID()) ? this.rule.getSummary() : null;
    }

    @Override
    public IDecisionMaker getRuleDecisionMaker(RuleID rule) {
        return (rule == this.rule.getID()) ? this.rule.getDecisionMaker() : null;
    }

    @Override
    public StrategyTester getNewTester() {
        return new SimpleStrategyTester((IStrategy) this);
    }

    @Override
    public int getID() {
        return this.name.hashCode();
    }
}
