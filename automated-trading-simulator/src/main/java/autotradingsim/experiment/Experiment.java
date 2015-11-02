package autotradingsim.experiment;

import autotradingsim.stocks.*;
import autotradingsim.strategy.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Set;

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

    StockLoader loader;
    String name;
    ArrayList<String> stocks;
    ArrayList<Integer> strategies;
    ArrayList<int[]> trials;

    /**
     *
     * @param name name of the experiment
     */
    public Experiment(String name){
        this.loader = new StockLoader();
        this.name = name;
        this.stocks = new ArrayList<>();
        this.strategies = new ArrayList<Integer>();
        this.trials = new ArrayList<>();
    }

    @Override
    public String getName(){
        return this.name;
    }

    /**
     * Use a StockLoader to fetchStockDateRange a stock with the given symbol, if it does not exist in the sample already
     *
     * @param symbol the symbol of a stock
     */
    @Override
    public boolean addStock(String symbol){
        if(loader.exists(symbol)) {
            stocks.add(symbol);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public IStock getStock(String symbol) {
        return loader.fetchStock(symbol);
    }

    @Override
    public boolean addStrategy(int id){
        if(false){ //"if Strategy exists"
            strategies.add(id);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public IStrategy getStrategy(int id){
        return null; // return strategy with the id
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
            BufferedWriter bw = new BufferedWriter(new FileWriter("file/DATA/RESULTS/exp" + name + ".atsr"));

            IStrategy strategy;
            StrategyTester st;
            IStock stock;
            Calendar currentDate;
            Set<IDecision> decisions;
            int duration;
            IDecision decision;

            BigDecimal balance;
            int shares;

            // Go through all the trials, test each one. Output a chunk of results to file for each trial
            for(int i  = 0; i < trials.size(); i++){
                strategy = getStrategy(strategies.get(trials.get(i)[0]));
                stock = getStock(stocks.get(trials.get(i)[1]));
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
        }
        return false;
    }
}
