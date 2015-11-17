package autotradingsim.engine;

import autotradingsim.application.TradingApplication;
import autotradingsim.experiment.Experiment;

public class ExperimentEngine {

	public static TradingApplication appEngine;
	public static Experiment currExperiment;
	
	/**
	 * 
	 * @param none
	 * populate appEngine with instance of application
	 */
	public ExperimentEngine() {
		// TODO Auto-generated constructor stub
		 appEngine = TradingApplication.getInstance();
	}
	
	/**
	 * 
	 * @param expname
	 * @return retExp 
	 * takes an experiment name, returns the new experiment created
	 */
	protected static Experiment createExperiment(String expname){
		Experiment retExp=null;
		if(appEngine.setExperiment(expname, new Experiment(expname))){
			retExp=(Experiment) appEngine.getExperiment(expname);
		}
		return retExp;
	}
	/**
	 * 
	 * @param expname
	 * @return Experiment
	 * takes experiment name and returns experiment object with that name
	 */
	protected static Experiment viewExperiment(String expname) {
		// TODO Auto-generated method stub
		return (Experiment) appEngine.getExperiment(expname);
	}
	/**
	 * 
	 * @param expName
	 * @param stratname
	 * take experiment name, adds the strategy name to it's list of strategy
	 * @return boolean
	 */
	protected static boolean addStrategy(String expName, String stratname){
		return(appEngine.getExperiment(expName).addStrategy(stratname));
	}

	public static void addtimeset(String currentExperiment, String string, String string2) {
		// TODO Auto-generated method stub
		
	}

}