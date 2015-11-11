package autotradingsim.application;

import java.io.IOException;
import java.text.ParseException;
import java.util.Iterator;

import autotradingsim.experiment.Experiment;
import autotradingsim.experiment.IExperiment;
import autotradingsim.stocks.IStock;
import autotradingsim.strategy.IStrategy;

public interface ITradingApplication {

	boolean saveExperiment(IExperiment experiment);
	Experiment getExperiment(int expID);

	IStrategy getStrategy(String stratname);
	IStrategy getStrategy(int stratid);

	boolean saveStrategy(IStrategy newstrat);

	/**
	 * Retrive a Stock from application. This is a lazy loading method, 
	 * will only retrive a Stock when asked for.
	 * @param symbol:
	 * @return
	 */
	IStock getStock(String symbol);

	/**
	 * Check if a Stock symbol is available in data.
	 * @param symbol: String of a stock symbol, not case sensitive.
	 * @return true if stock exists in data, false otherwise.
	 */
	boolean existsStock(String symbol);

	/**
	 * Get an iterator of loaded stock symbols.
	 * @return Iterator<String> of stock symbols that are loaded.
	 */
	Iterator<String> getStockSymbols();

}