package autotradingsim.util;

import autotradingsim.strategy.*;
import autotradingsim.strategy.indicators.SimpleMovingAverage;

import java.math.BigDecimal;

/**
 * Created by Asher on 2015-11-22.
 */
public class StrategyDemoFactory {

    /**
     * <p>Returns a new strategy object built with two rules -- one with a buy action, and one with a sell action.
     * <ul>
     *     <li>IConditions use {@link SimpleMovingAverage} with <tt>numDays == 1</tt> (equivalent to deprecated {@link
     * autotradingsim.strategy.simpleimpl.SimpleStockValue})</li>
     *     <li>IActions are {@link Action} constructed with constant <tt>quantity == 10</tt></li>
     *     <li>The rule with the {@link autotradingsim.strategy.IAction.ActionType#BUY} action will buy when stock
     *     value <= 100</li>
     *     <li>The rule with the {@link autotradingsim.strategy.IAction.ActionType#SELL} action will sell when stock
     *     value >= 150</li>
     * </ul></p>
     */
    public static IStrategy newBasicStrategy() {
        // Create new empty strategy
        IStrategy strat = new Strategy("Basic strategy",
                "A basic example of a strategy, that buys 10 units of stock whenever the price is under $100 and " +
                        "sells 10 units of stock whenever the price is over $150.");

        // Create new rule (for buying)
        IRule rule = new Rule("Buy 10 @ under 100",
                "A basic example of a rule, that buys 10 units of stock whenever the price is at or under $100.");
        rule.addCondition(new StaticCondition(
                new SimpleMovingAverage(1),
                ICondition.Comparator.LEQ,
                BigDecimal.valueOf(100)));
        // Specify action using constant quantity
        rule.addAction(new Action(IAction.ActionType.BUY, 10));
        // Add to strategy
        strat.addRule(rule);

        // Create new rule (for selling)
        rule = new Rule("Sell 10 @ over 150",
                "A basic example of a rule, that sells 10 units of stock whenever the price is at or over $150");
        rule.addCondition(new StaticCondition(
                new SimpleMovingAverage(1),
                ICondition.Comparator.GEQ,
                BigDecimal.valueOf(150)));
        // Specify action using constant quantity
        rule.addAction(new Action(IAction.ActionType.SELL, 10));
        // Add to strategy
        strat.addRule(rule);

        return strat;
    }

    /**
     * TODO: Not yet implemented
     * @return new strategy
     */
    public static IStrategy newAdvancedStrategy() {
        IStrategy strat = new Strategy("");
        return strat;
    }

}
