package team9L5101.stocks;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by Asher on 2015-10-25.
 * Used for daily stock data.
 */
public class StockDay extends StockEntry {
    // Stockwell Day?

    private BigDecimal open;
    private BigDecimal close;
    private BigDecimal high;
    private BigDecimal low;

    public StockDay(String name, Date date, BigDecimal open, BigDecimal high, BigDecimal low, BigDecimal close) {
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
    }

    public BigDecimal getOpen() {
        return this.open;
    }

    public BigDecimal getHigh() {
        return high;
    }

    public BigDecimal getLow() {
        return low;
    }

    public BigDecimal getClose() {
        return close;
    }

    @Override
    public BigDecimal getSingleValue() {
        return close;
    }
}
