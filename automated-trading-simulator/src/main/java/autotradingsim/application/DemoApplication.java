package autotradingsim.application;

import autotradingsim.ui.AutomatedTradingSimulator;
import autotradingsim.util.TemporaryTestingStrategies;

/**
 * Created by Asher on 2015-12-06.
 */
public class DemoApplication {

    public static void main(String[] args) {

        TemporaryTestingStrategies.createStrats();
        AutomatedTradingSimulator.main(args);
        //TemporaryTestingStrategies.clearStrats();
    }
}
