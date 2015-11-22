package autotradingsim.deprecated;

import autotradingsim.application.*;
import autotradingsim.engine.ExperimentEngine;
import autotradingsim.engine.StrategyEngine;

/**
 * Redundant class, gets instances of other singletons.  Entirely unnecessary.<br>
 *     **Deprecated.
 */
public class Engine {

	TradingApplication tradingApp;
	ExperimentEngine expEngine;
	StrategyEngine stratEngine;
	static Engine instance;
	
	private Engine(){
		tradingApp = TradingApplication.getInstance();
		expEngine = ExperimentEngine.getInstance();
		stratEngine = StrategyEngine.getInstance();
	}

	private static Engine getInstance() {
		if (instance == null) {
			instance = new Engine();
		}
		return instance;
	}

	public static ExperimentEngine getExperimentEngine() {
		return getInstance().expEngine;
	}

	public static StrategyEngine getStrategyEngine() {
		return getInstance().stratEngine;
	}

	
	
	
	
}
