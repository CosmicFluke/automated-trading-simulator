package autotradingsim.strategy;

import autotradingsim.application.TradingApplication;
import autotradingsim.stocks.IStock;
import autotradingsim.stocks.StockDay;
import autotradingsim.strategy.rules.IAction;
import autotradingsim.util.StrategyDemoFactory;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Asher on 2015-11-22.
 */
public class StrategyTesterTest {

    IStrategy stratBasic;
    IStrategy stratAdvanced;
    IStock stock;
    LocalDate testDate;
    final LocalDate endDate = LocalDate.of(2014, Month.SEPTEMBER, 30);;
    final LocalDate startDate = LocalDate.of(2014, Month.JULY, 1);
    IStrategyTester tester;
    int numDaysToTest;

    @Before
    public void setUp() throws Exception {
        stock = TradingApplication.getInstance().getStock("AAPL");
        /* 28 days of AAPL closing values ending 30 Sept 2014:
            2014-09-30	100.75
            2014-09-29	100.110001
            2014-09-26	100.75
            2014-09-25	97.870003
            2014-09-24	101.75
            2014-09-23	102.639999
            2014-09-22	101.059998
            2014-09-19	100.959999
            2014-09-18	101.790001
            2014-09-17	101.580002
            2014-09-16	100.860001
            2014-09-15	101.629997
            2014-09-12	101.660004
            2014-09-11	101.43
            2014-09-10	101.00
            2014-09-09	97.989998
            2014-09-08	98.360001
            2014-09-05	98.970001
            2014-09-04	98.120003
            2014-09-03	98.940002
            2014-09-02	103.300003
            2014-08-29	102.50
            2014-08-28	102.25
            2014-08-27	102.129997
            2014-08-26	100.889999
            2014-08-25	101.540001
            2014-08-22	101.32
            2014-08-21	100.580002
            2014-08-20	100.57
            2014-08-19	100.529999
            2014-08-18	99.160004
            2014-08-15	97.980003
            2014-08-14	97.50
            2014-08-13	97.239998
            2014-08-12	95.970001
            2014-08-11	95.989998
            2014-08-08	94.739998
            2014-08-07	94.480003
            2014-08-06	94.959999
            2014-08-05	95.120003
            2014-08-04	95.589996
            2014-08-01	96.129997
            2014-07-31	95.599998
            2014-07-30	98.150002
            2014-07-29	98.379997
            2014-07-28	99.019997
            2014-07-25	97.669998
            2014-07-24	97.029999
            2014-07-23	97.190002
            2014-07-22	94.720001
            2014-07-21	93.940002
            2014-07-18	94.43
            2014-07-17	93.089996
            2014-07-16	94.779999
            2014-07-15	95.32
            2014-07-14	96.449997
            2014-07-11	95.220001
            2014-07-10	95.040001
            2014-07-09	95.389999
            2014-07-08	95.349998
            2014-07-07	95.970001
            2014-07-03	94.029999
            2014-07-02	93.480003
            2014-07-01	93.519997
        */
        numDaysToTest = startDate.until(endDate).getDays();
        assertEquals(stock.getDay(startDate).getValue(StockDay.Values.CLOSE), BigDecimal.valueOf(93.519997));
        assertEquals(stock.getDay(endDate).getValue(StockDay.Values.CLOSE), BigDecimal.valueOf(100.75));

        stratBasic = StrategyDemoFactory.newBasicStrategy(BigDecimal.valueOf(99), BigDecimal.valueOf(102), 10, 20);
        stratAdvanced = StrategyDemoFactory.newAdvancedStrategy();

    }

    @Test
    public void testSetAll() throws Exception {
        // Use basic demo strategy to get a tester
        tester = stratBasic.getNewTester();
        tester.setAll(stock);

        // Count the number of decisions with the wrong stock symbol
        long wrongStockSymbolCount = tester.testDate(startDate).stream()
                .map((d) -> d.getStockSymbol())
                .filter((s) -> s != stock.getSymbol())
                .count();

        assertEquals("All stocks in tester have correct symbol.", 0, wrongStockSymbolCount);
    }

