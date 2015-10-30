package autotradingsim.strategy;

import autotradingsim.stocks.StockDay;

import java.util.Calendar;
import java.util.Iterator;

/**
 * Created by Asher on 2015-10-26.
 * Creates a buffer of StockDay objects to provide as input to Indicators
 */
public class StockBufferAdapter implements IBufferAdapter {
    @Override
    public StockDay getLastEntry() {
        return null;
    }

    @Override
    public Iterator<StockDay> getIteratorRange(Calendar start, Calendar end) {
        return null;
    }

    @Override
    public Iterator<StockDay> getIteratorAll() {
        return null;
    }
}
