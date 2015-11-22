package autotradingsim.deprecated.simpleimpl;

import autotradingsim.stocks.IStock;
import autotradingsim.stocks.Stock;
import autotradingsim.stocks.StockDay;
import autotradingsim.strategy.rules.IMeasurement;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by Asher on 2015-11-02.
 */
public class SimpleStockValueTest {

    @Test
    public void testGetValue() throws Exception {
        LocalDate stockDate = LocalDate.of(2014, 1, 1);
        BigDecimal one = new BigDecimal(1);
        BigDecimal two = new BigDecimal(2);
        BigDecimal twoPointFive = new BigDecimal(2.5);
        StockDay stockDay = new StockDay("TEST", stockDate, one, two, twoPointFive, one, 100);
        ArrayList<StockDay> dayList = new ArrayList<>();
        dayList.add(stockDay);

        IStock stock = new Stock("TEST", "Test Stock", dayList);
        IMeasurement testObj = new SimpleStockValue();
        ((SimpleStockValue) testObj).setStock(stock);
        LocalDate date = LocalDate.of(2014, 1, 1);
        BigDecimal value = testObj.getValue(stock.getNewBuffer(date, testObj.getBufferSize()));
        assertEquals(one, value);
    }
}