package autotradingsim.engine;

import autotradingsim.application.TradingApplication;
import autotradingsim.experiment.Experiment;
import autotradingsim.experiment.IExperiment;
import autotradingsim.experiment.Result;
import autotradingsim.experiment.TimeSet;
import java.util.*;
import java.time.LocalDate;

public class ExperimentEngine {

	private static ExperimentEngine engine;
	private static TimeSet timeSet;

	private TradingApplication application;

	/**
	 * Construct a new ExperimentEngine.<br>
	 *
	 */
	private ExperimentEngine() {
		application = TradingApplication.getInstance();
	}


	/**
	 * Get the instance of this singleton class.
	 * @return Singular instance of <tt>ExperimentEngine</tt>
     */
	public static ExperimentEngine getInstance() {
		if (engine == null){
			engine = new ExperimentEngine();
		}
		return engine;
	}
	
	/**
	 * Takes an experiment name, returns the new experiment created
	 * @param expname the name of the experiment to create
	 * @return A new experiment with the given name
	 *
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
	 * @param experiment
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
