package autotradingsim.engine;

import java.util.ArrayList;

import autotradingsim.experiment.Experiment;
import autotradingsim.strategy.Strategy;
import autotradingsim.strategy.Condition;
import autotradingsim.strategy.Action;
public class TradingEngine {

	static ArrayList<Experiment> experiments;
	static ArrayList<Strategy> strategies;
	public TradingEngine(){
		defineDefaults();
	}
	
	private void defineDefaults(){
		Experiment defaultExp = new Experiment("default");
		defaultExp.addStock("APPL");
	}

	public static String viewExperiment(String experimentName){
		Experiment query= findExperiment(experimentName);
		if(query == null)
			query = findExperiment("default");
		return query.getName();
	}
	public static void viewStrategy(String[] args) {
		if(args.length==2){
			//display strategy with name arg[1]
		}else{
			//display a list of strategies
		}
	}

	private static Experiment findExperiment(String name) {
		for(Experiment curr: experiments){
			if(curr.getName().equals(name))
				return curr;
		}
		return null;
	}

	public static void addStrategy(String currentExperiment, String[] args) {
		// TODO Auto-generated method stub
		
	}

	public static void addExpTime(String currentExperiment, String[] args) {
		// TODO Auto-generated method stub
		
	}

	public static void viewStrategy(String currentExperiment, String[] args) {
		// TODO Auto-generated method stub
		
	}

	public static void addCond(String[] args) {
		// TODO Auto-generated method stub
		
	}

	public static void addAction(String[] args) {
		// TODO Auto-generated method stub
		
	}
}