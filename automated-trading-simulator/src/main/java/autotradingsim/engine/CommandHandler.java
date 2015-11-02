package autotradingsim.engine;
import autotradingsim.strategy.*;

import java.util.ArrayList;
import java.util.Set;
import autotradingsim.experiment.*;
import autotradingsim.terminal.*;
public class CommandHandler {

	public CommandHandler() {
		// TODO Auto-generated constructor stub
	}
	public TradingApplication appEngine=TradingApplication.getInstance();
	
	protected void createStrategy(){
		appEngine.saveStrategy(null);
	}
	
	public void addStrategy(String exp, int stratid){
		
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
					//System.out.println(strat.getRuleDecisionMaker(r));
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
		System.out.println("This is a read-only strategy. Returning to Main menu.");
		
	}
	public void printconditions(){
		ArrayList<ICondition> conditions = new ArrayList<>();
		System.out.println("Choose from the following conditions");
		System.out.println("1. stock value is greater than x");
		System.out.println("2. stock value is smaller than x");
		
	}
	public void addnewrule(String stratname, int selection, int value) {
		// TODO Auto-generated method stub
		

	}	
}
