package autotradingsim.strategy;

import autotradingsim.stocks.IStock;

import java.util.*;

/**
 * Created by Asher on 2015-11-01.
 *
 */
public class SimpleStrategyTester extends StrategyTester {

    private Map<RuleID, IDecisionMaker> ruleIDtoDecisionMaker;
    private IStock stock;

    public SimpleStrategyTester(IStrategy strategy) {
        super(strategy);
        for (RuleID id : strategy.getRules()) {
            ruleIDtoDecisionMaker.put(id, strategy.getRuleDecisionMaker(id));
        }
    }

    @Override
    public void setAll(IStock stock) {
        this.stock = stock;
        for (IDecisionMaker maker : ruleIDtoDecisionMaker.values()) {
            maker.assignStock(stock);
        }
    }

    @Override
    public Set<IDecision> testDate(Calendar date) {
        Set<IDecision> decisions = new TreeSet<>();
        for (IDecisionMaker maker : ruleIDtoDecisionMaker.values()) {
            Iterator<IDecision> decisionIter = maker.getDecisions(date);
            while (decisionIter.hasNext()) {
                decisions.add(decisionIter.next());
            }
        }
        return decisions;
    }
}
