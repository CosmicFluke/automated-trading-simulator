package autotradingsim.deprecated.simpleimpl;

import autotradingsim.stocks.IStock;
import autotradingsim.stocks.Stock;
import autotradingsim.stocks.StockDay;
import autotradingsim.strategy.IBufferAdapter;
import autotradingsim.strategy.ICondition;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.function.Predicate;

import static org.junit.Assert.*;

/**
 * Created by Asher on 2015-11-02.
 */
public class SimpleConditionTest {

    private IStock stock;
    private BigDecimal one;
    private BigDecimal two;
    private BigDecimal three;
    private BigDecimal fourPointFive;

    private LocalDate testDate;

    @Before
    public void setUp() throws Exception {
        LocalDate stockDate = LocalDate.of(2014, 1, 1);
        testDate = stockDate;
        one = new BigDecimal(1);
        two = new BigDecimal(2);
        three = new BigDecimal(3);
        fourPointFive = new BigDecimal(2.5);

        ArrayList<StockDay> dayList = new ArrayList<>();
        BigDecimal addend = new BigDecimal(0);
        for (int i=0; i < 10; i++) {
            dayList.add(new StockDay("TEST", stockDate, one, one, one, two.add(addend), 100));
            stockDate = stockDate.plusDays(1);
            addend = addend.add(BigDecimal.TEN);
        }
        stock = new Stock("TEST", "Test Stock", dayList);
    }

    @After
    public void tearDown() throws Exception {
        // meh
    }

    @Test
    public void testGetFunction() throws Exception {
        ICondition condition = new SimpleCondition(ICondition.Comparator.LEQ, three);

        Predicate<IBufferAdapter> p = condition.getFunction();

        IBufferAdapter adapter = stock.getNewBuffer(testDate, 1);

        assertTrue(p.test(adapter));

        testDate = testDate.plusDays(2);
        adapter = stock.getNewBuffer(testDate, 1);
        assertFalse(p.test(adapter));

    }
}