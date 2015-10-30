package autotradingsim.strategy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Asher on 2015-10-26.
 *
 * A SimpleRule is a IRule that has one condition
 *
 */
public class SimpleRule implements IRule {

    private static String defaultDescription = "a simple rule";

    private IAction action;
    private ICondition condition;

    private String description;

    public SimpleRule (ICondition condition, IAction action) {
        this.action = action;
        this.condition = condition;
        this.description = defaultDescription;
    }

    public SimpleRule (ICondition condition, IAction action, String description) {
        this(condition, action);
        this.description = description;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public RuleID getRuleID() {
        return new RuleID(this);
    }

    @Override
    public IDecisionMaker getDecisionMaker() {
        return new SimpleDecisionMaker(this);
    }

    @Override
    public List<ICondition> getConditions() {
        List<ICondition> list = new ArrayList<>();
        list.add(this.condition);
        return list;
    }

    @Override
    public List<IAction> getActions() {
        List<IAction> list = new ArrayList<>();
        list.add(this.action);
        return list;
    }
}
