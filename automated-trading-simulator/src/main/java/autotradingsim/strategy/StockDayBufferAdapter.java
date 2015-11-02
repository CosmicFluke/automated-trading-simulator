package autotradingsim.strategy;

import autotradingsim.stocks.IStock;
import autotradingsim.stocks.StockDay;
import autotradingsim.stocks.StockEntry;

import java.util.*;

/**
 * Created by Asher on 2015-10-26.
 * Creates a buffer of StockDay objects to provide as input to Indicators
 */
public class StockDayBufferAdapter implements IBufferAdapter<StockDay> {

    private final IStock stock;
    private LinkedList<StockDay> buffer;
    private int size;
    private Calendar currentDate;

    public StockDayBufferAdapter(IStock stock, Calendar date, int size) {
        this.currentDate = null;
        this.stock = stock;
        this.size = size;
        this.buffer = new LinkedList<>();
        initializeBuffer(date);
    }

    @Override
    public StockDay getLastEntry() {
        if (buffer.isEmpty()) {
            return null;
        }
        return buffer.getLast();
    }

    @Override
    public void updateTo(Calendar date) {
        initializeBuffer(date);
    }

    @Override
    public void updateNext() {
        currentDate.add(Calendar.DATE, 1);
        if (buffer.size() >= this.size) {
            buffer.removeFirst();
        }
        buffer.addLast(this.stock.getDay(currentDate));
    }

    public boolean isEmpty() {
        return buffer.isEmpty();
    }

    @Override
    public Iterator<StockDay> getIterator() {
        return buffer.listIterator();
    }

    private void initializeBuffer(Calendar date) {
        buffer.clear();
        this.currentDate = (Calendar) date.clone();
        date = (Calendar) date.clone();
        for (int i=0; i < this.size; i++) {
            StockDay day = stock.getDay(date);
            if (day != null) {
                this.buffer.addLast(stock.getDay(date));
            }
            date.add(Calendar.DATE, -1);
        }
    }
}
