package autotradingsim.experiment;

import autotradingsim.stocks.IStock;
import autotradingsim.strategy.IStrategy;

/**
 * Created by Bill Feng on 15-11-01.
 *
 */
public interface IExperiment {

    String getName();

    boolean addStock(String symbol);

    IStock getStock(String symbol);

    boolean addStrategy(int id);

    IStrategy getStrategy(int id);
}
