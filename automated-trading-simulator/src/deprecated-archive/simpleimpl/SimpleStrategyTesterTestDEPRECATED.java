package autotradingsim.deprecated.simpleimpl;

import autotradingsim.strategy.rules.IDecisionMaker;
import autotradingsim.strategy.IStrategy;
import autotradingsim.strategy.rules.RuleID;
import autotradingsim.strategy.IStrategyTester;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by Asher on 2015-11-02.
 */
public class SimpleStrategyTesterTestDEPRECATED {

    private IStrategy strat;
    private IStrategyTester tester;

    @Before
    public void setUp() throws Exception {
        strat = new SimpleStrategy();
        tester = new SimpleStrategyTester(strat);

    }

    @Test
    public void testConstructor() throws Exception {
        Map<RuleID, IDecisionMaker> map = ((SimpleStrategyTester) tester).getMap();

        // Should be 1 rule
        assertEquals(1, map.size());


    }

    @Test
    public void testSetAll() throws Exception {

    }

    @Test
    public void testTestDate() throws Exception {

    }
}