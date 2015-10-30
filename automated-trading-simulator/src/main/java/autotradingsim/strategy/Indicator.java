package autotradingsim.strategy;

import autotradingsim.stocks.StockDay;

import java.math.BigDecimal;

/**
 * Created by Asher on 2015-10-25.<br>
 *
 * <p>"Market Indicators are datasets that contain meta data about the health of various markets or groups
 * of related stocks."<b> - StockCharts.com</b></p>
 *
 * TODO: Hold off on implementing this for the time being.
 *
 */
public abstract class Indicator implements IMeasurement, IBufferObserver {

    private String name;
    private String description;
    private Number value;

    public Indicator(String name, String description){
        this.name = name;
        this.description = description;
    }

    public Indicator(String name) {
        this.name = name;
        this.description = "";
    }

    public String getName(){
        return this.name;
    }

    public String getDescription(){
        return this.description;
    }

    public Number getValue(){
        return this.value;
    }

    public void attachBuffer(IBufferAdapter buffer) { }

}
