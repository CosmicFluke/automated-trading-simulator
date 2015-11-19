package autotradingsim.strategy;

import autotradingsim.strategy.simpleimpl.SimpleDecisionMaker;

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
public class Rule implements IRule {

    private static String default_name = "Rule";
    private static String default_description = "A rule";

    private RuleID id;
    private Set<ICondition> conditions;
    private Set<IAction> actions;
    private String name;
    private String description;

    public Rule (String name, String description){
        this.id = new RuleID(this);
        this.conditions = new HashSet<>();
        this.actions = new HashSet<>();
        this.name = name;
        this.description = description;
    }

    public Rule () {
        this(default_name, default_description);
    }

    @Override
    public IDecisionMaker getDecisionMaker() {
        return new DecisionMaker(this.conditions, this.actions, this);
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
    public String getDescription() {
        return this.description;
    }

    @Override
    public String getName() {
        return this.name;
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
        conditions.stream().peek((ICondition c) -> summary.append(c.toString() + "\n"));
        summary.append("\nActions:\n");
        actions.stream().peek(
                (IAction a) -> summary.append(
                        a.getActionType().toString() + " " + String.valueOf(a.getQuantity().toString()) + "\n"));
        return summary.toString() + "\n";
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
    public void setName(String newName) {
        name = newName;
    }

    @Override
    public void setDescription(String newDescription) {
        description = newDescription;
    }

}
