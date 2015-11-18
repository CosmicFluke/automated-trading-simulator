package autotradingsim.application;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import autotradingsim.application.ITradingApplication;
import autotradingsim.application.TradingApplication;

public class BasicTest {

	ITradingApplication ApplicationUnderTest = null;
	
	@AfterClass
	public static void afterClass() {
		TradingApplication.destructObject();
    }
	
	@Before
	public void setUp() throws Exception {
		String PathToExperiments = System.getProperty("user.dir") + "//DATA//EXPERIMENTS";
		String PathToStrategies = System.getProperty("user.dir") + "//DATA//STRATEGIES";
		
		File experiments = new File(PathToExperiments);
		if(experiments.exists() && experiments.isDirectory())
			for(File experiment : experiments.listFiles())
				experiment.delete();
		
		new File(PathToStrategies).delete();
		ApplicationUnderTest = TradingApplication.getInstance();
	}

	@After
	public void tearDown() throws Exception {
		ApplicationUnderTest.clearMemory();
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
}
