package autotradingsim.strategy.indicators;

import autotradingsim.stocks.StockDay;
import autotradingsim.strategy.Indicator;

/**
 * Created by Bill Feng on 15-10-29.
 *
 * SMA: Simple Moving Average
 */
public class SMA extends Indicator{

    String name;
    Double value;
    public SMA(){
        this.name = "Simple Moving Average";
        this.value = 0.0;
    }

    @Override
    public String getName(){
        return this.name;
    }

    @Override
    public Double getValue(){
        return this.value;
    }

    @Override
    public void update(StockDay data){

    }
}
