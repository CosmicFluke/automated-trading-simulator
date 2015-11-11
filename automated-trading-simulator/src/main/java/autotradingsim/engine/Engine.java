package autotradingsim.engine;
import autotradingsim.application.*;
import autotradingsim.strategy.*;

import autotradingsim.strategy.ICondition.Comparator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Set;
import autotradingsim.experiment.*;
import autotradingsim.terminal.*;
public class Engine {

	public TradingApplication appEngine = TradingApplication.getInstance();
	
	protected void createStrategy(){
		appEngine.saveStrategy(null);
	}
	
	public void addStrategy(String exp, int stratid){
		
	}
	
	
	/**
	 * List every available strategy which belongs to the engine
	 */
	public void ListStrategyNames() {
		System.out.println("List of Strategies:");
		for(IStrategy strategy : appEngine.strategies.values())
			System.out.println(strategy.getName());
	}
	
	
	/**
	 * Given a strategy name, print to system.out
	 * Name, and then print every rule which belongs to it
	 * @param stratname name of strategy to view
	 */
	public void viewStrategy(String stratname) {
		System.out.println("List of Strategies:");
		IStrategy strat = null;
		if((strat = appEngine.getStrategy(stratname)) != null){
			System.out.println(strat.getName());
			for (RuleID r : strat.getRules()){
				System.out.println(strat.getRuleName(r));
				System.out.println(strat.getRuleDescription(r));
				System.out.println(strat.getRuleSummary(r));
				//System.out.println(strat.getRuleDecisionMaker(r));
			}
		}
	}
	

	protected static void viewExperiment(String string) {
		// TODO Auto-generated method stub
		
	}

	public static void addtimeset(String currentExperiment, String string, String string2) {
		// TODO Auto-generated method stub
		
	}

	public void createDefaultStrategy() {
		// TODO Auto-generated method stub
		SimpleStrategy newstrat = new SimpleStrategy();
		appEngine.saveStrategy(newstrat);
		System.out.println("Default strategy "+appEngine.getStrategy(newstrat.getName()).getName()+" created");
		System.out.println("This is a read-only strategy. Returning to Main menu.");
	}
	
	/**
	 * Adds a new simple strategy
	 * 
	 * @param stratname
	 * @param cselection Must be either 1 or 2
	 * @param cvalue 
	 * @param aselection Must be either 1 or 2
	 * @param avalue
	 */
	public IStrategy currentStrategy;
	public void addNewSimpleStrategy(String stratname, int cselection, int cvalue, int aselection, int avalue) {
		currentStrategy = 
				new SimpleStrategy(
						stratname, "",
						(cselection == 1) ? Comparator.GT : Comparator.LT, new BigDecimal(cvalue),
						(aselection == 1) ? IAction.ActionType.BUY : IAction.ActionType.SELL, avalue);
		

	}
	public void saveCurrentStrategy(){
		appEngine.saveStrategy((SimpleStrategy) currentStrategy);
	}

	
}
