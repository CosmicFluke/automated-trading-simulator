package autotradingsim.strategy.indicators;

import autotradingsim.stocks.StockDay;
import autotradingsim.strategy.Indicator;

/**
 * Created by Bill Feng on 15-10-29.
 *
 * SMA: Simple Moving Average
 * Calculated by
 */
public class SMA extends Indicator{

    private String name;
    private String description;
    private Double value;
    private int days;
    public SMA(int days){
        this.name = "Simple Moving Average";
        this.description = "The Simple Moving Average is calculated by summing the closing prices of the security for a period of time and then dividing this total by the number of time periods. Sometimes called an arithmetic moving average, the SMA is basically the average stock price over time. As a trend develops, the moving average will slope in the direction of the trend, showing the trend direction and some indication of its strength based on the slope steepness.\n Note that since the Simple Moving Average gives equal weight to each daily price, the longer time period studied suggests the greater smoothing out of recent market volatility. Long-term moving averages smooth out all the minor fluctuations showing only longer-term trends. Shorter-term moving averages show shorter-term trends but at the expense of the long-term ones.";
        this.value = 0.0;
        this.days = days;
    }

    @Override
    public String getName(){
        return this.name;
    }

    @Override
    public String getDescription(){
        return this.description;
    }

    @Override
    public Double getValue(){
        return this.value;
    }

    @Override
    public void update(StockDay data){
        value = (value * (days - 1) + data.getClose()) / days;
    }
}
