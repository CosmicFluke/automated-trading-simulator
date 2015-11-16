package autotradingsim.strategy.indicators;

import autotradingsim.strategy.IBufferAdapter;
import autotradingsim.strategy.IMeasurement;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.function.Function;

/**
 * Created by Asher on 2015-11-15.
 */
public class IndicatorAbsoluteChange extends MetaIndicator {

    static String default_name = "Absolute Change Meta-Indicator";
    static String default_description =
            "This Indicator shows an absolute change in another indicator, such as a Moving Average, over some specified number of days.";

    /**
     * Construct a new IndicatorAbsoluteChange that follows the change in the given indicator over a period of numDays.
     * @param indicator an Indicator to follow
     * @param numDays Number of days to average for a change in Indicator's value
     */
    public IndicatorAbsoluteChange(IMeasurement indicator, int numDays) {
        super(indicator, numDays, default_name, default_description);
    }

    public BigDecimal[] getFirstAndSecond(IBufferAdapter adapter) {
        LocalDate lastDate = adapter.getLastDay();
        LocalDate firstDate = lastDate.minusDays(numDays);
        adapter.updateTo(firstDate);
        BigDecimal firstVal = indicator.getValue(adapter);
        adapter.updateTo(lastDate);
        BigDecimal secondVal = indicator.getValue(adapter);

        return new BigDecimal[]{firstVal, secondVal};
    }

    @Override
    public BigDecimal getValue(IBufferAdapter adapter) {
        BigDecimal[] firstAndSecond = getFirstAndSecond(adapter);
        return firstAndSecond[2].subtract(firstAndSecond[1]);
    }

    @Override
    public Function<IBufferAdapter, BigDecimal> getFunction() {
        return (e) -> (this.getValue(e));
    }
}
