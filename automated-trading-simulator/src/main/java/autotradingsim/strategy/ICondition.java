package autotradingsim.strategy;

import autotradingsim.util.Pair;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.function.Predicate;

/**
 * Created by Asher on 2015-10-25.
 * Contributors: Bill
 *
 * Functional class that can compare an Indicator against some Predicate
 */
public interface ICondition {

    public enum Comparator {
        GT, LT, GEQ, LEQ, EQ, NEQ
    }

    default Predicate<Pair<BigDecimal, BigDecimal>> makeComparator(Comparator comp) {
        switch (comp) {
            case GT:
                return (Pair<BigDecimal, BigDecimal> pair) -> (pair.x.floatValue() > pair.y.floatValue());
            case LT:
                return (Pair<BigDecimal, BigDecimal> pair) -> (pair.x.floatValue() < pair.y.floatValue());
            case GEQ:
                return (Pair<BigDecimal, BigDecimal> pair) -> (pair.x.floatValue() >= pair.y.floatValue());
            case LEQ:
                return (Pair<BigDecimal, BigDecimal> pair) -> (pair.x.floatValue() <= pair.y.floatValue());
            case EQ:
                return (Pair<BigDecimal, BigDecimal> pair) -> (pair.x.floatValue() == pair.y.floatValue());
            case NEQ:
                return (Pair<BigDecimal, BigDecimal> pair) -> (pair.x.floatValue() != pair.y.floatValue());
            default:
                return null;
        }
    }


    boolean evaluate(Calendar date);

    Predicate<? extends IBufferAdapter> getFunction();


}
