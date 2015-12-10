package autotradingsim.strategy;

import autotradingsim.application.TradingApplication;
import autotradingsim.stocks.IBufferAdapter;
import autotradingsim.stocks.IStock;
import autotradingsim.stocks.Stock;
import autotradingsim.stocks.StockDay;
import autotradingsim.strategy.indicators.IndicatorRelativeChange;
import autotradingsim.strategy.indicators.SimpleMovingAverage;
import autotradingsim.strategy.rules.ICondition;
import autotradingsim.strategy.rules.StaticCondition;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.Assert.*;

/**
 * Created by Asher on 2015-11-15.
 */
public class StaticConditionTest {

    TradingApplication app;
    LocalDate startDate;
    LocalDate endDate;
    IStock stock;
    IStock simpleStock;
    ICondition simpleValueCondition;
    ICondition movingAvgConditionOne;
    ICondition movingAvgConditionFive;
    ICondition relativeChangeCondition;

    @Before
    public void setUp() throws Exception {

        app = TradingApplication.getInstance();

        // Set up dates for test stock
        startDate = LocalDate.of(2013, 1, 1);
        endDate = LocalDate.of(2015, 11, 1);
        long diff = startDate.until(endDate, ChronoUnit.DAYS);

        // Set up new test stock
        IntStream ints =
                IntStream.iterate(0, (seed) -> (seed + 1))
                        .limit(diff + 1);

        /* Create sequence of StockDay objects from startDate to endDate
         * Each day starting from startDate has a closing price $0.25 greater than the previous day.
         * Starting value is:
         *      300 - (0.25 * (diff + 1))
         */
        Stream<StockDay> stockDays =
                ints.mapToObj(num -> (new StockDay(
                        "TEST",
                        endDate.minusDays(num),
                        BigDecimal.ONE, BigDecimal.ONE, BigDecimal.ONE,
                        getClosingValue(num),
                        100)));
        ArrayList<StockDay> dayList = new ArrayList<>(stockDays.collect(Collectors.toList()));
        // Ensure stock will be set up correctly
        assertTrue(!dayList.isEmpty());
        assertEquals(diff + 1, dayList.size());
        stock = new Stock("TEST", "Test Stock", dayList);

        // Set up indicators/IMeasurements
        movingAvgConditionOne =                     // 1-day average (stock value) > 299
                new StaticCondition(                // True for last 4 days
                        new SimpleMovingAverage(1),
                        ICondition.Comparator.GT,
                        BigDecimal.valueOf(299));
        movingAvgConditionFive =                    // 5-day average > 290
                new StaticCondition(                // True for last 40 days
                        new SimpleMovingAverage(5),
                        ICondition.Comparator.GT,
                        BigDecimal.valueOf(290));
        relativeChangeCondition =                   // Relative change between 2 days > 0.85%
                new StaticCondition(                // True except for last 28 days
                        new IndicatorRelativeChange(new SimpleMovingAverage(1), 2),
                        ICondition.Comparator.GT,
                        BigDecimal.valueOf(0.00085));

    }

    private BigDecimal getClosingValue (int daysBehind) {
        return (new BigDecimal(300)).subtract(BigDecimal.valueOf(0.25).multiply(new BigDecimal(daysBehind)));
    }

    @Test
    public void testGetFunction() throws Exception {
        ArrayList<StockDay> smallList = new ArrayList<>();
        BigDecimal one = BigDecimal.ONE;

        // Set up a small list of StockDays
        smallList.add(
                new StockDay(
                        "SIMP", endDate.minusDays(4),
                        one, one, one,
                        one, 10));
        smallList.add(
                new StockDay(
                        "SIMP", endDate.minusDays(3),
                        one, one, one,
                        one.add(one), 10));
        smallList.add(
                new StockDay(
                        "SIMP", endDate.minusDays(2),
                        one, one, one,
                        BigDecimal.TEN, 10));
        smallList.add(
                new StockDay(
                        "SIMP", endDate.minusDays(1),
                        one, one, one,
                        BigDecimal.TEN.add(one), 10));
        smallList.add(
                new StockDay(
                        "SIMP", endDate,
                        one, one, one,
                        BigDecimal.TEN.add(BigDecimal.TEN), 10));

        smallList.sort((c, d) -> ((-1) * (c.compareTo(d))));
        LocalDate startDate = smallList.get(smallList.size() - 1).getDate();

        // Create the new Simple Stock
        simpleStock = new Stock("SIMP", "Simple Stock", smallList);

        // Instantiate two different StaticConditions with 1- and 2-day moving average indicators
        ICondition movingAvgOne =
                new StaticCondition(new SimpleMovingAverage(1), ICondition.Comparator.GEQ, BigDecimal.TEN);
        ICondition movingAvgTwo =
                new StaticCondition(new SimpleMovingAverage(2), ICondition.Comparator.GEQ, BigDecimal.TEN);

        IBufferAdapter movingAvgOneBuffer = simpleStock.getNewBuffer(startDate, movingAvgOne.getBufferSize());
        IBufferAdapter movingAvgTwoBuffer = simpleStock.getNewBuffer(startDate, movingAvgTwo.getBufferSize());
        List<IBufferAdapter> buffers =
                Arrays.asList(new IBufferAdapter[]{movingAvgOneBuffer, movingAvgTwoBuffer});

        assertFalse(movingAvgOne.getFunction().test(movingAvgOneBuffer));
        assertFalse(movingAvgTwo.getFunction().test(movingAvgTwoBuffer));

        // Update both buffers to next day
        Stream<LocalDate> dates = buffers.stream().map(IBufferAdapter::updateNext);
        // Check that none of them returned null
        assertEquals(0, dates.filter(d -> !d.equals(startDate.plusDays(1))).count());

        assertFalse(movingAvgOne.getFunction().test(movingAvgOneBuffer));
        assertFalse(movingAvgTwo.getFunction().test(movingAvgTwoBuffer));

        // Update both buffers to next day
        dates = buffers.stream().map(IBufferAdapter::updateNext);
        // Check that none of them returned null
        assertEquals(0, dates.filter(d -> !d.equals(startDate.plusDays(2))).count());

        assertTrue(movingAvgOne.getFunction().test(movingAvgOneBuffer));
        assertFalse(movingAvgTwo.getFunction().test(movingAvgTwoBuffer));

        // Update both buffers to next day
        dates = buffers.stream().map(IBufferAdapter::updateNext);
        // Check that none of them returned null
        assertEquals(0, dates.filter(d -> !d.equals(startDate.plusDays(3))).count());

        assertTrue(movingAvgOne.getFunction().test(movingAvgOneBuffer));
        assertTrue(movingAvgTwo.getFunction().test(movingAvgTwoBuffer));

        // Update both buffers to next day
        dates = buffers.stream().map(IBufferAdapter::updateNext);
        // Check that none of them returned null
        assertEquals(0, dates.filter(d -> !d.equals(startDate.plusDays(4))).count());

        assertTrue(movingAvgOne.getFunction().test(movingAvgOneBuffer));
        assertTrue(movingAvgTwo.getFunction().test(movingAvgTwoBuffer));

        // Update both buffers to next day
        dates = buffers.stream().map(IBufferAdapter::updateNext);
        // Check that all of them returned null
        assertEquals(0, dates.filter(d -> d != null).count());

        assertTrue(movingAvgOne.getFunction().test(movingAvgOneBuffer));
        assertTrue(movingAvgTwo.getFunction().test(movingAvgTwoBuffer));
    }

    @Test
    public void testChangeCompareTo() throws Exception {

    }

}