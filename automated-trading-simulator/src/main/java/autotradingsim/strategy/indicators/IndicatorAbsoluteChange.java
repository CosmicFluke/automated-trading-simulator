package autotradingsim.strategy.indicators;

import autotradingsim.stocks.IBufferAdapter;
import autotradingsim.strategy.rules.IMeasurement;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * Created by Asher on 2015-11-15.
 */
public class IndicatorAbsoluteChange extends MetaIndicator {

	private static final long serialVersionUID = -2707354216623734844L;
	static final String default_name = "Absolute Change Meta-Indicator";
    static final String default_description =
            "This Indicator shows an absolute change in another indicator, such as a Moving Average, over some " +
                    "specified number of days.";

    /**
     * <p>Enumerates the calculation mode for this MetaIndicator.</p>
     * <p>DAILY_AVERAGE_CHANGE averages the daily changes in the indicator over numDays</p>
     * <p>NET_CHANGE calculates the net change from the numDays before the current date to the current date, ignoring
     * values in between</p>
     */
    enum CalcMode {
        /**
         * Calculation mode that averages the daily changes in the indicator over numDays
         */
        DAILY_AVERAGE_CHANGE,
        /**
         * Calculation mode that calculates the net change from the numDays before the current date to the current date,
         * ignoring values in between
         */
        NET_CHANGE
    }

    private CalcMode mode;

    /**
     * Construct a new IndicatorAbsoluteChange that follows the change in the given indicator over a period of numDays.
     * @param indicator an Indicator to follow
     * @param numDays Number of days to average for a change in Indicator's value.  Must be at least 1.
     */
    public IndicatorAbsoluteChange(IMeasurement indicator, int numDays) {
        this(indicator, numDays, true);
    }

    public IndicatorAbsoluteChange(IMeasurement indicator, int numDays, CalcMode calcMode) {
        super(indicator, numDays, default_name, default_description);
        mode = calcMode;
    }

    public BigDecimal[] getFirstAndSecond(IBufferAdapter adapter) {
        LocalDate lastDate = adapter.getLastDay();
        LocalDate firstDate = lastDate.minusDays(numDays - 1);
        adapter.updateTo(firstDate);
        BigDecimal firstVal = indicator.getValue(adapter);
        adapter.updateTo(lastDate);
        BigDecimal secondVal = indicator.getValue(adapter);

        return new BigDecimal[]{firstVal, secondVal};
    }

    public List<BigDecimal> getAllDays(IBufferAdapter adapter) {
        List<BigDecimal> allDays = new ArrayList<>();
        for (int i = 0; i < numDays; i++) {

        }
    }

    @Override
    public BigDecimal getValue(IBufferAdapter adapter) {
        BigDecimal[] firstAndSecond = getFirstAndSecond(adapter);

        return firstAndSecond[1].subtract(firstAndSecond[0]);
    }

    @Override
    public Function<IBufferAdapter, BigDecimal> getFunction() {
        return (e) -> (this.getValue(e));
    }
}
