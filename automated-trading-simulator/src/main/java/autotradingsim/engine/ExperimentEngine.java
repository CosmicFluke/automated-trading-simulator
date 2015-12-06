package autotradingsim.engine;

import autotradingsim.application.TradingApplication;
import autotradingsim.experiment.Experiment;
import autotradingsim.experiment.IExperiment;
import autotradingsim.experiment.Result;
import autotradingsim.experiment.TimeSet;
import autotradingsim.util.Pair;
import java.util.*;
import java.time.LocalDate;

public class ExperimentEngine {

	private static ExperimentEngine engine;
	private static TimeSet timeSet;

	//private TradingApplication application;

	/**
	 * Construct a new ExperimentEngine.<br>
	 *
	 */
	private ExperimentEngine() {
		//application = TradingApplication.getInstance();
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
		IExperiment retExp = new Experiment(expname);
		try {
            TradingApplication.getInstance().addExperiment(retExp);
		} catch (IllegalArgumentException e) {
            System.out.println("Could not add experiment to application");
            throw e;
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
		return TradingApplication.getInstance().getExperiment(expname);
	}

	/**
	 * Add Strategy and stock pair to the trial
	 * @param expName
	 * @param strategyId
	 * @param stockSymbol
	 */
	public void addTrial(String expName, String strategyId, String stockSymbol) {
		TradingApplication.getInstance().getExperiment(expName).addTrial(strategyId, stockSymbol);
	}

//	public void addtimeset(String currentExperiment, String string, String string2) {
//		// TODO Auto-generated method stub
//
//	}

	/**
	 * Returns a primitive experiment result
	 * @param experiment
	 * @return
	 */

        public Pair<LocalDate, LocalDate> generateTimeSet(IExperiment experiment){
            
            Map<String, Pair<LocalDate, LocalDate>>startAndEndDates = experiment.getStockStartAndEndDates();
            //find the maximum startdate, if there are stocks with ends before maximum startdates
                //return null
            //else: find minimum enddate
            if(startAndEndDates.isEmpty()){
                return null;
            }
            LocalDate StartDate = null;
            LocalDate EndDate = null;
            List<LocalDate> startDates = new ArrayList<>();
            List<LocalDate> endDates = new ArrayList<>();
            Set<String>symbols = startAndEndDates.keySet();
            for(String symbol: symbols){
                startDates.add(startAndEndDates.get(symbol).y);
                endDates.add(startAndEndDates.get(symbol).x);
            }
            StartDate = Collections.max(startDates);
            EndDate = Collections.min(endDates);
			return new Pair(StartDate, EndDate);
        }
        /**
         * Returns a primitive experiment result
         * @param timeset
         * @return
         */

	public List<String> runExperiment(IExperiment experiment, TimeSet timeset){
		List<String> resultstring = new ArrayList<String>();
		while (experiment.runExperiment(timeset).getExperimentResultsIterator().hasNext()){
			Result result = experiment.runExperiment(timeset).getExperimentResultsIterator().next();
			resultstring.add("Start Date: " + result.getStartDate().toString());
			resultstring.add("Opening balance: " + result.getOpeningBalance());
			resultstring.add("End Date: " + result.getStartDate().plusDays(result.getDurationInDays()));
			resultstring.add("Closing balance: "+ result.getClosingBalance());
			resultstring.add("---------------------------------------------");
			}

			return resultstring;
	}

	public void runExperiment(TimeSet timeSet) {
		ExperimentEngine engine = getInstance();
        }


}
