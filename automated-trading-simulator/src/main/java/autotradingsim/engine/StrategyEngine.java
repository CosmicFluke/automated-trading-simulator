package autotradingsim.engine;

import java.math.BigDecimal;

import autotradingsim.application.ITradingApplication;
import autotradingsim.application.TradingApplication;

import autotradingsim.strategy.IStrategy;
import autotradingsim.strategy.Strategy;
import autotradingsim.util.StrategyDemoFactory;

public class StrategyEngine {
	//public TradingApplication appEngine;
	public IStrategy currentStrategy;
	public static StrategyEngine engine;

	private StrategyEngine() {
		 //appEngine = TradingApplication.getInstance();
	}
	public static StrategyEngine getInstance(){
		if(engine==null){
			engine = new StrategyEngine();
		}
		return engine;
	}

	/**
	 *saveStrategy saves given instance of strategy to file system through application, replacing any existing instances
	 * @param strategy
	 */
	public void saveStrategy(IStrategy strategy){
		TradingApplication.getInstance().saveStrategy(strategy);
	}
        public IStrategy getStrategy(String name){
            return TradingApplication.getInstance().getStrategy(name);
        }
	/**
	 * creates a default strategy and stores it in application
	 * @return
	 */
	public IStrategy createDefaultStrategy() {
		// TODO Auto-generated method stub
		currentStrategy = new Strategy();
		//appEngine.saveStrategy(newstrat);
		return currentStrategy;
	}

	public IStrategy createStrategy(String stratname){
            IStrategy strategy = new Strategy(stratname, "");
            TradingApplication.getInstance().saveStrategy(strategy);
		return strategy;
                
	}

	/**
	 *
	 * @param buybelow Buy shares when the price is below than this.
	 * @param sellabove Sell shares when the closingPrice of the stock for each day is above than this.
	 * @param buyNum Buy this much amount of shares
	 * @param sellNum Sell this much amount of shares
	 * @return basicStrategy that is built in util::StrategyDemoFactory::newBasicStrategy.
	 */
	public IStrategy addNewBasicDemoStrategy(BigDecimal buybelow, BigDecimal sellabove, int buyNum, int sellNum) {
		ITradingApplication app = TradingApplication.getInstance();
		currentStrategy =  StrategyDemoFactory.newBasicStrategy(buybelow, sellabove, buyNum, sellNum);
		if (app.addStrategy(currentStrategy)) {
			return app.getStrategy(currentStrategy.getName());
		} else {
			return null;
		}
	}

	/**
	 *
	 * @param strategyName
	 * @return
	 */
	public IStrategy addAdvancedDemoStrategy(String strategyName) {
		ITradingApplication app = TradingApplication.getInstance();
		currentStrategy = StrategyDemoFactory.newAdvancedStrategy();
		if (app.addStrategy(currentStrategy)) {
			return app.getStrategy(strategyName);
		} else {
			return null;
		}
	}
	
	/**
	 * retrieve and return strategy from application with the given name
	 * @param stratname name of the strategy
	 * @return Strategy with @param stratname
	 */
	public IStrategy viewStrategy(String stratname) {
		return TradingApplication.getInstance().getStrategy(stratname);
	}

}
