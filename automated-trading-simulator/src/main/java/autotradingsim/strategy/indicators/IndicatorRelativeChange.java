package autotradingsim.strategy.indicators;

import autotradingsim.stocks.IBufferAdapter;
import autotradingsim.strategy.rules.IMeasurement;

import java.math.BigDecimal;

/**
 * Created by Asher on 2015-11-15.
 */
public class IndicatorRelativeChange extends IndicatorAbsoluteChange {

    static final String default_name = "Relative Change Meta-Indicator";
    static final String default_description =
            "This Indicator shows a relative (percentage) change in another indicator, such as a Moving Average, " +
                    "over some specified number of days.";

    /**
     * Construct a new IndicatorAbsoluteChange that follows the change in the given indicator over a period of numDays.
     *
     * @param indicator an Indicator to follow
     * @param numDays   Number of days to average for a change in Indicator's value
     */
    public IndicatorRelativeChange(IMeasurement indicator, int numDays) {
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
