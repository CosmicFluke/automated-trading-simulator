package autotradingsim.strategy;

import autotradingsim.stocks.IStock;
import autotradingsim.stocks.StockLoader;
import junit.framework.TestCase;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by Asher on 2015-11-01.
 */
public class SimpleStockValueTest extends TestCase {

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