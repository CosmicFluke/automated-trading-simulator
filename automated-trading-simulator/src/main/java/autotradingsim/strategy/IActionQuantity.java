package autotradingsim.strategy;

import java.math.BigDecimal;

/**
 * Created by Asher on 2015-10-30.</br>
 *
 * <p>This is a machine which can be used to calculate a quantity for an action.</p>
 *
 */
public interface IActionQuantity {

    default int getValue() {
        return 0;
    }

    int getValue(BigDecimal balance);

}
