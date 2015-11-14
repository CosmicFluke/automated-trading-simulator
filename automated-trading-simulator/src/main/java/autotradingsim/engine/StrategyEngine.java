package autotradingsim.engine;

import java.math.BigDecimal;
import java.util.Set;

import autotradingsim.application.TradingApplication;
import autotradingsim.strategy.IAction;
import autotradingsim.strategy.IStrategy;
import autotradingsim.strategy.simpleimpl.*;
import autotradingsim.strategy.Strategy;
import autotradingsim.strategy.ICondition.Comparator;

public class StrategyEngine {
	public TradingApplication appEngine;
	public IStrategy currentStrategy;
	
	public StrategyEngine() {
		// TODO Auto-generated constructor stub
		 appEngine = TradingApplication.getInstance();
	}
	/**
	 * creates a default strategy and stores it in application
	 * @return
	 */
	public IStrategy createDefaultStrategy() {
		// TODO Auto-generated method stub
		IStrategy newstrat = new Strategy();
		//appEngine.saveStrategy(newstrat);
		return newstrat;
	}
	
	/**
	 * creates a simplestrategy, saves it to application and returns the strategy if saved properly
	 * @param stratname
	 * @param cselection
	 * @param cvalue
	 * @param aselection
	 * @param avalue
	 * @return strategy
	 */

	public IStrategy addNewSimpleStrategy(String stratname, int cselection, int cvalue, int aselection, int avalue) {
		//if(appEngine.saveStrategy(new SimpleStrategy(stratname, "",(cselection == 1) ? Comparator.GT : Comparator.LT,
		//		new BigDecimal(cvalue),(aselection == 1) ? IAction.ActionType.BUY : IAction.ActionType.SELL, avalue))){
		//	return appEngine.getStrategy(stratname.hashCode());
		//}else{
			return null;
		//}	
	}
	
	/**
	 * retrieve and return strategy from application with the given name
	 * @param stratname
	 * @return Strategy
	 */
	public IStrategy viewStrategy(String stratname) {
		// TODO Auto-generated method stub
		//return(appEngine.getStrategy(stratname.hashCode()));
		return null;
	}

}
