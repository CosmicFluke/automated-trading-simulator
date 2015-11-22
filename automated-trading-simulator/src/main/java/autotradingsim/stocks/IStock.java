package autotradingsim.stocks;

import autotradingsim.strategy.IBufferAdapter;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by Asher on 2015-10-30.
 */
public interface IStock {

    /**
     * @return Stock Symbol in String. (i.e. AAPL for Apple Inc. Stock.)
     */
    String getSymbol();

    /**
     * @return Name of the Stock in String. (i.e. Apple Inc. for AAPL)
     */
    String getName();

    /**
     * Get the data for a given day in the data list of this stock
     *
     * @param   date a initialized date variable
     * @return  a StockDay object for this stock on the given date
     *
     * NOTE:    Returns NULL if this stock does not have an entry for the given date
     */
    StockDay getDay(LocalDate date);

    /**
     * @return LocalDate StartDate depending on the location of the user.
     */
    LocalDate getStartDate();

    /**
     * @return LocalDate getEndDate depending on the location of the user.
     */
    LocalDate getEndDate();

    IBufferAdapter getNewBuffer(LocalDate date, int size);

    Stream<StockDay> getAllStockDays();
}
