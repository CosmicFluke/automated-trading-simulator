package autotradingsim.stocks;

import autotradingsim.strategy.IBufferAdapter;

import java.util.Calendar;

/**
 * Created by Asher on 2015-10-30.
 */
public interface IStock {
    String getSymbol();

    String getName();

    StockDay getDay(Calendar date);

    IBufferAdapter getBuffer();
}
