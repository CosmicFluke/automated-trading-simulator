package autotradingsim.strategy;

import autotradingsim.stocks.StockDay;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.stream.Stream;

/**
 * Created by Asher on 2015-10-30.
 *
 * TODO: Potentially observable class
 */
public interface IBufferAdapter {

    /**
     * Updates the buffer to end at the given date (given date will be the buffer's {@link #getLastDay()}.
     * @param date
     */
    void updateTo(LocalDate date);

    /**
     * Call this method to update the buffer to the next day.  If the last day of the buffer is not the last day of
     * the stock's entries, the buffer will move forward in time by one day.
     * @return The date of the StockDay added as a result of the update.  Returns <b>null</b> if there were no days left.
     */
    LocalDate updateNext();

    /**
     * True iff the buffer contains no StockDay entries.
     * @return
     */
    boolean isEmpty();

    /**
     * Gets the size of the buffer.
     * @return
     */
    int getSize();

    /**
     * Provides the last (most recent) entry in the buffer.
     * @return
     */
    StockDay getLastEntry();

    /**
     * Creates an iterator that starts with most recent date and goes backwards in time.
     * @return
     */
    Iterator<StockDay> getIterator();

    /**
     * Creates a stream that starts with most recent date and goes backwards in time.
     * @return
     */
    Stream<StockDay> getStream();

    /**
     * Provides the first (oldest) day stored in the buffer.
     * @return
     */
    LocalDate getFirstDay();

    /**
     * Provides the last (most recent) day stored in the buffer.
     * @return
     */
    LocalDate getLastDay();

}
