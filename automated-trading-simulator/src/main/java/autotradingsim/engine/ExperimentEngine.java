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
        /**
         * Returns a primitive experiment result
         * @param experimentname
         * @param timeset
         * @return 
         */
	public List<String> runExperiment(IExperiment experiment, TimeSet timeset){
                List<String> resultstring = new ArrayList<String>();
		for (Result r : experiment.runExperiment(timeset)){
                    resultstring.add("Start Date: "+r.getStartDate().toString());
                    resultstring.add("Opening balance: "+ r.getOpeningBalance());
                    resultstring.add("End Date: "+ r.getStartDate().plusDays(r.getDurationInDays()));
                    resultstring.add("Closing balance: "+ r.getClosingBalance());
                    resultstring.add("---------------------------------------------");
                }
                
                return resultstring;
	}

	public void runExperiment(TimeSet timeSet) {
		ExperimentEngine engine = getInstance();


	}


}
