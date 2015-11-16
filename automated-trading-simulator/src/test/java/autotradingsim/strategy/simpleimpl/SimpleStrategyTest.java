package autotradingsim.strategy.simpleimpl;

import autotradingsim.stocks.IStock;
import autotradingsim.stocks.Stock;
import autotradingsim.stocks.StockDay;
import autotradingsim.strategy.*;
import autotradingsim.strategy.simpleimpl.SimpleStrategy;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

import static org.junit.Assert.*;

/**
 * Created by Asher on 2015-11-02.
 */
public class SimpleStrategyTest {

    private IStrategy stratDefault;
    private IStrategy stratCustom;
    private IStock stock;
    private static LocalDate startDate = LocalDate.of(2001, 1, 1);

    @Before
    public void setUp() throws Exception {

        // Default strategy buys 10 shares if the share price is less than $100

        stratDefault = new SimpleStrategy();
        stratCustom = new SimpleStrategy("TestStrat1", "Testing custom strategy",
                ICondition.Comparator.GT, BigDecimal.TEN,
                IAction.ActionType.BUY, 1);
        // Set up new Stock
        LocalDate testDate = startDate;
        BigDecimal one = BigDecimal.ONE;
        BigDecimal two = one.add(one);
        BigDecimal ten = BigDecimal.TEN;
        BigDecimal addend = one;
        ArrayList<StockDay> dayList = new ArrayList<>();

        dayList.add(new StockDay("TEST", testDate, one, one, one, ten, 10));
        testDate = testDate.plusDays(1);
        dayList.add(new StockDay("TEST", testDate, two, one, one, ten.add(one), 11));
        testDate = testDate.plusDays(1);
        dayList.add(new StockDay("TEST", testDate, two.add(one), one, one, ten.multiply(ten).add(one), 101));
        testDate = testDate.plusDays(1);
        dayList.add(new StockDay("TEST", testDate, two.add(two), one, one, ten.add(ten), 20));

        stock = new Stock("TEST", "Test Stock", dayList);

    }

    private String formatDate(LocalDate date) {
        return date.toString();
    }

    private void printStamp(String date) {
        System.out.format("Set date to: %s\n", date);
    }

    @Test
    public void testGetRulesDefault() throws Exception {
        Set<RuleID> rules = stratDefault.getRules();
        assertEquals(1, rules.size());
        for (RuleID ruleid : rules) {
            assertEquals("a simple rule", stratDefault.getRuleName(ruleid));
        }
    }

    @Test
    public void testGetNewTester() throws Exception {
        LocalDate testDate = startDate;

        StrategyTester tester = stratDefault.getNewTester();
        tester.setAll(stock);

        assertEquals(stratDefault, tester.getStrategy());

        // First day
        List<IDecision> decisions = tester.testDate(testDate);
        assertEquals(1, decisions.size());

        // Second day
        testDate = testDate.plusDays(1);
        decisions = tester.testDate(testDate);
        assertEquals(1, decisions.size());

        // Third day
        testDate = testDate.plusDays(1);
        decisions = tester.testDate(testDate);
        assertEquals(0, decisions.size());

        // Fourth day
        testDate = testDate.plusDays(1);
        decisions = tester.testDate(testDate);
        assertEquals(1, decisions.size());

    }

    @Test
    public void testGetID() throws Exception {
        assertNotEquals(stratDefault.getName(), stratCustom.getName());
        assertEquals(stratDefault.getName(), (new SimpleStrategy()).getName());

    }
}