package autotradingsim.experiment;
import autotradingsim.application.TradingApplication;

import autotradingsim.strategy.simpleimpl.SimpleStrategy;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

import static org.junit.Assert.*;
/**
 * Created by Bill Feng on 15-11-02.
 * Contributors: Ujash, Myung In (Justin)
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

        SimpleStrategy s = new SimpleStrategy();

        TradingApplication.getInstance().setStrategy(s.getName(), s);

        String id = s.getName();

        test.addStrategy(id);

        test.addTrial(id, "AAPL");

        TimeSet ts1 = new TimeSet(1, 2, LocalDate.of(2015, 10, 15), LocalDate.of(2015, 10, 16));

        List<Result> resultList = test.runExperiment(ts1);

        assertEquals(resultList.get(0).getBalanceRelativeChange().compareTo(new BigDecimal(0.8)), -1);
        //TODO fix run experiment
        //test7.runExperiment();
    }
    
    @After
    public void tearDown(){
    	this.test= null;
    	TradingApplication.getInstance().clearMemory();
    }
}
