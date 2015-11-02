package autotradingsim.engine;
import autotradingsim.strategy.*;

import java.util.Set;

import autotradingsim.experiment.*;
public class CommandHandler {

	public CommandHandler() {
		// TODO Auto-generated constructor stub
	}
	public TradingApplication appEngine=TradingApplication.getInstance();
	
	protected void createStrategy(){
		appEngine.saveStrategy(null);
	}
	
	public void addStrategy(String exp, String strat){
		
	}

	public void viewStrategy(String stratname) {
		// TODO Auto-generated method stub
		if(stratname.isEmpty()){
			System.out.println("Strategy List");
		}else{
			IStrategy strat=null;
			Set<RuleID> rules;
			if((strat=appEngine.getStrategy(stratname))!=null){
				rules=strat.getRules();
				System.out.println(strat.getName());
				for (RuleID r:rules){
					System.out.println(strat.getRuleName(r));
					System.out.println(strat.getRuleDescription(r));
					System.out.println(strat.getRuleSummary(r));
				}
				
				
			}
			
		}
		
	}

	protected static void viewExperiment(String string) {
		// TODO Auto-generated method stub
		
	}

	public static void saveStrat(String stratname) {
		// TODO Auto-generated method stub
		
	}

	public static void addtimeset(String currentExperiment, String string, String string2) {
		// TODO Auto-generated method stub
		
	}

	public void createDefaultStrategy() {
		// TODO Auto-generated method stub
		SimpleStrategy newstrat=new SimpleStrategy();
		appEngine.saveStrategy(newstrat);
		System.out.println("Default strategy "+appEngine.getStrategy(newstrat.getName()).getName()+" created");
		
	}
	
	
}
