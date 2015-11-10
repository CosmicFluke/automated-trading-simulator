package autotradingsim.strategy;

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
     * Sorry for making this complicated.  It's a way of maintaining robustness & extensibility.
     * @return
     */
    IActionQuantity getQuantity();

}
