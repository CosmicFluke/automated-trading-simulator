package autotradingsim.deprecated.simpleimpl;

import autotradingsim.stocks.IStock;
import autotradingsim.strategy.*;
import autotradingsim.strategy.rules.IDecisionMaker;
import autotradingsim.strategy.rules.RuleID;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Asher on 2015-11-01.
 *
 */
public class SimpleStrategyTester extends AbstractStrategyTester {

    private Map<RuleID, IDecisionMaker> ruleIDtoDecisionMaker;

    public SimpleStrategyTester(IStrategy strategy) {
        super(strategy, null);

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
    public void setAllUnset(IStock stock) {
        // NOT IMPLEMENTED
        throw new RuntimeException("Deprecated class.  Method not implemented in SimpleStrategyTester.");
    }

    @Override
    public void setStockForRule(RuleID ruleID, IStock stock) {
        // NOT IMPLEMENTED
        throw new RuntimeException("Deprecated class.  Method not implemented in SimpleStrategyTester.");
    }

    @Override
    public List<RuleID> getUnassignedRules() {
        throw new RuntimeException("Deprecated class.  Method not implemented in SimpleStrategyTester.");
    }

    @Override
    public List<IDecision> testDate(LocalDate date) {
        List<IDecision> decisions = new LinkedList<>();
        for (IDecisionMaker maker : ruleIDtoDecisionMaker.values()) {
            Stream<IDecision> decisionStream = maker.getDecisions(date);
            decisions.addAll(decisionStream.collect(Collectors.toList()));
        }
        return decisions;
    }
}
