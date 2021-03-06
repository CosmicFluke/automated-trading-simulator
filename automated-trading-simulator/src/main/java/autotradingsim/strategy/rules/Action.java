package autotradingsim.strategy.rules;

import autotradingsim.experiment.Experiment;
import autotradingsim.experiment.ResultDay;
import autotradingsim.experiment.TimeSet;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>Actions always specify a type (through enum {@link IAction.ActionType}) and a quantity.</p>
 * <p>Quantity can be specified in three ways:<br>
 *     <li>As a constant integer value</li>
 *     <li>As a fraction of cash balance (see {@link Experiment#runExperiment(TimeSet)} and {@link
 *     ResultDay#getClosingBalance()}), such that the quantity bought or sold will be the quotient of the given
 *     fraction divided by the value of the stock</li>
 *     <li>As a {@link IActionQuantity} function, which returns an integer quantity based on three parameters: balance,
 *     stock value, and a confidence factor (see enum {@link ConfidenceFactor}</li>
 * </p>
 */
public class Action implements IAction, Serializable {

	private static final long serialVersionUID = 7261229972405060856L;
	public final ActionType type;
	public final IActionQuantity quantity;

	/**
	 * Create a new Action instance with the given type and fixed (constant) quantity value
	 * @param type Action type
	 * @param quantity Constant value to specify a quantity for the action
	 */
	public Action(ActionType type, int quantity) {
		this.type = type;
		this.quantity = (IActionQuantity & Serializable)(a, b, c, d) -> quantity;
	}

	/**
	 * Create a new Action instance with the given type and a multiplier of the cash balance to use to buy or sell
	 * @param type Action type
	 * @param balanceMultiplier specifies how much of the remaining cash balance to spend buying stock or to gain by selling stock
	 */
	public Action(ActionType type, BigDecimal balanceMultiplier) {
		this(type,
				(IActionQuantity & Serializable)
						(BigDecimal balance, BigDecimal stockValue, int numSharesOwned, ConfidenceFactor c) ->
						balance.multiply(balanceMultiplier).divide(stockValue, BigDecimal.ROUND_FLOOR).intValue());
	}

	/**
	 * Create a new Action instance with the given type and complete quantity function
	 * @param type Action type
	 * @param quantityFunction Function that produces a quantity based on a cash balance, stock price, and confidence factor
	 */
	public Action(ActionType type, IActionQuantity quantityFunction) {
		this.type = type;
		this.quantity = (IActionQuantity & Serializable) quantityFunction;
	}

	@Override
	public ActionType getActionType() {
		return this.type;
	}

	@Override
	public IActionQuantity getQuantity() {
		return this.quantity;
	}

    @Override
    public String toString() {
    	String action = "";
    	switch(type){
    	case BUY:
    		action = "Buy";
    		break;
    	case SELL:
    		action = "Sell";
    		break;
    	case SHORT:
    		action = "Short";
    		break;
    	case COVER:
    		action = "Cover";
    		break;
    	default:
    		throw new IllegalArgumentException("action type not understood by tostring");
    	}
        return "" + action + " " + String.valueOf(quantity);
    }
}
