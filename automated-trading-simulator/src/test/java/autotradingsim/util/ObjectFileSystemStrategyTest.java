package autotradingsim.util;

import autotradingsim.application.TradingApplication;
import autotradingsim.stocks.BufferAdapter;
import autotradingsim.stocks.IBufferAdapter;
import autotradingsim.strategy.indicators.*;
import autotradingsim.strategy.rules.Action;
import autotradingsim.strategy.rules.ConfidenceFactor;
import autotradingsim.strategy.rules.IAction;
import autotradingsim.strategy.rules.IActionQuantity;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.Assert.*;

/**
 * Created by Asher on 2015-12-05.
 */
public class ObjectFileSystemStrategyTest {

    static final String filename = "testFilename";
    static final String altFilename = "altTestFilename";

    @Test
    public void testSaveObjectBasicStrategyNoExceptions() throws Exception {
        ObjectFileSystem.saveObject(
                filename,
                StrategyDemoFactory.newBasicStrategy(BigDecimal.valueOf(10), BigDecimal.valueOf(20), 100, 20));

        (new File(filename)).delete();
    }

    @Test
    public void testSaveLoadIndicator() throws Exception {
        Indicator test_obj = MeasurementFactory.newSimpleMovingAverage(2);

        ObjectFileSystem.saveObject(filename, test_obj);
        Indicator loaded_obj = (Indicator) ObjectFileSystem.loadObject(filename);

        IBufferAdapter testBuffer = new BufferAdapter(
                TradingApplication.getInstance().getStock("AAPL"),
                LocalDate.of(2014, 1, 10),
                test_obj.getBufferSize());

        assertTrue(loaded_obj instanceof SimpleMovingAverage);
        assertEquals("Indicators have same description",
                test_obj.getDescription(),
                loaded_obj.getDescription());
        assertEquals("Indicators produce the same values.",
                test_obj.getValue(testBuffer),
                loaded_obj.getValue(testBuffer));

        if (!(new File(filename)).delete()) {
            throw new IOException("Something bad happened");
        }
    }

    @Test
    public void testSaveLoadMetaIndicator() throws Exception {
        Indicator test_obj = MeasurementFactory.newPrefabAbsoluteChange1();

        ObjectFileSystem.saveObject(filename, test_obj);
        MetaIndicator loaded_obj = (MetaIndicator) ObjectFileSystem.loadObject(filename);

        IBufferAdapter testBuffer = new BufferAdapter(
                TradingApplication.getInstance().getStock("AAPL"),
                LocalDate.of(2014, 1, 10),
                test_obj.getBufferSize());

        assertTrue(loaded_obj instanceof IndicatorAbsoluteChange);
        assertEquals("Indicators have same description",
                test_obj.getDescription(),
                loaded_obj.getDescription());
        assertEquals("Indicators produce the same values.",
                test_obj.getValue(testBuffer),
                loaded_obj.getValue(testBuffer));

        if (!(new File(filename)).delete()) {
            throw new IOException("Something bad happened");
        }
    }

    @Test
    public void testSaveLoadIActionQuantity() throws Exception {
        IActionQuantity test_obj =
                (cashBalance, stockVal, sharesOwned, cf) ->
                        (sharesOwned > 100) ? // if true
                                Math.min(sharesOwned, cashBalance.divideAndRemainder(stockVal)[0].intValue()) : // do this
                                Math.floorDiv(cashBalance.divideAndRemainder(stockVal)[0].intValue(), 2); // else do this


        ObjectFileSystem.saveObject(filename, test_obj);
        IActionQuantity loaded_obj = (IActionQuantity) ObjectFileSystem.loadObject(filename);

        // Test loaded_obj::getValue with these values
        BigDecimal cashBalance = BigDecimal.valueOf(110);
        BigDecimal stockVal =  BigDecimal.valueOf(8);
        int numShares = 50;

        assertEquals(
                test_obj.getValue(cashBalance, stockVal, numShares, ConfidenceFactor.HIGH),
                loaded_obj.getValue(cashBalance, stockVal, numShares, ConfidenceFactor.HIGH));
    }
}