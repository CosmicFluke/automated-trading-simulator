package autotradingsim.strategy;

import autotradingsim.stocks.IStock;
import autotradingsim.stocks.Stock;
import autotradingsim.stocks.StockDay;
import autotradingsim.util.StrategyDemoFactory;
import com.sun.javaws.exceptions.InvalidArgumentException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by Asher on 2015-11-22.
 */
public class StockBuilderTestingUtil {

    private static LocalDate builderDate;

    private static StockDay newStockDayHelper(int close) {
        builderDate = builderDate.minusDays(1);
        return new StockDay("TEST", builderDate, BigDecimal.ONE, BigDecimal.ONE, BigDecimal.ONE, BigDecimal.valueOf(close), 1000);
    }

    /**
     * <p>Builds a custom stock object with sequential closing values each day, starting with <i>start</i>, rising to end,
     * and then decreasing back to start<i>end</i>.  Number of days in the stock will be <tt>2 * abs(end - start)</tt>).<br>
     * <b>Note: only the closing values of the stock's days are sequential.  All other values are set to {@link
     * BigDecimal#ONE}</b><br><br>
     * Ending date of the Stock's values is:<br>
     * <tt>{@link LocalDate#of LocalDate.of}(2013, {@link Month#SEPTEMBER}, 30)</tt><br>
     * Dates go sequentially backwards from there.<br><br>
     * Precondition:<br>
     * <tt>abs(end - start) >= 5</tt></p>
     * @param start starting number (for stock value)
     * @param end ending number (for stock value)
     * @return
     */
    public static IStock buildSequentialStock(int start, int end) {
        if (Math.abs(end - start) < 5) {
            throw new IllegalArgumentException("buildSequentialStock: insufficient difference between start and end");
        }
        LocalDate endDate = LocalDate.of(2013, Month.SEPTEMBER, 30);
        int numDays = Math.abs(end - start);
        builderDate = endDate.plusDays(1);
        numDays = numDays * 2 + 1;
        List<StockDay> days =
                IntStream.concat(
                    IntStream.range(start, end),
                    IntStream.iterate(end + 1, (int i) -> i - 1)
                            .limit(numDays + 1))
                .mapToObj((int i) -> newStockDayHelper(i))
                .collect(Collectors.toCollection(ArrayList::new));
        assert(days.size() == numDays);
        days.stream()
                .peek((StockDay d) ->
                        System.out.println(
                                d.getDate().toString() + String.valueOf(d.getValue(StockDay.Values.CLOSE).intValue())));
        return new Stock("TEST", "Test stock", days);
    }
}
