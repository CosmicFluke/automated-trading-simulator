package autotradingsim.engine;

import java.math.BigDecimal;
import java.util.Set;

import autotradingsim.strategy.IAction;
import autotradingsim.strategy.IStrategy;
import autotradingsim.strategy.SimpleStrategy;
import autotradingsim.strategy.ICondition.Comparator;

public class StrategyCommandHandler {
	public TradingApplication appEngine;
	public IStrategy currentStrategy;
	
	public StrategyCommandHandler() {
		// TODO Auto-generated constructor stub
		 appEngine = TradingApplication.getInstance();
	}
	public IStrategy createDefaultStrategy() {
		// TODO Auto-generated method stub
		IStrategy newstrat = new SimpleStrategy();
		appEngine.saveStrategy(newstrat);
		return newstrat;
	}

	public IStrategy addNewSimpleStrategy(String stratname, int cselection, int cvalue, int aselection, int avalue) {
		
		return (new SimpleStrategy(stratname, "",(cselection == 1) ? Comparator.GT : Comparator.LT,
				new BigDecimal(cvalue),(aselection == 1) ? IAction.ActionType.BUY : IAction.ActionType.SELL, avalue));
	
	}

	public IStrategy viewStrategy(String stratname) {
		// TODO Auto-generated method stub
		return(appEngine.getStrategy(stratname.hashCode()));
	}

}
