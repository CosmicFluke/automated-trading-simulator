package autotradingsim.engine;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.Locale;

import autotradingsim.experiment.Experiment;

public class TradingEngine {

	ArrayList<Experiment> experiments;
	
	public TradingEngine(){
		defineDefaults();
	}
	
	private void defineDefaults(){
		Experiment defaultExp = new Experiment("default");
		defaultExp.addStock("APPL");
	}

	public String viewExperiment(String experimentName){
		Experiment query= findExperiment(experimentName);
		if(query == null)
			query = findExperiment("default");
		
		StringBuilder stringbuilder = new StringBuilder();
		Formatter formatter = new Formatter(stringbuilder, Locale.US);
		formatter.format("Name: %s", query.getName());
		
		formatter.close();
		return stringbuilder.toString();
	}

	private Experiment findExperiment(String name) {
		for(Experiment curr: experiments){
			if(curr.getName().equals(name))
				return curr;
		}
		return null;
	}
}