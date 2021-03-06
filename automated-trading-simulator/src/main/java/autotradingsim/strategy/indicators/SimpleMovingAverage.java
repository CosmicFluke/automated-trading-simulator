package autotradingsim.strategy.indicators;

import autotradingsim.stocks.StockDay;
import autotradingsim.stocks.IBufferAdapter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * <p>Created by Asher Minden-Webb on 15-11-14</p>
 *
 * <p>Calculated by taking the average of the past days, the length of which can be specified.
 * When updating, add the new data and take the new average.</p>
 */
public class SimpleMovingAverage extends Indicator implements Serializable{

	private static final long serialVersionUID = -2696371208609135157L;
	static final String default_name = "Simple Moving Average";
    static final String default_description =
            "The Simple Moving Average is calculated by summing the closing prices of the security for a period of " +
                    "time and then dividing this total by the number of time periods. Sometimes called an arithmetic " +
                    "moving average, the SimpleMovingAverage is basically the average stock price over time. As a " +
                    "trend develops, the moving average will slope in the direction of the trend, showing the trend " +
                    "direction and some indication of its strength based on the slope steepness.\n Note that since " +
                    "the Simple Moving Average gives equal weight to each daily price, the longer time period " +
                    "studied suggests the greater smoothing out of recent market volatility. Long-term moving " +
                    "averages smooth out all the minor fluctuations showing only longer-term trends. Shorter-term " +
                    "moving averages show shorter-term trends but at the expense of the long-term ones.";

    private int numDays;

    /**
     * Construct a new SimpleMovingAverage that uses the given number of days to calculate a moving average.
     * @param days
     * @param name
     * @param description
     */
    public SimpleMovingAverage(int days, String name, String description) {
        super(name, description);
        this.numDays = days;
    }

    public SimpleMovingAverage(int days){
        this(days, default_name, default_description);
    }

    /**
     * Gets the number of days <i>n</i> tracked by this <i>n</i>-day Simple Moving Average.
     * @return Number of days
     */
    public int getNumDays() {
        return this.numDays;
    }

    public BigDecimal getValue(IBufferAdapter adapter) {
        return this.getValue(adapter, adapter.getSize());
    }

    public int getBufferSize() {
        return this.numDays;
    }


    public Function<IBufferAdapter, BigDecimal> getFunction() {
        return (IBufferAdapter buffer) -> ((buffer.getSize() > 0) ? this.getValue(buffer, buffer.getSize()) : null);
    }

    /**
     * Computes the average of a stream of StockDays.
     * @param buffer A stream of StockDay objects.  Must satisfy condition that <br>
     *      {@link Stream#count() stream.count()} ==  {@link #getBufferSize()}
     * @param size The size of the stream being passed in.
     * @return
     */
    private BigDecimal getValue (IBufferAdapter buffer, int size) {
        LocalDate firstDay = buffer.getLastDay().minusDays(size);

        BigDecimal sum = (buffer.getStream()
                .filter((day) -> day.getDate().isAfter(firstDay.minusDays(1)))
                .map((StockDay day) -> (day.getValue(StockDay.Values.CLOSE)))
                .reduce(new BigDecimal(0), (BigDecimal identity, BigDecimal addend) -> (identity.add(addend))));

        if (size == 0) {
            return BigDecimal.ZERO;
        }

        return sum.divide(BigDecimal.valueOf(size), BigDecimal.ROUND_HALF_EVEN);
    }
}
