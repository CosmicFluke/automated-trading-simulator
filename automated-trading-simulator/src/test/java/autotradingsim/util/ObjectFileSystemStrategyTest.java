package autotradingsim.util;

import autotradingsim.application.TradingApplication;
import autotradingsim.stocks.BufferAdapter;
import autotradingsim.stocks.IBufferAdapter;
import autotradingsim.strategy.IStrategy;
import autotradingsim.strategy.Strategy;
import autotradingsim.strategy.indicators.*;
import autotradingsim.strategy.rules.*;
import org.junit.After;
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
    boolean usedFilename = false;
    boolean usedAltFilename = false;

    @Test (expected = NullPointerException.class)
    public void testSaveNullObject() throws Exception {
        ObjectFileSystem.saveObject(filename, null);
    }

    @Test
    public void testSaveObjectBasicStrategyNoExceptions() throws Exception {
        assertTrue(ObjectFileSystem.saveObject(
                filename,
                StrategyDemoFactory.newBasicStrategy(BigDecimal.valueOf(10), BigDecimal.valueOf(20), 100, 20)));

        usedFilename = true;
    }

    @Test
    public void testSaveLoadIndicator() throws Exception {
        Indicator test_obj = MeasurementFactory.newSimpleMovingAverage(2);

        assertTrue(ObjectFileSystem.saveObject(filename, test_obj));
        usedFilename = true;
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
    }

    @Test
    public void testSaveLoadMetaIndicator() throws Exception {
        Indicator test_obj = MeasurementFactory.newPrefabAbsoluteChange1();

        assertTrue(ObjectFileSystem.saveObject(filename, test_obj));
        usedFilename = true;
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
    }

    @Test
    public void testSaveLoadIActionQuantity() throws Exception {
        IActionQuantity test_obj =
                (Serializable & IActionQuantity) (cashBalance, stockVal, sharesOwned, cf) ->
                        (sharesOwned > 100) ? // if true
                                Math.min(sharesOwned, cashBalance.divideAndRemainder(stockVal)[0].intValue()) : // do this
                                Math.floorDiv(cashBalance.divideAndRemainder(stockVal)[0].intValue(), 2); // else do this


        assertTrue(ObjectFileSystem.saveObject(filename, test_obj));
        usedFilename = true;
        IActionQuantity loaded_obj = (IActionQuantity) ObjectFileSystem.loadObject(filename);
        assertNotEquals("Ensure loaded object is not null", null, loaded_obj);

        // Test loaded_obj::getValue with these values
        BigDecimal cashBalance = BigDecimal.valueOf(110);
        BigDecimal stockVal =  BigDecimal.valueOf(8);
        int numShares = 50;

        assertEquals("Compare quantity values of original and deserialized objects",
                test_obj.getValue(cashBalance, stockVal, numShares, ConfidenceFactor.HIGH),
                loaded_obj.getValue(cashBalance, stockVal, numShares, ConfidenceFactor.HIGH));
    }

    @Test
    public void testSaveLoadAction() throws Exception {
        IActionQuantity testQuant =
                (Serializable & IActionQuantity) (cashBalance, stockVal, sharesOwned, cf) -> (sharesOwned > 100) ?                       // if true
                        Math.min(sharesOwned, cashBalance.divideAndRemainder(stockVal)[0].intValue()) : // do this
                        Math.floorDiv(cashBalance.divideAndRemainder(stockVal)[0].intValue(), 2);       // else do this

        IAction test_obj_const = new Action(IAction.ActionType.BUY, 10);
        IAction test_obj_func = new Action(IAction.ActionType.BUY, testQuant);

        assertTrue(ObjectFileSystem.saveObject(filename, test_obj_const));
        usedFilename = true;
        assertTrue(ObjectFileSystem.saveObject(altFilename, test_obj_func));
        usedAltFilename = true;

        IAction loaded_obj_const = (IAction) ObjectFileSystem.loadObject(filename);
        IAction loaded_obj_func = (IAction) ObjectFileSystem.loadObject(altFilename);

        assertEquals("Testing equivalence of constant quantities",
                test_obj_const.getQuantity().getValue(null, null, 0, null),
                loaded_obj_const.getQuantity().getValue(null, null, 0, null));

        // Test loaded_obj::getValue with these values
        BigDecimal cashBalance = BigDecimal.valueOf(110);
        BigDecimal stockVal =  BigDecimal.valueOf(8);
        int numShares = 50;

        assertEquals("Testing equivalence of quantity functions",
                test_obj_func.getQuantity().getValue(cashBalance, stockVal, numShares, ConfidenceFactor.HIGH),
                loaded_obj_func.getQuantity().getValue(cashBalance, stockVal, numShares, ConfidenceFactor.HIGH));

    }

    @Test
    public void testSaveLoadCondition() throws Exception {
        ICondition test_obj = new StaticCondition(
                MeasurementFactory.newPrefabAbsoluteChange1(),
                ICondition.Comparator.GT,
                BigDecimal.valueOf(2));

        IBufferAdapter testBuffer = new BufferAdapter(
                TradingApplication.getInstance().getStock("AAPL"),
                LocalDate.of(2014, 1, 10),
                test_obj.getBufferSize());

        assertTrue(ObjectFileSystem.saveObject(filename, test_obj));
        usedFilename = true;

        ICondition loaded_obj = (ICondition) ObjectFileSystem.loadObject(filename);

        assertTrue(loaded_obj instanceof StaticCondition);
        assertEquals(test_obj.getFunction().test(testBuffer), loaded_obj.getFunction().test(testBuffer));

    }

    @Test
    public void testSaveLoadStrategy() throws Exception {
        IStrategy test_obj_basic =
                StrategyDemoFactory.newBasicStrategy(BigDecimal.valueOf(10), BigDecimal.valueOf(20), 100, 20);
        IStrategy test_obj_adv =
                StrategyDemoFactory.newAdvancedTestingStrategy();

        assertTrue(ObjectFileSystem.saveObject(filename, test_obj_basic));
        usedFilename = true;
        assertTrue(ObjectFileSystem.saveObject(altFilename, test_obj_adv));
        usedAltFilename = true;

        IStrategy loaded_obj_basic = (IStrategy) ObjectFileSystem.loadObject(filename);
        IStrategy loaded_obj_adv = (IStrategy) ObjectFileSystem.loadObject(altFilename);

        assertTrue(loaded_obj_adv instanceof Strategy);
        assertTrue(loaded_obj_basic instanceof Strategy);

        // Basic Strategy checks
        assertEquals(test_obj_basic.getID(), loaded_obj_basic.getID());
        assertEquals(test_obj_basic.getRules(), loaded_obj_basic.getRules());


        // Adv Strategy checks
        assertEquals(test_obj_adv.getID(), loaded_obj_adv.getID());
        assertEquals(test_obj_adv.getRules(), loaded_obj_adv.getRules());

    }

    @After
    public void tearDown(){
        if (usedFilename && !(new File(filename)).delete()) {
            System.out.println("File could not be deleted.  Non-critical warning.");
        }
        if (usedAltFilename && !(new File(altFilename)).delete()) {
            System.out.println("File could not be deleted.  Non-critical warning.");
        }
        usedFilename = false;
        usedAltFilename = false;
    }
}