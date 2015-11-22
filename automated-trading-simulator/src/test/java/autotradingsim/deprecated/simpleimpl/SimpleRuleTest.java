package autotradingsim.deprecated.simpleimpl;

import autotradingsim.strategy.rules.IAction;
import autotradingsim.strategy.rules.ICondition;
import junit.framework.TestCase;

/**
 * Created by Asher on 2015-10-30.
 */
public class SimpleRuleTest extends TestCase {

    protected ICondition simpleCondition;
    protected IAction simpleAction;

    public void setUp() throws Exception {
        super.setUp();
        simpleAction = new SimpleAction(IAction.ActionType.BUY, 2);
        simpleCondition = null;

    }

    public void testGetRuleID() throws Exception {

    }

    public void testGetDecisionMaker() throws Exception {

    }

    public void testGetConditions() throws Exception {

    }

    public void testGetActions() throws Exception {

    }
}