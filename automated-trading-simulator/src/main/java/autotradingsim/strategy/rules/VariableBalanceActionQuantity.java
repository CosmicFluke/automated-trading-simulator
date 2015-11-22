package autotradingsim.strategy.rules;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.function.Function;

/**
 * Created by Asher on 2015-11-22.<br>
 *
 * This class is probably not needed (lambdas and method references are sufficient for functional interface)
 */
public class VariableBalanceActionQuantity implements IActionQuantity {

    Function<BigDecimal, Integer> function;

    /**
     * Provide a function that takes in the quotient of (balance divided by stock value), and returns a quantity.
     * @param function
     */
    public VariableBalanceActionQuantity(Function<BigDecimal, Integer> function) {
        this.function = function;
    }

    @Override
    public int getValue(BigDecimal balance, BigDecimal stockValue, ConfidenceFactor confidence) {
        return function.apply(balance.divideAndRemainder(stockValue)[0]);
    }
}
