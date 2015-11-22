package autotradingsim.strategy.indicators;


import autotradingsim.stocks.IBufferAdapter;
import autotradingsim.strategy.rules.IMeasurement;

import java.math.BigDecimal;
import java.util.function.Function;

/**
 * Created by Asher on 2015-10-25.<br>
 *
 * <p>"Market Indicators are datasets that contain meta data about the health of various markets or groups
 * of related stocks."<b> - StockCharts.com</b></p>
 *
 * TODO: Hold off on implementing this for the time being.  I'm not quite sure what to do with it.
 *
 */
public abstract class Indicator implements IMeasurement {

    private String name;
    private String description;
    protected Function<IBufferAdapter, BigDecimal> function;

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

}
