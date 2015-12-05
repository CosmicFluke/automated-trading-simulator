package autotradingsim.strategy;

import autotradingsim.stocks.IStock;
import autotradingsim.strategy.exceptions.RuleDoesNotExistException;
import autotradingsim.strategy.rules.IDecisionMaker;
import autotradingsim.strategy.rules.IRule;
import autotradingsim.strategy.rules.RuleID;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Asher on 2015-11-01.
 * Abstract implementation of IStrategyTester
 * Subclassed into StrategyTester for testDate method implementation
 */
public abstract class AbstractStrategyTester implements IStrategyTester {

    protected final IStrategy strategy;
    protected Map<RuleID, IRule> ruleIDtoRule;
    protected Map<RuleID, IDecisionMaker> ruleIDtoDecisionMaker;

    /**
     * <p>Takes the strategy to be tested as its parameter</p>
     * @param strategy
     */
    public AbstractStrategyTester(IStrategy strategy){
        this.strategy = strategy;
        Set<IRule> rules = strategy.getRules().stream()
                .map(strategy::getRule)
                .collect(Collectors.toSet());
        this.ruleIDtoRule = new HashMap<>();
        this.ruleIDtoDecisionMaker = new HashMap<>();
        for (IRule rule : rules) {
            ruleIDtoRule.put(rule.getID(), rule);
            ruleIDtoDecisionMaker.put(rule.getID(), rule.getDecisionMaker());
        }
    }

    @Override
    public String getStrategy() {
        return this.strategy.getName();
    }

    @Override
    public void setAll(IStock stock) {
        for (RuleID id : ruleIDtoRule.keySet()) {
            ruleIDtoDecisionMaker.get(id).assignStock(stock);
        }
    }

    @Override
    public void setAllUnset(IStock stock) {
        for (RuleID id : ruleIDtoRule.keySet()) {
            IDecisionMaker maker = ruleIDtoDecisionMaker.get(id);
            if (!maker.hasStockAssigned()) {
                maker.assignStock(stock);
            }
        }
    }

    @Override
    public void setStockForRule(RuleID ruleID, IStock stock) {
        if (ruleIDtoRule.containsKey(ruleID)) {
            ruleIDtoDecisionMaker.get(ruleID).assignStock(stock);
        } else {
            throw new RuleDoesNotExistException();
        }
    }

    @Override
    public List<RuleID> getUnassignedRules(){
        Stream<RuleID> unassignedRules =
                ruleIDtoDecisionMaker
                        .entrySet()     // K,V pairs of <RuleID, IDecisionMaker>
                        .stream()
                        // Select only entries without a stock assigned
                        .filter(entry -> !(entry.getValue().hasStockAssigned()))
                        // Map the K,V pairs to only their RuleID keys
                        .map(Map.Entry::getKey);

        return unassignedRules.collect(Collectors.toList());    // Return collected list of RuleID keys
    }
}
