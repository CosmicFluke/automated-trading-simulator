package autotradingsim.deprecated.simpleimpl;

import autotradingsim.strategy.rules.*;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Asher on 2015-10-26.
 *
 * A SimpleRule is a IRule that has one condition
 *
 */
public class SimpleRule implements IRule, Serializable {

	private static final long serialVersionUID = -8372277688581923592L;
	private static String defaultDescription = "a simple rule";
    private static int counter = 0;
    private static String defaultName = String.format("SimpleRule%d", counter);

    private IAction action;
    private ICondition condition;
    private RuleID id;

    private String description;

    public SimpleRule (ICondition condition, IAction action) {
        this.action = action;
        this.condition = condition;
        this.description = defaultDescription;
        this.id = new RuleID(this);
    }

    public SimpleRule (ICondition condition, IAction action, String description) {
        this(condition, action);
        this.description = description;
        counter++;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public RuleID getID() {
        return this.id;
    }

    @Override
    public String getSummary() {
        // TODO: implement!
        return null;
    }

    @Override
    public void addAction(IAction action) {
        throw new NotImplementedException();
    }

    @Override
    public void addCondition(ICondition condition) {
        throw new NotImplementedException();
    }

    @Override
    public void removeAction(IAction action) {
        throw new NotImplementedException();
    }

    @Override
    public void removeCondition(IAction condition) {
        throw new NotImplementedException();
    }

    @Override
    public void setConfidenceThreshold(double thresh) {
        System.out.println("SimpleRule confidence threshold is not settable.");
    }

    @Override
    public double getConfidenceThreshold() {
        return 0;
    }

    @Override
    public void setName(String name) {

    }

    @Override
    public void setDescription(String description) {

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

	@Override
	public RuleID generateNewID() {
		this.id = new RuleID(this);
		return this.id;
	}
}
