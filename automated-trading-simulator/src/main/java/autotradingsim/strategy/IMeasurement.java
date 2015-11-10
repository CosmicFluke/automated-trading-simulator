package autotradingsim.strategy;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.function.Function;

/**
 * Created by Asher on 2015-10-30.
 *
 * <p>Measurements are units of information about stocks and stock behaviour.  They contain both
 * metadata (name, description) and a function for getting the desired information from some set of market data,
 * whether it be a stock, a set of stocks, or some other data set.</p>
 *
 */
public interface IMeasurement extends IFunctionBuilder{

    String getName();
    String getDescription();

    /**
     * Provides the minimum buffer size needed to accommodate this IMeasurement
     * @return
     */
    int getBufferSize();

    /**
     * Gets the value associated with this measurement for a given date.
     * @param date
     * @return
     */
    BigDecimal getValue(Calendar date);

    /**
     * <p>Gets the function that calculates this IMeasurement's value for a given IBufferAdapter.
     * The IBufferAdapter must be at least as big as the return value of {@link #getBufferSize()}</p>
     * @return a function that will calculate this IMeasurement's value for a given Buffer
     */
    @Override
    Function<? extends IBufferAdapter, BigDecimal> getFunction();

}
