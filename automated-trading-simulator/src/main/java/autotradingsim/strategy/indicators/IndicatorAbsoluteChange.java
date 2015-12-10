package autotradingsim.strategy.indicators;

import autotradingsim.stocks.IBufferAdapter;
import autotradingsim.stocks.StockDay;
import autotradingsim.strategy.rules.IMeasurement;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
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
        this(indicator, numDays, CalcMode.NET_CHANGE);
    }

    public IndicatorAbsoluteChange(IMeasurement indicator, int numDays, CalcMode calcMode) {
        this(indicator, numDays, calcMode, default_name, default_description);
    }

    public IndicatorAbsoluteChange(IMeasurement indicator, int numDays, CalcMode calcMode, String name, String description) {
        super(indicator, numDays, name, description);
        mode = calcMode;
    }

    protected BigDecimal[] getFirstAndSecond (IBufferAdapter adapter) {
        LocalDate lastDate = adapter.getLastDay();
        LocalDate firstDate = lastDate.minusDays(numDays - 1);
        adapter.updateTo(firstDate);
        BigDecimal firstVal = indicator.getValue(adapter);
        adapter.updateTo(lastDate);
        BigDecimal secondVal = indicator.getValue(adapter);

        return new BigDecimal[]{firstVal, secondVal};
    }

    protected BigDecimal getNetChange(BigDecimal[] oldAndNew) {
        if (oldAndNew == null) {
            return BigDecimal.ZERO;
        }
        return oldAndNew[1].subtract(oldAndNew[0]);
    }

    protected BigDecimal getAverageChange(IBufferAdapter adapter) {
        BigDecimal sum = BigDecimal.ZERO;
        LocalDate date = adapter.getLastDay().minusDays(numDays - 1);
        adapter.updateTo(date);
        for (int i=0; i < numDays; i++) {
            sum = sum.add(indicator.getValue(adapter));
            adapter.updateNext();
        }
        return sum.divide(BigDecimal.valueOf(numDays), BigDecimal.ROUND_HALF_EVEN);
    }

    @Override
    public BigDecimal getValue(IBufferAdapter adapter) {
        switch (mode) {
            case DAILY_AVERAGE_CHANGE:
                return getAverageChange(adapter);
            case NET_CHANGE:
                return getNetChange(getFirstAndSecond(adapter));
            default:
                return null;
        }
    }

    @Override
    public Function<IBufferAdapter, BigDecimal> getFunction() {
        return this::getValue;
    }
}
