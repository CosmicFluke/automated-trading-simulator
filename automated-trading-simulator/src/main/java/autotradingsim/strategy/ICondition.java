package autotradingsim.strategy;

import java.util.function.Predicate;

import autotradingsim.stocks.StockEntry;

/**
 * Created by Asher on 2015-10-25.
 * Contributors: Bill
 *
 * Functional class that can compare an Indicator against some Predicate
 */
public interface ICondition {

    public boolean check();
}
