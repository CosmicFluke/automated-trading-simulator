package autotradingsim.strategy.indicators;

import autotradingsim.strategy.IBufferAdapter;
import autotradingsim.strategy.IMeasurement;

import java.math.BigDecimal;
import java.util.function.Function;

/**
 * Created by Asher on 2015-11-15.
 */
public class IndicatorChange extends MetaIndicator {

    static String default_name = "Indicator Trend";
    static String default_description =
            "This Indicator shows a change in another indicator, such as a Moving Average, over some specified number of days.";

    /**
     * Construct a new IndicatorChange that follows the change in the given indicator over a period of numDays.
     * @param indicator an Indicator to follow
     * @param numDays Number of days to average for a change in Indicator's value
     */
    public IndicatorChange(Indicator indicator, int numDays) {
        super(indicator, numDays, default_name, default_description);
    }

    @Override
    public BigDecimal getValue(IBufferAdapter adapter) {
        return null;
    }

    @Override
    public Function<IBufferAdapter, BigDecimal> getFunction() {
        return null;
    }
}
