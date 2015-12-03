package autotradingsim.strategy.indicators;

import autotradingsim.stocks.IBufferAdapter;
import autotradingsim.stocks.IStock;
import autotradingsim.stocks.Stock;
import autotradingsim.stocks.StockDay;
import autotradingsim.strategy.rules.IMeasurement;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.Assert.*;

/**
 * Created by Shirley on 2015-12-02.
 */

public class IndicatorAbsoluteChangeTest {

    LocalDate startDate;
    IStock testStock;
    IMeasurement indicator;

    StockDay newStockDay(int i) {
        return new StockDay(
                "TEST",
                startDate.plusDays(i - 1),
                BigDecimal.ONE, BigDecimal.ONE, BigDecimal.ONE,
                BigDecimal.valueOf(i),
                100);
    }

    @Before
    public void setUp() throws Exception {

        startDate = LocalDate.of(2014, Month.JANUARY, 1);

        List<StockDay> myStockDays = IntStream.range(1, 11)
                .mapToObj((int i) -> newStockDay(i))
                .collect(Collectors.toList());

        testStock = new Stock("TEST", "Test stock", myStockDays);
        // Create a new meta indicator that covers a 2-day period using a 2-day simple moving average
        indicator = new IndicatorAbsoluteChange(new SimpleMovingAverage(2), 2);

    }

    @Test
    public void testGetValue() throws Exception {
        int bufferSize = indicator.getBufferSize();
        assertEquals("Ensuring the buffer is the expected size before proceeding", 3, bufferSize);
        IBufferAdapter buffer = testStock.getNewBuffer(startDate.plusDays(9), bufferSize);
        BigDecimal value = indicator.getFunction().apply(buffer);
        assertEquals(1, value.intValue());
    }

    @Test
    public void testGetFunction() throws Exception {

    }
}