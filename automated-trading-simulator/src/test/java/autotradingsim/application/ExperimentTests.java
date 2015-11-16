package autotradingsim.application;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import autotradingsim.experiment.Experiment;
import autotradingsim.experiment.IExperiment;

public class ExperimentTests {

	private String PathToExperiments = System.getProperty("user.dir") + "//DATA//EXPERIMENTS//";
	ITradingApplication ApplicationUnderTest = null;
	
	@AfterClass
	public static void afterClass() {
		TradingApplication.destructObject();
    }
	
	@Before
	public void setUp() throws Exception {
		File experiments = new File(PathToExperiments);
		if(experiments.exists() && experiments.isDirectory())
			for(File experiment : experiments.listFiles())
				experiment.delete();
		ApplicationUnderTest = TradingApplication.getInstance();
	}

	@After
	public void tearDown() throws Exception {
		ApplicationUnderTest.clearMemory();
	}

	@Test
	public void testSetExperimentValid(){
		assertTrue(ApplicationUnderTest.setExperiment("TestSaving", new Experiment("TestSaving")));
	}
	
	@Test
	public void testSetExperimentInValid(){
		assertFalse(ApplicationUnderTest.setExperiment("TestSaving", null));
	}
	
	@Test
	public void testSetExperimentNameInValid(){
		assertFalse(ApplicationUnderTest.setExperiment(null, new Experiment("Test")));
	}
	
	@Test
	public void testSetExperimentTwice(){
		IExperiment savingExperiment = new Experiment("Test");
		assertTrue(ApplicationUnderTest.setExperiment("Test", savingExperiment));
		assertFalse(ApplicationUnderTest.setExperiment("Test", savingExperiment));
	}
	
	@Test
	public void testSetExperimentTwiceNullSecond(){
		IExperiment savingExperiment = new Experiment("Test");
		assertTrue(ApplicationUnderTest.setExperiment("Test", savingExperiment));
		assertFalse(ApplicationUnderTest.setExperiment("Test", null));
	}
	
	@Test
	public void testSetExperimentTwiceNullFirst(){
		IExperiment savingExperiment = new Experiment("Test");
		assertFalse(ApplicationUnderTest.setExperiment("Test", null));
		assertTrue(ApplicationUnderTest.setExperiment("Test", savingExperiment));
	}
	
	@Test
	public void testGetExperimentValidExperiment(){
		String ExpectedFileExists = PathToExperiments + "TestSaving.bin";
		ApplicationUnderTest.setExperiment("TestSaving", new Experiment("TestSaving"));
		File testingFile = new File(ExpectedFileExists);
		assertTrue(testingFile.exists());
		testingFile.delete();
	}
	
	@Test
	public void testSavingExperiment(){
		String ExpectedFileExists = PathToExperiments + "TestSaving.bin";
		ApplicationUnderTest.setExperiment("TestSaving", new Experiment("TestSaving"));
		File testingFile = new File(ExpectedFileExists);
		assertTrue(testingFile.exists());
		testingFile.delete();
	}
	
	@Test
	public void testSavingLoadingExperiment(){
		String ExpectedFileExists = PathToExperiments + "TestSaving.bin";
		IExperiment myExperiment = new Experiment("TestSaving");
		ApplicationUnderTest.setExperiment("TestSaving", myExperiment);
		File testingFile = new File(ExpectedFileExists);
		assertTrue(testingFile.exists());
		
		IExperiment expectedMyExperiment = ApplicationUnderTest.getExperiment("TestSaving");
		assertEquals(myExperiment, expectedMyExperiment);
		
		ApplicationUnderTest.clearMemory();
		
		expectedMyExperiment = ApplicationUnderTest.getExperiment("TestSaving");
		assertEquals(myExperiment.getName(), expectedMyExperiment.getName());
		
		testingFile.delete();
	}

}
