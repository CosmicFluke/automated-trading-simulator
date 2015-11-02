package autotradingsim.strategy.indicators;

import autotradingsim.stocks.StockDay;
import autotradingsim.strategy.IBufferAdapter;
import autotradingsim.strategy.Indicator;

import java.math.BigDecimal;
import java.util.function.Function;

/**
 * Created by Bill Feng on 15-10-29.
 *
 * Simple Moving Average
 *      Calculated by taking the average of the past days, the length of which can be specified.
 *      When updating, add the new data and take the new average.
 */
public class SimpleMovingAverage extends Indicator{

    private int days;
    private double init;
    private static final String name = "Simple Moving Average";
    private static final String description = "The Simple Moving Average is calculated by summing the closing prices of the security for a period of time and then dividing this total by the number of time periods. Sometimes called an arithmetic moving average, the SimpleMovingAverage is basically the average stock price over time. As a trend develops, the moving average will slope in the direction of the trend, showing the trend direction and some indication of its strength based on the slope steepness.\n Note that since the Simple Moving Average gives equal weight to each daily price, the longer time period studied suggests the greater smoothing out of recent market volatility. Long-term moving averages smooth out all the minor fluctuations showing only longer-term trends. Shorter-term moving averages show shorter-term trends but at the expense of the long-term ones.";

    public SimpleMovingAverage(double init, int days){
        super(name, description);
        this.init = init;
        this.days = days;
    }

    public void update(StockDay data){
        // setValue((this.getValue() * (days - 1) + data.getClose()) / days);
    }

    @Override
    public int getBufferSize() {
        return 0;
    }

    @Override
    public Function<? extends IBufferAdapter, BigDecimal> getFunction() {
        return null;
    }
}
