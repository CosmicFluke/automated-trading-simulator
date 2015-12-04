package autotradingsim.strategy;

import autotradingsim.stocks.IStock;
import autotradingsim.strategy.exceptions.RuleDoesNotExistException;
import autotradingsim.strategy.rules.IDecisionMaker;
import autotradingsim.strategy.rules.IRule;
import autotradingsim.strategy.rules.RuleID;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Asher on 2015-11-10.
 */
public class StrategyTester extends AbstractStrategyTester {

    private Map<RuleID, IRule> ruleIDtoRule;
    private Map<RuleID, IDecisionMaker> ruleIDtoDecisionMaker;

    /**
     * <p>Takes in a strategy, and the set of rules contained in that strategy.</p>
     * <p>Since rules cannot be accessed directly through strategies, the tester needs to be given the rules.</p>
     * @param strategy
     * @param rules
     */
    public StrategyTester(IStrategy strategy, Set<IRule> rules) {
        super(strategy);
        this.ruleIDtoDecisionMaker = new HashMap<>();
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

    @Override
    public List<IDecision> testDate(LocalDate date) {
        List<IDecision> decisionsForDate = new LinkedList<>();
        ruleIDtoDecisionMaker.values()
                .stream()
                .map(maker -> maker.getDecisions(date).collect(Collectors.toList()))
                .forEach(decisionsForDate::addAll);   // Add all of the IDecisionMaker's decisions to the decisions list
        return decisionsForDate;
    }
}