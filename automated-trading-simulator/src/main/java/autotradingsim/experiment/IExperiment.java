package autotradingsim.experiment;

import java.time.LocalDate;
import java.util.*;

import autotradingsim.stocks.IStock;
import autotradingsim.strategy.IStrategy;
import autotradingsim.util.Pair;

/**
 * Created by Bill Feng on 15-11-01.
 *
 */
public interface IExperiment {

    String getName();
    void setName(String name);

    void addTrial(String id, String symbol);

    /**
     * Maps strategy IDs to lists of the stocks assigned to each strategy.
     * @return unmodifiable (but mutable) wrapper for the map of strategy-stock trial pairings
     */
    Map<String, List<String>> getAllTrials();

    Map<String, Pair<LocalDate, LocalDate>> getStockStartAndEndDates();
    Map<String, Integer> getStocksToShares();

    Set<IStrategy> getAllStrategies();
    Set<IStock> getAllStocks();
    void setShares(String id, Integer shares);
    Integer getShares(String id);

    /**
     * Run the experiment specified in this instance on the given {@link TimeSet}.
     * @param ts
     * @return
     */
    ExperimentResults runExperiment(TimeSet ts);
}