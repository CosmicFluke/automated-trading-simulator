package autotradingsim.strategy;

import autotradingsim.stocks.Stock;
import autotradingsim.stocks.StockDay;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.function.Function;

/**
 * Created by Asher on 2015-10-30.
 *
 * IMeasurement which always uses a stock's daily closing value.
 *
 */
public class SimpleStockValue implements IMeasurement {

    private static String name = "Simple Stock Value";
    private static String desc = "Daily closing value of a stock";

    /**
     * The function!
     */
    private static Function<StockDay, BigDecimal> function = (StockDay day) -> (new BigDecimal(day.getClose()));

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return desc;
    }

    @Override
    public Number getValue(Stock stock, Calendar date) {
        return function.apply(stock.getDay(date));
    }
}
