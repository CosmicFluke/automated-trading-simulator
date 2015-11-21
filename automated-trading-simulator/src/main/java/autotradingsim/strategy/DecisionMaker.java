package autotradingsim.strategy;

import autotradingsim.stocks.IStock;

import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Stream;

/**
 * Created by Asher on 2015-11-16.
 */
public class DecisionMaker implements IDecisionMaker {

    private IStock stock;
    private Set<ICondition> conditions;
    private Set<IAction> actions;
    private IRule rule;

    public DecisionMaker(Set<ICondition> conditions, Set<IAction> actions, Rule rule) {
        if (conditions == null || actions == null || rule == null) {
            throw new NullPointerException();
        }
        this.conditions = conditions;
        this.actions = actions;
        this.rule = rule;
        this.stock = null;
    }

    @Override
    public void assignStock(IStock stock) {
        if (stock == null) {
            throw new NullPointerException();
        }
        this.stock = stock;
    }

    @Override
    public boolean hasStockAssigned() {
        return this.stock != null;
    }

    @Override
    public Stream<IDecision> getDecisions(LocalDate date) {
        return null;
    }
}
