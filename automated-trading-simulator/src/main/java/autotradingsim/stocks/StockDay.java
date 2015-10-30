package autotradingsim.stocks;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Asher on 2015-10-25.
 * Contributors: Bill
 *
 * Used for daily stock data.
 * Holds symbol, date, open, high, low, close, and volume data
 *
 * Public Methods:
 *      getDate()
 *      getOpen()
 *      getHigh()
 *      getLow()
 *      getClose()
 *      getVolume()
 */
public class StockDay extends StockEntry {

    public enum Values {
        OPEN, CLOSE, HIGH, LOW, VOLUME
    }

    private String symbol;
    private Calendar date;

    // Experimental BigDecimal Map
    private Map<Values, BigDecimal> values;

    private Double open;
    private Double close;
    private Double high;
    private Double low;
    private Double volume;

    public StockDay(String symbol, Calendar date, Double open, Double high, Double low, Double close, Double volume) {
        this.symbol = symbol;
        this.date = date;
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
        this.volume = volume;

        // Experimental BigDecimal Map
        values = new HashMap<>();
        values.put(Values.OPEN, new BigDecimal(open));
        values.put(Values.CLOSE, new BigDecimal(close));
        values.put(Values.HIGH, new BigDecimal(high));
        values.put(Values.LOW, new BigDecimal(low));
        values.put(Values.VOLUME, new BigDecimal(volume));

    }

    // BigDecimal getter
    public BigDecimal getValue(Values which) {
        return values.get(which);
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
