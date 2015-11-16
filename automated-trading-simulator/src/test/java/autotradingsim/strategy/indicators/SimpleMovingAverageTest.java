package autotradingsim.strategy.indicators;

import autotradingsim.application.TradingApplication;
import autotradingsim.stocks.IStock;
import autotradingsim.stocks.Stock;
import autotradingsim.stocks.StockDay;
import autotradingsim.strategy.IBufferAdapter;
import autotradingsim.strategy.IMeasurement;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.ArrayList;
import java.util.stream.*;

import static org.junit.Assert.*;

/**
 * Created by Asher on 2015-11-14.
 */
public class SimpleMovingAverageTest {

    TradingApplication app;
    IStock stockAAPL;
    IStock stockCustom;
    IBufferAdapter buffer;
    IMeasurement movingAverage;
    LocalDate startDate;
    LocalDate endDate;
    LocalDate date;

    @Before
    public void setUp() throws Exception {
        app = TradingApplication.getInstance();
        stockAAPL = app.getStock("AAPL");

        // Set up custom stock
        startDate = LocalDate.of(2013, 1, 1);
        endDate = LocalDate.of(2015, 11, 1);
        long diff = startDate.until(endDate, ChronoUnit.DAYS);
        System.out.print(diff);

        // Set up new Stock
        IntStream ints =
                IntStream.iterate(0, (seed) -> (seed + 1))
                        .limit(diff + 1);
        Stream<StockDay> stockDays =
                ints.mapToObj(num -> (new StockDay(
                        "TEST",
                        endDate.minusDays(num),
                        BigDecimal.ONE, BigDecimal.ONE, BigDecimal.ONE,
                        new BigDecimal(300 - (0.25 * num)),
                        100)));
        ArrayList<StockDay> dayList = new ArrayList<>(stockDays.collect(Collectors.toList()));
        assertTrue(!dayList.isEmpty());
        assertEquals(diff + 1, dayList.size());
        stockCustom = new Stock("TEST", "Test Stock", dayList);
    }

    void setBufferAndDate(int size, int dateNum) {

        switch (dateNum) {
            case 0:
                date = LocalDate.of(2013, Month.MARCH, 10);
                break;
            case 1:
                date = LocalDate.of(2014, Month.NOVEMBER, 20);
                break;
            default:
                date = LocalDate.of(2015, Month.JULY, 2);
                break;
        }
        buffer = stockCustom.getNewBuffer(date, size);
    }

    BigDecimal getAverage(LocalDate end, int numDays) {
        StockDay day = null;
        BigDecimal sum = BigDecimal.ZERO;
        for (int i = 0; i < numDays; i++) {
            day = stockCustom.getDay(end.minusDays(i));
            sum = sum.add(day.getValue());
        }
        return sum.divide(new BigDecimal(numDays));
    }

    @Test
    public void testFakeStock() throws Exception {
        assertEquals("Stock startDate", startDate, stockCustom.getStartDate());
        assertEquals("Stock endDate", endDate, stockCustom.getEndDate());
        assertEquals("Stock last StockDay is endDate", endDate, stockCustom.getDay(endDate).getDate());

    }

    @Test
    public void testGetBufferSizeOneDay() throws Exception {
        movingAverage = new SimpleMovingAverage(1);
        int bufferSize = movingAverage.getBufferSize();
        assertEquals("First access", 1, bufferSize);
        assertEquals("Second access", 1, movingAverage.getBufferSize());
    }

    @Test
    public void testGetBufferSizeFiveDays() throws Exception {
        movingAverage = new SimpleMovingAverage(5);
        int bufferSize = movingAverage.getBufferSize();
        assertEquals("First access", 5, bufferSize);
        assertEquals("Second access", 5, movingAverage.getBufferSize());
    }

    @Test
    public void testGetValueOneDay() throws Exception {
        movingAverage = new SimpleMovingAverage(1);
        setBufferAndDate(movingAverage.getBufferSize(), 0);
        BigDecimal value = movingAverage.getValue(buffer);
        assertEquals("Date sample 1", stockCustom.getDay(date).getValue(), value);

        movingAverage = new SimpleMovingAverage(1);
        setBufferAndDate(movingAverage.getBufferSize(), 1);
        value = movingAverage.getValue(buffer);
        assertEquals("Date sample 2", stockCustom.getDay(date).getValue(), value);
    }

    @Test
    public void testGetValueFiveDays() throws Exception {
        movingAverage = new SimpleMovingAverage(5);
        setBufferAndDate(movingAverage.getBufferSize(), 0);
        BigDecimal value = movingAverage.getValue(buffer);
        assertEquals("Date sample 1", getAverage(date, movingAverage.getBufferSize()), value);

        movingAverage = new SimpleMovingAverage(5);
        setBufferAndDate(movingAverage.getBufferSize(), 1);
        value = movingAverage.getValue(buffer);
        assertEquals("Date sample 2", getAverage(date, movingAverage.getBufferSize()), value);
    }
}