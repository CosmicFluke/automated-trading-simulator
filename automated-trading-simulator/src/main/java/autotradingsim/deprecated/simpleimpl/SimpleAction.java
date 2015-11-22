package autotradingsim.deprecated.simpleimpl;

import autotradingsim.strategy.rules.Action;
import autotradingsim.strategy.rules.ConstantActionQuantity;
import autotradingsim.strategy.rules.IAction;
import autotradingsim.strategy.rules.IActionQuantity;

/**
 * Created by Asher on 2015-10-30.
 *
 * <p>Basic implementation of IAction, sufficient for early testing and possibly a beginner-level example strategy.</p>
 *
 * <p>Holds a <i>constant</i> quantity function for any given action type.  Future implementations of IAction will
 * <b>not</b> take a constant quantity as a parameter to the constructor.  Consider implementing a
 * "quantity function builder"</p>
 *
 * <p>**Deprecated in favour of {@link Action}, which has an equivalent constructor option.</p>
 *
 */
public class SimpleAction implements IAction {

    private ActionType type;
    private IActionQuantity quantity;

    public SimpleAction (ActionType type, int quantity) {
        this.type = type;
        this.quantity = new ConstantActionQuantity(quantity);
    }

    @Override
    public ActionType getActionType() {
        return this.type;
    }

    @Override
    public IActionQuantity getQuantity() {
        return this.quantity;
    }


}
