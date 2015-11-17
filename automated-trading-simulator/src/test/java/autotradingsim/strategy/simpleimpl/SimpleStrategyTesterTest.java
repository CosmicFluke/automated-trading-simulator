package autotradingsim.strategy.simpleimpl;

import autotradingsim.strategy.IDecisionMaker;
import autotradingsim.strategy.IStrategy;
import autotradingsim.strategy.RuleID;
import autotradingsim.strategy.StrategyTester;
import autotradingsim.strategy.simpleimpl.SimpleStrategy;
import autotradingsim.strategy.simpleimpl.SimpleStrategyTester;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by Asher on 2015-11-02.
 */
public class SimpleStrategyTesterTest {

    private IStrategy strat;
    private StrategyTester tester;

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