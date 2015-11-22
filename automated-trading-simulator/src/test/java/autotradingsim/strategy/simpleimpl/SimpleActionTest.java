package autotradingsim.strategy.simpleimpl;

import autotradingsim.strategy.IAction;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * Created by Asher on 2015-11-02.
 */
public class SimpleActionTest {

    @Test
    public void testGetActionType() throws Exception {
        IAction simpleAction = new SimpleAction(IAction.ActionType.BUY, 10);
        assertEquals(simpleAction.getActionType(), IAction.ActionType.BUY);

        simpleAction = new SimpleAction(IAction.ActionType.SELL, 100000);
        assertEquals(simpleAction.getActionType(), IAction.ActionType.SELL);

    }

    @Test
    public void testGetQuantity() throws Exception {
        IAction simpleAction = new SimpleAction(IAction.ActionType.BUY, 1);
        assertEquals(simpleAction.getQuantity().getValue(BigDecimal.ONE, null, null), 1);

        simpleAction = new SimpleAction(IAction.ActionType.SELL, 99999);
        assertEquals(simpleAction.getQuantity().getValue(BigDecimal.TEN, null, null), 99999);
    }
}