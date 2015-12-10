package autotradingsim.strategy.indicators;

import autotradingsim.stocks.IBufferAdapter;
import autotradingsim.strategy.rules.IMeasurement;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Created by Asher on 2015-11-15.
 */
public class IndicatorRelativeChange extends IndicatorAbsoluteChange {

	private static final long serialVersionUID = -4431873581367443756L;
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
        this(indicator, numDays, CalcMode.NET_CHANGE);
    }

    public IndicatorRelativeChange(IMeasurement indicator, int numDays, CalcMode mode) {
        super(indicator, numDays, mode, default_name, default_description);
    }

    @Override
    protected BigDecimal getNetChange(BigDecimal[] oldAndNew) {
        if (oldAndNew == null || oldAndNew[0] == null || oldAndNew[1] == null || oldAndNew[0].equals(BigDecimal.ZERO)) {
            System.out.println("One or more values required for IndicatorRelativeChange::getNetChange were invalid.");
            return null;
        }
        return oldAndNew[1].divide(oldAndNew[0], BigDecimal.ROUND_HALF_EVEN).subtract(BigDecimal.ONE);
    }

    @Override
    protected BigDecimal getAverageChange(IBufferAdapter adapter) {
        BigDecimal sum = BigDecimal.ZERO;
        LocalDate date = adapter.getLastDay().minusDays(numDays - 1);
        adapter.updateTo(date);
        for (int i=0; i < numDays; i++) {
            sum.add(getNetChange(getFirstAndSecond(adapter)));
            adapter.updateNext();
        }
        return sum.divide(BigDecimal.valueOf(numDays), BigDecimal.ROUND_HALF_EVEN);
    }
}
