package autotradingsim.strategy;

import autotradingsim.stocks.StockDay;

/**
 * Created by Asher on 2015-10-25.
 * Contributors: Bill
 */
public abstract class Indicator {

    public abstract  String getName();

    public abstract Double getValue();

    public abstract void update(StockDay data);

}
