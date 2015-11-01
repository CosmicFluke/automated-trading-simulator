package autotradingsim.strategy;

import autotradingsim.util.Pair;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.function.Predicate;

/**
 * Created by Asher on 2015-10-30.
 *
 * <p>Very basic implementation of ICondition, using:<br>
 * <ul><li>{@link SimpleStockValue} as its {@link IMeasurement}</li>
 *     <li>A fixed value to compare the IMeasurement against</li>
 * </ul></p>
 *
 */
public class SimpleCondition implements ICondition {

    private SimpleStockValue measurement;
    private Predicate<StockDayBufferAdapter> compare;
    private Predicate<Pair<BigDecimal,BigDecimal>> comparison;

    public SimpleCondition (Comparator comp, BigDecimal value) {
        // Using SimpleStockValue as Measurement
        this.measurement = new SimpleStockValue();

        // Want to use comp to check measurement against value
        this.comparison = makeComparator(comp);
        this.compare = (StockDayBufferAdapter buf) ->
            (comparison.test(new Pair<>(measurement.getFunction().apply(buf), value)));

    }

    @Override
    public boolean evaluate(Calendar date) {

        //Run comparison on value of measurement against constant value
        //
        return false;
    }

    @Override
    public Predicate<StockDayBufferAdapter> getFunction() {
        return this.compare;
    }


}
