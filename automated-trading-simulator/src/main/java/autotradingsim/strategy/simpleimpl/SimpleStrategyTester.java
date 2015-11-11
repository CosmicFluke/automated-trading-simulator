package autotradingsim.strategy.simpleimpl;

import autotradingsim.stocks.IStock;
import autotradingsim.strategy.*;

import java.util.*;

/**
 * Created by Asher on 2015-11-01.
 *
 */
public class SimpleStrategyTester extends StrategyTester {

    private Map<RuleID, IDecisionMaker> ruleIDtoDecisionMaker;

    public SimpleStrategyTester(IStrategy strategy) {
        super(strategy);

        // Load and store a decision maker for each rule in the strategy
        ruleIDtoDecisionMaker = new HashMap<>();
        for (RuleID id : strategy.getRules()) {
            IDecisionMaker maker = strategy.getRuleDecisionMaker(id);
            if (maker != null) {
                ruleIDtoDecisionMaker.put(id, maker);
            } else
                System.out.format("SimpleStrategyTester: IDecisionMaker for rule %d in strategy \"%d\" was null pointer",
                        id.getID(), strategy.getName());
        }
    }

    protected Map<RuleID, IDecisionMaker> getMap() {
        return new HashMap<>(this.ruleIDtoDecisionMaker);
    }

    @Override
    public void setAll(IStock stock) {
        for (IDecisionMaker maker : ruleIDtoDecisionMaker.values()) {
            maker.assignStock(stock);
        }
    }

    @Override
    public List<IDecision> testDate(Calendar date) {
        List<IDecision> decisions = new LinkedList<>();
        for (IDecisionMaker maker : ruleIDtoDecisionMaker.values()) {
            Iterator<IDecision> decisionIter = maker.getDecisions(date);
            while (decisionIter.hasNext()) {
                decisions.add(decisionIter.next());
            }
        }
        return decisions;
    }
}
