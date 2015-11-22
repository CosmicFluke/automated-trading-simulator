package autotradingsim.strategy.rules;

import autotradingsim.experiment.Experiment;
import autotradingsim.experiment.ResultDay;
import autotradingsim.experiment.TimeSet;

import java.math.BigDecimal;
import java.util.function.Function;

/**
 * <p>Actions always specify a type (through enum {@link IAction.ActionType}) and a quantity.</p>
 * <p>Quantity can be specified in three ways:<br>
 *     <li>As a constant integer value</li>
 *     <li>As a fraction of balance (see {@link Experiment#runExperiment(TimeSet)} and {@link
 *     ResultDay#getClosingBalance()}), such that the quantity bought or sold will be the quotient of the given
 *     fraction divided by the value of the stock</li>
 *     <li>As a {@link IActionQuantity} function, which returns an integer quantity based on three parameters: balance,
 *     stock value, and a confidence factor (see enum {@link IActionQuantity.ConfidenceFactor}</li>
 * </p>
 */
public class Action implements IAction {

	public final ActionType type;
	public final IActionQuantity quantity;

	/**
	 * Create a new Action instance with the given type and fixed (constant) quantity value
	 * @param type Action type
	 * @param quantity Constant value to specify a quantity for the action
	 */
	public Action(ActionType type, int quantity) {
		this.type = type;
		this.quantity = (a, b, c) -> quantity;
	}

	/**
	 * Create a new Action instance with the given type and a function specifying what fraction of the balance to use to buy or sell
	 * @param type Action type
	 * @param balanceFunction Function that produces a quantity based on a balance
	 */
	public Action(ActionType type, Function<BigDecimal, BigDecimal> balanceFunction) {
		this(type,
				(BigDecimal balance, BigDecimal value, IActionQuantity.ConfidenceFactor c) ->
						balanceFunction.apply(balance).divide(value).intValue());
	}

	/**
	 * Create a new Action instance with the given type and complete quantity function
	 * @param type Action type
	 * @param quantityFunction Function that produces a quantity based on a balance, stock price, and confidence factor
	 */
	public Action(ActionType type, IActionQuantity quantityFunction) {
		this.type = type;
		this.quantity = quantityFunction;
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
