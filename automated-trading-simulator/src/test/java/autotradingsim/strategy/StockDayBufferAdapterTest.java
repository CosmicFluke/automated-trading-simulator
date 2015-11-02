package autotradingsim.strategy;

import autotradingsim.stocks.IStock;
import autotradingsim.stocks.Stock;
import autotradingsim.stocks.StockDay;
import autotradingsim.stocks.StockLoader;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Asher on 2015-11-02.
 */
public class StockDayBufferAdapterTest {

    private Calendar startDate;
    private Calendar endDate;
    private BigDecimal one;
    private BigDecimal two;
    private ArrayList<StockDay> dayList;

    @Before
    public void setUp() throws Exception {

        startDate = new GregorianCalendar(2014, 0, 1);
        endDate = new GregorianCalendar(2014, 0, 1);
        // stock = new StockLoader().fetchStock("AAPL");

        // Set up new Stock
        Calendar testDate = (Calendar) startDate.clone();
        one = BigDecimal.ONE;
        two = one.add(one);
        BigDecimal addend = two;
        dayList = new ArrayList<>();
        dayList.add(new StockDay("TEST", (Calendar) startDate.clone(), one, one, one, BigDecimal.TEN, 100));

        

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

        IBufferAdapter<StockDay> buffer = new StockDayBufferAdapter(stock, (Calendar) endDate.clone(), 1);
        assertEquals(BigDecimal.TEN, buffer.getLastEntry().getValue());
    }

    @Test
    public void testGetLastEntrySizeTwo() throws Exception {

        // From stock with TWO days
        ArrayList<StockDay> newList = new ArrayList<>(dayList);
        startDate.add(Calendar.DATE, -1);
        newList.add(new StockDay("TEST", (Calendar) startDate.clone(), two, two, two, BigDecimal.TEN.multiply(two), 1000));
        IStock stock = buildStock(newList);

        // Buffer for endDate
        IBufferAdapter<StockDay> buffer = new StockDayBufferAdapter(stock, (Calendar) endDate.clone(), 1);
        assertEquals(BigDecimal.TEN, buffer.getLastEntry().getValue());

        // Buffer for startDate
        buffer = new StockDayBufferAdapter(stock, (Calendar) startDate.clone(), 1);
        assertEquals(BigDecimal.TEN.multiply(two), buffer.getLastEntry().getValue());

    }

    @Test
    public void testUpdateTo() throws Exception {

    }

    @Test
    public void testUpdateNext() throws Exception {
    }

    @Test
    public void testIsEmpty() throws Exception {

    }

    @Test
    public void testGetIterator() throws Exception {

    }
}