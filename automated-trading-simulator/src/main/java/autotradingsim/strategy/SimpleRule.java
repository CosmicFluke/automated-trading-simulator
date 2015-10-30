package autotradingsim.strategy;

/**
 * Created by Asher on 2015-10-26.
 *
 * A SimpleRule is a IRule that has one condition
 *
 */
public class SimpleRule implements IRule {

    private IAction action;
    private ICondition condition;

    public SimpleRule (ICondition condition, IAction action) {
        this.action = action;
        this.condition = condition;
    }

    @Override
    public IDecisionMaker getDecisionMaker() {
        return null;
    }
}
