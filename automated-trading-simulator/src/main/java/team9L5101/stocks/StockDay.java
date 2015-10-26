package team9L5101.stocks;

import java.util.Date;
import java.util.List;

/**
 * Created by Asher on 2015-10-25.
 */
public class StockDay {
    // Stockwell Day?

    private int open;
    private int close;
    private int high;
    private int low;

    public StockDay(String name, Date date, int open, int close, int high, int low) {
        this.open = open;
        this.close = close;
        this.high = high;
        this.low = low;
    }

    public int getOpen() {
        return this.open;
    }

    public int getClose() {
        return close;
    }

    public int getHigh() {
        return high;
    }

    public int getLow() {
        return low;
    }
}
