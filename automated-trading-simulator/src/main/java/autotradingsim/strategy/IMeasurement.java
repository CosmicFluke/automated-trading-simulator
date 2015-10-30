package autotradingsim.strategy;

import autotradingsim.stocks.Stock;

import java.util.Calendar;

/**
 * Created by Asher on 2015-10-30.
 *
 * <p>Measurements are units of information about stocks and stock behaviour.  They contain both
 * metadata (name, description) and a function for getting the desired information from some set of market data,
 * whether it be a stock, a set of stocks, or some other data set.</p>
 *
 */
public interface IMeasurement {

    String getName();
    String getDescription();

    Number getValue(Stock stock, Calendar date);
}
