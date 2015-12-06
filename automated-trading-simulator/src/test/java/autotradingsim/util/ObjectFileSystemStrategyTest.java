package autotradingsim.util;

import autotradingsim.application.TradingApplication;
import autotradingsim.stocks.BufferAdapter;
import autotradingsim.stocks.IBufferAdapter;
import autotradingsim.strategy.indicators.*;
import org.junit.Before;
import org.junit.Test;
import org.omg.CORBA.Object;

import java.io.File;
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
        assertEquals("Indicators have same lambda functions.",
                test_obj.getValue(testBuffer),
                loaded_obj.getValue(testBuffer));

        (new File(filename)).delete();


    }

    @Test
    public void testSaveLoadMetaIndicator() throws Exception {

    }
}