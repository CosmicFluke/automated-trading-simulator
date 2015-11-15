package autotradingsim.application;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import autotradingsim.application.ITradingApplication;
import autotradingsim.application.TradingApplication;
import autotradingsim.experiment.Experiment;

public class BasicTest {

	private String PathToExperiments = "//DATA//EXPERIMENTS//";
	ITradingApplication ApplicationUnderTest = null;
	
	@Before
	public void setUp() throws Exception {
		ApplicationUnderTest = TradingApplication.getInstance();
	}

	@After
	public void tearDown() throws Exception {
		ApplicationUnderTest.ClearMemory();
	}

	@Test
	public void testSingleton() {
		assertTrue(ApplicationUnderTest == TradingApplication.getInstance());
	}

	@Test
	public void testEmptyStrategy(){
		assertTrue(ApplicationUnderTest.getAvailableStrategies().isEmpty());
	}
	
	@Test
	public void testEmptyExperiments(){
		assertTrue(ApplicationUnderTest.getAvailableExperiments().isEmpty());
	}
	
	@Test
	public void testSavingExperiment(){
		String ExpectedFileExists = System.getProperty("user.dir") + PathToExperiments + "ExperimentTestSaving.bin";
		ApplicationUnderTest.setExperiment("TestSaving", new Experiment("TestSaving"));
		File testingFile = new File(ExpectedFileExists);
		assertTrue(testingFile.exists());
		testingFile.delete();
	}
}
