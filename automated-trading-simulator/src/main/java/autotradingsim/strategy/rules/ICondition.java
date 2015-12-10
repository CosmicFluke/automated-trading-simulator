package autotradingsim.strategy.rules;

import autotradingsim.stocks.IBufferAdapter;
import autotradingsim.util.Pair;

import java.math.BigDecimal;
import java.util.function.Predicate;

/**
 * Created by Asher on 2015-10-25.
 * Contributors: Bill
 *
 * Functional class that can compare an Indicator against some Predicate
 */
public interface ICondition {

    enum Comparator {
        GT, LT, GEQ, LEQ, EQ, NEQ
    }

    /**
     * Creates a Predicate function which compares to values in a Pair using a given comparator.
     * @param comp Comparison operator
     * @return New Predicate built with given comparison operator
     */
    default Predicate<Pair<BigDecimal, BigDecimal>> makeComparator(Comparator comp) {
        switch (comp) {
            case GT:
                return (Pair<BigDecimal, BigDecimal> pair) ->
                        (pair.x != null) && (pair.y != null) && (pair.x.compareTo(pair.y) > 0);
            case LT:
                return (Pair<BigDecimal, BigDecimal> pair) ->
                        (pair.x != null) && (pair.y != null) && (pair.x.compareTo(pair.y) < 0);
            case GEQ:
                return (Pair<BigDecimal, BigDecimal> pair) ->
                        (pair.x != null) && (pair.y != null) && (pair.x.compareTo(pair.y) >= 0);
            case LEQ:
                return (Pair<BigDecimal, BigDecimal> pair) ->
                        (pair.x != null) && (pair.y != null) && (pair.x.compareTo(pair.y) <= 0);
            case EQ:
                return (Pair<BigDecimal, BigDecimal> pair) ->
                        (pair.x != null) && (pair.y != null) && (pair.x.equals(pair.y));
            case NEQ:
                return (Pair<BigDecimal, BigDecimal> pair) ->
                        (pair.x != null) && (pair.y != null) && (!pair.x.equals(pair.y));
            default:
                return null;
        }
    }

    static String compToString(Comparator comp) {
        switch (comp) {
            case GT:
                return ">";
            case LT:
                return "<";
            case GEQ:
                return ">=";
            case LEQ:
                return "<=";
            case EQ:
                return "==";
            case NEQ:
                return "!=";
            default:
                return "(?)";
        }
    }

    int getBufferSize();

    Predicate<IBufferAdapter> getFunction();

    ConfidenceFactor getConfidenceFactor();

    void setConfidenceFunction(ConfidenceFunction function);

    ConfidenceFunction getConfidenceFunction();

    IMeasurement getMeasurement();

    Comparator getComparator();

    BigDecimal getComparisonValue();

}
