package autotradingsim.strategy.rules;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Asher on 2015-10-30.
 *
 * Basis for general implementation of IRule -- allows for multiple conditions and multiple actions.
 *
 */
public class Rule implements IRule, Serializable {

	private static final long serialVersionUID = -8909903863033085129L;
	private static String default_name = "Rule";
    private static String default_description = "A rule, containing a set of conditions, and a set of actions to take " +
            "if those conditions are all met.";

    private transient RuleID id;
    private Set<ICondition> conditions;
    private Set<IAction> actions;
    private String name;
    private String description;
    private double confidenceThreshold;

    public Rule (String name, String description){
        this.id = new RuleID(this);
        this.conditions = new HashSet<ICondition>();
        this.actions = new HashSet<IAction>();
        this.name = name;
        this.description = description;
    }

    public Rule () {
        this(default_name, default_description);
    }

    @Override
    public IDecisionMaker getDecisionMaker() {
        return new DecisionMaker(this);
    }

    @Override
    public List<ICondition> getConditions() {
        return new ArrayList<>(conditions);
    }

    @Override
    public List<IAction> getActions() {
        return new ArrayList<>(actions);
    }

    @Override
    public void addAction(IAction action) {
        actions.add(action);
    }

    @Override
    public void addCondition(ICondition condition){
        conditions.add(condition);
    }

    @Override
    public void removeAction(IAction action){
        actions.remove(action);
    }

    @Override
    public void removeCondition(IAction condition){
        conditions.remove(condition);
    }

    @Override
    public void setConfidenceThreshold(double thresh) {
        if (thresh <= 0 || thresh > 1) {
            throw new IllegalArgumentException();
        }
        confidenceThreshold = thresh;
    }

    @Override
    public double getConfidenceThreshold() {
        return confidenceThreshold;
    }


    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public String getName() {
        return this.name;
    }

	@Override
	public RuleID generateNewID() {
		this.id = new RuleID(this);
		return this.id;
	}
	
    @Override
    public RuleID getID(){
        return this.id;
    }

    @Override
    public String getSummary() {
        StringBuilder summary = new StringBuilder();
        String opener = "Rule: " + this.getName() + "\n" +
                "Description: " + this.getDescription() + "\n\n" +
                "Conditions:\n";
        summary.append(opener);
        conditions.stream()
                .peek((ICondition c) -> summary.append(c.toString() + "\n"));
        summary.append("\nActions:\n");
        actions.stream().peek(
                (IAction a) -> summary.append(
                        a.getActionType().toString() + " " + String.valueOf(a.getQuantity().toString()) + "\n"));
        return summary.toString() + "\n";
    }

    @Override
    public void setName(String newName) {
        name = newName;
    }

    @Override
    public void setDescription(String newDescription) {
        description = newDescription;
    }



}
