package autotradingsim.strategy;

import autotradingsim.stocks.IStock;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
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

    public DecisionMaker(IRule rule) {
        if (conditions == null || actions == null || rule == null) {
            throw new NullPointerException();
        }
        this.rule = rule;
        this.conditions = rule.getConditions();
        this.actions = rule.getActions();
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
        if (stockBuffers == null) {
            stockBuffers = new HashMap<>();
        }

        // Update/set the stockBuffers list to the given data
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
                        new Decision(date, action.getActionType(), stock, action.getQuantity(), rule))
                : (new ArrayList<IDecision>()).stream();
    }
}
