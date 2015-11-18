package autotradingsim.application;

import java.util.Iterator;
import java.util.Set;

import autotradingsim.experiment.IExperiment;
import autotradingsim.stocks.IStock;
import autotradingsim.strategy.IStrategy;

public interface ITradingApplication {

	/**
	 * Add an experiment by name into the application
	 * Name given and name found in experiment need
	 * to match
	 * 
	 * @param experimentName name under which to store experiment
	 * @param experiment Experiment object which will be stored
	 * @return true if experiment added into Application successfully
	 */
	boolean setExperiment(String experimentName, IExperiment experiment);
	
	/**
	 * Add an experiment into the application
	 * Experiment will be stored by name found in from IExperiment.getName
	 * 
	 * @param experiment Experiment object which will be stored
	 * @return true if experiment added into Application successfully
	 */
	boolean addExperiment(IExperiment experiment);
	
	/**
	 * Return experiment object associated with given name
	 * 
	 * @param experimentName ID associated with experiment
	 * @return experiment object found with ID. Null if no experiment by name found
	 */
	IExperiment getExperiment(String experimentName);
	
	/**
	 * get all available experiment names in application
	 * @return a set of experiment names
	 */
	Set<String> getAvailableExperiments();

	/**
	 * Add a strategy by name into the application
	 * StrategyName should match with name found under newStrat object
	 * 
	 * @param StrategyName name under to which to store experiment
	 * @param newStrat IStrategy object which is to be added to application
	 * @return true if strategy added successfully into application
	 */
	boolean setStrategy(String StrategyName, IStrategy newStrat);
	
	/**
	 * Add a strategy into the application
	 * Strategy stored by using the name resolved under getName
	 * 
	 * @param newStrat IStrategy object which is to be added to application
	 * @return true if strategy added successfully into application
	 */
	boolean setStrategy(IStrategy newStrat);
	
	/**
	 * Retrieves a strategy by it's given name
	 * 
	 * @param stratname strategy name which was used to store strategy
	 * @return strategy with the associated name or null on none found
	 */
	IStrategy getStrategy(String stratname);

	/**
	 * return a set of available strategies loaded into memory
	 * @return set of names of strategies
	 */
	Set<String> getAvailableStrategies();

	/**
	 * Retrieve a Stock from application.
	 *
	 * @param symbol: official name of the stock
	 * @return Stock object associated with stock
	 */
	IStock getStock(String symbol);

	/**
	 * Check if a Stock symbol is available in data.
	 * 
	 * @param symbol: String of a stock symbol, not case sensitive.
	 * @return true if stock exists in data, false otherwise.
	 */
	boolean stockExists(String symbol);

	/**
	 * Get an iterator of loaded stock symbols.
	 * 
	 * @return Iterator<String> of stock symbols available.
	 */
	Iterator<String> getStockSymbols();
	
	/**
	 * Clear any objects in Application memory
	 */
	void clearMemory();
	
}