package autotradingsim.experiment;

import java.util.*;
import autotradingsim.strategy.IStrategy;

/**
 * Created by Bill Feng on 15-11-01.
 *
 */
public interface IExperiment {

    String getName();

    void addStock(String symbol);
    void addStrategy(String name);

    IStrategy getStrategy(String name);

    List<Result> runExperiment(TimeSet ts);
}