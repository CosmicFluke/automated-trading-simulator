package autotradingsim.application;
import java.io.*;
import java.util.*;
import java.util.function.Function;

import autotradingsim.experiment.*;
import autotradingsim.stocks.IStock;
import autotradingsim.strategy.*;
import autotradingsim.strategy.rules.IRule;
import autotradingsim.strategy.rules.RuleID;
import autotradingsim.util.ObjectFileSystem;
import autotradingsim.util.Pair;

public class TradingApplication implements ITradingApplication {


	private Set<String> experimentNameSet;
	private Set<String> strategyNameSet;
	
	private HashMap<Integer, IStrategy> strategies;
	private HashMap<Integer, IExperiment> experiments;
	
	private StockLoader loader;
	private HashMap<String, IStock> stocks;

	private static TradingApplication instance;
	
	private TradingApplication() {
		this.loader = new StockLoader();
		
		this.strategies = new HashMap<Integer, IStrategy>();
		
		this.experiments = new HashMap<Integer, IExperiment>();
		
		this.stocks = new HashMap<String, IStock>();
		
		//Initialize Directory for storing experiments
		File experimentDir = new File(rootPath + pathToExperiments);
		if(!experimentDir.exists())
			experimentDir.mkdir();
		
		//Initialize Directory for storing strategies
		File strategyDir = new File(rootPath + pathToStrategies);
		if(!strategyDir.exists())
			strategyDir.mkdir();

		experimentNameSet =
				(ObjectFileSystem.checkListFileExists(pathToData + expListFilename)) ?
						ObjectFileSystem.loadNamesFromListFile(pathToData + expListFilename) : new HashSet<>();

		strategyNameSet =
				(ObjectFileSystem.checkListFileExists(pathToData + stratListFilename)) ?
						ObjectFileSystem.loadNamesFromListFile(pathToData + stratListFilename) : new HashSet<>();

	}

	public static TradingApplication getInstance(){
		if (instance == null){
			instance = new TradingApplication();
		}
		return instance;
	}
	
	/**
	 * Add an experiment by name into the application
	 * Name given and name found in experiment need
	 * to match
	 *
	 * @return true if experiment added into Application successfully
	 */
	@Override
	public boolean addExperiment(IExperiment experiment){
		if (experiment == null)
			throw new NullPointerException("addExperiment: IExperiment argument was null");

		if (experiment.getName() == null)
			throw new IllegalArgumentException("addExperiment: IExperiment had a null name");


		if (experimentNameSet.contains(experiment.getName())){
			throw new IllegalArgumentException(
					"addExperiment: duplicate key -- an experiment with "+ experiment.getName() +"is already stored");
		}

		experiments.put(experiment.getName().hashCode(), experiment);
		experimentNameSet.add(experiment.getName());

		ObjectFileSystem.appendNameToListFile(pathToData + expListFilename, experiment.getName());
		this.saveExperiment(experiment);
		return true;
	}


	/**
	 * Remove experiment from cache and disk
	 * 
	 * @param experimentName of experiment to remove
	 * @return true iff experiment found and removed successfully
	 */
	public boolean delExperiment(String experimentName) {
		if (experimentName == null)
			throw new NullPointerException("Experiment name was null");
		IExperiment exp = this.getExperiment(experimentName);
		if (exp == null) {
			System.err.println("Experiment with given name \"" + experimentName + "\" does not exist.");
			return false;
		}

		if (!deleteExperimentFromFileSystem(exp)) {
			System.err.println("Could not delete Experiment \"" + exp.getName() + "\" from filesystem.  " +
					"Experiment was not deleted.  Check console.  Filesystem may be corrupted.");
			return false;
		}

		experimentNameSet.remove(experimentName);
		experiments.remove(experimentName.hashCode());

		return true;
	}

	public boolean delStrategy(String strategyName) {
		IStrategy strategy = this.getStrategy(strategyName);
		if (strategy == null) {
			System.err.println("Strategy with given name \"" + strategyName + "\" does not exist.");
			return false;
		}

		if (!deleteStrategyFromFileSystem(strategy)) {
			System.err.println("Could not delete strategy \"" + strategy.getName() + "\" from filesystem.  " +
					"Strategy was not deleted.  Check console.  Filesystem may be corrupted.");
			return false;
		}

		strategyNameSet.remove(strategyName);
		strategies.remove(strategyName.hashCode());

		return true;
	}

	private boolean deleteExperimentFromFileSystem(IExperiment experiment) {
		if (!ObjectFileSystem.deleteNameFromListFile(pathToData + expListFilename, experiment.getName()))
			return false;

		String pathToFile = pathToExperiments + experiment.getName();
		return ObjectFileSystem.deleteObjectFile(pathToFile);
	}

