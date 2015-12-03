package autotradingsim.engine;
import autotradingsim.application.TradingApplication;
import autotradingsim.engine.ExperimentEngine;
import autotradingsim.experiment.*;
import autotradingsim.strategy.IStrategy;
import autotradingsim.strategy.Strategy;
import autotradingsim.deprecated.simpleimpl.SimpleStrategy;
import autotradingsim.strategy.StrategyTester;
import autotradingsim.util.Pair;
import autotradingsim.util.StrategyDemoFactory;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.omg.CORBA.FREE_MEM;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

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
        testEngine = ExperimentEngine.getInstance();
        application = TradingApplication.getInstance();
    }

    @Test
    public void testCreateExperiment(){
        experiment = testEngine.createExperiment("test");
        assertEquals(application.getExperiment("test"), experiment);
    }

    @Test
    public void testExperimentAddTrial(){
        experiment = application.getExperiment("test");
        IStrategy testStrat = new Strategy("teststrat");
        application.setStrategy(testStrat);
        experiment.addTrial("teststrat", "AAPL");
        assert(experiment.getAllTrials().get("teststrat").contains("AAPL"));
    }

    @Test
    public void testGenerateTimeSet(){
        experiment = application.getExperiment("test");
        experiment.addTrial("teststrat", "IPG");
        experiment.addTrial("teststrat", "AAPL");
        LocalDate expectedStartDate = LocalDate.of(1987,11,05);
        LocalDate expectedEndDate = LocalDate.of(2015,10,16);
        Pair<LocalDate, LocalDate> expectedTimeSet = new Pair<> (expectedStartDate, expectedEndDate);
        assertEquals(expectedTimeSet.x,testEngine.generateTimeSet(experiment).x);
        assertEquals(expectedTimeSet.y, testEngine.generateTimeSet(experiment).y);
    }

    @After
    public void tearDown(){
        application.clearMemory();
    }
}
