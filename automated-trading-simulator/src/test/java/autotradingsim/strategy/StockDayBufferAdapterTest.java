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

import static org.junit.Assert.*;

/**
 * Created by Asher on 2015-11-02.
 */
public class StockDayBufferAdapterTest {

    private Calendar startDate;
    private Calendar endDate;
    private IStock stock;
    private BigDecimal one;
    private BigDecimal two;
    private ArrayList<StockDay> dayList;

    @Before
    public void setUp() throws Exception {

        startDate = new GregorianCalendar(2014, 1, 1);
        endDate = new GregorianCalendar(2014, 1, 1);
        // stock = new StockLoader().fetchStock("AAPL");

        // Set up new Stock
        Calendar testDate = (Calendar) startDate.clone();
        System.out.format("Setting up date %s\n", new SimpleDateFormat("YYYY-MM-DD").format(testDate.getTime()));
        one = BigDecimal.ONE;
        two = one.add(one);
        BigDecimal addend = two;
        dayList = new ArrayList<>();

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testGetLastEntrySizeOne() throws Exception {
        // From stock with ONE day
        dayList.add(new StockDay("TEST", (Calendar) startDate.clone(), one, one, one, BigDecimal.TEN, 100));
        stock = new Stock("TEST", "Test Stock", dayList);

        IBufferAdapter<StockDay> buffer = new StockDayBufferAdapter(stock, (Calendar) endDate.clone(), 1);
        assertEquals(BigDecimal.TEN, buffer.getLastEntry().getValue());

        // From stock with TWO days
        startDate.add(Calendar.DATE, -1);
        dayList.add(new StockDay("TEST", (Calendar) startDate.clone(), two, two, two, BigDecimal.TEN.multiply(two), 1000));
        stock = new Stock("TEST", "Test Stock", dayList);

        buffer = new StockDayBufferAdapter(stock, (Calendar) endDate.clone(), 1);
        assertEquals(BigDecimal.TEN, buffer.getLastEntry().getValue());

        buffer = new StockDayBufferAdapter(stock, (Calendar) startDate.clone(), 1);
        assertEquals(BigDecimal.TEN.multiply(two), buffer.getLastEntry().getValue());

    }

    @Test
    public void testGetLastEntrySizeTen() throws Exception {
        Calendar testDate = (Calendar) startDate.clone();
        BigDecimal addend = one.add(one);
        for (int i=0; i < 10; i++) {
            dayList.add(new StockDay("TEST", (Calendar) testDate.clone(), one, one, one, addend.multiply(addend), 100));
            testDate.add(Calendar.DATE, 1);
            addend = addend.add(one);
        }
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