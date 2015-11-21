package autotradingsim.strategy;

import autotradingsim.stocks.IStock;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

/**
 * Created by Asher on 2015-11-16.
 */
public class DecisionMaker implements IDecisionMaker {

    private IStock stock;
    private List<ICondition> conditions;
    private List<IAction> actions;
    private IRule rule;
    private IStrategy strategy;

    public DecisionMaker(Rule rule, IStrategy strategy) {
        if (conditions == null || actions == null || rule == null) {
            throw new NullPointerException();
        }
        this.rule = rule;
        this.conditions = rule.getConditions();
        this.actions = rule.getActions();
        this.stock = null;
        this.strategy = null;
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
        List<IDecision> decisionList = new ArrayList<>();
        IBufferAdapter buffer = stock.getNewBuffer(date, 1);
        rule.getConditions();
        IDecision decision = getDecision(buffer);
        if (decision != null) {
            decisionList.add(decision);
        }
        return decisionList.stream();
    }

    private IDecision getDecision(IBufferAdapter buffer) {
        ICondition condition = rule.getConditions().get(0);
        IAction action = rule.getActions().get(0);

        if (condition.getFunction().test(buffer)) {
            IActionQuantity q = action.getQuantity();
            return new Decision(buffer.getLastEntry().getDate(), action.getActionType(), stock, action.getQuantity(),
                    this.strategy, this.rule);
        }
        else return null;
    }

}
