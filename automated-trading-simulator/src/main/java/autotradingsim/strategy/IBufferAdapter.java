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
     * @return True iff the buffer is empty
     */
    boolean isEmpty();

    /**
     * Gets the maximum size of the buffer.
     * @return maximum size of the buffer
     */
    int getMaxSize();

    /**
     * Gets the current number of StockDays stored in the buffer.
     * @return number of elements currently stored in the buffer
     */
    int getSize();

    /**
     * Provides the last (most recent) entry in the buffer.
     * @return Most recent entry in the buffer
     */
    StockDay getLastEntry();

    /**
     * Creates an iterator that starts with most recent date and goes backwards in time.
     * @return Iterator over the elements of this buffer
     */
    Iterator<StockDay> getIterator();

    /**
     * Creates a stream that starts with most recent date and goes backwards in time.
     * @return Stream over the elements of this buffer
     */
    Stream<StockDay> getStream();

    /**
     * Provides the first (oldest) day stored in the buffer.
     * @return oldest day stored in the buffer
     */
    LocalDate getFirstDay();

    /**
     * Provides the last (most recent) day stored in the buffer.
     * @return most recent day stored in the buffer
     */
    LocalDate getLastDay();

}
