package autotradingsim.strategy;

/**
 * Created by Asher on 2015-10-30.
 *
 * Basis for more general implementation of IRule -- allows for multiple conditions and multiple actions.
 *
 */
public abstract class Rule implements IRule {

    public abstract void addAction(IAction action);

    public abstract void addCondition(ICondition condition);

}
