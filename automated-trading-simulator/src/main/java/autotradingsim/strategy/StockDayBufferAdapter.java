package autotradingsim.strategy;

import autotradingsim.stocks.Stock;
import autotradingsim.stocks.StockEntry;

import java.util.Calendar;
import java.util.Iterator;

/**
 * Created by Asher on 2015-10-26.
 * Creates a buffer of StockDay objects to provide as input to Indicators
 */
public class StockDayBufferAdapter extends StockBufferAdapter {

    private Stock stock;

    public StockDayBufferAdapter(Stock stock) {
        this.stock = stock;
    }

    @Override
    public StockEntry getLastEntry() {
        return null;
    }

    @Override
    public Iterator<StockEntry> getIteratorRange(Calendar start, Calendar end) {
        return null;
    }

    @Override
    public Iterator<StockEntry> getIteratorAll() {
        return null;
    }
}
