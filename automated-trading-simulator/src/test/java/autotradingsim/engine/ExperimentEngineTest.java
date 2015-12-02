package autotradingsim.engine;
import autotradingsim.application.TradingApplication;
import autotradingsim.engine.ExperimentEngine;
import autotradingsim.experiment.*;
import autotradingsim.strategy.IStrategy;
import autotradingsim.strategy.Strategy;
import autotradingsim.deprecated.simpleimpl.SimpleStrategy;
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

    @Before
    public void setUp(){
        testEngine = ExperimentEngine.getInstance();
        application = TradingApplication.getInstance();
    }

    @Test
    public void testCreateExperiment(){
        IExperiment experiment = testEngine.createExperiment("test");
        assertEquals(application.getExperiment("test"), experiment);
    }
    @Test
    public void testSaveExperiment(){

    }
    @Test
    public void testGetExperiment(){

    }
    @Test
    public void testGenerateTimeSet(){

    }
    @After
    public void tearDown(){
        ExperimentEngine.freeEngine();
    }
}
