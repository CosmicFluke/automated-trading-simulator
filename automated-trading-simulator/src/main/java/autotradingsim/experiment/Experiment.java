package autotradingsim.experiment;

import autotradingsim.application.TradingApplication;
import autotradingsim.stocks.*;
import autotradingsim.strategy.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;

/**
 * Created by Asher on 2015-10-25.
 * Contributors: Bill, Shirley
 * 
 * Experiments apply Strategies to particular stocks over a set of time periods.
 *
 * Public Methods:
 *      addStock(String)
 * 
 * Modifications on 2015-10-30
 * -changes to experiment constructor to include name
 */
public class Experiment implements IExperiment {

    private String name;
    private ArrayList<String> stocks;
    private ArrayList<String> strategies;
    private ArrayList<int[]> trials;

    /**
     *
     * @param name name of the experiment
     */
    public Experiment(String name){
        this.name = name;
        this.stocks = new ArrayList<>();
        this.strategies = new ArrayList<String>();
        this.trials = new ArrayList<>();
    }

    @Override
    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    /**
     * Use a StockLoader to fetchStockDateRange a stock with the given symbol, if it does not exist in the sample already
     *
     * @param symbol the symbol of a stock
     */
    @Override
    public boolean addStock(String symbol){
        if(TradingApplication.getInstance().stockExists(symbol)) { //check existing might not be needed if trading application can check first
            stocks.add(symbol);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean addStrategy(String name){
        if(TradingApplication.getInstance().getStrategy(name) != null){  //check existing might not be needed if trading application can check first
            strategies.add(name);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public IStrategy getStrategy(String name){
        return TradingApplication.getInstance().getStrategy(name); // return strategy with the id
    }

    public void addTrial(String id, String symbol){
        int i = strategies.size();
        int j = stocks.size();
        for(int k = 0; k < i; k++){
            if(strategies.get(k).equals(id)){
                i = k;
                break;
            }
        }
        if(i == strategies.size()){
            strategies.add(id);
        }
        for(int k = 0; k < j; k++){
            if(stocks.get(k).equalsIgnoreCase(symbol)){
                j = k;
                break;
            }
        }
        if(j == stocks.size()){
            stocks.add(symbol);
        }
        int[] hi = {i, j};
        trials.add(hi);
    }

    /**
     *
     * @param ts a time set
     * @return whether the experiment was ran successfully
     */
    @Override
    public boolean runExperiment(TimeSet ts){
        try{
            // Create the file writer with the given file ID as the name
            BufferedWriter bw = new BufferedWriter(new FileWriter(System.getProperty("user.dir") + "/automated-trading-simulator/src/main/resources/DATA/RESULTS/" + name + ".txt"));

            IStrategy strategy;
            StrategyTester st;
            IStock stock;
            Calendar currentDate;
            List<IDecision> decisions;
            int duration;
            IDecision decision;

            BigDecimal balance;
            int shares;

            // Go through all the trials, test each one. Output a chunk of results to file for each trial
            for(int i  = 0; i < trials.size(); i++){
                strategy = TradingApplication.getInstance().getStrategy(strategies.get(trials.get(i)[0]));
                stock = TradingApplication.getInstance().getStock(stocks.get(trials.get(i)[1]));
                st = strategy.getNewTester();
                st.setAll(stock);
                duration = ts.getDuration();

                // Run once for every time snippet in the time set
                while(ts.hasNext()){
                    currentDate = ts.next();
                    bw.write(name);
                    bw.newLine();
                    bw.write(stock.getSymbol());
                    bw.newLine();
                    bw.write(currentDate.YEAR+"-"+currentDate.MONTH+"-"+currentDate.DATE);
                    bw.newLine();

                    balance = new BigDecimal(0);
                    shares = 0;

                    // Iterate through all the days in the time snippet
                    for(int j = 0; j < duration; j++) {
                        decisions = st.testDate(currentDate);
                        Iterator itr = decisions.iterator();

                        bw.write(balance.toString());
                        bw.write("," + shares);

                        while(itr.hasNext()){
                            decision = (IDecision)itr.next();
                            if(decision.getActionType() == IAction.ActionType.BUY){
                                shares += decision.getQuantity();
                                balance.subtract(stock.getDay(currentDate).getValue().multiply(new BigDecimal(shares)));
                            }else if(decision.getActionType() == IAction.ActionType.SELL){
                                shares -= decision.getQuantity();
                                balance.add(stock.getDay(currentDate).getValue().multiply(new BigDecimal(shares)));
                            }

                            bw.write("," + decision.getActionType().toString() + "-" + decision.getQuantity());
                        }
                        bw.newLine();
                        currentDate.add(currentDate.DATE, 1);
                    }
                    bw.newLine();
                }
            }

        }catch(IOException e){
            System.out.println(e);
            return false;
        }
        return true;
    }

    public boolean runExperiment(){
        try{
            // Create the file writer with the given file ID as the name
            BufferedWriter bw = new BufferedWriter(new FileWriter(System.getProperty("user.dir") + "/automated-trading-simulator/src/main/resources/DATA/RESULTS/" + name + ".txt"));

            IStrategy strategy;
            StrategyTester st;
            IStock stock;
            Calendar currentDate;
            List<IDecision> decisions;
            int duration;
            IDecision decision;

            BigDecimal balance;
            int shares;

            // Go through all the trials, test each one. Output a chunk of results to file for each trial
            for(int[] trial: trials){
                strategy = TradingApplication.getInstance().getStrategy(strategies.get(trial[0]));
                stock = TradingApplication.getInstance().getStock(stocks.get(trial[1]));
                st = strategy.getNewTester();
                st.setAll(stock);

                currentDate = stock.getStartDate();
                bw.write(strategy.getName()); bw.newLine();
                bw.write(stock.getSymbol()); bw.newLine();
                bw.write(currentDate.get(Calendar.YEAR)+"-"+currentDate.get(Calendar.MONTH)+"-"+currentDate.get(Calendar.DATE)); bw.newLine();

                balance = new BigDecimal(100000);
                shares = 0;

                while(currentDate.before(stock.getEndDate())){
                    decisions = st.testDate(currentDate);
                    Iterator itr = decisions.iterator();

                    bw.write(currentDate.get(Calendar.YEAR)+"-"+currentDate.get(Calendar.MONTH)+"-"+currentDate.get(Calendar.DATE));
                    bw.write("," + balance.toString());
                    bw.write("," + shares);

                    while(itr.hasNext()){
                        decision = (IDecision)itr.next();
                        if(decision.getActionType() == IAction.ActionType.BUY){
                            shares += decision.getQuantity();
                            balance = balance.subtract(stock.getDay(currentDate).getValue().multiply(new BigDecimal(shares)));
                        }else if(decision.getActionType() == IAction.ActionType.SELL){
                            shares -= decision.getQuantity();
                            balance = balance.add(stock.getDay(currentDate).getValue().multiply(new BigDecimal(shares)));
                        }

                        bw.write("," + decision.getActionType().toString() + "-" + decision.getQuantity());
                    }
                    bw.newLine();
                    currentDate.add(Calendar.DATE, 1);
                }
                bw.newLine();
            }

        }catch(IOException e){
            System.out.println(e);
            return false;
        }
        return true;
    }
}
