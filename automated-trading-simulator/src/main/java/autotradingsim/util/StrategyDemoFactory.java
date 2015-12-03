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


        // Create new rule
        IRule rule = new Rule("Buy 10 @ under 100",
                "A basic example of a rule, that buys 10 units of stock whenever the price is at or under $100.");

        rule.addCondition(new StaticCondition(      // New Condition (w/ fixed comparison value)
                new SimpleMovingAverage(1),             // Closing value of stock (one-day simple moving average)
                ICondition.Comparator.LEQ,              // Less than or equal to
                buyBelow));                             // Number specified by parameter "buyBelow"

        rule.addAction(new Action(                  // New Action
                IAction.ActionType.BUY, buyNum));       // Buy the number of shares specified by parameter "buyNum"

        // Add rule to strategy
        strat.addRule(rule);


        // Create new rule
        rule = new Rule("Sell 10 @ over 150",
                "A basic example of a rule, that sells 10 units of stock whenever the price is at or over $150");

        rule.addCondition(new StaticCondition(      // New Condition (w/ fixed comparison value)
                new SimpleMovingAverage(1),             // Closing value of stock (one-day simple moving average)
                ICondition.Comparator.GEQ,              // Greater than or equal to
                sellAbove));                            // Number specified by parameter "sellAbove"

        rule.addAction(new Action(                  // New Action
                IAction.ActionType.SELL, sellNum));     // Sell the number of shares specified by parameter "sellNum"

        // Add rule to strategy
        strat.addRule(rule);

        return strat;
    }

    /**
     * <p>Creates an returns a new IStrategy with the following rules:<ul>
     *     <li>Buy half of my balance worth of a stock if its 5-day moving average increases by at least 2% over 3 days</li>
     *     <li>Sell up to 1000 shares of a stock if<ul>
     *         <li>The 30-day simple moving average decreases by at least 2% (relative) over 3 days, and</li>
     *         <li>The 5-day simple moving average drops by at least 2 currency units (absolute) over 2 days</li>
     *     </ul></li>
     * </ul>
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
                "Sell up to 1000 shares when the 30-day moving average ");
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

    public static IStrategy newAdvancedTestingStrategy() {
        IStrategy strat = new Strategy("Advanced Testing Strategy",
                "Another example of a strategy with two rules and non-constant values in Actions and Indicators, for use in testing.");

        IRule rule = new Rule("Buy increasing stock, short-term",
                "Buy half of my balance worth of a stock if its 1-day moving average increases by 2% over 2 days.");
        rule.addCondition(new StaticCondition(      // Daily closing value increases by 2% over 2 days
                new IndicatorRelativeChange(new SimpleMovingAverage(1), 2),
                ICondition.Comparator.GEQ,
                BigDecimal.valueOf(0.02)));
        rule.addAction(new Action(
                IAction.ActionType.BUY,
                new VariableBalanceActionQuantity(
                        (num_stocks) -> num_stocks
                                .divide(BigDecimal.valueOf(2))
                                .intValue())));
        rule = new Rule("Sell decreasing stock, long term",
                "Sell up to 1000 shares when the 1-day moving average drops by 2% over 2 days and the 2-day simple " +
                        "moving average drops by 2.00 currency units in 2 days");
        rule.addCondition(new StaticCondition(      // Daily closing value decreases by 2% over 2 days
                new IndicatorRelativeChange(new SimpleMovingAverage(1), 2),
                ICondition.Comparator.LEQ,
                BigDecimal.valueOf(-0.02)));
        rule.addCondition(new StaticCondition(      // 2-day simple moving average dropped by at least $2.00 in 2 days
                new IndicatorAbsoluteChange(new SimpleMovingAverage(2), 2),
                ICondition.Comparator.GEQ,
                BigDecimal.valueOf(2)));
        rule.addAction(new Action(                  // SELL SELL SELL (up to 1000 shares, for now)
                IAction.ActionType.SELL,
                new ConstantActionQuantity(1000))); // TODO: Needs to be fixed once shares-based quantities are implemented

        return strat;
    }

}
