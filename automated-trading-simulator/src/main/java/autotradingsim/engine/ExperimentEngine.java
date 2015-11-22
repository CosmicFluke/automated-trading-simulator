package autotradingsim.engine;

import autotradingsim.application.TradingApplication;
import autotradingsim.experiment.Experiment;
import autotradingsim.experiment.IExperiment;
import autotradingsim.experiment.Result;
import autotradingsim.experiment.TimeSet;
import java.util.*;
import java.time.LocalDate;

public class ExperimentEngine {

	public static TradingApplication application;
	public static ExperimentEngine engine;
	public static TimeSet timeSet;
	
	/**
	 *
	 * populate appEngine with instance of application
	 */
	private ExperimentEngine() {
		// TODO Auto-generated constructor stub
		application = TradingApplication.getInstance();
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
	public IExperiment createExperiment(String expname){
		IExperiment retExp=null;
		if(application.setExperiment(expname, new Experiment(expname))) {
			retExp = application.getExperiment(expname);
		}
		return retExp;
	}
	/**
	 *
	 * @param expname
	 * @return Experiment
	 * takes experiment name and returns experiment object with that name
	 */
	public IExperiment getExperiment(String expname) {
		return application.getExperiment(expname);
	}

	/**
	 *
	 * @param expName
	 * @param stratname
	 * take experiment name, adds the strategy name to it's list of strategy
	 * @throws IllegalArgumentException: If strategyName does not exist in Trading Application
	 */
	public void addStrategy(String expName, String stratname){
		application.getExperiment(expName).addStrategy(stratname);
	}

	/**
	 * Add Stock symbol to the experiment
	 * @param expName
	 * @param stockSymbol
	 */
	public void addStock(String expName, String stockSymbol) {
		application.getExperiment(expName).addStock(stockSymbol);
	}

	/**
	 * Add Strategy and stock pair to the trial
	 * @param expName
	 * @param strategyId
	 * @param stockSymbol
	 */
	public void addTrial(String expName, String strategyId, String stockSymbol) {
		application.getExperiment(expName).addTrial(strategyId, stockSymbol);
	}

//	public void addtimeset(String currentExperiment, String string, String string2) {
//		// TODO Auto-generated method stub
//
//	}
	public List<Result> runExperiment(String experimentname, TimeSet timeset){
		IExperiment experiment = application.getExperiment(experimentname);
		return experiment.runExperiment(timeset);
	}

	public void runExperiment(TimeSet timeSet) {
		ExperimentEngine engine = getInstance();


	}


}
