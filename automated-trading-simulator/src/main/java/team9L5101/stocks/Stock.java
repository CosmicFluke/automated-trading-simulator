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

    private String name;
    private String filepath;

    public Stock(String name, String filepath) {
        // TODO: implement!

    }

    // TODO: docs
    public StockIterator iterator (InputStream file, Date start, Date end) {
        // TODO: implement!
        // Needs to create an iterator with the given start and end dates
        return null;
    }

}
