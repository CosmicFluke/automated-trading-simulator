package autotradingsim.engine;

import java.math.BigDecimal;
import java.util.Set;

import autotradingsim.strategy.IAction;
import autotradingsim.strategy.IStrategy;
import autotradingsim.strategy.RuleID;
import autotradingsim.strategy.SimpleStrategy;
import autotradingsim.strategy.ICondition.Comparator;

public class strategyCommandHandler {
	public TradingApplication appEngine;
	public strategyCommandHandler() {
		// TODO Auto-generated constructor stub
		 appEngine= TradingApplication.getInstance();
	}
	public void createDefaultStrategy() {
		// TODO Auto-generated method stub
		SimpleStrategy newstrat = new SimpleStrategy();
		appEngine.saveStrategy(newstrat);
		System.out.println("Default strategy "+appEngine.getStrategy(newstrat.getName()).getName()+" created");
		System.out.println("This is a read-only strategy. Returning to Main menu.");
		
	}
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
	public IStrategy viewStrategy(String stratname) {
		// TODO Auto-generated method stub
		IStrategy retStrat=null;
		System.out.println("List of Strategies:");
		if(stratname.isEmpty()){
			for(IStrategy i: appEngine.strategies){
				System.out.println(i.getName());
			}
		}else{
			if((appEngine.getStrategy(stratname)) != null){
				retStrat=appEngine.getStrategy(stratname);
/*				rules = strat.getRules();
				System.out.println(strat.getName());
				for (RuleID r:rules){
					System.out.println(strat.getRuleName(r));
					System.out.println(strat.getRuleDescription(r));
					System.out.println(strat.getRuleSummary(r));
					//System.out.println(strat.getRuleDecisionMaker(r));
				}*/
			}
		}
		return retStrat;
	}

}
