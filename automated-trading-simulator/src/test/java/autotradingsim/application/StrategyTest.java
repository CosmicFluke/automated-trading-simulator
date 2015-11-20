package autotradingsim.application;

import static org.junit.Assert.*;

import java.io.File;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import autotradingsim.application.ITradingApplication;
import autotradingsim.application.TradingApplication;

import autotradingsim.strategy.*;
import autotradingsim.strategy.simpleimpl.SimpleCondition;
import autotradingsim.strategy.simpleimpl.SimpleStrategy;

public class StrategyTest {

	private String PathToStrategies = System.getProperty("user.dir") + File.separator + "DATA" + 
										File.separator + "STRATEGIES" + File.separator;
	ITradingApplication ApplicationUnderTest = null;
	
	@AfterClass
	public static void afterClass() {
		TradingApplication.destructObject();
    }
	
	@Before
	public void setUp() throws Exception {
		File strategies = new File(PathToStrategies);
		if(strategies.exists() && strategies.isDirectory())
			for(File strategy : strategies.listFiles())
				strategy.delete();
		ApplicationUnderTest = TradingApplication.getInstance();
	}

	@After
	public void tearDown() throws Exception {
		ApplicationUnderTest.clearMemory();
	}

	@Test
	public void testSetStrategyValid(){
		IStrategy testStrat = new Strategy("TestSaving");
		assertTrue(ApplicationUnderTest.setStrategy("TestSaving", testStrat));
	}
	
	@Test
	public void testSetStrategyInValid(){
		assertFalse(ApplicationUnderTest.setStrategy("TestSaving", null));
	}
	
	@Test
	public void testSetStrategyNameInValid(){
		assertFalse(ApplicationUnderTest.setStrategy(null, new Strategy("Test")));
	}
	
	@Test
	public void testSetStrategyTwice(){
		IStrategy savingStrategy = new Strategy("Test");
		assertTrue(ApplicationUnderTest.setStrategy("Test", savingStrategy));
		assertFalse(ApplicationUnderTest.setStrategy("Test", savingStrategy));
	}
	
	@Test
	public void testSetStrategyTwiceNullSecond(){
		IStrategy savingStrategy = new Strategy("Test");
		assertTrue(ApplicationUnderTest.setStrategy("Test", savingStrategy));
		assertFalse(ApplicationUnderTest.setStrategy("Test", null));
	}
	
	@Test
	public void testSetStrategyTwiceNullFirst(){
		IStrategy savingStrategy = new Strategy("Test");
		assertFalse(ApplicationUnderTest.setStrategy("Test", null));
		assertTrue(ApplicationUnderTest.setStrategy("Test", savingStrategy));
	}
	
	@Test
	public void testGetStrategyValidStrategy(){
		IStrategy savingStrategy = new Strategy("TestSaving");
		ApplicationUnderTest.setStrategy("TestSaving", savingStrategy);
		assertEquals(savingStrategy, ApplicationUnderTest.getStrategy("TestSaving"));
	}
	
	@Test
	public void testGetStrategyInValidStrategy(){
		assertEquals(ApplicationUnderTest.getStrategy("Invalid"), null);
	}
	
	@Test
	public void testGetStrategyNullStrategyName(){
		assertEquals(ApplicationUnderTest.getStrategy(null), null);
	}
	
	@Test
	public void testGetStrategyMultipleStrategys(){
		IStrategy savingStrategy1 = new Strategy("TestSaving1");
		IStrategy savingStrategy2 = new Strategy("TestSaving2");
		ApplicationUnderTest.setStrategy("TestSaving1", savingStrategy1);
		ApplicationUnderTest.setStrategy("TestSaving2", savingStrategy2);
		assertEquals(savingStrategy1, ApplicationUnderTest.getStrategy("TestSaving1"));
		assertEquals(savingStrategy2, ApplicationUnderTest.getStrategy("TestSaving2"));
	}
	
	@Test
	public void testGetStrategyMultipleGetStrategy(){
		IStrategy savingStrategy1 = new Strategy("TestSaving1");
		IStrategy savingStrategy2 = new Strategy("TestSaving2");
		ApplicationUnderTest.setStrategy("TestSaving1", savingStrategy1);
		ApplicationUnderTest.setStrategy("TestSaving2", savingStrategy2);
		assertEquals(savingStrategy1, ApplicationUnderTest.getStrategy("TestSaving1"));
		assertEquals(savingStrategy1, ApplicationUnderTest.getStrategy("TestSaving1"));
	}
	
	@Test
	public void testSavingEmptyStrategy(){
		String ExpectedFileExists = PathToStrategies + "TestSaving";
		ApplicationUnderTest.setStrategy("TestSaving", new Strategy("TestSaving"));
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
		
		ApplicationUnderTest.setStrategy("TestSingleRule", mySimpleStrat);
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
		
		ApplicationUnderTest.setStrategy("TestSingleRule", mySimpleStrat);
		File testingFile = new File(ExpectedFileExists);
		assertTrue(testingFile.exists());
		testingFile.delete();
	}
	
	@Test
	public void testSavingStrategyOneRuleOneCondition(){
		String ExpectedFileExists = PathToStrategies + "TestSingleRule";
		IStrategy mySimpleStrat = new Strategy("TestSingleRule");
		IRule myRule = new Rule();
		IAction action = new Action();
		myRule.addAction(action );
		//ICondition myCondition = new SimpleCondition(ICondition.Comparator.EQ, new BigDecimal(10));
		//myRule.addCondition(myCondition);
		//mySimpleStrat.addRule(myRule);
		// TODO Solidify the serialization of conditions
		ApplicationUnderTest.setStrategy("TestSingleRule", mySimpleStrat);
		File testingFile = new File(ExpectedFileExists);
		assertTrue(testingFile.exists());
		testingFile.delete();
	}
	
	@Test
	public void testSavingLoadingStrategy(){
		String ExpectedFileExists = PathToStrategies + "TestSaving";
		IStrategy myStrategy = new Strategy("TestSaving");
		ApplicationUnderTest.setStrategy("TestSaving", myStrategy);
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
		ApplicationUnderTest.setStrategy("newStrategy", testStrategy);
		Set<String> expectedSet = new HashSet<String>();
		expectedSet.add("newStrategy");
		assertEquals(ApplicationUnderTest.getAvailableStrategies(), expectedSet);
	}

	@Test
	public void testAvailableStrategiesSingleClearStrategy(){
		IStrategy testStrategy = new Strategy("newStrategy");
		ApplicationUnderTest.setStrategy("newStrategy", testStrategy);
		ApplicationUnderTest.clearMemory();
		Set<String> expectedSet = new HashSet<String>();
		expectedSet.add("newStrategy");
		assertEquals(ApplicationUnderTest.getAvailableStrategies(), expectedSet);
	}

	
}
