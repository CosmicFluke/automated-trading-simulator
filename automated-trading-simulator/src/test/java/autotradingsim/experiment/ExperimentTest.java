package autotradingsim.experiment;
import autotradingsim.application.TradingApplication;
import autotradingsim.strategy.IDecision;
import autotradingsim.strategy.IStrategy;
import autotradingsim.strategy.Strategy;
import autotradingsim.util.Pair;
import autotradingsim.util.StrategyDemoFactory;
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
	enum Detail {MINIMUM, DAILY};
    @Before
	public void setUp(){
        TradingApplication.clearMemoryAndFileSystem();
        TradingApplication.getInstance()
                .addStrategy(new Strategy("Empty Strategy", "Empty Strategy for testing"));
		this.test = new Experiment("experiment1");
	}

    @Test
    public void testExperimentName(){
        assertEquals(test.getName(), "experiment1");
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
    public void testRunExperimentBasicStrategy(){

        IStrategy s = StrategyDemoFactory.newBasicStrategy(BigDecimal.valueOf(95), BigDecimal.valueOf(101), 100, 50);

        TradingApplication.getInstance().addStrategy(s);

        String id = s.getName();

        test.addTrial(id, "AAPL");

        TimeSet ts1 = new TimeSet(1, 2, LocalDate.of(2015, 10, 15), LocalDate.of(2015, 10, 16));

        ExperimentResults resultList = test.runExperiment(ts1);
        assertNotEquals(null, resultList);

        // assertEquals(resultList.getResultAt(0).getBalanceRelativeChange().compareTo(new BigDecimal(0.8)), -1);
    }

    @Test
    public void testRunExperimentAdvancedStrategy() {
        IStrategy testStrat = StrategyDemoFactory.newAdvancedTestingStrategy();

        String id = testStrat.getName();

        TradingApplication.getInstance().addStrategy(testStrat);

        test.addTrial(id, "AAPL");

        TimeSet ts1 = new TimeSet(1, 2, LocalDate.of(2015, 10, 15), LocalDate.of(2015, 10, 16));

        ExperimentResults resultList = test.runExperiment(ts1);
        assertNotEquals(null, resultList);
    }


    /**
     * Test only for demo purposes.
     */
    @Test
    public void testRunExperiment1(){
        System.out.println("running Test 1===================");
        ExperimentResults experimentResults;
        IStrategy strategy =  StrategyDemoFactory.newBasicStrategy(new BigDecimal(110), new BigDecimal(115), 3, 300);

        TradingApplication.getInstance().addStrategy(strategy);

        String id = strategy.getName();

        test.addTrial(id, "AAPL");
        Detail detailLevel;
        detailLevel = Detail.DAILY;
        Iterator<ResultDay> results;
        ResultDay currentResultDay;
        TimeSet ts1 = new TimeSet(2, 30, LocalDate.of(2015, 8, 15), LocalDate.of(2015, 10, 15));
        experimentResults = test.runExperiment(ts1);

        for (int i = 0; i < experimentResults.size(); i++){
        	System.out.println("Results for timeset from: "
        			+ experimentResults.getResultAt(i).getStartDate().toString()
        			+ " to " + experimentResults.getResultAt(i).getEndDate().toString());
        	if (detailLevel == Detail.DAILY){
        		results = experimentResults.getResultAt(i).getResultDays().iterator();
	        	while (results.hasNext()){
	        		currentResultDay = results.next();
	        		System.out.println("Result for: " + currentResultDay.getDate().toString());
	        		System.out.println("\t\t\t" + currentResultDay.getClosingBalance());
	        		for (IDecision decision: currentResultDay.getDecisions()){
	        			System.out.println("\t\t\t" + decision.getActionType().toString() + " " + decision.getStockSymbol());
                        for (Map.Entry<String, Integer> share : currentResultDay.getNumShares().entrySet()){
                            System.out.println(share.getKey() + ": " + share.getValue());
                        }

	        		}
	        	}
    		}

        	System.out.println("Opening balance: " + experimentResults.getResultAt(i).getOpeningBalance());
        	System.out.println("Closing balance: " + experimentResults.getResultAt(i).getClosingBalance());
        	detailLevel = Detail.MINIMUM;
        }
//        assertEquals(resultList.get(0).getBalanceRelativeChange().compareTo(new BigDecimal(0.8)), -1);
    }

    /**
     * Test only for demo purposes.
     */
    @Test
    public void testRunExperiment2(){
        System.out.println("Running Test 2====================");
        ExperimentResults experimentResults;
        IStrategy strategy =  StrategyDemoFactory.newBasicStrategy(new BigDecimal(110), new BigDecimal(115), 3, 300);
//        IStrategy strategy1 = TradingApplication.getInstance().getStrategy("Basic strategy");

        TradingApplication.getInstance().addStrategy(strategy);

        String id = strategy.getName();

        test.addTrial(id, "AAPL");
        Detail detailLevel;
        detailLevel = Detail.MINIMUM;
        Iterator<ResultDay> results;
        ResultDay result;
        TimeSet ts1 = new TimeSet(1, 365, LocalDate.of(2014, 1, 1), LocalDate.of(2015, 1, 1));
        experimentResults = test.runExperiment(ts1);
        for (int i = 0; i < experimentResults.size(); i++){
        	System.out.println("Results for timeset from: "
        			+ experimentResults.getResultAt(i).getStartDate().toString()
        			+ " to " + experimentResults.getResultAt(i).getEndDate().toString());
        	if (detailLevel == Detail.DAILY){
        		results = experimentResults.getResultAt(i).getResultDays().iterator();
	        	while (results.hasNext()){
	        		result = results.next();
	        		System.out.println("Result for: " + result.getDate().toString());
	        	}
    		}

        	System.out.println("Opening balance: " + experimentResults.getResultAt(i).getOpeningBalance());
        	System.out.println("Closing balance: " + experimentResults.getResultAt(i).getClosingBalance());
        	detailLevel = Detail.MINIMUM;
        }
//        assertEquals(resultList.get(0).getBalanceRelativeChange().compareTo(new BigDecimal(0.8)), -1);
    }

//    @Test
//    public void testRunExperiment3(){
//
//        IStrategy advancedStrategy = StrategyDemoFactory.newAdvancedTestingStrategy();
//        TradingApplication.getInstance().addStrategy(advancedStrategy.getName(), advancedStrategy);
//
//        String advancedStrategyName = advancedStrategy.getName();
//
//        test.addTrial(advancedStrategyName, "A");
//        Detail detailLevel;
//        detailLevel = Detail.DAILY;
//        Iterator<ResultDay> results;
//        ResultDay result;
//        TimeSet ts1 = new TimeSet(1, 365, LocalDate.of(2014, 1, 1), LocalDate.of(2015, 1, 1));
//        List<Result> resultList = test.runExperiment(ts1);
//        for (int i = 0; i < resultList.size(); i++){
//            System.out.println("Results for timeset from: "
//                    + resultList.get(i).getStartDate().toString()
//                    + " to " + resultList.get(i).getEndDate().toString());
//            if (detailLevel == Detail.DAILY){
//                results = resultList.get(i).getResultDays().iterator();
//                while (results.hasNext()){
//                    result = results.next();
//                    System.out.println("Result for: " + result.getDate().toString());
//                }
//            }
//
//            System.out.println("Opening balance: " + resultList.get(i).getOpeningBalance());
//            System.out.println("Closing balance: " + resultList.get(i).getClosingBalance());
//            detailLevel = Detail.MINIMUM;
//        }
////        assertEquals(resultList.get(0).getBalanceRelativeChange().compareTo(new BigDecimal(0.8)), -1);
//    }
    
    @After
    public void tearDown(){
    	this.test= null;
    	TradingApplication.getInstance().clearMemory();
    }
}
