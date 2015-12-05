package autotradingsim.application;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import autotradingsim.experiment.*;
import autotradingsim.stocks.IStock;
import autotradingsim.strategy.*;
import autotradingsim.strategy.rules.IRule;
import autotradingsim.strategy.rules.RuleID;
import autotradingsim.util.ObjectFileSystem;
import autotradingsim.util.Pair;

public class TradingApplication implements ITradingApplication {
	
	private String PathToExperiments;
	private String PathToStrategies;
	
	private HashMap<Integer, IStrategy> strategies;
	private HashMap<Integer, IExperiment> experiments;
	
	private StockLoader loader;
	private HashMap<String, IStock> stocks;

	private static TradingApplication instance = null;
	
	protected TradingApplication() {
		this.loader = new StockLoader();
		
		this.strategies = new HashMap<Integer, IStrategy>();
		
		this.experiments = new HashMap<Integer, IExperiment>();
		
		this.stocks = new HashMap<String, IStock>();
		
		PathToExperiments = System.getProperty("user.dir") + File.separator + "DATA" +
							File.separator + "EXPERIMENTS" + File.separator;
		PathToStrategies = System.getProperty("user.dir") + File.separator + "DATA" + 
							File.separator + "STRATEGIES" + File.separator;
		
		instance = this;
		
		//Initialize Directory for storing experiments
		File experimentDir = new File(PathToExperiments);
		if(!experimentDir.exists())
			experimentDir.mkdir();
		
		//Initialize Directory for storing strategies
		File strategyDir = new File(PathToStrategies);
		if(!strategyDir.exists())
			strategyDir.mkdir();
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
	 *
	 * @return true if experiment added into Application successfully
	 */
	@Override
	public boolean setExperiment(String experimentName, IExperiment experiment){
		if(experimentName == null || experiment == null ||
				!experiment.getName().equals(experimentName))
			return false;
		
		return addExperiment(experiment);
	}

	/**
	 * Remove experiment from cache and disk
	 * 
	 * @param experimentName of experiment to remove
	 * @return true iff experiment found and removed successfully
	 */
	public boolean delExperiment(String experimentName){
		if(this.getExperiment(experimentName) == null)
			return false;
		String path = PathToExperiments + experimentName;
		File expFile = new File(path);
		if (!expFile.exists() || !expFile.isFile()){
			return false;
		}
		expFile.delete();
		experiments.remove(experimentName.hashCode());
		return true;
	}
	/**
	 * Add an experiment into the application
	 * Experiment will be stored by name found in from IExperiment.getName
	 * 
	 * @param experiment Experiment object which will be stored
	 * @return true if experiment added into Application successfully
	 */
	@Override
	public boolean addExperiment(IExperiment experiment) {
		if(experiment == null || experiment.getName() == null)
			return false;
		
		if(experiments.containsKey(experiment.getName().hashCode())){
			return false;
		}
		experiments.put(experiment.getName().hashCode(), experiment);
		
		this.saveExperiment(experiment);
		return true;
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
		if(experiments.containsKey(experimentName.hashCode())){
			return experiments.get(experimentName.hashCode());
		}else{
			IExperiment result = loadExperiment(experimentName);
			if(result != null)
				this.setExperiment(experimentName, result);
			return result;
		}
	}
	

	/**
	 * Save an experiment to file. Experiment is saved by it's given name.
	 * 
	 * @param experiment which will be saved to file under EXPERIMENTS dir
	 */
	private void saveExperiment(IExperiment experiment){
		String path = PathToExperiments + experiment.getName();
		if(!ObjectFileSystem.saveObject(path, experiment))
			System.err.println("Something went wrong. Check console");
	}

	/**
	 * Load experiment from memory with given name. 
	 * Null on error with error printed to System.err
	 * 
	 * @param name of experiment to load
	 * @return experiment in file or null on error
	 */
	private IExperiment loadExperiment(String name){
		String path = PathToExperiments + name;
		return (IExperiment) ObjectFileSystem.loadObject(path);
	}
	
	/**
	 * get all available experiment names in application
	 * @return a set of experiment names
	 */
	public Set<String> getAvailableExperiments(){
		File experiments = new File(this.PathToExperiments);
		Set<String> returningSet = new HashSet<String>();
		if(experiments.exists() && experiments.isDirectory()){
			for(File experiment : experiments.listFiles())
				returningSet.add(experiment.getName());
		}
		return returningSet;
	}

	/**
	 * Add a strategy by name into the application
	 * StrategyName should match with name found under newStrat object
	 * 
	 * @param stratName name under to which to store experiment
	 * @param strat IStrategy object which is to be added to application
	 * @return true if strategy added successfully into application
	 */
	@Override
	public boolean setStrategy(String stratName, IStrategy strat){
		if(stratName == null || strat == null ||
				!strat.getName().equals(stratName))
			return false;
		return setStrategy(strat);
	}
	
	
	/**
	 * Add a strategy into the application
	 * Strategy stored by using the name resolved under getName
	 * 
	 * @param newStrat IStrategy object which is to be added to application
	 * @return true if strategy added successfully into application
	 */
	@Override
	public boolean setStrategy(IStrategy newStrat) {
		if(newStrat == null || newStrat.getName() == null)
			return false;
		
		if(strategies.containsKey(newStrat.getName().hashCode()))
			return false;

		strategies.put(newStrat.getName().hashCode(), newStrat);
		
		this.saveStrategy(newStrat);
		return true;
	}

	/**
	 * Retrieves a strategy by it's given name
	 * 
	 * @param stratName strategy name which was used to store strategy
	 * @return strategy with the associated name or null on none found
	 */
	@Override
	public IStrategy getStrategy(String stratName){
		if(stratName == null)
			return null;
		if(strategies.containsKey(stratName.hashCode())){
			return strategies.get(stratName.hashCode());
		}else{
			IStrategy result = loadStrategy(stratName);
			if(result != null)
				this.setStrategy(stratName, result);
			return result;
		}
	}
	
	private void saveStrategy(IStrategy newStrat) {
		if(newStrat.getName() == null){
			System.out.println("Warning, not saving strategy. Missing name.");
			return;
		}
		String path = this.PathToStrategies + newStrat.getName();
		ObjectFileSystem.saveObject(path, newStrat);
	}
	
	private IStrategy loadStrategy(String stratName) {
		String path = this.PathToStrategies + stratName;
		IStrategy returnedObject = (IStrategy) ObjectFileSystem.loadObject(path);
		if(returnedObject == null)
			return null;
		
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
		File strategies = new File(this.PathToStrategies);
		Set<String> returningSet = new HashSet<String>();
		if(strategies.exists() && strategies.isDirectory()){
			for(File strategy : strategies.listFiles())
				returningSet.add(strategy.getName());
		}
		return returningSet;
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
	 * Clear the Applications internal cache
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
		instance.clearMemory();
		instance = null;
	}

	/**
	 * Clear any objects saved by the application.
	 * Application returns to a "first run" state
	 */
	public static void clearFileSystem() {
		
		String PathToExperiments = System.getProperty("user.dir") + File.separator + "DATA" +
				File.separator + "EXPERIMENTS" + File.separator;
		String PathToStrategies = System.getProperty("user.dir") + File.separator + "DATA" + 
				File.separator + "STRATEGIES" + File.separator;
		
		File experiments = new File(PathToExperiments);
		if(experiments.exists() && experiments.isDirectory())
			for(File experiment : experiments.listFiles())
				experiment.delete();
		
		File strategies = new File(PathToStrategies);
		if(strategies.exists() && strategies.isDirectory())
			for(File strategy : strategies.listFiles())
				strategy.delete();
		
	}
	
}
