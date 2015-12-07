package autotradingsim.application;

import static org.junit.Assert.*;

import java.io.File;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import autotradingsim.strategy.rules.Action;
import autotradingsim.strategy.rules.IAction;
import autotradingsim.strategy.rules.ICondition;
import autotradingsim.strategy.rules.IMeasurement;
import autotradingsim.strategy.rules.IRule;
import autotradingsim.strategy.rules.Rule;
import autotradingsim.strategy.rules.StaticCondition;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import autotradingsim.strategy.*;
import autotradingsim.strategy.indicators.ExponentialMovingAverage;
import autotradingsim.strategy.indicators.IndicatorAbsoluteChange;
import autotradingsim.strategy.indicators.IndicatorRelativeChange;
import autotradingsim.strategy.indicators.SimpleMovingAverage;
import autotradingsim.util.ObjectFileSystem;

public class ApplicationStrategyTest {

    private String PathToStrategies = System.getProperty("user.dir") + File.separator + "DATA" +
            File.separator + "STRATEGIES" + File.separator;
    ITradingApplication ApplicationUnderTest = null;

    @AfterClass
    public static void afterClass() {
        TradingApplication.destructObject();
    }

    @Before
    public void setUp() throws Exception {
        TradingApplication.clearMemoryAndFileSystem();
        ApplicationUnderTest = TradingApplication.getInstance();
    }

    @After
    public void tearDown() throws Exception {
        ApplicationUnderTest.clearMemory();
    }

    @Test
    public void testAddStrategyValid(){
        IStrategy testStrat = new Strategy("TestSaving");
        assertTrue(ApplicationUnderTest.addStrategy(testStrat));
    }

