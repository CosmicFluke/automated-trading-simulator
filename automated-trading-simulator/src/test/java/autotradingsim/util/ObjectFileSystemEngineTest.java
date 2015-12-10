package autotradingsim.util;

import autotradingsim.application.TradingApplication;
import autotradingsim.engine.ExperimentEngine;
import autotradingsim.experiment.Experiment;
import autotradingsim.experiment.IExperiment;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * Created by Shirley on 2015-12-05.
 */
public class ObjectFileSystemEngineTest {
    static final String experimentName = "Test Experiment";
    TradingApplication application;
    ExperimentEngine engine;
    IExperiment experiment;


    @Before
    public void setUp(){
        TradingApplication.destructObject();
        application = TradingApplication.getInstance();
        engine = ExperimentEngine.getInstance();
        application.addStrategy(StrategyDemoFactory.newAdvancedStrategy());
        application.addStrategy(StrategyDemoFactory.newAdvancedTestingStrategy());
        application.addStrategy(StrategyDemoFactory.newBasicStrategy(new BigDecimal(20), new BigDecimal(10), 10, 10));
        experiment = new Experiment(experimentName);
        experiment.addTrial("Advanced Strategy 1", "A");
        experiment.addTrial("Basic strategy", "AAPL");
        experiment.addTrial("Advanced Testing Strategy", "AA");
        experiment.setShares("A", 1000);
        experiment.setShares("AAPL", 1000);
        experiment.setShares("AA", 1000);
    }

    @Test
    public void testSaveExperiment(){

        assertTrue(ObjectFileSystem.saveObject(experiment.getName(), experiment));

    }
    @Test
    public void testLoadExperiment(){
        ObjectFileSystem.saveObject(String.valueOf(experiment.getName()), experiment);
        IExperiment loaded = (IExperiment) ObjectFileSystem.loadObject(String.valueOf(experiment.getName()));
        assertTrue(loaded instanceof Experiment);
        assertEquals(loaded.getName(), experiment.getName());
        assertEquals(loaded.getAllTrials(), experiment.getAllTrials());

    }
    @Test
    public void testSaveLoadExperiment(){

    }

    @After
    public void tearDown(){
        File f = new File(experimentName);
        if (f.exists() && !f.delete()){
            System.err.println(
                    "ObjectFileSystemEngineTest: File couldn't be deleted: " +
                            "/\"" + experimentName + "\"");
        }
        TradingApplication.clearMemoryAndFileSystem();
    }
}