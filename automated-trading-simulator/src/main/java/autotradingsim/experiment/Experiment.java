package autotradingsim.experiment;

import autotradingsim.application.TradingApplication;
import autotradingsim.stocks.*;
import autotradingsim.strategy.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
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
public class Experiment implements IExperiment, Serializable {

    private static final long serialVersionUID = -7533956851982543038L;
    private String name;
    private Map<String, Integer> stocks;
    private ArrayList<String> strategies;
    private HashMap<String, ArrayList<String>> strategyToStocks;

    /**
     * Initialize the experiment constructor.
     * @param name name of the experiment
     */
    public Experiment(String name){
        this.name = name;
        this.stocks = new HashMap<String, Integer>();
        this.strategies = new ArrayList<String>();
        this.strategyToStocks = new HashMap<String, ArrayList<String>>();
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
    public void addStock(String symbol){
        if (TradingApplication.getInstance().stockExists(symbol)) {
            this.stocks.put(symbol, 0);
        } else {
            throw new IllegalArgumentException("Stock symbol does not exist in the database!");
        }

    }

    @Override
    public void addStrategy(String name){
        if(TradingApplication.getInstance().getStrategy(name) != null){  //check existing might not be needed if trading application can check first
            strategies.add(name);
        }else{
            throw new IllegalArgumentException("Strategy name has not been defined!");
        }
    }

    @Override
    public IStrategy getStrategy(String name){
        return TradingApplication.getInstance().getStrategy(name); // return strategy with the id
    }

    public void addTrial(String id, String symbol){
        int strategySize = strategies.size();
        int stockSize = stocks.size();
        for(int i = 0; i < strategySize; i++){
            if(strategies.get(i).equals(id)){
                strategySize = i;
                break;
            }
        }
        if(strategySize == strategies.size()){
            // strategy id does not exist
            this.addStrategy(id);
            this.addStock(symbol);
            this.strategyToStocks.put(id, new ArrayList<String>());
        }
        for(int i = 0; i < stockSize; i++){
            if(stocks.containsValue(symbol)){
                stockSize = i;
                break;
            }
        }
        if(stockSize == stocks.size()){
            this.addStock(symbol);
            this.strategyToStocks.get(id).add(symbol);
        }
    }


    /**
     *
     * @param ts a time set
     * @return whether the experiment was ran successfully
     */
    @Override
    public List<Result> runExperiment(TimeSet ts) {
        List<Result> resultList = new ArrayList<Result>();
        IStrategy strategy;
        StrategyTester st;
        IStock stock;
        LocalDate currentDate;
        LocalDate experimentStartDate;
        List<IDecision> decisions;
        int duration;
        IDecision decision;

        BigDecimal balance;
        int shares;

        while (ts.hasNext()) {
            experimentStartDate = ts.next();
            currentDate = experimentStartDate;
            duration = ts.getDuration();
            balance = BigDecimal.valueOf(100);
            Result result = new Result(experimentStartDate, duration, strategyToStocks, balance);
            while (currentDate.isBefore(experimentStartDate.plusDays(duration))) {
                ResultDay resultDay = new ResultDay(currentDate, balance, balance);
                for (Map.Entry<String, ArrayList<String>> entry : strategyToStocks.entrySet()) {
                    strategy = TradingApplication.getInstance().getStrategy(entry.getKey());
                    for (int i = 0; i < entry.getValue().size(); i++) {
                        shares = 0;
                        stock = TradingApplication.getInstance().getStock(entry.getValue().get(i));
                        st = strategy.getNewTester();
                        st.setAll(stock);

                        decisions = st.testDate(currentDate);
                        Iterator<IDecision> decisionIter = decisions.iterator();
                        while (decisionIter.hasNext()) {
                            decision = decisionIter.next();
                            resultDay.addDecision(decision);
                            if (decision.getActionType() == IAction.ActionType.BUY) {
                                shares += decision.getQuantity(balance);
                                balance.subtract(stock.getDay(currentDate).getValue().multiply(new BigDecimal(shares)));
                            } else if (decision.getActionType() == IAction.ActionType.SELL) {
                                shares -= decision.getQuantity(balance);
                                balance.add(stock.getDay(currentDate).getValue().multiply(new BigDecimal(shares)));
                            }
                            this.stocks.put(stock.getSymbol(), this.stocks.get(stock.getSymbol()) + shares);
                        }
                        resultDay.setClosingDate(balance);
                        result.addResultDay(resultDay);
                    }

                }
                resultList.add(result);
                currentDate.plusDays(1);
            }

        }
        return resultList;
    }

//
//            // Go through all the trials, test each one. Output a chunk of results to file for each trial
//            for(int i  = 0; i < trials.size(); i++){
//                strategy = TradingApplication.getInstance().getStrategy(strategies.get(trials.get(i)[0]));
//                stock = TradingApplication.getInstance().getStock(stocks.get(trials.get(i)[1]));
//                st = strategy.getNewTester();
//                st.setAll(stock);
//                duration = ts.getDuration();

                // Run once for every time snippet in the time set
//                while(ts.hasNext()){
//                    currentDate = ts.next();
//
//                    bw.write(name);
//                    bw.newLine();
//                    bw.write(stock.getSymbol());
//                    bw.newLine();
//                    bw.write(currentDate.toString());
//                    bw.newLine();
//
//                    balance = new BigDecimal(0);
//                    shares = 0;
//
//                    // Iterate through all the days in the time snippet
//                    for(int j = 0; j < duration; j++) {
//                        decisions = st.testDate(currentDate);
//                        Iterator<IDecision> itr = decisions.iterator();
//
//                        bw.write(balance.toString());
//                        bw.write("," + shares);
//
//                        while(itr.hasNext()){
//                            decision = (IDecision)itr.next();
//                            if(decision.getActionType() == IAction.ActionType.BUY){
//                                shares += decision.getQuantity();
//                                balance.subtract(stock.getDay(currentDate).getValue().multiply(new BigDecimal(shares)));
//                            }else if(decision.getActionType() == IAction.ActionType.SELL){
//                                shares -= decision.getQuantity();
//                                balance.add(stock.getDay(currentDate).getValue().multiply(new BigDecimal(shares)));
//                            }
//
//                            bw.write("," + decision.getActionType().toString() + "-" + decision.getQuantity());
//                        }
//                        bw.newLine();
//                        currentDate = currentDate.plusDays(1);
//                    }
//                    bw.newLine();
//                }
//            }
//
//        }catch(IOException e){
//            System.out.println(e);
//        }
//    }

//    public boolean runExperiment(){
//        try{
//            // Create the file writer with the given file ID as the name
//            BufferedWriter bw = new BufferedWriter(new FileWriter(System.getProperty("user.dir") + "/automated-trading-simulator/src/main/resources/DATA/RESULTS/" + name + ".txt"));
//
//            IStrategy strategy;
//            StrategyTester st;
//            IStock stock;
//            LocalDate currentDate;
//            List<IDecision> decisions;
//            int duration;
//            IDecision decision;
//
//            BigDecimal balance;
//            int shares;
//
//            // Go through all the trials, test each one. Output a chunk of results to file for each trial
//            for(int[] trial: trials){
//                strategy = TradingApplication.getInstance().getStrategy(strategies.get(trial[0]));
//                stock = TradingApplication.getInstance().getStock(stocks.get(trial[1]));
//                st = strategy.getNewTester();
//                st.setAll(stock);
//
//                currentDate = stock.getStartDate();
//                bw.write(strategy.getName()); bw.newLine();
//                bw.write(stock.getSymbol()); bw.newLine();
//                bw.write(currentDate.toString());
//                bw.newLine();
//
//                balance = new BigDecimal(100000);
//                shares = 0;
//
//                while(currentDate.isBefore(stock.getEndDate())){
//                    decisions = st.testDate(currentDate);
//                    Iterator itr = decisions.iterator();
//
//                    bw.write(currentDate.toString());
//                    bw.write("," + balance.toString());
//                    bw.write("," + shares);
//
//                    while(itr.hasNext()){
//                        decision = (IDecision)itr.next();
//                        if(decision.getActionType() == IAction.ActionType.BUY){
//                            shares += decision.getQuantity();
//                            balance = balance.subtract(stock.getDay(currentDate).getValue().multiply(new BigDecimal(shares)));
//                        }else if(decision.getActionType() == IAction.ActionType.SELL){
//                            shares -= decision.getQuantity();
//                            balance = balance.add(stock.getDay(currentDate).getValue().multiply(new BigDecimal(shares)));
//                        }
//
//                        bw.write("," + decision.getActionType().toString() + "-" + decision.getQuantity());
//                    }
//                    bw.newLine();
//                    currentDate = currentDate.plusDays(1);
//                }
//                bw.newLine();
//            }
//
//        }catch(IOException e){
//            System.out.println(e);
//            return false;
//        }
//        return true;
//    }
}