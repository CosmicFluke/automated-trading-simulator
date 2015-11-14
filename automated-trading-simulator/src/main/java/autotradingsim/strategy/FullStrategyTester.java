package autotradingsim.strategy;

import autotradingsim.stocks.IStock;
import autotradingsim.strategy.exceptions.RuleDoesNotExistException;

import java.time.LocalDate;
import java.util.*;

/**
 * Created by Asher on 2015-11-10.
 */
public class FullStrategyTester extends StrategyTester {

    private Map<RuleID, IRule> ruleIDtoRule;
    private Map<RuleID, IDecisionMaker> ruleIDtoDecisionMaker;

    /**
     * <p>Takes in a strategy, and the set of rules contained in that strategy.</p>
     * <p>Since rules cannot be accessed directly through strategies, the tester needs to be given the rules.</p>
     * @param strategy
     * @param rules
     */
    public FullStrategyTester(IStrategy strategy, Set<IRule> rules) {
        super(strategy);
        this.ruleIDtoRule = new HashMap<>();
        for (IRule rule : rules) {
            ruleIDtoRule.put(rule.getID(), rule);
            ruleIDtoDecisionMaker.put(rule.getID(), rule.getDecisionMaker());
        }
    }


    @Override
    public void setAll(IStock stock) {
        for (RuleID id : ruleIDtoRule.keySet()) {
            ruleIDtoDecisionMaker.get(id).assignStock(stock);
        }
    }

    /**
     * Assigns the given stock to all of the rules in the strategy associated with this tester
     * <i>which do not currently have a stock assigned.</i>
     * @param stock The stock to be assigned to each available rule
     */
    public void setAllUnset(IStock stock) {
        for (RuleID id : ruleIDtoRule.keySet()) {
            IDecisionMaker maker = ruleIDtoDecisionMaker.get(id);
            if (!maker.hasStockAssigned()) {
                maker.assignStock(stock);
            }
        }
    }

    /**
     * Assigns a stock to a particular rule in the strategy associated with this tester.
     * @param ruleID ID of the rule to assign a stock to
     * @param stock Stock to assign to the given rule
     */
    public void setStockForRule(RuleID ruleID, IStock stock) {
        if (ruleIDtoRule.containsKey(ruleID)) {
            ruleIDtoDecisionMaker.get(ruleID).assignStock(stock);
        } else {
            throw new RuleDoesNotExistException();
        }
    }

    /**
     * Produces a list of all rules which do not have an assigned stock
     * @return
     */
    public List<RuleID> getUnassignedRules(){
        List<RuleID> unassigned = new LinkedList<>();
        for (Map.Entry<RuleID, IDecisionMaker> entry : ruleIDtoDecisionMaker.entrySet()){
            if (!entry.getValue().hasStockAssigned()) {
                unassigned.add(entry.getKey());
            }
        }
        return null;
    }

    @Override
    public List<IDecision> testDate(LocalDate date) {
        List<IDecision> decisions = new LinkedList<>();
        for (IDecisionMaker maker : ruleIDtoDecisionMaker.values()) {
            Iterator<IDecision> decisionIterator = maker.getDecisions(date);
            while (decisionIterator.hasNext()) {
                decisions.add(decisionIterator.next());
            }
        }
        return decisions;
    }
}
