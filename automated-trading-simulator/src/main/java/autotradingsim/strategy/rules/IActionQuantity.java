package autotradingsim.strategy.rules;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by Asher on 2015-10-30.</br>
 *
 * <p>This is a machine (function) which can be used to calculate a quantity for an action.</p>
 * <p>Functional interface takes three parameters: <br>
 *     {@link BigDecimal} balance<br>
 *     {@link BigDecimal} stockValue<br>
 *     {@link ConfidenceFactor} confidence</p>
 *
 */
@FunctionalInterface
public interface IActionQuantity extends Serializable {

    int getValue(BigDecimal balance, BigDecimal stockValue, int numSharesOwned, ConfidenceFactor confidence);

}
