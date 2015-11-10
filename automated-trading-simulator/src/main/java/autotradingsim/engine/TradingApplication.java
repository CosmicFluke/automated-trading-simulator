package autotradingsim.engine;
import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.Iterator;

import autotradingsim.experiment.*;
import autotradingsim.stocks.IStock;
import autotradingsim.stocks.StockLoader;
import autotradingsim.strategy.*;

public class TradingApplication {
	private StockLoader loader;
	public HashMap<Integer, IStrategy> strategies = new HashMap();
	public HashMap<Integer, IExperiment> experiments = new HashMap();
	private HashMap<String,IStock> stocks = new HashMap<>();

	private static TradingApplication instance=null;
	
	protected TradingApplication() {
		this.loader = new StockLoader();
		// TODO Auto-generated constructor stub
	}
	
	public static TradingApplication getInstance(){
		if (instance==null){
			instance=new TradingApplication();
		}
		return instance;
	}
	
	public boolean saveExperiment(IExperiment experiment){
		if(experiments.containsKey(experiment.getName())){
			return false;
		}else{
			experiments.put(experiment.getName().hashCode(), experiment);
			return true;
		}
	}
	
	public Experiment getExperiment(int expID){
		return (Experiment) experiments.get(expID);
	}
	
	public void displayResults(String filename) throws IOException, ParseException{
		File file = new File(filename);
		Scanner fileReader = new Scanner(file);
		while((fileReader.hasNextLine())){
			String strategyName=fileReader.nextLine();
			String symbol=fileReader.nextLine();
			String dateString=fileReader.nextLine();
			List<String[]> actionList = new ArrayList<String[]>();
			List<BigDecimal> balanceList = new ArrayList<BigDecimal>();
			List<Integer> holdingList = new ArrayList<Integer>();
			//print result header
			DateFormat format = new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH);
			Calendar cal=Calendar.getInstance();
			cal.setTime((Date) format.parse(dateString));
			dateString=format.format(cal.getTime());
			System.out.println("Strategy: "+strategyName+" | Stock: "+symbol+" | Starting date: "+dateString);
	
			String line = null;
			while(fileReader.hasNextLine()){
				line = fileReader.nextLine();
				if(line.equals("") || line == null){
					break;
				}
					String[] dailyData=line.split(",");
					balanceList.add(new BigDecimal(dailyData[0]));
					holdingList.add(Integer.parseInt(dailyData[1]));
					String[] actions = new String[dailyData.length-2];
					System.arraycopy(dailyData,2, actions, 0, dailyData.length-2);
					actionList.add(actions);
					
					if(actions.length!=0){
						System.out.print(dateString);
						System.out.print(" action: ");
						System.out.print(actions[0]);
						for(int i = 1; i < actions.length; i++){
							System.out.print(", " + actions[i]);
						}
						System.out.println("");
					}else{
						System.out.println(dateString);
					}
					//increment date by 1
					cal.setTime((Date) format.parse(dateString));
					cal.add(Calendar.DATE, 1);
					dateString=format.format(cal.getTime());
			}
			BigDecimal startingCapital = balanceList.get(0).add(new BigDecimal(holdingList.get(0)));
			BigDecimal closingBalance = balanceList.get(balanceList.size()-1).add(new BigDecimal(holdingList.get(balanceList.size()-1)));
			BigDecimal earnings = closingBalance.subtract((startingCapital));
			BigDecimal percentEarning = earnings.multiply(new BigDecimal(100)).divide(startingCapital, 2, RoundingMode.HALF_UP);
			System.out.println("Starting Capital: "+startingCapital);
			System.out.println("Closing Balance: "+closingBalance);
			System.out.println("Earnings: "+earnings);
			System.out.println("Percent Earning: " + percentEarning + "%");
			System.out.println("------------------------------------------------------------");
			if(line==null){
				break;
			}
		}
		fileReader.close();
	}
	
	public IStrategy getStrategy(String stratname){
		return null;
	}
	public IStrategy getStrategy(int stratid){
		return strategies.get(stratid);	
	}
	
	public boolean saveStrategy (SimpleStrategy strategy){
		if(strategies.containsKey(strategy.hashCode())){
			return false;
		}else{
		strategies.put(strategy.getName().hashCode(), strategy);
			return true;
		}
	}
	
	/**
	 * Loads a Stock to memory.
	 * @param symbol: String representing the stock symbol to be loaded.
	 */
	private void loadStock(String symbol){
		if (this.existsStock(symbol)){
			stocks.put(symbol, this.loader.fetchStock(symbol));
		}
	}
	
	/**
	 * Retrive a Stock from application. This is a lazy loading method, 
	 * will only retrive a Stock when asked for.
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
	public boolean existsStock(String symbol) {
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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
	}
}
