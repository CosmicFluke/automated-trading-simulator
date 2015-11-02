package autotradingsim.strategy;

import autotradingsim.stocks.IStock;

import java.util.Calendar;
import java.util.Set;

/**
 * Created by Asher on 2015-11-01.
 */
public abstract class StrategyTester {

    protected final Strategy strategy;

    public StrategyTester(Strategy strategy){
        this.strategy = strategy;
    }

    public Strategy getStrategy() {
        return this.strategy;
    }

    /**
     * Set all rules to evaluate using the given stock.
     * @param stock
     */
    public abstract void setAll(IStock stock);

    /**
     * Get a set of decisions from this strategy for a given date.
     * @param date
     * @return
     */
    public abstract Set<IDecision> testDate(Calendar date);

}
