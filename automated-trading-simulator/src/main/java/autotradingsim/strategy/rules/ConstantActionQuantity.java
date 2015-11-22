package autotradingsim.strategy.rules;

import java.math.BigDecimal;

/**
 * <p>Created by Asher on 2015-10-30.</p>
 *
 * <p>No calculations required -- allows Action to have constant-valued quantity.</p>
 * <p>This class is likely not needed, since IActionQuantity is a functional interface.  The {@link #toString()} method
 * may be useful, and the explicit class may be clearer than a lambda.</p>
 *
 */
public class ConstantActionQuantity implements IActionQuantity {

    public static final String default_description = "Constant Quantity";

    private final int quantity;

    public ConstantActionQuantity (int quantity) {
        this.quantity = quantity;
    }

    @Override
    public int getValue(BigDecimal balance, BigDecimal stockValue, ConfidenceFactor confidence) {
        return quantity;
    }

    @Override
    public String toString() {
        return default_description + " " + String.valueOf(quantity);
    }
}
