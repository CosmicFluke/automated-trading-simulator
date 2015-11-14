package autotradingsim.strategy;

import autotradingsim.stocks.IStock;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

/**
 * Created by Asher on 2015-11-01.
 */
public abstract class StrategyTester {

    protected final IStrategy strategy;

    public StrategyTester(IStrategy strategy){
        this.strategy = strategy;
    }

    public IStrategy getStrategy() {
        return this.strategy;
    }

    /**
     * Set all rules to evaluate using the given stock.
     * @param stock
     */
    public abstract void setAll(IStock stock);

    /**
     * Get a set of decisions from this strategy for a given date.
     * @param currentDate
     * @return
     */
    public abstract List<IDecision> testDate(LocalDate currentDate);

}
