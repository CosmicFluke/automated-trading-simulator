package autotradingsim.strategy;

/**
 * Created by Asher on 2015-10-30.
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
