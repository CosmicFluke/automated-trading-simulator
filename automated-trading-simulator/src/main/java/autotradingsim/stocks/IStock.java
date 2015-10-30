package autotradingsim.stocks;

import autotradingsim.strategy.IBufferAdapter;

import java.util.Calendar;

/**
 * Created by Asher on 2015-10-30.
 */
public interface IStock {
    String getSymbol();

    String getName();

    /**
     * Get the data for a given day in the data list of this stock
     *
     * @param   date a initialized date variable
     * @return  a StockDay object for this stock on the given date
     *
     * NOTE:    Returns NULL if this stock does not have an entry for the given date
     */
    StockDay getDay(Calendar date);

    Calendar getStartDate();

    Calendar getEndDate();

    IBufferAdapter getNewBuffer(Calendar date, int size);
}
