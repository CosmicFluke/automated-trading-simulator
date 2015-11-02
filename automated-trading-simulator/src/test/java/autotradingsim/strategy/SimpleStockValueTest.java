package autotradingsim.strategy;

import autotradingsim.stocks.IStock;
import autotradingsim.stocks.StockLoader;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.Assert.*;

/**
 * Created by Asher on 2015-11-02.
 */
public class SimpleStockValueTest {

    @Test
    public void testGetValue() throws Exception {
        StockLoader stockLoader = new StockLoader();
        IStock stock = stockLoader.fetchStock("AAPL");
        IMeasurement testObj = new SimpleStockValue();
        ((SimpleStockValue) testObj).setStock(stock);
        Calendar date = new GregorianCalendar(2015, 9, 10);
        BigDecimal value = new BigDecimal(testObj.getValue(date).doubleValue());
        assertEquals(new BigDecimal(112.57), value);
    }
}