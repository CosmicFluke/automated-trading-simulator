package autotradingsim.engine;

import java.util.ArrayList;

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
		return query.getName();
	}

	private Experiment findExperiment(String name) {
		for(Experiment curr: experiments){
			if(curr.getName().equals(name))
				return curr;
		}
		return null;
	}
}