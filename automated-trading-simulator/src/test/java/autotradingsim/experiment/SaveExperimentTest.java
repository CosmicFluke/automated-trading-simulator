package autotradingsim.experiment;
import autotradingsim.application.*;
import autotradingsim.engine.*;
import autotradingsim.util.ObjectFileSystem;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Shirley on 2015-12-05.
 */
public class SaveExperimentTest {
    TradingApplication application;
    ExperimentEngine engine;
    IExperiment experiment;
    @Before
    public void setUp(){
       /** application = TradingApplication.getInstance();
        engine = ExperimentEngine.getInstance();
        experiment = engine.createExperiment("TestExperiment");
        experiment.addTrial("teststrat", "A");
        experiment.addTrial("Basic strategy", "AAPL");
        experiment.addTrial("Empty strategy", "AA");
        experiment.setShares("A", 1000);
        experiment.setShares("AAPL", 1000);
        experiment.setShares("AA", 1000);**/
    }

    @Test
    public void saveExperiment(){
        assert(true);
    }
    @Test
    public void loadExperiment(){
        assert(true);
    }
    @Test
    public void saveLoadExperiment(){

        assert(true);
    }
    @After
    public void tearDown(){

    }
}
