package autotradingsim.strategy;

import autotradingsim.strategy.exceptions.DuplicateEntryException;
import autotradingsim.strategy.exceptions.RuleDoesNotExistException;
import autotradingsim.strategy.simpleimpl.SimpleAction;

import java.io.Serializable;
import java.util.HashMap;
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
public class Strategy implements IStrategy, Serializable {

	private static final long serialVersionUID = -1393482066088892563L;
	private static final String defaultDescription = "This is a strategy.";
    private static final String defaultName = "DefaultStrategyName";
    private static int counter = 0;

    private Map<RuleID, IRule> rules;
    private String name;
    private String description;

    public Strategy (String name, String description) {
        this.name = name;
        this.description = description;
        this.rules = new HashMap<RuleID, IRule>();
    }

    public Strategy(String name) {
        this(name, defaultDescription);
    }

    /**
     * WARNING. Avoid using this constructor.
     */
    public Strategy() {
        this(defaultName + String.valueOf(counter), defaultDescription);
        counter++;
    }

    public void setDescription(String newDescription) {
        this.description = newDescription;
    }

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
	public IRule getRule(RuleID rule) {
		if(rule == null)
			return null;
		return this.rules.get(rule);
	}

    @Override
    public IRule removeRule(RuleID rule) {
        if (! this.rules.containsKey(rule)) {
            throw new RuleDoesNotExistException();
        }
        return this.rules.remove(rule);

    }

    @Override
    public int getID(){
        return this.name.hashCode();
    }

    @Override
    public String getRuleName(RuleID rule) {
        return this.rules.get(rule).getName();
    }

    @Override
    public String getRuleDescription(RuleID rule) {
        return this.rules.get(rule).getDescription();
    }

    @Override
    public String getRuleSummary(RuleID rule) {
        return this.rules.get(rule).getSummary();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public IDecisionMaker getRuleDecisionMaker(RuleID rule) {
        return this.rules.get(rule).getDecisionMaker();
    }

    @Override
    public StrategyTester getNewTester() {
        return new FullStrategyTester(this, new HashSet<>(this.rules.values()));
    }
}