	private boolean deleteStrategyFromFileSystem(IStrategy strategy) {
		if (!ObjectFileSystem.deleteNameFromListFile(pathToData + stratListFilename, strategy.getName()))
			return false;

		String pathToFile = pathToStrategies + strategy.getName();
		return ObjectFileSystem.deleteObjectFile(pathToFile);
	}

	/**
	 * Return experiment object associated with given name
	 * Tries to load the experiment from memory if able
	 * 
	 * @param experimentName ID associated with experiment
	 * @return experiment object found with ID. Null if no experiment by name found
	 */
	@Override
	public IExperiment getExperiment(String experimentName){
		if(experimentName == null)
			return null;
		if (experiments.containsKey(experimentName.hashCode())){
			return experiments.get(experimentName.hashCode());
		}else{
			IExperiment result;
			try {
				result = loadExperiment(experimentName);
				this.experiments.put(experimentName.hashCode(), result);
			} catch (NullPointerException e) {
				System.err.println("Experiment does not exist");
				throw e;
			}
			return result;
		}
	}
	

	/**
	 * Save an experiment to file. Experiment is saved by it's given name.
	 *
	 * @param experiment which will be saved to file under EXPERIMENTS dir
	 */
	public void saveExperiment(IExperiment experiment){
		if (experiment == null)
			throw new NullPointerException("IExperiment argument was null");
		if (experiment.getName() == null)
			throw new NullPointerException("IExperiment argument has null name");
		if (experiment.getName().equals(""))
			throw new IllegalArgumentException("IExperiment argument has empty string as name");

		String path = pathToExperiments + experiment.getName();
		if (!ObjectFileSystem.saveObject(path, experiment)) {
			System.err.println("Error in \"TradingApplication::saveExperiment\"\n\tCould not save object. Check console");
		}

	}

	/**
	 * Load experiment from memory with given name. 
	 * Null on error with error printed to System.err
	 * 
	 * @param name of experiment to load
	 * @return experiment in file or null on error
	 */
	private IExperiment loadExperiment(String name) {
		String path = pathToExperiments + name;
		IExperiment exp = (IExperiment) ObjectFileSystem.loadObject(path);
		if (exp == null) {
			throw new NullPointerException("File for experiment does not exist or contained null object");
		}
		if (exp.getName() == null) {
			throw new NullPointerException("loadExperiment: loaded object contains invalid properties");
		}
		return exp;
	}
	
	/**
	 * get all available experiment names in application
	 * @return a set of experiment names
	 */
	public Set<String> getAvailableExperiments(){
		return Collections.unmodifiableSet(experimentNameSet);
	}

	public boolean addStrategy(IStrategy strategy){
		if (strategy == null) {
			throw new NullPointerException("Strategy was null");
		}
		if (strategy.getName() == null) {
			throw new NullPointerException("Strategy name was null");
		}
		if (strategy.getName().equals("")) {
			throw new IllegalArgumentException("Strategy name was empty string");
		}

		if (strategyNameSet.contains(strategy.getName())) {
			System.err.println("TradingApplication::getStrategy\n\tStrategy with that name already exists");
			return false;
		}

		strategies.put(strategy.getName().hashCode(), strategy);
		strategyNameSet.add(strategy.getName());
		ObjectFileSystem.appendNameToListFile(pathToData + stratListFilename, strategy.getName());
		this.saveStrategy(strategy);

		return true;
	}

	/**
	 * Retrieves a strategy by it's given name
	 * 
	 * @param strategyName strategy name which was used to store strategy
	 * @return strategy with the associated name or null on none found
	 */
	@Override
	public IStrategy getStrategy(String strategyName){
		if (strategyName == null)
			throw new NullPointerException("getStrategy: strategyName was null");
		if (!strategyNameSet.contains(strategyName))
			return null;
		if (strategies.containsKey(strategyName.hashCode())) {
			return strategies.get(strategyName.hashCode());
		}else{
			IStrategy result = loadStrategy(strategyName);
			if (result != null)
				this.strategies.put(strategyName.hashCode(), result);
			return result;
		}
	}

	public void saveStrategy(IStrategy newStrategy) {
		if (newStrategy == null)
			throw new NullPointerException("Strategy argument was null");
		if (newStrategy.getName() == null)
			throw new NullPointerException("IExperiment argument has null name");
		if (newStrategy.getName().equals(""))
			throw new IllegalArgumentException("IExperiment argument has empty string as name");

		String path = pathToStrategies + newStrategy.getName();

		if (!ObjectFileSystem.saveObject(path, newStrategy)) {
			System.err.println("Error in \"TradingApplication::saveStrategy\"\n\tCould not save object. Check console");
		}
	}
	
