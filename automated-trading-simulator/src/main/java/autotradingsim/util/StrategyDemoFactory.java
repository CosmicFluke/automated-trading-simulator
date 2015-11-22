package autotradingsim.util;

import autotradingsim.strategy.*;
import autotradingsim.strategy.indicators.IndicatorAbsoluteChange;
import autotradingsim.strategy.indicators.IndicatorRelativeChange;
import autotradingsim.strategy.indicators.SimpleMovingAverage;
import autotradingsim.strategy.rules.*;

import java.math.BigDecimal;

/**
 * Created by Asher on 2015-11-22.
 */
public class StrategyDemoFactory {

    /**
     * <p>Returns a new strategy object built with two rules -- one with a buy action, and one with a sell action.
     * <ul>
     *     <li>IConditions use {@link SimpleMovingAverage} with <tt>numDays == 1</tt> (equivalent to deprecated {@link
     * autotradingsim.deprecated.simpleimpl.SimpleStockValue})</li>
     *     <li>IActions are {@link Action} constructed with constant <tt>quantity == 10</tt></li>
     *     <li>The rule with the {@link IAction.ActionType#BUY} action will buy when stock
     *     value <= buyBelow</li>
     *     <li>The rule with the {@link IAction.ActionType#SELL} action will sell when stock
     *     value >= sellAbove</li>
     * </ul></p>
     *
     */
    public static IStrategy newBasicStrategy(BigDecimal buyBelow, BigDecimal sellAbove, int buyNum, int sellNum) {
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
                buyBelow));
        // Specify action using constant quantity
        rule.addAction(new Action(IAction.ActionType.BUY, buyNum));
        // Add to strategy
        strat.addRule(rule);

        // Create new rule (for selling)
        rule = new Rule("Sell 10 @ over 150",
                "A basic example of a rule, that sells 10 units of stock whenever the price is at or over $150");
        rule.addCondition(new StaticCondition(          // Stock value is greater than 150
                new SimpleMovingAverage(1),
                ICondition.Comparator.GEQ,
                sellAbove));
        // Specify action using constant quantity
        rule.addAction(new Action(IAction.ActionType.SELL, sellNum));
        // Add to strategy
        strat.addRule(rule);

        return strat;
    }

    /**
     *
     * @return new strategy
     */
    public static IStrategy newAdvancedStrategy() {
        IStrategy strat = new Strategy("Advanced Strategy 1",
                "An example of a strategy with two rules and non-constant values in Actions and Indicators.");

        IRule rule = new Rule("Buy increasing stock, short-term",
                "Buy half of my balance worth of a stock if its 5-day moving average increases by 2% over 3 days.");
        rule.addCondition(new StaticCondition(      // 5-day moving average increases by 2% over 3 days
                new IndicatorRelativeChange(new SimpleMovingAverage(5), 3),
                ICondition.Comparator.GEQ,
                BigDecimal.valueOf(0.02)));
        rule.addAction(new Action(
                IAction.ActionType.BUY,
                new VariableBalanceActionQuantity(
                        (num_stocks) -> num_stocks
                                .divide(BigDecimal.valueOf(2))
                                .intValue())));
        rule = new Rule("Sell decreasing stock, long term",
                "");
        rule.addCondition(new StaticCondition(      // 30-day moving average decreases by 2% over 3 days
                new IndicatorRelativeChange(new SimpleMovingAverage(30), 5),
                ICondition.Comparator.LEQ,
                BigDecimal.valueOf(-0.02)));
        rule.addCondition(new StaticCondition(      // 5-day simple moving average dropped by at least $2.00 in 2 days
                new IndicatorAbsoluteChange(new SimpleMovingAverage(5), 2),
                ICondition.Comparator.GEQ,
                BigDecimal.valueOf(2)));
        rule.addAction(new Action(                  // SELL SELL SELL (up to 1000 shares, for now)
                IAction.ActionType.SELL,
                new ConstantActionQuantity(1000))); // TODO: Needs to be fixed once shares-based quantities are implemented

        return strat;
    }

}
