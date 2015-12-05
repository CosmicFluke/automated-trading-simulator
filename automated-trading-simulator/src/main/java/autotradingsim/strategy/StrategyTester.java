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

    public StrategyTester(IStrategy strategy) {
        super(strategy);
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