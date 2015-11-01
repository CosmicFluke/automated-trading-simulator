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

    /**
     * For this Simple Decision Maker, there is only one rule and only one stock, so this method alone may be used
     * to assign a stock instead of {@link IDecisionMaker}'s {@link #assignStock(RuleID, IStock)} and
     * {@link #getRules()}.
     * @param stock
     */
    public void assignStockSimple(IStock stock) {
        this.stock = stock;
    }

    @Override
    public Map<RuleID, String> getRules() {
        Map<RuleID, String> rules = new HashMap<>();
        rules.put(rule.getRuleID(), rule.getDescription());
        return rules;
    }

    @Override
    public void assignStock(RuleID id, IStock stock) throws RuleDoesNotExistException {
        if (this.rule.getRuleID().equals(id)) {
            this.stock = stock;
        }
        else throw new RuleDoesNotExistException();
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
