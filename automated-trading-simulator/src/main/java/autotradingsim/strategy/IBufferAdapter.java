package autotradingsim.strategy;

import autotradingsim.stocks.StockEntry;

import java.time.LocalDate;
import java.util.Iterator;

/**
 * Created by Asher on 2015-10-30.
 *
 * TODO: Potentially observable class
 */
public interface IBufferAdapter<E extends StockEntry> {

    void updateTo(LocalDate date);

    void updateNext();

    boolean isEmpty();

    E getLastEntry();

    Iterator<E> getIterator();

}
