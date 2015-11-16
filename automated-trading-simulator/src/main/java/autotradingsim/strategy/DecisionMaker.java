package autotradingsim.strategy;

import autotradingsim.stocks.IStock;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by Asher on 2015-11-16.
 */
public class DecisionMaker implements IDecisionMaker {
    public DecisionMaker(Set<ICondition> conditions, Set<IAction> actions, Rule rule) {
    }

    @Override
    public void assignStock(IStock stock) {

    }

    @Override
    public boolean hasStockAssigned() {
        return false;
    }

    @Override
    public Iterator<IDecision> getDecisions(LocalDate date) {
        return null;
    }
}
