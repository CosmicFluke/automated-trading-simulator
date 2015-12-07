package autotradingsim.application;

import java.io.File;
import java.util.Iterator;
import java.util.Set;

import autotradingsim.experiment.IExperiment;
import autotradingsim.stocks.IStock;
import autotradingsim.strategy.IStrategy;
import autotradingsim.util.Pair;

public interface ITradingApplication {

	String rootPath = System.getProperty("user.dir") + File.separator;
	String listExtension = ".tsl";
	String pathToData = "DATA" + File.separator;
	String pathToStrategies = pathToData + "STRATEGIES" + File.separator;
	String pathToExperiments = pathToData + "EXPERIMENTS" + File.separator;
	String expListFilename = "experimentList";
	String stratListFilename = "strategyList";

	// Unused for now
	String stockListFilename = "stockList";
	String experimentExtension = ".tse";
	String strategyExtension = ".tss";
	String resultsExtension = ".tsr";


	/**
	 * Add an experiment by name into the application
	 * Name given and name found in experiment need
	 * to match
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
	 * Delete experiment from memory and file system
	 * @param experimentName to which remove
	 * @return true iff successful
	 */
	boolean delExperiment(String experimentName);

	/**
	 * Add a strategy into the application
	 * Strategy stored by using the name resolved under getName
	 * @param newStrat IStrategy object which is to be added to application.  Must not be <tt>null</tt>.
	 * @return true if strategy added successfully into application
	 */
	boolean addStrategy(IStrategy newStrat);
	
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
	Iterator<Pair<String, String>> getStockSymbols();
	
	/**
	 * Clear any objects in Application memory
	 */
	void clearMemory();

}