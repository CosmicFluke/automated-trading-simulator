package autotradingsim.experiment;
import autotradingsim.application.TradingApplication;

import autotradingsim.strategy.Strategy;
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
        TradingApplication.getInstance()
                .setStrategy("Empty Strategy", new Strategy("Empty Strategy", "Empty Strategy for testing"));
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

    @Test(expected=IllegalArgumentException.class)
    public void testAddingTrialNonExistingStock(){
        test.addTrial("Empty Strategy", "LOL");
    }

    @Test(expected=IllegalArgumentException.class)
    public void testAddTrialNonExistingStrategy(){
        test.addTrial("nameA", "AAPL");
    }

    @Test
    public void testRunExperiment1(){

        SimpleStrategy s = new SimpleStrategy();

        TradingApplication.getInstance().setStrategy(s.getName(), s);

        String id = s.getName();

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
