package autotradingsim.experiment;
import autotradingsim.application.TradingApplication;

import autotradingsim.strategy.simpleimpl.SimpleStrategy;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
/**
 * Created by Bill Feng on 15-11-02.
 *
 */
public class ExperimentTest {
	Experiment test;
	
	@Before
	public void setUp(){
		this.test = new Experiment("experiment1");
	}
	
    @Test
    public void testExperimentName(){
        assertEquals(test.getName(),"experiment1");
    }

    @Test
    public void testExperimentSetName(){
        test.setName("experiment2");
        assertEquals(test.getName(), "experiment2");
    }

    @Test
    public void testExperimentAddStock(){
        Experiment test3 = new Experiment("experiment3");
        test3.addStock("AAPL");
    }

    @Test(expected=IllegalArgumentException.class)
    public void testAddingNonExistingStock(){
        test.addStock("LOL");
    }

    @Test
    public void testExperimentAddStrategy(){
        SimpleStrategy s = new SimpleStrategy();
        TradingApplication.getInstance().setStrategy(s.getName(), s);
        test.addStrategy(s.getName());
    }

    @Test(expected=IllegalArgumentException.class)
    public void testAddNonExistingStrategy(){
        test.addStrategy("nameA");
    }

    @Test
    public void testRunExperiment1(){
        test.addStock("AAPL");
        test.addStock("MSFT");

        SimpleStrategy s = new SimpleStrategy();
        TradingApplication.getInstance().setStrategy(s.getName(), s);
        String id = s.getName();
        //TradingApplication.getInstance().saveStrategy(s);

        test.addTrial(id, "AAPL");
        test.addTrial(id, "MSFT");

        test.addStrategy(id);
        //TODO fix run experiment
        //test7.runExperiment();
    }
    
    @After
    public void tearDown(){
    	this.test= null;
    	TradingApplication.getInstance().clearMemory();
    }
}
