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

        public Pair<LocalDate, LocalDate> getValidTimeSet(IExperiment experiment){
            
            Map<String, Pair<LocalDate, LocalDate>>startAndEndDates = experiment.getStockStartAndEndDates();
            //find the maximum startdate, if there are stocks with ends before maximum startdates
                //return null
            //else: find minimum enddate
            if(startAndEndDates.isEmpty()){
                return null;
            }
            LocalDate maxStartDate = null;
            LocalDate minEndDate = null;
            List<LocalDate> startDates = new ArrayList<>();
            List<LocalDate> endDates =new ArrayList<>();
            Set<String>symbols = startAndEndDates.keySet();
            for(String symbol: symbols){
                System.out.println(symbol);
                startDates.add(startAndEndDates.get(symbol).x);
                endDates.add(startAndEndDates.get(symbol).y);
            }
            maxStartDate = Collections.max(startDates);
            minEndDate = Collections.min(endDates);
            if(minEndDate.compareTo(maxStartDate)>0){
                return new Pair(maxStartDate, minEndDate);
            }
            return null;
        }
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
