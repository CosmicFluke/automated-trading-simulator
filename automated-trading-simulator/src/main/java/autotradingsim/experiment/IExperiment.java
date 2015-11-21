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

    void addStock(String symbol);
    void addStrategy(String name);
    void addTrial(String id, String symbol);

    Map<String, Pair<LocalDate, LocalDate>> getStockStartAndEndDates();

    IStrategy getStrategy(String name);
    IStock getStock(String symbol);

    List<Result> runExperiment(TimeSet ts);
}