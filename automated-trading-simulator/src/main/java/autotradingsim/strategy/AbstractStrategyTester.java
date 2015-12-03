package autotradingsim.strategy;

/**
 * Created by Asher on 2015-11-01.
 */
public abstract class AbstractStrategyTester implements StrategyTester {

    protected final IStrategy strategy;

    public AbstractStrategyTester(IStrategy strategy){
        this.strategy = strategy;
    }

    @Override
    public String getStrategy() {
        return this.strategy.getName();
    }

}
