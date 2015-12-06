package autotradingsim.util;
import autotradingsim.application.*;
import autotradingsim.strategy.Strategy;
import autotradingsim.util.StrategyDemoFactory;

import java.math.BigDecimal;

/**
 * Created by Shirley on 2015-12-05.
 */
public class TemporaryTestingStrategies {
    static TradingApplication application = TradingApplication.getInstance();
    public static void createStrats(){
        application.setStrategy(StrategyDemoFactory.newBasicStrategy(new BigDecimal(10), new BigDecimal(20), 10,10));
        application.setStrategy(StrategyDemoFactory.newAdvancedTestingStrategy());
        application.setStrategy(StrategyDemoFactory.newAdvancedStrategy());
    }
    public static void clearStrats(){
        TradingApplication.clearFileSystem();
    }
}
