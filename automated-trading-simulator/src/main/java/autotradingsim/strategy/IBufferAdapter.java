package autotradingsim.strategy;

import autotradingsim.stocks.StockDay;

import java.time.LocalDate;
import java.util.Iterator;

/**
 * Created by Asher on 2015-10-30.
 *
 * TODO: Potentially observable class
 */
public interface IBufferAdapter {

    void updateTo(LocalDate date);

    void updateNext();

    boolean isEmpty();

    StockDay getLastEntry();

    Iterator<StockDay> getIterator();

}
