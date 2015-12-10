package autotradingsim.strategy.rules;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by Asher on 2015-10-30.</br>
 *
 * <p>This is a machine (function) which can be used to calculate a quantity for an action.</p>
 * <p>Functional method takes four parameters: <br>
 *     {@link BigDecimal} cashBalance<br>
 *     {@link BigDecimal} stockValue<br>
 *     <b>int</b> numSharesOwned<br>
 *     {@link ConfidenceFactor} confidence</p>
 *  <p>Has one method, {@link IActionQuantity#getValue(BigDecimal, BigDecimal, int, ConfidenceFactor)}</p>
 *
 */
@FunctionalInterface
public interface IActionQuantity extends Serializable {

    /**
     *
     * @param cashBalance current cash balance
     * @param stockValue value of the stock to be bought/sold
     * @param numSharesOwned number of shares of this stock currently owned
     * @param confidence a confidence factor
     * @return
     */
    int getValue(BigDecimal cashBalance, BigDecimal stockValue, int numSharesOwned, ConfidenceFactor confidence);

}
