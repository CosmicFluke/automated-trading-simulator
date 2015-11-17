package autotradingsim.strategy;

import autotradingsim.stocks.IStock;
import autotradingsim.stocks.Stock;
import autotradingsim.stocks.StockDay;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by Asher on 2015-11-02.
 */
public class BufferAdapterTest {

    LocalDate startDate;
    LocalDate endDate;
    BigDecimal one;
    BigDecimal two;
    ArrayList<StockDay> dayList;
    IStock stock;

    @Before
    public void setUp() throws Exception {

        startDate = LocalDate.of(2014, 1, 1);
        endDate = LocalDate.of(2015, 11, 1);
        // stock = new StockLoader().fetchStock("AAPL");

        // Set up new Stock
        one = BigDecimal.ONE;
        two = one.add(one);
        dayList = new ArrayList<>();
        dayList.add(new StockDay("TEST", endDate, one, one, one, BigDecimal.TEN, 100));
    }

    private IStock buildStock(ArrayList<StockDay> dayList) {
        return new Stock("TEST", "Test Stock", dayList);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testGetLastEntrySizeOne() throws Exception {

        // From stock with ONE day
        IStock stock = buildStock(new ArrayList<>(dayList));

        IBufferAdapter buffer = new BufferAdapter(stock, endDate, 1);
        assertEquals(BigDecimal.TEN, buffer.getLastEntry().getValue());
    }

    @Test
    public void testGetLastEntrySizeTwo() throws Exception {

        // From stock with TWO days
        ArrayList<StockDay> newList = new ArrayList<>(dayList);
        startDate = endDate.minusDays(1);
        newList.add(new StockDay("TEST", startDate, two, two, two, BigDecimal.TEN.multiply(two), 1000));
        stock = buildStock(newList);

        // Buffer for endDate
        IBufferAdapter buffer = new BufferAdapter(stock, endDate, 1);
        assertEquals(BigDecimal.TEN, buffer.getLastEntry().getValue());

        // Buffer for startDate
        buffer = new BufferAdapter(stock, startDate, 1);
        assertEquals(BigDecimal.TEN.multiply(two), buffer.getLastEntry().getValue());
    }

    @Test
    public void testUpdateTo() throws Exception {

    }

    @Test
    public void testUpdateNextWithBufferSizeOne() throws Exception {
        // From stock with TWO days
        ArrayList<StockDay> newList = new ArrayList<>(dayList);
        startDate = endDate.minusDays(1);
        newList.add(new StockDay("TEST", startDate, two, two, two, BigDecimal.TEN.multiply(two), 1000));
        stock = buildStock(newList);

        // Buffer of size ONE for startDate
        IBufferAdapter buffer = new BufferAdapter(stock, startDate, 1);
        // Check initial buffer state before updateNext()
        assertEquals("First getLastEntry call", BigDecimal.TEN.multiply(two), buffer.getLastEntry().getValue());

        // Update the buffer
        LocalDate last = buffer.updateNext();
        assertEquals("Checking date after update", endDate, last);
        assertEquals("getLastEntry call after updateNext()", BigDecimal.TEN, buffer.getLastEntry().getValue());

        // Update again, with no more entries available
        last = buffer.updateNext();
        assertEquals("Checking date after second update", null, last);
        assertEquals("getLastEntry call after updateNext()", BigDecimal.TEN, buffer.getLastEntry().getValue());
    }

    @Test
    public void testUpdateNextWithBufferSizeTwo() throws Exception {

        BigDecimal day1Expected = new BigDecimal(100);
        BigDecimal day2Expected = new BigDecimal(20);
        BigDecimal day3Expected = dayList.get(0).getValue();

        // From stock with THREE days
        ArrayList<StockDay> newList = new ArrayList<>(dayList);
        newList.add(new StockDay(
                "TEST",
                endDate.minusDays(1),       // Date
                two, two, two,
                day2Expected,               // Closing value
                1000));
        newList.add(new StockDay(
                "TEST",
                endDate.minusDays(2),       // Date
                two, two, two,
                day1Expected,               // Closing value
                1000));
        startDate = endDate.minusDays(2);
        stock = buildStock(newList);

        // Buffer of size TWO for startDate
        // Edge case, since only one past entry exists in the stock for this date
        IBufferAdapter buffer = new BufferAdapter(stock, startDate, 2);
        // Check initial buffer state before updateNext()
        assertEquals("Size of buffer initially", 1, buffer.getSize());
        assertEquals("First getLastEntry call", day1Expected, buffer.getLastEntry().getValue());
        assertEquals("First getFirstDay call", startDate, buffer.getFirstDay());

        // First update
        LocalDate last = buffer.updateNext();
        assertEquals("Checking date after first update", startDate.plusDays(1), last);
        assertEquals("Size of buffer after first update", 2, buffer.getSize());
        assertEquals("getLastEntry call after first update", day2Expected, buffer.getLastEntry().getValue());
        assertEquals("getFirstDay call after first update", startDate, buffer.getFirstDay());

        // Second update
        last = buffer.updateNext();
        assertEquals("Checking date after second update", endDate, last);
        assertEquals("Checking size of buffer after second update", 2, buffer.getSize());
        assertEquals("getLastEntry call after second update", day3Expected, buffer.getLastEntry().getValue());
        assertEquals("getFirstDay call after second update", startDate.plusDays(1), buffer.getFirstDay());

        // Third update, no more entries available
        last = buffer.updateNext();
        assertEquals("Checking date after second update", null, last);
        assertEquals("Checking size of buffer after second update", 2, buffer.getSize());
        assertEquals("getLastEntry call after updateNext()",day3Expected, buffer.getLastEntry().getValue());
        assertEquals("getFirstDay call after second update", startDate.plusDays(1), buffer.getFirstDay());
    }

    @Test
    public void testIsEmpty() throws Exception {

    }

    @Test
    public void testGetIterator() throws Exception {

    }
}