package team9L5101.stocks;

import java.io.InputStream;
import java.util.Date;
import java.util.Iterator;

/**
 * Created by Asher on 2015-10-25.
 */
public class StockIterator implements Iterator {

    public StockIterator (InputStream file, Date start, Date end) {
        // TODO: implement!
    }

    // TODO: docs
    @Override
    public StockDay next() {
        // TODO: implement!
        // Needs to parse a line of a stock CSV file and create new StockDay object
        return null;
    }

    // TODO: docs
    @Override
    public boolean hasNext() {
        // TODO: implement!
        return false;
    }
}