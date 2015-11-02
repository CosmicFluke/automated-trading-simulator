package autotradingsim.engine;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
			List<Integer> balancelist = new ArrayList<Integer>();
			List<Integer> holdinglist = new ArrayList<Integer>();
			//print result header
			DateFormat format = new SimpleDateFormat("dd-mm-yyyy", Locale.ENGLISH);
			Date date = format.parse(datestring);
			System.out.println("Strategy: "+stratname+"|Stock: "+symbol+"|date: "+date);
			while(filereader.hasNextLine()){
				String[] dailydata=filereader.nextLine().split(",");
				balancelist.add(Integer.parseInt(dailydata[0]));
				holdinglist.add(Integer.parseInt(dailydata[1]));
				String[] actions = new String[dailydata.length-2];
				System.arraycopy(dailydata,2, actions, 0, dailydata.length-2);
				actionlist.add(actions);
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