	private IStrategy loadStrategy(String stratName) {
		String path = pathToStrategies + stratName;
		IStrategy returnedObject = (IStrategy) ObjectFileSystem.loadObject(path);
		if (returnedObject == null)
			throw new NullPointerException("File for strategy does not exist or could not be loaded.");
		if (returnedObject.getName() == null) {
			throw new NullPointerException("loadStrategy: loaded object contains invalid properties");
		}

		// Reset all of the RuleIDs
		Set<IRule> myRules = new HashSet<IRule>();
		for(RuleID myRuleId : returnedObject.getRules()){
			myRules.add(returnedObject.getRule(myRuleId));
			returnedObject.removeRule(myRuleId);
		}
		for(IRule myRule : myRules){
			myRule.generateNewID();
			returnedObject.addRule(myRule);
		}
		
		return returnedObject;
	}

	/**
	 * return a set of available strategies loaded into memory
	 * @return set of names of strategies
	 */
	@Override
	public Set<String> getAvailableStrategies() {
		return Collections.unmodifiableSet(strategyNameSet);
	}

	
	/**
	 * Loads a Stock to memory.
	 * @param symbol: String representing the stock symbol to be loaded.
	 */
	private void loadStock(String symbol){
		if (this.stockExists(symbol)){
			stocks.put(symbol, this.loader.fetchStock(symbol));
		}
	}
	
	/**
	 * Retrieve a Stock from application. This is a lazy loading method, 
	 * will only retrieve a Stock when asked for.
	 * @param symbol:
	 * @return
	 */
	public IStock getStock(String symbol) {
		if (!stocks.containsKey(symbol)){
			this.loadStock(symbol);
		}
		return this.stocks.get(symbol);
    }
	
	/**
	 * Check if a Stock symbol is available in data.
	 * @param symbol: String of a stock symbol, not case sensitive.
	 * @return true if stock exists in data, false otherwise.
	 */
	public boolean stockExists(String symbol) {
        return loader.exists(symbol);
    }
	
	/**
	 * Get an iterator of loaded stock symbols.
	 * @return Iterator<String> of stock symbols that are loaded.
	 */
	public Iterator<Pair<String, String>> getStockSymbols(){
		String pathToStocks = System.getProperty("user.dir") + File.separator + "DATA" + 
				File.separator + "S&P-500-symbol-name-list.csv";

		List<Pair<String, String>> returningSet = new ArrayList<Pair<String, String>>();
		try {
			FileReader stocksFile = new FileReader(pathToStocks);
			BufferedReader stocks = new BufferedReader(stocksFile);
			String stockID, stockName;
			String stockString;
			stocks.readLine(); // Skip first line detailing columns
			while((stockString = stocks.readLine()) != null){
				stockID = stockString.substring(0, stockString.indexOf(','));
				stockName = stockString.substring(stockString.indexOf(',')+1);
				returningSet.add(new Pair<String, String>(stockID, stockName));
			}
			stocks.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return returningSet.iterator();
	}

	/**
	 * Clear the Application's internal cache
	 */
	@Override
	public void clearMemory() {
		strategies.clear();
				
		experiments.clear();
		
		stocks.clear();
	}
	
	/**
	 * Destroy the instance of the object and set it to null
	 */
	public static void destructObject() {
		if (instance != null)
			instance.clearMemory();
		instance = null;
	}

	/**
	 * Clear any objects saved by the application.
	 *
	 */
	public static void clearMemoryAndFileSystem() {

		// Define error-message-generating function
		Function<String[], String> errMessageGen = (String[] typeAndName) ->
				"Could not delete object file for " + typeAndName[0] + ": \"" + typeAndName[1] + "\"";

		// Delete object files for both experiments and strategies
		for (String listType : new String[]{"experiment", "strategy"}) {
			String objectPath = (listType.equals("experiment")) ? pathToExperiments : pathToStrategies;
			File objectDir = new File(objectPath);
			if (objectDir.isDirectory()) {
				File[] files = objectDir.listFiles();
				if (files == null) {
					System.err.println("No files found in directory:\n\t\"" + objectPath + "\"");
					continue;
				}
				for (File item : files) {
					if (!item.delete())
						System.err.println(
								"Could not delete file found at path:\n\t\"" + item.getAbsolutePath() + "\"");
				}
			}
		}

		// Delete list files
		if (ObjectFileSystem.checkListFileExists(pathToData + expListFilename))
			ObjectFileSystem.deleteListFile(pathToData + expListFilename);
		if (ObjectFileSystem.checkListFileExists(pathToData + stratListFilename))
			ObjectFileSystem.deleteListFile(pathToData + stratListFilename);

		// Clear memory and "destroy" instance (via garbage collector)
		if (instance != null) {
			instance.clearMemory();
			instance.experimentNameSet.clear();
			instance.strategyNameSet.clear();
		}
		instance = null;
	}
	
}
