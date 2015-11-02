package autotradingsim.strategy;

import autotradingsim.stocks.IStock;
import autotradingsim.stocks.Stock;
import autotradingsim.stocks.StockDay;
import autotradingsim.stocks.StockLoader;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Asher on 2015-11-02.
 */
public class SimpleStockValueTest {

    @Test
    public void testGetValue() throws Exception {
        Calendar stockDate = new GregorianCalendar(2014, 1, 1);
        BigDecimal one = new BigDecimal(1);
        BigDecimal two = new BigDecimal(2);
        BigDecimal twoPointFive = new BigDecimal(2.5);
        StockDay stockDay = new StockDay("TEST", stockDate, one, two, twoPointFive, one, 100);
        ArrayList<StockDay> dayList = new ArrayList<>();
        dayList.add(stockDay);

        IStock stock = new Stock("TEST", "Test Stock", dayList);
        IMeasurement testObj = new SimpleStockValue();
        ((SimpleStockValue) testObj).setStock(stock);
        Calendar date = new GregorianCalendar(2014, 1, 1);
        BigDecimal value = testObj.getValue(date);
        assertEquals(one, value);
    }
}