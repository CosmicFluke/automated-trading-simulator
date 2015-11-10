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
        OPEN, CLOSE, HIGH, LOW
    }

    private String symbol;
    private Calendar date;
    private int volume;

    // Experimental BigDecimal Map
    private Map<Values, BigDecimal> values;

    public StockDay(String symbol, Calendar date, BigDecimal open, BigDecimal high, BigDecimal low, BigDecimal close, int volume) {
        this.symbol = symbol;
        this.date = date;

        // Experimental BigDecimal Map
        values = new HashMap<>();
        values.put(Values.OPEN, open);
        values.put(Values.CLOSE, close);
        values.put(Values.HIGH, high);
        values.put(Values.LOW, low);

        this.volume = volume;
    }

    // BigDecimal getter
    public BigDecimal getValue(Values which) {
        return values.get(which);
    }

    public String getSymbol(){
        return this.symbol;
    }

    public Calendar getDate(){
        return this.date;
    }

    public int getVolume(){
        return this.volume;
    }

    public BigDecimal getValue() {
        return values.get(Values.CLOSE);
    }
}
