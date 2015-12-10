package autotradingsim.application;

import static org.junit.Assert.*;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import autotradingsim.experiment.Experiment;
import autotradingsim.experiment.IExperiment;
import autotradingsim.strategy.IStrategy;
import autotradingsim.strategy.Strategy;

public class ApplicationExperimentTest {

    private static String PathToExperiments = System.getProperty("user.dir") + "//DATA//EXPERIMENTS//";
    ITradingApplication applicationUnderTest;

    @AfterClass
    public static void afterClass() {
        TradingApplication.destructObject();
    }

    @Before
    public void setUp() throws Exception {
        TradingApplication.clearMemoryAndFileSystem();
        TradingApplication.destructObject();
        applicationUnderTest = TradingApplication.getInstance();
    }

    @After
    public void tearDown() throws Exception {
        applicationUnderTest.clearMemory();
    }

    @Test
    public void testSetExperimentValid(){
        assertTrue(applicationUnderTest.addExperiment(new Experiment("TestSaving")));
    }

    @Test(expected = NullPointerException.class)
    public void testSetExperimentInvalid(){
        applicationUnderTest.addExperiment(null);
    }

    @Test
    public void testSetExperimentNameInvalid(){
        applicationUnderTest.addExperiment(new Experiment("Test"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetExperimentTwice(){
        IExperiment savingExperiment = new Experiment("Test");
        assertTrue(applicationUnderTest.addExperiment(savingExperiment));
        applicationUnderTest.addExperiment(savingExperiment);
    }

    @Test(expected = NullPointerException.class)
    public void testSetExperimentTwiceNullSecond(){
        IExperiment savingExperiment = new Experiment("Test");
        assertTrue(applicationUnderTest.addExperiment(savingExperiment));
        applicationUnderTest.addExperiment(null);
    }

    @Test
    public void testSetExperimentTwiceNullFirst(){
        IExperiment savingExperiment = new Experiment("Test");
        Set<String> firstExpSet = applicationUnderTest.getAvailableExperiments();
        try {
            applicationUnderTest.addExperiment(null);
        } catch (NullPointerException e) {
            assertEquals(firstExpSet, applicationUnderTest.getAvailableExperiments());
        }
        assertTrue(applicationUnderTest.addExperiment(savingExperiment));
    }

    @Test
    public void testGetExperimentValidExperiment(){
        IExperiment savingExperiment = new Experiment("TestSaving");
        applicationUnderTest.addExperiment(savingExperiment);
        assertEquals(savingExperiment, applicationUnderTest.getExperiment("TestSaving"));
    }

    @Test
    public void testGetExperimentNullExperimentName(){
        assertEquals(applicationUnderTest.getExperiment(null), null);
    }

    @Test
    public void testGetExperimentMultipleExperiments(){
        IExperiment savingExperiment1 = new Experiment("TestSaving1");
        IExperiment savingExperiment2 = new Experiment("TestSaving2");
        applicationUnderTest.addExperiment(savingExperiment1);
        applicationUnderTest.addExperiment(savingExperiment2);
        assertEquals(savingExperiment1, applicationUnderTest.getExperiment("TestSaving1"));
        assertEquals(savingExperiment2, applicationUnderTest.getExperiment("TestSaving2"));
    }

    @Test
    public void testGetExperimentMultipleGetExperiment(){
        IExperiment savingExperiment1 = new Experiment("TestSaving1");
        applicationUnderTest.addExperiment(savingExperiment1);
        assertEquals(savingExperiment1, applicationUnderTest.getExperiment("TestSaving1"));
        assertEquals(savingExperiment1, applicationUnderTest.getExperiment("TestSaving1"));
    }

    @Test
    public void testSavingExperiment(){
        String ExpectedFileExists = PathToExperiments + "TestSaving";
        applicationUnderTest.addExperiment(new Experiment("TestSaving"));
        File testingFile = new File(ExpectedFileExists);
        assertTrue(testingFile.exists());
        testingFile.delete();
    }

    @Test
    public void testSavingLoadingExperiment(){
    	IStrategy newStrategy = new Strategy();
    	applicationUnderTest.addStrategy(newStrategy);
    	
        String ExpectedFileExists = PathToExperiments + "TestSaving";
        IExperiment myExperiment = new Experiment("TestSaving");
        
        myExperiment.addTrial(newStrategy.getName(), "AAPL");
        applicationUnderTest.addExperiment(myExperiment);
        File testingFile = new File(ExpectedFileExists);
        assertTrue(testingFile.exists());

        IExperiment expectedMyExperiment = applicationUnderTest.getExperiment("TestSaving");
        assertEquals(myExperiment, expectedMyExperiment);

        applicationUnderTest.clearMemory();

        expectedMyExperiment = applicationUnderTest.getExperiment("TestSaving");
        assertEquals(myExperiment.getName(), expectedMyExperiment.getName());

        testingFile.delete();
    }

    @Test
    public void testAvailableExperimentsEmpty(){
        assertTrue(applicationUnderTest.getAvailableExperiments().isEmpty());
    }

    @Test
    public void testAvailableExperimentsSingleExperiment(){
        IExperiment testExperiment = new Experiment("newExperiment");
        applicationUnderTest.addExperiment(testExperiment);
        Set<String> expectedSet = new HashSet<String>();
        expectedSet.add("newExperiment");
        assertEquals(applicationUnderTest.getAvailableExperiments(), expectedSet);
    }

    @Test
    public void testAvailableExperimentsSingleClearExperiment(){
        IExperiment testExperiment = new Experiment("newExperiment");
        applicationUnderTest.addExperiment(testExperiment);
        applicationUnderTest.clearMemory();
        Set<String> expectedSet = new HashSet<String>();
        expectedSet.add("newExperiment");
        assertEquals(applicationUnderTest.getAvailableExperiments(), expectedSet);
    }

    @Test(expected = NullPointerException.class)
    public void testDeleteExperimentNull(){
        applicationUnderTest.delExperiment(null);
    }
    
    @Test
    public void testDeleteExperiment(){
        String ExpectedFileExists = PathToExperiments + "TestSaving";
        applicationUnderTest.addExperiment(new Experiment("TestSaving"));
        File testingFile = new File(ExpectedFileExists);
        assertTrue(testingFile.exists());
        
        assertTrue(applicationUnderTest.delExperiment("TestSaving"));
        assertFalse(testingFile.exists());
        //assertTrue(applicationUnderTest.getExperiment("TestSaving") == null);
    }
    
    @Test
    public void testDeleteExperimentClearMem(){
        String expectedFilePath = PathToExperiments + "TestSaving";

        applicationUnderTest.addExperiment(new Experiment("TestSaving"));
        File testingFile = new File(expectedFilePath);
        assertTrue(testingFile.exists());
        
        applicationUnderTest.clearMemory();
        assertTrue(applicationUnderTest.delExperiment("TestSaving"));
        assertFalse(testingFile.exists());
        //assertTrue(applicationUnderTest.getExperiment("TestSaving") == null);
    }
}