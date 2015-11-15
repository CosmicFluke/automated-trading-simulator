package autotradingsim.strategy;

import autotradingsim.stocks.IStock;
import autotradingsim.stocks.StockDay;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Stream;

/**
 * Created by Asher on 2015-10-26.
 * Creates a buffer of StockDay objects to provide as input to Indicators
 */
public class BufferAdapter implements IBufferAdapter {

    private final IStock stock;
    private LinkedList<StockDay> buffer;
    private int size;
    private LocalDate currentDate;

    public BufferAdapter(IStock stock, LocalDate date, int size) {
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
    public void updateTo(LocalDate date) {
        initializeBuffer(date);
    }

    @Override
    public LocalDate updateNext() {
        LocalDate nextDate = currentDate.plusDays(1);
        StockDay next = this.stock.getDay(currentDate);
        if (next == null) {
            return null;
        }
        if (buffer.size() >= this.size) {
            buffer.removeFirst();
        }
        buffer.addLast(next);
        currentDate = nextDate;
        return currentDate;
    }

    public boolean isEmpty() {
        return buffer.isEmpty();
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public Iterator<StockDay> getIterator() {
        return buffer.listIterator();
    }

    @Override
    public Stream<StockDay> getStream() {
        return buffer.stream();
    }

    @Override
    public LocalDate getLastDay() {
        return this.currentDate;
    }

    @Override
    public LocalDate getFirstDay() {
        return this.currentDate.minusDays(this.size);
    }

    private void initializeBuffer(LocalDate date) {
        buffer.clear();
        this.currentDate = date;
        for (int i=0; i < this.size; i++) {
            StockDay day = stock.getDay(date.minusDays(i));
            if (day != null) {
                this.buffer.addLast(day);
            }
        }
    }
}
