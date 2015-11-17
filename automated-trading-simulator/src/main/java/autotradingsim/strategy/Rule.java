package autotradingsim.strategy;

/**
 * Created by Asher on 2015-10-30.
 *
 * Basis for general implementation of IRule -- allows for multiple conditions and multiple actions.
 *
 */
public abstract class Rule implements IRule {

    private RuleID id;

    public Rule (){
        this.id = new RuleID(this);
    }

    @Override
    public RuleID getID(){
        return this.id;
    }

    public abstract void addAction(IAction action);
    public abstract void addCondition(ICondition condition);
    public abstract void removeAction(IAction action);
    public abstract void removeCondition(IAction condition);

}
