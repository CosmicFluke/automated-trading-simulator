package autotradingsim.strategy.rules;

/**
 * Created by Asher on 2015-10-30.
 */
public interface IAction {


    /**
     * Enumerates the various types of possible actions
     */
    enum ActionType {
        BUY, SELL, SHORT, COVER
    }

    ActionType getActionType();

    /**
     * Gets the IActionQuantity object associated with this action.  IActionQuantities may be as simple as a
     * constant quantity, but the interface implicitly supports more dynamic quantities.
     * NOTE: Sorry for making this complicated.  It's a way of maintaining robustness & extensibility.
     * @return
     */
    IActionQuantity getQuantity();

}
