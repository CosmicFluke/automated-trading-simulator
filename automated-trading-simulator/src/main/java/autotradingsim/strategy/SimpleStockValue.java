package autotradingsim.strategy;

import autotradingsim.stocks.Stock;
import autotradingsim.stocks.StockDay;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.function.Function;

/**
 * Created by Asher on 2015-10-30.
 *
 * IMeasurement implementation which always uses a stock's daily closing value.
 *
 */
public class SimpleStockValue implements IMeasurement, IFunctionBuilder {

    private static final String name = "Simple Stock Value";
    private static final String desc = "Daily closing value of a stock";
    private static final int bufferSize = 1;

    private Stock stock;

    /**
     * The function!
     */
    private static Function<StockDayBufferAdapter, BigDecimal> function =
            (StockDayBufferAdapter stockBuffer) -> (stockBuffer.getLastEntry().getValue(StockDay.Values.CLOSE));


    public SimpleStockValue () {
        this.stock = null;
    }

    /**
     * Sets the stock to be used to calculate the value of this measurement.<br>
     * See {@link IMeasurement#getValue(Calendar)}
     * @param stock
     */
    public void setStock(Stock stock) {
        this.stock = stock;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return desc;
    }

    @Override
    public BigDecimal getValue(Calendar date) throws DataNotProvidedException {
        if (this.stock == null) {
            throw new DataNotProvidedException();
        }
        // Calendar prevDate = ((Calendar) date.clone());
        // prevDate.add(Calendar.DATE, -1);
        return function.apply(this.stock.getNewDayBuffer(date, this.getBufferSize()));
    }

    @Override
    public Function<StockDayBufferAdapter, BigDecimal> getFunction() {
        return function;
    }

    public int getBufferSize() {
        return bufferSize;
    }

}
