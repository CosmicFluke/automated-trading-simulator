package autotradingsim.strategy.indicators;

import autotradingsim.stocks.StockDay;
import autotradingsim.strategy.Indicator;

/**
 * Created by Bill Feng on 15-10-29.
 *
 * Exponential Moving Average
 *
 */
public class ExponentialMovingAverage extends Indicator{

    String name;
    String description;
    double value;
    public ExponentialMovingAverage(double init){
        this.name = "Exponential Moving Average";
        this.description = "The Exponential Moving Average is a type of the moving average study. In a simple moving average, all price data has an equal weight in the computation of the average with the oldest value removed as each new value is added. In the exponential moving average equation the most recent market action is assigned greater importance as the average is calculated. The oldest pricing data in the exponential moving average is however never removed. \n A buy signal occurs when the short and intermediate term averages cross from below to above the longer term average. Conversely, a sell signal is issued when the short and intermediate term averages cross from above to below the longer term average. Use longer term averages when trading only two exponential moving averages in a crossover system.\n A 5-day exponential moving average normally will include more than 5 days worth of data and could include data from the entire life of a security. In fact, these moving averages might be better identified by their actual \"smoothing constants,\" since the number of days of data in the calculation is the same for a so-called 5-day average as for a 10-day average. Exponential calculations can arrive at different moving average values depending on your starting point.";
        this.value = init;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public Double getValue() {
        return this.value;
    }

    @Override
    public void update(StockDay data) {

    }
}
