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
        ruleIDtoDecisionMaker = new HashMap<>();
        for (RuleID id : strategy.getRules()) {
            IDecisionMaker maker = strategy.getRuleDecisionMaker(id);
            if (maker != null) {
                ruleIDtoDecisionMaker.put(id, maker);
            } else System.out.print("Null pointer error in SimpleStrategyTester");
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
