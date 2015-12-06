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

public class ExperimentTest {

    private String PathToExperiments = System.getProperty("user.dir") + "//DATA//EXPERIMENTS//";
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
    public void testSetExperimentValid(){
        assertTrue(ApplicationUnderTest.addExperiment(new Experiment("TestSaving")));
    }

    @Test(expected = NullPointerException.class)
    public void testSetExperimentInvalid(){
        ApplicationUnderTest.addExperiment(null);
    }

    @Test
    public void testSetExperimentNameInvalid(){
        ApplicationUnderTest.addExperiment(new Experiment("Test"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetExperimentTwice(){
        IExperiment savingExperiment = new Experiment("Test");
        assertTrue(ApplicationUnderTest.addExperiment(savingExperiment));
        ApplicationUnderTest.addExperiment(savingExperiment);
    }

    @Test(expected = NullPointerException.class)
    public void testSetExperimentTwiceNullSecond(){
        IExperiment savingExperiment = new Experiment("Test");
        assertTrue(ApplicationUnderTest.addExperiment(savingExperiment));
        ApplicationUnderTest.addExperiment(null);
    }

    @Test
    public void testSetExperimentTwiceNullFirst(){
        IExperiment savingExperiment = new Experiment("Test");
        try {
            ApplicationUnderTest.addExperiment(null);
        } catch (NullPointerException e) {
            System.out.println("Caught NullPointerException");
        }
        assertTrue(ApplicationUnderTest.addExperiment(savingExperiment));
    }

    @Test
    public void testGetExperimentValidExperiment(){
        IExperiment savingExperiment = new Experiment("TestSaving");
        ApplicationUnderTest.addExperiment(savingExperiment);
        assertEquals(savingExperiment, ApplicationUnderTest.getExperiment("TestSaving"));
    }

    @Test
    public void testGetExperimentNullExperimentName(){
        assertEquals(ApplicationUnderTest.getExperiment(null), null);
    }

    @Test
    public void testGetExperimentMultipleExperiments(){
        IExperiment savingExperiment1 = new Experiment("TestSaving1");
        IExperiment savingExperiment2 = new Experiment("TestSaving2");
        ApplicationUnderTest.addExperiment(savingExperiment1);
        ApplicationUnderTest.addExperiment(savingExperiment2);
        assertEquals(savingExperiment1, ApplicationUnderTest.getExperiment("TestSaving1"));
        assertEquals(savingExperiment2, ApplicationUnderTest.getExperiment("TestSaving2"));
    }

    @Test
    public void testGetExperimentMultipleGetExperiment(){
        IExperiment savingExperiment1 = new Experiment("TestSaving1");
        IExperiment savingExperiment2 = new Experiment("TestSaving2");
        ApplicationUnderTest.addExperiment(savingExperiment1);
        ApplicationUnderTest.addExperiment(savingExperiment2);
        assertEquals(savingExperiment1, ApplicationUnderTest.getExperiment("TestSaving1"));
        assertEquals(savingExperiment1, ApplicationUnderTest.getExperiment("TestSaving1"));
    }

    @Test
    public void testSavingExperiment(){
        String ExpectedFileExists = PathToExperiments + "TestSaving";
        ApplicationUnderTest.addExperiment(new Experiment("TestSaving"));
        File testingFile = new File(ExpectedFileExists);
        assertTrue(testingFile.exists());
        testingFile.delete();
    }

    @Test
    public void testSavingLoadingExperiment(){
    	IStrategy newStrategy = new Strategy();
    	ApplicationUnderTest.setStrategy(newStrategy);
    	
        String ExpectedFileExists = PathToExperiments + "TestSaving";
        IExperiment myExperiment = new Experiment("TestSaving");
        
        myExperiment.addTrial(newStrategy.getName(), "AAPL");
        System.out.println(myExperiment.getAllStocks());
        ApplicationUnderTest.addExperiment(myExperiment);
        File testingFile = new File(ExpectedFileExists);
        assertTrue(testingFile.exists());

        IExperiment expectedMyExperiment = ApplicationUnderTest.getExperiment("TestSaving");
        assertEquals(myExperiment, expectedMyExperiment);

        ApplicationUnderTest.clearMemory();

        expectedMyExperiment = ApplicationUnderTest.getExperiment("TestSaving");
        assertEquals(myExperiment.getName(), expectedMyExperiment.getName());

        testingFile.delete();
    }

    @Test
    public void testAvailableExperimentsEmpty(){
        assertTrue(ApplicationUnderTest.getAvailableExperiments().isEmpty());
    }

    @Test
    public void testAvailableExperimentsSingleExperiment(){
        IExperiment testExperiment = new Experiment("newExperiment");
        ApplicationUnderTest.addExperiment(testExperiment);
        Set<String> expectedSet = new HashSet<String>();
        expectedSet.add("newExperiment");
        assertEquals(ApplicationUnderTest.getAvailableExperiments(), expectedSet);
    }

    @Test
    public void testAvailableExperimentsSingleClearExperiment(){
        IExperiment testExperiment = new Experiment("newExperiment");
        ApplicationUnderTest.addExperiment(testExperiment);
        ApplicationUnderTest.clearMemory();
        Set<String> expectedSet = new HashSet<String>();
        expectedSet.add("newExperiment");
        assertEquals(ApplicationUnderTest.getAvailableExperiments(), expectedSet);
    }

    @Test
    public void testDeleteExperimentNull(){
        assertFalse(ApplicationUnderTest.delExperiment(null));
    }
    
    @Test
    public void testDeleteExperiment(){
        String ExpectedFileExists = PathToExperiments + "TestSaving";
        ApplicationUnderTest.addExperiment(new Experiment("TestSaving"));
        File testingFile = new File(ExpectedFileExists);
        assertTrue(testingFile.exists());
        
        assertTrue(ApplicationUnderTest.delExperiment("TestSaving"));
        assertFalse(testingFile.exists());
        //assertTrue(ApplicationUnderTest.getExperiment("TestSaving") == null);
    }
    
    @Test
    public void testDeleteExperimentClearMem(){
        String ExpectedFileExists = PathToExperiments + "TestSaving";
        ApplicationUnderTest.addExperiment(new Experiment("TestSaving"));
        File testingFile = new File(ExpectedFileExists);
        assertTrue(testingFile.exists());
        
        ApplicationUnderTest.clearMemory();
        
        assertTrue(ApplicationUnderTest.delExperiment("TestSaving"));
        assertFalse(testingFile.exists());
        //assertTrue(ApplicationUnderTest.getExperiment("TestSaving") == null);
    }
}