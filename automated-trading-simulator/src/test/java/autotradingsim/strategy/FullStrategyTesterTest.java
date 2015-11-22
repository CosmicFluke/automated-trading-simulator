package autotradingsim.strategy;

import autotradingsim.application.TradingApplication;
import autotradingsim.stocks.IStock;
import autotradingsim.stocks.Stock;
import autotradingsim.stocks.StockDay;
import autotradingsim.util.StrategyDemoFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.Assert.*;

/**
 * Created by Asher on 2015-11-22.
 */
public class FullStrategyTesterTest {

    private IStrategy stratBasic;
    private IStrategy stratAdvanced;
    private IStock stock;

    private LocalDate testDate;

    @Before
    public void setUp() throws Exception {
        stock = TradingApplication.getInstance().getStock("AAPL");
        testDate = LocalDate.of(2014, Month.SEPTEMBER, 30);
        stratBasic = StrategyDemoFactory.newBasicStrategy(BigDecimal.valueOf(99), BigDecimal.valueOf(110), 10, 20);

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testSetAll() throws Exception {

    }

    @Test
    public void testSetAllUnset() throws Exception {

    }

    @Test
    public void testSetStockForRule() throws Exception {

    }

    @Test
    public void testGetUnassignedRules() throws Exception {

    }

    @Test
    public void testTestDate() throws Exception {

    }
}