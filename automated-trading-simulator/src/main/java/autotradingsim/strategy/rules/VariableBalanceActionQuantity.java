package autotradingsim.strategy.rules;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.function.Function;

/**
 * Created by Asher on 2015-11-22.<br>
 *
 * This class is probably not needed (lambdas and method references are sufficient for functional interface)
 */
public class VariableBalanceActionQuantity implements IActionQuantity, Serializable {

	private static final long serialVersionUID = -1632716857260695363L;
	Function<BigDecimal, Integer> function;

    /**
     * Provide a function that takes in the quotient of (balance divided by stock value), and returns a quantity.
     * @param function
     */
    public VariableBalanceActionQuantity(Function<BigDecimal, Integer> function) {
        this.function = function;
    }

    @Override
    public int getValue(BigDecimal balance, BigDecimal stockValue, int numSharesOwned, ConfidenceFactor confidence) {
        return function.apply(balance.divideAndRemainder(stockValue)[0]);
    }
}
