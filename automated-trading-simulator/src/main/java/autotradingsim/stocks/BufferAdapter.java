package autotradingsim.stocks;

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
        if (size < 1) {
            throw new IllegalArgumentException("Size cannot be less than 1");
        }
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
        return buffer.getFirst();
    }

    @Override
    public void updateTo(LocalDate date) {
        initializeBuffer(date);
    }

    @Override
    public LocalDate updateNext() {
        LocalDate nextDate = currentDate.plusDays(1);
        StockDay next = stock.getDay(nextDate);
        if (next == null) {
            return null;
        }
        buffer.addFirst(next);
        if (buffer.size() > this.size) {
            buffer.removeLast();
        }
        currentDate = nextDate;
        return currentDate;
    }

    public boolean isEmpty() {
        return buffer.isEmpty();
    }

    @Override
    public int getMaxSize() {
        return this.size;
    }

    @Override
    public int getSize() {
        return this.buffer.size();
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
        return this.currentDate.minusDays(this.getSize() - 1);
    }

    private void initializeBuffer(LocalDate date) {
        buffer.clear();
        this.currentDate = date;
        for (int i=0; i < this.size; i++) {
            StockDay day = stock.getDay(date.minusDays(i));
            if (day != null) {
                this.buffer.add(day);
            }
        }
    }
}
