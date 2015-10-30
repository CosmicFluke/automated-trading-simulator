package autotradingsim.strategy;

import java.util.Calendar;

/**
 * Created by Asher on 2015-10-25.
 * Contributors: Bill
 *
 * Functional class that can compare an Indicator against some Predicate
 */
public interface ICondition {

    boolean evaluate(Calendar date);
}
