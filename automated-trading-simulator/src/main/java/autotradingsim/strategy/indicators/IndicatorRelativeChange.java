package autotradingsim.strategy.indicators;

import autotradingsim.strategy.IBufferAdapter;

import java.math.BigDecimal;

/**
 * Created by Asher on 2015-11-15.
 */
public class IndicatorRelativeChange extends IndicatorAbsoluteChange {
    /**
     * Construct a new IndicatorAbsoluteChange that follows the change in the given indicator over a period of numDays.
     *
     * @param indicator an Indicator to follow
     * @param numDays   Number of days to average for a change in Indicator's value
     */
    public IndicatorRelativeChange(Indicator indicator, int numDays) {
        super(indicator, numDays);
    }

    @Override
    public BigDecimal getValue(IBufferAdapter adapter) {
        BigDecimal[] firstAndSecond = getFirstAndSecond(adapter);
        BigDecimal first = firstAndSecond[0];
        BigDecimal second = firstAndSecond[1];
        return second.subtract(first).divide(first);
    }
}
