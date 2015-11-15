package autotradingsim.strategy.indicators;

import autotradingsim.stocks.Stock;
import autotradingsim.strategy.IBufferAdapter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.function.Function;

/**
 * Created by Bill Feng on 15-10-29.
 * Modified by Asher Minden-Webb on 15-11-14
 *
 * Simple Moving Average
 *      Calculated by taking the average of the past days, the length of which can be specified.
 *      When updating, add the new data and take the new average.
 */
public class SimpleMovingAverage extends Indicator{

    private static final String default_name = "Simple Moving Average";
    private static final String default_description =
            "The Simple Moving Average is calculated by summing the closing prices of the security for a period of " +
                    "time and then dividing this total by the number of time periods. Sometimes called an arithmetic " +
                    "moving average, the SimpleMovingAverage is basically the average stock price over time. As a " +
                    "trend develops, the moving average will slope in the direction of the trend, showing the trend " +
                    "direction and some indication of its strength based on the slope steepness.\n Note that since " +
                    "the Simple Moving Average gives equal weight to each daily price, the longer time period " +
                    "studied suggests the greater smoothing out of recent market volatility. Long-term moving " +
                    "averages smooth out all the minor fluctuations showing only longer-term trends. Shorter-term " +
                    "moving averages show shorter-term trends but at the expense of the long-term ones.";

    private int days;

    /**
     * This is only here because of confusion in the responsibilities/collaborations of the Indicator hierarchy.<br>
     */
    private Stock stock;

    /**
     * Construct a new SimpleMovingAverage that uses the given number of days to calculate a moving average.
     * @param days
     * @param name
     * @param description
     */
    public SimpleMovingAverage(int days, String name, String description) {
        super(name, description);
        this.days = days;
    }

    public SimpleMovingAverage(int days){
        this(days, default_name, default_description);
    }

    /**
     * Gets the number of days <i>n</i> tracked by this <i>n</i>-day Simple Moving Average.
     * @return Number of days
     */
    public int getNumDays() {
        return this.days;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public BigDecimal getValue(LocalDate date) {
        return this.getFunction().apply(this.stock.getNewBuffer(date, this.days));
    }

    public int getBufferSize() {
        return this.days;
    }


    public Function<IBufferAdapter, BigDecimal> getFunction() {
        return this.function;
    }
}
