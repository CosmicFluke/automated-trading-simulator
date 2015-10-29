package autotradingsim.stocks;

import java.util.Calendar;

/**
 * Created by Asher on 2015-10-25.
 * Contributors: Bill
 * Used for daily stock data.
 */
public class StockDay extends StockEntry {
    // Stockwell Day?

    private String symobol;
    private Calendar date;
    private Double open;
    private Double close;
    private Double high;
    private Double low;
    private Double volume;

    public StockDay(String symbol, Calendar date, Double open, Double high, Double low, Double close, Double volume) {
        this.symobol = symbol;
        this.date = date;
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
        this.volume = volume;
    }

    public Calendar getDate(){
        return this.date;
    }

    public Double getOpen() {
        return this.open;
    }

    public Double getHigh() {
        return high;
    }

    public Double getLow() {
        return low;
    }

    public Double getClose() {
        return close;
    }

    public Double getVolume() {
        return volume;
    }

    @Override
    public Double getSingleValue() {
        return close;
    }
}
