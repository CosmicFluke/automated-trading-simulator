package autotradingsim.strategy;

/**
 * Created by Asher on 2015-10-30.
 */
public class ConstantActionQuantity implements IActionQuantity {

    private final int quantity;

    public ConstantActionQuantity (int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return this.quantity;
    }

}
