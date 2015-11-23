package autotradingsim.strategy.rules;

import autotradingsim.stocks.IBufferAdapter;
import autotradingsim.stocks.IStock;
import autotradingsim.strategy.Decision;
import autotradingsim.strategy.IDecision;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Created by Asher on 2015-11-16.
 */
public class DecisionMaker implements IDecisionMaker {

    private IStock stock;
    private Map<Integer, IBufferAdapter> stockBuffers;
    private List<ICondition> conditions;
    private List<IAction> actions;
    private IRule rule;

    /**
     * Create a DecisionMaker for a valid IRule.  IRule must provide valid conditions, actions, and ID.
     * @param rule
     */
    public DecisionMaker(IRule rule) {
        if (rule == null) {
            throw new NullPointerException("DecisionMaker constructor was passed a null IRule");
        }
        if (rule.getConditions() == null || rule.getActions() == null || rule.getID() == null) {
            throw new IllegalArgumentException("DecisionMaker constructor was passed an invalid IRule");
        }
        this.rule = rule;
        this.conditions = rule.getConditions();
        this.actions = rule.getActions();
        this.stock = null;
    }

    @Override
    public void assignStock(IStock stock) {
        if (stock == null) {
            throw new NullPointerException("DecisionMaker::assignStock was passed a null IStock");
        }
        if (stock.getAllStockDays().count() < 1) {
            throw new IllegalArgumentException(String.format("Stock with symbol '%s' does not contain any data", stock));
        }
        this.stock = stock;
    }

    @Override
    public boolean hasStockAssigned() {
        return this.stock != null;
    }

    @Override
    public Stream<IDecision> getDecisions(LocalDate date) {
        if (stockBuffers == null) {
            stockBuffers = new HashMap<>();
        }

        // Update/set the stockBuffers list to the given date
        for (ICondition cond : conditions) {
            Integer size = cond.getBufferSize();
            if (stockBuffers.containsKey(size)) {   // Buffer of correct size exists in stockBuffers
                // Update existing buffer
                IBufferAdapter buffer = stockBuffers.get(size);
                if (stockBuffers.get(size)  // Buffer is one day behind
                        .getLastDay().plusDays(1)
                        .equals(date)) {
                    buffer.updateNext();
                } else if (stockBuffers.get(size)   // Buffer is on the correct day
                        .getLastDay().equals(date)) {
                    // do nothing
                } else {                    // Buffer is something other than one day behind
                    buffer.updateTo(date);
                }
            } else {    // No buffer of correct size exists in stockBuffers
                // Get a new buffer and add to stockBuffers map
                stockBuffers.put(size, stock.getNewBuffer(date, size));
            }
        }

        boolean doActions =
                conditions.stream()
                        .map((ICondition c) ->
                                c.getFunction().test(stockBuffers.get(c.getBufferSize())))
                        .reduce(Boolean.TRUE, (Boolean a, Boolean b) -> a && b);
        return doActions ? actions.stream()
                .map((IAction action) ->
                        new Decision(date, action.getActionType(), stock.getSymbol(), action.getQuantity(), null, rule))
                : (new ArrayList<IDecision>()).stream();
    }
}