    @Test
    public void testSetAllUnset() throws Exception {
        // TODO: Not yet implemented
    }

    @Test
    public void testSetStockForRule() throws Exception {
        // TODO: Not yet implemented
    }

    @Test
    public void testGetUnassignedRules() throws Exception {
        // TODO: Not yet implemented
    }

    @Test
    public void testTestDateBasicOneDayOneDecision() throws Exception {

        tester = stratBasic.getNewTester();
        tester.setAll(stock);

        // Test startDate (2014-07-01, 93.519997)
        LocalDate testDate = startDate;

        List<IDecision> decisions = tester.testDate(startDate);
        assertEquals("Tester produced one decision on startDate", 1, decisions.size());
        assertEquals("Tester produced buy decision on startDate",
                IAction.ActionType.BUY, decisions.get(0).getActionType());

    }

    @Test
    public void testTestDateBasicOneDayNoData() throws Exception {
        tester = stratBasic.getNewTester();
        tester.setAll(stock);

        // Test startDate (2014-07-01, 93.519997)
        LocalDate testDate = startDate;

        // Test startDate + 3 days (**no value** for 2014-07-04)
        testDate = testDate.plusDays(3);
        List<IDecision> decisions = tester.testDate(testDate);
        assertEquals("Tester produced no decisions on startDate + 3", 0, decisions.size());

    }

    @Test
    public void testTestDateBasicOneDayNoDecisions() throws Exception {

        tester = stratBasic.getNewTester();

        tester.setAll(stock);

        // Test 2014-08-26, value == 100.889999
        LocalDate testDate = LocalDate.of(2014, Month.AUGUST, 26);
        List<IDecision> decisions = tester.testDate(testDate);
        assertEquals("Tester produced no decisions on 2014-08-26", 0, decisions.size());

    }

    @Test
    public void testTestDateBasicSequence() throws Exception {

        tester = stratBasic.getNewTester();

        tester.setAll(stock);


        // Test startDate (2014-07-01, 93.519997)
        LocalDate testDate = startDate;

        List<IDecision> decisions = tester.testDate(startDate);
        assertEquals("Tester produced one decision on startDate", 1, decisions.size());
        assertEquals("Tester produced buy decision on startDate",
                IAction.ActionType.BUY, decisions.get(0).getActionType());

        // Test startDate + 1 day (2014-07-02, 93.480003)
        testDate = testDate.plusDays(1);
        decisions = tester.testDate(startDate);
        assertEquals("Tester produced one decision on startDate + 1", 1, decisions.size());
        assertEquals("Tester produced buy decision on startDate",
                IAction.ActionType.BUY, decisions.get(0).getActionType());

        // Test startDate + 1 day (2014-07-02, 94.029999)
        testDate = testDate.plusDays(1);
        decisions = tester.testDate(startDate);
        assertEquals("Tester produced one decision on startDate + 2", 1, decisions.size());
        assertEquals("Tester produced buy decision on startDate",
                IAction.ActionType.BUY, decisions.get(0).getActionType());

        // Test startDate + 3 days (**no value** for 2014-07-04)
        testDate = testDate.plusDays(1);
        decisions = tester.testDate(testDate);
        assertEquals("Tester produced no decisions on startDate + 3", 0, decisions.size());

        // Test 2014-08-26, value == 100.889999
        testDate = LocalDate.of(2014, Month.AUGUST, 26);
        decisions = tester.testDate(testDate);
        assertEquals("Tester produced no decisions on 2014-08-26", 0, decisions.size());

        // Test 2014-08-27, value == 102.129997
        testDate = LocalDate.of(2014, Month.AUGUST, 27);
        decisions = tester.testDate(testDate);
        assertEquals("Tester produced one decision on 2014-08-27", 1, decisions.size());
        assertEquals("Tester produced sell decision on startDate",
                IAction.ActionType.SELL, decisions.get(0).getActionType());
    }

    @Test
    public void testTestDateAdvanced() throws Exception {
        // TODO: Not yet implemented
        tester = stratAdvanced.getNewTester();
        tester.setAll(stock);

        // Advanced strategy
        List<IDecision> decisions = tester.testDate(startDate);
    }
}