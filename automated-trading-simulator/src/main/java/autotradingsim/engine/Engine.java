package autotradingsim.engine;
import autotradingsim.application.*;
import autotradingsim.strategy.*;

import autotradingsim.strategy.ICondition.Comparator;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;
import autotradingsim.experiment.*;
import autotradingsim.strategy.simpleimpl.*;
import autotradingsim.terminal.*;
public class Engine {

<<<<<<< HEAD
	public TradingApplication appEngine = TradingApplication.getInstance();
	
	protected void createStrategy(){
		appEngine.saveStrategy(null);
	}
	
	public void addStrategy(String exp, int stratid){
		
	}
	
	
	/**
	 * List every available strategy which belongs to the engine
	 */
	public void ListStrategyNames() {
		System.out.println("List of Strategies:");
		for(IStrategy strategy : appEngine.strategies.values())
			System.out.println(strategy.getName());
	}
	
	
	/**
	 * Given a strategy name, print to system.out
	 * Name, and then print every rule which belongs to it
	 * @param stratname name of strategy to view
	 */
	public void viewStrategy(String stratname) {
		System.out.println("List of Strategies:");
		IStrategy strat = null;
		if((strat = appEngine.getStrategy(stratname)) != null){
			System.out.println(strat.getName());
			for (RuleID r : strat.getRules()){
				System.out.println(strat.getRuleName(r));
				System.out.println(strat.getRuleDescription(r));
				System.out.println(strat.getRuleSummary(r));
				//System.out.println(strat.getRuleDecisionMaker(r));
			}
		}
	}
	

	protected static void viewExperiment(String string) {
		// TODO Auto-generated method stub
		
	}

	public static void addtimeset(String currentExperiment, String string, String string2) {
		// TODO Auto-generated method stub
		
	}

	public void createDefaultStrategy() {
		// TODO Auto-generated method stub
		SimpleStrategy newstrat = new SimpleStrategy();
		appEngine.saveStrategy(newstrat);
		System.out.println("Default strategy "+appEngine.getStrategy(newstrat.getName()).getName()+" created");
		System.out.println("This is a read-only strategy. Returning to Main menu.");
	}
	
	/**
	 * Adds a new simple strategy
	 * 
	 * @param stratname
	 * @param cselection Must be either 1 or 2
	 * @param cvalue 
	 * @param aselection Must be either 1 or 2
	 * @param avalue
	 */
	public IStrategy currentStrategy;
	public void addNewSimpleStrategy(String stratname, int cselection, int cvalue, int aselection, int avalue) {
		currentStrategy = 
				new SimpleStrategy(
						stratname, "",
						(cselection == 1) ? Comparator.GT : Comparator.LT, new BigDecimal(cvalue),
						(aselection == 1) ? IAction.ActionType.BUY : IAction.ActionType.SELL, avalue);
		

	}
	public void saveCurrentStrategy(){
		appEngine.saveStrategy((SimpleStrategy) currentStrategy);
	}


	/**
	 * Display the results of an experiment which ran.
	 * 
	 * @param filename location of results
	 * @throws IOException
	 * @throws ParseException
	 */
	public void displayResults(String filename) throws IOException, ParseException{
		File file = new File(filename);
		Scanner fileReader = new Scanner(file);
		while((fileReader.hasNextLine())){
			String strategyName = fileReader.nextLine();
			String symbol = fileReader.nextLine();
			String dateString = fileReader.nextLine();
			List<String[]> actionList = new ArrayList<String[]>();
			List<BigDecimal> balanceList = new ArrayList<BigDecimal>();
			List<Integer> holdingList = new ArrayList<Integer>();
			//print result header
			DateFormat format = new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH);
			Calendar cal=Calendar.getInstance();
			cal.setTime((Date) format.parse(dateString));
			dateString = format.format(cal.getTime());
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
=======
	public TradingApplication TradingSimApp = TradingApplication.getInstance();
	private Engine(){
		
	}

	
	
	
>>>>>>> ab25f3c9ce52fb19a3d453fe9fbd830c934205e1
	
}
