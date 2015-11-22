package autotradingsim.strategy.rules;

import java.math.BigDecimal;

/**
 * <p>Created by Asher on 2015-11-22.</p>
 * <p>Functional interface for a function that calculates a {@link ConfidenceFactor} from three values.</p>
 */
@FunctionalInterface
public interface ConfidenceFunction {
    ConfidenceFactor apply(BigDecimal value, BigDecimal cutoff, BigDecimal threshold);
}
