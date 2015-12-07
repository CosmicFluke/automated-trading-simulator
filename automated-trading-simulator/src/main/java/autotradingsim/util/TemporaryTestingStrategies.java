package autotradingsim.util;
import autotradingsim.application.*;

import java.math.BigDecimal;

/**
 * Created by Shirley on 2015-12-05.
 */
public class TemporaryTestingStrategies {

    public static void createStrats(){
        ITradingApplication application = TradingApplication.getInstance();
        application.addStrategy(StrategyDemoFactory.newBasicStrategy(new BigDecimal(10), new BigDecimal(20), 50, 25));
        application.addStrategy(StrategyDemoFactory.newAdvancedTestingStrategy());
        application.addStrategy(StrategyDemoFactory.newAdvancedStrategy());
    }
    public static void clearStrats(){
        TradingApplication.clearMemoryAndFileSystem();
    }
}
