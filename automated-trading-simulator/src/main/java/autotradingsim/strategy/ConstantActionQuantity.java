package autotradingsim.strategy;

import java.math.BigDecimal;

/**
 * Created by Asher on 2015-10-30.
 *
 * No calculations required -- allows Action to have constant-valued quantity.
 *
 */
public class ConstantActionQuantity implements IActionQuantity {

    private final int quantity;

    public ConstantActionQuantity (int quantity) {
        this.quantity = quantity;
    }

    @Override
    public int getValue() {
        return this.quantity;
    }

    @Override
    public int getValue(BigDecimal balance) {
        return getValue();
    }
}
