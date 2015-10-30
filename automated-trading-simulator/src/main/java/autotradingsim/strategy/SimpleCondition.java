package autotradingsim.strategy;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Created by Asher on 2015-10-30.
 */
public class SimpleCondition implements ICondition {

    private IMeasurement measurement;
    private Predicate<Calendar> compare;

    public SimpleCondition (BigDecimal value) {
        this.measurement = new SimpleStockValue();

    }

    @Override
    public boolean evaluate(Calendar date) {
        return false;
    }
}
