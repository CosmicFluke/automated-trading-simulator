package autotradingsim.experiment;

import autotradingsim.stocks.Stock;
import autotradingsim.strategy.Strategy;

/**
 * Created by Bill Feng on 15-11-01.
 *
 */
public interface IExperiment {

    String getName();

    void addStock(String symbol);

    Stock getStock(String symbol);

    void addStrategy(String name);

    Strategy getStrategy(String name);
}
