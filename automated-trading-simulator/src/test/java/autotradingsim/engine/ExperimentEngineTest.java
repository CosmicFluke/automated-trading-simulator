package autotradingsim.engine;
import autotradingsim.application.TradingApplication;
import autotradingsim.experiment.*;
import autotradingsim.strategy.IStrategy;
import autotradingsim.strategy.Strategy;
import autotradingsim.util.Pair;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.time.LocalDate;

import static org.junit.Assert.*;
/**
 * Created by Bill Feng on 15-11-02.
 * Contributors: Ujash, Myung In (Justin)
 */
public class ExperimentEngineTest {
    ExperimentEngine testEngine;
    TradingApplication application;
    IExperiment experiment;
    @Before
    public void setUp(){
        TradingApplication.clearMemoryAndFileSystem();
        testEngine = ExperimentEngine.getInstance();
        application = TradingApplication.getInstance();
        experiment = testEngine.createExperiment("test1");
        application.getExperiment("test1");
        IStrategy testStrat = new Strategy("teststrat");
        application.addStrategy(testStrat);
    }

    @Test
    public void testCreateExperiment(){

        experiment = testEngine.createExperiment("test2");
        assertEquals(application.getExperiment("test2").getAllTrials(), experiment.getAllTrials());
    }

    @Test
    public void testExperimentAddTrial(){
        experiment = application.getExperiment("test1");
        experiment.addTrial("teststrat", "AAPL");
        assertTrue(experiment.getAllTrials().get("teststrat").contains("AAPL"));
    }

    @Test
    public void testGenerateTimeSet(){
        experiment = application.getExperiment("test1");
        experiment.addTrial("teststrat", "IPG");
        experiment.addTrial("teststrat", "AAPL");
        LocalDate expectedStartDate = LocalDate.of(1987,11,5);
        LocalDate expectedEndDate = LocalDate.of(2015,10,16);
        Pair<LocalDate, LocalDate> expectedTimeSet = new Pair<> (expectedStartDate, expectedEndDate);
        assertEquals(expectedTimeSet.x,testEngine.generateTimeSet(experiment).x);
        assertEquals(expectedTimeSet.y, testEngine.generateTimeSet(experiment).y);
    }

    @After
    public void tearDown(){
        TradingApplication.clearMemoryAndFileSystem();
    }
}
