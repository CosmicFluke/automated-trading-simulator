package team9L5101.stocks;

import java.io.InputStream;
import java.util.Date;

/**
 * Created by Asher on 2015-10-25.
 *
 * Each instance of a Stock is associated with a single stock.
 * Stocks can produce iterators which provide a sequence of day-by-day entries for that stock.
 */
public class Stock {

    public Stock(String name, String filepath) {

    }

    public StockIterator iterator (InputStream file, Date start, Date end) {
        return null;
    }

}
