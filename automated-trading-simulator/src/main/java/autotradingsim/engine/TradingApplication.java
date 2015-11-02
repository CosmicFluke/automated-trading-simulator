package autotradingsim.engine;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
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

import autotradingsim.experiment.*;
import autotradingsim.strategy.*;

public class TradingApplication {
	public static ArrayList<IStrategy> strategies;
	public static ArrayList<IExperiment> experiments;
	
	private static TradingApplication instance=null;
	
	protected TradingApplication() {
		// TODO Auto-generated constructor stub
	}
	
	public static TradingApplication getInstance(){
		if (instance==null){
			instance=new TradingApplication();
		}
		return instance;
	}
	public void displayResults(String filename) throws IOException, ParseException{
		InputStream reader = getClass().getResourceAsStream(filename);
		Scanner filereader = new Scanner(reader);
		while((filereader.hasNextLine())){
			String stratname=filereader.nextLine();
			String symbol=filereader.nextLine();
			String datestring=filereader.nextLine();
			List<String[]> actionlist = new ArrayList<String[]>();
			List<BigDecimal> balancelist = new ArrayList<BigDecimal>();
			List<Integer> holdinglist = new ArrayList<Integer>();
			//print result header
			DateFormat format = new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH);
			Calendar cal=Calendar.getInstance();
			cal.setTime((Date) format.parse(datestring));
			datestring=format.format(cal.getTime());
			System.out.println("Strategy: "+stratname+" | Stock: "+symbol+" | Starting date: "+datestring);
			String line = null;
			while(filereader.hasNextLine()){
				line = filereader.nextLine();
				if(line.equals("") || line == null){
					break;
				}
					String[] dailydata=line.split(",");
					balancelist.add(new BigDecimal(dailydata[0]));
					holdinglist.add(Integer.parseInt(dailydata[1]));
					String[] actions = new String[dailydata.length-2];
					System.arraycopy(dailydata,2, actions, 0, dailydata.length-2);
					actionlist.add(actions);
					
					if(actions.length!=0){
						System.out.print(datestring);
						System.out.print(" action: ");
						System.out.print(actions[0]);
						for(int i = 1; i < actions.length; i++){
							System.out.print(", " + actions[i]);
						}
						System.out.println("");
					}else{
						System.out.println(datestring);
					}
					//increment date by 1
					cal.setTime((Date) format.parse(datestring));
					cal.add(Calendar.DATE, 1);
					datestring=format.format(cal.getTime());
			}
			BigDecimal startingcapital = balancelist.get(0).add(new BigDecimal(holdinglist.get(0)));
			BigDecimal closingbalance = balancelist.get(balancelist.size()-1).add(new BigDecimal(holdinglist.get(balancelist.size()-1)));
			BigDecimal earnings = closingbalance.subtract((startingcapital));
			BigDecimal percentEarning = earnings.multiply(new BigDecimal(100)).divide(startingcapital, 2, RoundingMode.HALF_UP);
			System.out.println("Starting Capital: "+startingcapital);
			System.out.println("Closing Balance: "+closingbalance);
			System.out.println("Earnings: "+earnings);
			System.out.println("Percent Earning: " + percentEarning + "%");
			System.out.println("------------------------------------------------------------");
			if(line==null){
				break;
			}
		}
	}
	public static Strategy getStrategy(String stratname){
	
		for (IStrategy strat: strategies){
		
		}
		return null;	
	}
	
	public static void saveStrategy (IStrategy strategy){
		if(!strategies.contains(strategy)){
			strategies.add(strategy);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
	}

}
