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
import java.util.*;

import static org.junit.Assert.*;

/**
 * Created by Asher on 2015-11-02.
 */
public class SimpleStrategyTest {

    private IStrategy stratDefault;
    private IStrategy stratCustom;
    private IStock stock;
    private static Calendar startDate = new GregorianCalendar(2001, 0, 1);

    @Before
    public void setUp() throws Exception {

        // Default strategy buys 10 shares if the share price is less than $100

        stratDefault = new SimpleStrategy();
        stratCustom = new SimpleStrategy("TestStrat1", "Testing custom strategy",
                ICondition.Comparator.GT, BigDecimal.TEN,
                IAction.ActionType.BUY, 1);
        // Set up new Stock
        Calendar testDate = (Calendar) startDate.clone();
        BigDecimal one = BigDecimal.ONE;
        BigDecimal two = one.add(one);
        BigDecimal ten = BigDecimal.TEN;
        BigDecimal addend = one;
        ArrayList<StockDay> dayList = new ArrayList<>();

        printStamp(formatDate(testDate));
        dayList.add(new StockDay("TEST", (Calendar) testDate.clone(), one, one, one, ten, 10));
        testDate.add(Calendar.DATE, 1);
        printStamp(formatDate(testDate));
        dayList.add(new StockDay("TEST", (Calendar) testDate.clone(), two, one, one, ten.add(one), 11));
        testDate.add(Calendar.DATE, 1);
        printStamp(formatDate(testDate));
        dayList.add(new StockDay("TEST", (Calendar) testDate.clone(), two.add(one), one, one, ten.multiply(ten).add(one), 101));
        testDate.add(Calendar.DATE, 1);
        printStamp(formatDate(testDate));
        dayList.add(new StockDay("TEST", (Calendar) testDate.clone(), two.add(two), one, one, ten.add(ten), 20));

        stock = new Stock("TEST", "Test Stock", dayList);

    }

    private String formatDate(Calendar date) {
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        return f.format(date.getTime());
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
        Calendar testDate = (Calendar) startDate.clone();
        System.out.print("New test date.\n");
        printStamp(formatDate(testDate));

        StrategyTester tester = stratDefault.getNewTester();
        tester.setAll(stock);

        assertEquals(stratDefault, tester.getStrategy());

        // First day
        List<IDecision> decisions = tester.testDate(testDate);
        assertEquals(1, decisions.size());

        // Second day
        testDate.add(Calendar.DATE, 1);
        printStamp(formatDate(testDate));
        decisions = tester.testDate(testDate);
        assertEquals(1, decisions.size());

        // Third day
        testDate.add(Calendar.DATE, 1);
        printStamp(formatDate(testDate));
        decisions = tester.testDate(testDate);
        assertEquals(0, decisions.size());

        // Fourth day
        testDate.add(Calendar.DATE, 1);
        printStamp(formatDate(testDate));
        decisions = tester.testDate(testDate);
        assertEquals(1, decisions.size());

    }

    @Test
    public void testGetID() throws Exception {
        assertNotEquals(stratDefault.getID(), stratCustom.getID());
        assertEquals(stratDefault.getID(), (new SimpleStrategy()).getID());

    }
}