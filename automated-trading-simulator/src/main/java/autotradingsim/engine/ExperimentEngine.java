package autotradingsim.engine;

import autotradingsim.application.TradingApplication;
import autotradingsim.experiment.Experiment;

public class ExperimentEngine {

	public static TradingApplication appEngine;
	public static Experiment currExperiment;
	public ExperimentEngine() {
		// TODO Auto-generated constructor stub
		 appEngine = TradingApplication.getInstance();
	}
	protected static Experiment createExperiment(String name){
		currExperiment = new Experiment(name);
		appEngine.saveExperiment(currExperiment);
		return currExperiment;
	}
	protected static Experiment viewExperiment(String name) {
		// TODO Auto-generated method stub
		return appEngine.getExperiment(name.hashCode());
		
	}
	protected static void addStrategy(String expName, String stratname){
		appEngine.getExperiment(expName.hashCode()).addStrategy(stratname);
	}

	public static void addtimeset(String currentExperiment, String string, String string2) {
		// TODO Auto-generated method stub
		
	}

}
