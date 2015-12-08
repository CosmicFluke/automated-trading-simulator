package autotradingsim.util;
import autotradingsim.application.*;

import java.math.BigDecimal;

/**
 * Created by Shirley on 2015-12-05.
 */
public class TemporaryTestingStrategies {

    public static void createStrats(){
        ITradingApplication application = TradingApplication.getInstance();
        application.addStrategy(StrategyDemoFactory.newBasicStrategy(new BigDecimal(105), new BigDecimal(115), 10, 5));
        application.addStrategy(StrategyDemoFactory.newAdvancedStrategy());
    }
    public static void clearStrats(){
        TradingApplication.clearMemoryAndFileSystem();
    }
}
