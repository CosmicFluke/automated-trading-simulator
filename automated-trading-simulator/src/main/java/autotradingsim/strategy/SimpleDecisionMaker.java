package autotradingsim.strategy;

import autotradingsim.stocks.IStock;

import java.util.*;

/**
 * Created by Asher on 2015-10-30.
 *
 * Basic implementation of IDecisionMaker.  Will be useful for early testing and a sample beginner strategy.
 *
 */
public class SimpleDecisionMaker implements IDecisionMaker {

    private SimpleRule rule;
    private IStock stock;

    public SimpleDecisionMaker (SimpleRule rule) {
        this.rule = rule;
    }

    @Override
    public void assignStock(IStock stock) {
        this.stock = stock;
    }

    @Override
    public Iterator<IDecision> getDecisions(Calendar date) {
        List<IDecision> decisionList = new ArrayList<>();
        IDecision decision = getDecision(date);
        if (decision != null) {
            decisionList.add(decision);
        }
        return decisionList.iterator();
    }

    private IDecision getDecision(Calendar date) {
        ICondition condition = rule.getConditions().get(0);
        IAction action = rule.getActions().get(0);

        if (condition.evaluate(date)) {
            IActionQuantity q = action.getQuantity();
            return new Decision(date, action.getActionType(), stock, action.getQuantity());
        }
        else return null;
    }
}
