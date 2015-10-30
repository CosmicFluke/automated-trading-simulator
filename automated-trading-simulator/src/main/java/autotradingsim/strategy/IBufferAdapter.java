package autotradingsim.strategy;

import autotradingsim.stocks.StockEntry;

import java.util.Calendar;
import java.util.Iterator;

/**
 * Created by Asher on 2015-10-30.
 *
 * TODO: Potentially observable class -- would need to implement an observer pattern with IBufferObserver
 */
public interface IBufferAdapter<E extends StockEntry> {

    void updateTo(Calendar date);

    void updateNext();

    boolean isEmpty();

    E getLastEntry();

    Iterator<E> getIterator();

}
