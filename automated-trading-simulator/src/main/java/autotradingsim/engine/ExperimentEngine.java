package autotradingsim.engine;

import autotradingsim.application.TradingApplication;
import autotradingsim.experiment.Experiment;

public class ExperimentEngine {

	public static TradingApplication appEngine;
	public static Experiment currExperiment;
	public static ExperimentEngine engine;
	
	/**
	 * 
	 * @param none
	 * populate appEngine with instance of application
	 */
	private ExperimentEngine() {
		// TODO Auto-generated constructor stub
		 appEngine = TradingApplication.getInstance();
	}
	

	public static ExperimentEngine getInstance() {
		// TODO Auto-generated method stub
		if (engine==null){
			engine = new ExperimentEngine();
		}
		return engine;
		
	}
	
	/**
	 * 
	 * @param expname
	 * @return retExp 
	 * takes an experiment name, returns the new experiment created
	 */
	public Experiment createExperiment(String expname){
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
	public Experiment getExperiment(String expname) {
		// TODO Auto-generated method stub
		return (Experiment) appEngine.getExperiment(expname);
	}
	/**
	 *
	 * @param expName
	 * @param stratname
	 * take experiment name, adds the strategy name to it's list of strategy
	 * @throws IllegalArgumentException: If strategyName does not exist in Trading Application
	 */
	public void addStrategy(String expName, String stratname){
		appEngine.getExperiment(expName).addStrategy(stratname);
	}

	public void addtimeset(String currentExperiment, String string, String string2) {
		// TODO Auto-generated method stub
		
	}


}