    @Test(expected = NullPointerException.class)
    public void testAddStrategyInvalid(){
        ApplicationUnderTest.addStrategy(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddStrategyNameInvalid(){
        ApplicationUnderTest.addStrategy(new Strategy(""));
    }

    @Test
    public void testAddStrategyTwice(){
        IStrategy savingStrategy = new Strategy("Test");
        assertTrue(ApplicationUnderTest.addStrategy(savingStrategy));
        assertFalse(ApplicationUnderTest.addStrategy(savingStrategy));
    }

    @Test(expected = NullPointerException.class)
    public void testAddStrategyTwiceNullSecond(){
        IStrategy savingStrategy = new Strategy("Test");
        assertTrue(ApplicationUnderTest.addStrategy(savingStrategy));
        ApplicationUnderTest.addStrategy(null);
    }

    @Test
    public void testAddStrategyTwiceNullFirst(){
        IStrategy savingStrategy = new Strategy("Test");
        try { ApplicationUnderTest.addStrategy(null);
        } catch (NullPointerException e) {
            // expected
        }
        assertTrue(ApplicationUnderTest.addStrategy(savingStrategy));
    }

    @Test
    public void testGetStrategyValidStrategy(){
        IStrategy savingStrategy = new Strategy("TestSaving");
        ApplicationUnderTest.addStrategy(savingStrategy);
        assertEquals(savingStrategy, ApplicationUnderTest.getStrategy("TestSaving"));
    }

    @Test
    public void testGetStrategyNullStrategyName(){
        assertEquals(ApplicationUnderTest.getStrategy(null), null);
    }

    @Test
    public void testGetStrategyMultipleStrategys(){
        IStrategy savingStrategy1 = new Strategy("TestSaving1");
        IStrategy savingStrategy2 = new Strategy("TestSaving2");
        ApplicationUnderTest.addStrategy(savingStrategy1);
        ApplicationUnderTest.addStrategy(savingStrategy2);
        assertEquals(savingStrategy1, ApplicationUnderTest.getStrategy("TestSaving1"));
        assertEquals(savingStrategy2, ApplicationUnderTest.getStrategy("TestSaving2"));
    }

    @Test
    public void testGetStrategyMultipleGetStrategy(){
        IStrategy savingStrategy1 = new Strategy("TestSaving1");
        IStrategy savingStrategy2 = new Strategy("TestSaving2");
        ApplicationUnderTest.addStrategy(savingStrategy1);
        ApplicationUnderTest.addStrategy(savingStrategy2);
        assertEquals(savingStrategy1, ApplicationUnderTest.getStrategy("TestSaving1"));
        assertEquals(savingStrategy1, ApplicationUnderTest.getStrategy("TestSaving1"));
    }

    @Test
    public void testSavingEmptyStrategy(){
        String ExpectedFileExists = PathToStrategies + "TestSaving";
        ApplicationUnderTest.addStrategy(new Strategy("TestSaving"));
        File testingFile = new File(ExpectedFileExists);
        assertTrue(testingFile.exists());
        testingFile.delete();
    }

    @Test
    public void testSavingStrategyOneEmptyRule(){
        String ExpectedFileExists = PathToStrategies + "TestSingleRule";
        IStrategy mySimpleStrat = new Strategy("TestSingleRule");
        IRule myRule = new Rule();
        mySimpleStrat.addRule(myRule);

        ApplicationUnderTest.addStrategy(mySimpleStrat);
        File testingFile = new File(ExpectedFileExists);
        assertTrue(testingFile.exists());
        testingFile.delete();
    }

    @Test
    public void testSavingStrategyMultipleEmptyRules(){
        String ExpectedFileExists = PathToStrategies + "TestSingleRule";
        IStrategy mySimpleStrat = new Strategy("TestSingleRule");
        IRule myRule1 = new Rule();
        mySimpleStrat.addRule(myRule1);
        IRule myRule2 = new Rule();
        mySimpleStrat.addRule(myRule2);
        ApplicationUnderTest.addStrategy(mySimpleStrat);
        File testingFile = new File(ExpectedFileExists);
        assertTrue(testingFile.exists());
        testingFile.delete();
    }

    @Test
    public void testSavingStrategyOneRuleOneConditionWithSimpleMovingAverage(){
        String ExpectedFileExists = PathToStrategies + "TestSingleRule";
        IStrategy mySimpleStrat = new Strategy("TestSingleRule");
        IRule myRule = new Rule();
        IMeasurement simpleAverage = new SimpleMovingAverage(1);
        ICondition myCondition = new StaticCondition(simpleAverage, ICondition.Comparator.EQ, new BigDecimal(10));
        myRule.addCondition(myCondition);
        mySimpleStrat.addRule(myRule);
        ApplicationUnderTest.addStrategy(mySimpleStrat);
        File testingFile = new File(ExpectedFileExists);
        assertTrue(testingFile.exists());
        
        
        testingFile.delete();
    }
    
    @Test
    public void testSavingStrategyByParts(){
    	File testingFile;
        String ExpectedFileExists = PathToStrategies + "TestingComponent";
        
        IStrategy mySimpleStrat = new Strategy("TestSingleRule");
        ObjectFileSystem.saveObject(ExpectedFileExists, mySimpleStrat);
        testingFile = new File(ExpectedFileExists);
        assertTrue(testingFile.exists());
        testingFile.delete();
        
        IRule myRule = new Rule();
        ObjectFileSystem.saveObject(ExpectedFileExists, myRule);
        testingFile = new File(ExpectedFileExists);
        assertTrue(testingFile.exists());
        testingFile.delete();

        IMeasurement simpleAverage = new SimpleMovingAverage(1);
        ObjectFileSystem.saveObject(ExpectedFileExists, simpleAverage);
        testingFile = new File(ExpectedFileExists);
        assertTrue(testingFile.exists());
        testingFile.delete();
        
        IMeasurement expoChange = new ExponentialMovingAverage(1);
        ObjectFileSystem.saveObject(ExpectedFileExists, expoChange);
        testingFile = new File(ExpectedFileExists);
        assertTrue(testingFile.exists());
        testingFile.delete();
        
        IMeasurement relativeChange = new IndicatorRelativeChange(new SimpleMovingAverage(5), 3);
        ObjectFileSystem.saveObject(ExpectedFileExists, relativeChange);
        testingFile = new File(ExpectedFileExists);
        assertTrue(testingFile.exists());
        testingFile.delete();
        
        IMeasurement absChange = new IndicatorAbsoluteChange(new SimpleMovingAverage(5), 3);
        ObjectFileSystem.saveObject(ExpectedFileExists, absChange);
        testingFile = new File(ExpectedFileExists);
        assertTrue(testingFile.exists());
        testingFile.delete();
        
        ICondition myCondition = new StaticCondition(simpleAverage, ICondition.Comparator.EQ, new BigDecimal(10));
        ObjectFileSystem.saveObject(ExpectedFileExists, myCondition);
        testingFile = new File(ExpectedFileExists);
        assertTrue(testingFile.exists());
        testingFile.delete();
        
        IAction myAction = new Action(IAction.ActionType.BUY, 10);
        ObjectFileSystem.saveObject(ExpectedFileExists, myAction);
        testingFile = new File(ExpectedFileExists);
        assertTrue(testingFile.exists());
        testingFile.delete();
    }

    @Test
    public void testSavingLoadingStrategy(){
        String ExpectedFileExists = PathToStrategies + "TestSaving";
        IStrategy myStrategy = new Strategy("TestSaving");
        ApplicationUnderTest.addStrategy(myStrategy);
        File testingFile = new File(ExpectedFileExists);
        assertTrue(testingFile.exists());

        IStrategy expectedMyStrategy = ApplicationUnderTest.getStrategy("TestSaving");
        assertEquals(myStrategy, expectedMyStrategy);

        ApplicationUnderTest.clearMemory();

        expectedMyStrategy = ApplicationUnderTest.getStrategy("TestSaving");
        assertEquals(myStrategy.getName(), expectedMyStrategy.getName());

        testingFile.delete();
    }

    @Test
    public void testAvailableStrategiesEmpty(){
        assertTrue(ApplicationUnderTest.getAvailableStrategies().isEmpty());
    }

    @Test
    public void testAvailableStrategiesSingleStrategy(){
        IStrategy testStrategy = new Strategy("newStrategy");
        ApplicationUnderTest.addStrategy(testStrategy);
        Set<String> expectedSet = new HashSet<String>();
        expectedSet.add("newStrategy");
        assertEquals(ApplicationUnderTest.getAvailableStrategies(), expectedSet);
    }

    @Test
    public void testAvailableStrategiesSingleClearStrategy(){
        IStrategy testStrategy = new Strategy("newStrategy");
        ApplicationUnderTest.addStrategy(testStrategy);
        ApplicationUnderTest.clearMemory();
        Set<String> expectedSet = new HashSet<String>();
        expectedSet.add("newStrategy");
        assertEquals(ApplicationUnderTest.getAvailableStrategies(), expectedSet);
    }
}