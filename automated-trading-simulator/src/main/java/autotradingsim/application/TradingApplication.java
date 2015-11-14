package autotradingsim.application;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import autotradingsim.experiment.*;
import autotradingsim.stocks.IStock;
import autotradingsim.stocks.StockLoader;
import autotradingsim.strategy.*;

public class TradingApplication implements ITradingApplication {
	
	private HashMap<Integer, IStrategy> strategies;
	private HashSet<String> strategyNames;
	
	private HashMap<Integer, IExperiment> experiments;
	private HashSet<String> experimentNames;
	
	private StockLoader loader;
	private HashMap<String, IStock> stocks;

	private static TradingApplication instance = null;
	
	protected TradingApplication() {
		this.loader = new StockLoader();
		
		this.strategies = new HashMap<Integer, IStrategy>();
		this.strategyNames = new HashSet<String>();
		
		this.experiments = new HashMap<Integer, IExperiment>();
		this.experimentNames = new HashSet<String>();
		
		this.stocks = new HashMap<String, IStock>();
		
		instance = this;
	}
	
	public static TradingApplication getInstance(){
		if (instance == null){
			instance = new TradingApplication();
		}
		return instance;
	}
	
	/**
	 * Add an experiment by name into the application
	 * Name given and name found in experiment don't need
	 * to match, but after being loaded, must use name found
	 * in IExperiment class
	 * 
	 * @param experimentName name under which to store experiment
	 * @param experiment Experiment object which will be stored
	 * @return true if experiment added into Application successfully
	 */
	@Override
	public boolean setExperiment(String experimentName, IExperiment experiment){
		if(experiments.containsKey(experimentName.hashCode())){
			assert(experimentNames.contains(experimentName));
			return false;
		}
		experimentNames.add(experimentName);
		experiments.put(experimentName.hashCode(), experiment);
		return true;
	}

	/**
	 * Return experiment object associated with given name
	 * 
	 * @param experimentName ID associated with experiment
	 * @return experiment object found with ID. Null if no experiment by name found
	 */
	@Override
	public IExperiment getExperiment(String experimentName){
		return experiments.get(experimentName.hashCode());
	}
	
	/**
	 * get all available experiment names in application
	 * @return a set of experiment names
	 */
	public Set<String> getAvailableExperiments(){
		Set<String> returningSet = new HashSet<String>();
		for(String name : this.experimentNames)
			returningSet.add(name);
		return returningSet;
	}

	/**
	 * Add a strategy by name into the application
	 * StrategyName should match with name found under newStrat object
	 * 
	 * @param StrategyName name under to which to store experiment
	 * @param newStrat IStrategy object which is to be added to application
	 * @return true if strategy added successfully into application
	 */
	@Override
	public boolean setStrategy(String stratName, IStrategy strat){
		if(strategies.containsKey(stratName.hashCode())) {
			assert(strategyNames.contains(stratName));
			return false;
		}
		strategyNames.add(stratName);
		strategies.put(stratName.hashCode(), strat);
		return true;
	}
	

	/**
	 * Retrieves a strategy by it's given name
	 * 
	 * @param stratname strategy name which was used to store strategy
	 * @return strategy with the associated name or null on none found
	 */
	@Override
	public IStrategy getStrategy(String stratName){
		return strategies.get(stratName.hashCode());
	}
	
	/**
	 * return a set of available strategies loaded into memory
	 * @return set of names of strategies
	 */
	@Override
	public Set<String> getAvailableStrategies() {
		Set<String> returningSet = new HashSet<String>();
		for(String name : this.strategyNames)
			returningSet.add(name);
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
		if (stocks.containsKey(symbol)){
			return this.stocks.get(symbol);
		} else {
			this.loadStock(symbol);
			return this.stocks.get(symbol);
		}
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
	public Iterator<String> getStockSymbols(){
		// TODO Change this so we can get a list of all possible stocks.
		return this.stocks.keySet().iterator();
	}

	/**
	 * Clear the Applications internal cache
	 */
	@Override
	public void ClearMemory() {
		strategies.clear();
		strategyNames.clear();
		
		experiments.clear();
		experimentNames.clear();

		stocks.clear();
	}
}
