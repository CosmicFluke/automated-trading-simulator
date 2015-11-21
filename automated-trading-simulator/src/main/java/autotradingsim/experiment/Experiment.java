package autotradingsim.experiment;

import autotradingsim.application.TradingApplication;
import autotradingsim.stocks.*;
import autotradingsim.strategy.*;
import autotradingsim.util.Pair;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

/**
 * Created by Asher on 2015-10-25.
 * Contributors: Bill, Shirley, Myung In (Justin)
 *
 * Experiments apply Strategies to particular stocksToShares over a set of time periods.
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
    private HashMap<String, Integer> stocksToShares;                // Pair of Stock symbol & its shares for user

    /**
     * Map<Stock symbol, Pair<startDate, endDate>>
     * Pair:
     * startDate is the IPO date. The first date(ie. IPO) for each Stock in the database.
     * endDate is the last date for each Stock in the database.
     */
    private Map<String, Pair<LocalDate, LocalDate>> stocksToFirstAndLastDate;

    private Set<String> strategies;
    private HashMap<String, ArrayList<String>> strategyToStocks;    // Map<Strategy, List<Stocks>>. One to many

    /**
     * Initialize the experiment constructor.
     * @param name name of the experiment
     */
    public Experiment(String name){
        this.name = name;
        this.stocksToShares = new HashMap<String, Integer>();
        this.strategies = new HashSet<String>();
        this.strategyToStocks = new HashMap<String, ArrayList<String>>();
        this.stocksToFirstAndLastDate = new HashMap<String, Pair<LocalDate, LocalDate>>();
    }

    @Override
    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    /**
     * Add Stock symbol to the stocksToShares ArrayList, otherwise throw exception.
     *
     * @param symbol the symbol of a stock
     */
    @Override
    public void addStock(String symbol){
        if (TradingApplication.getInstance().stockExists(symbol)) {
            this.stocksToShares.put(symbol, 0);
            LocalDate startDate = TradingApplication.getInstance().getStock(symbol).getStartDate();
            LocalDate endDate = TradingApplication.getInstance().getStock(symbol).getEndDate();
            this.stocksToFirstAndLastDate.put(symbol, new Pair<LocalDate, LocalDate>(startDate, endDate));
        } else {
            throw new IllegalArgumentException("Stock symbol does not exist in the database!");
        }

    }
    @Override
    public Map getStockStartAndEndDates() {
        return this.stocksToFirstAndLastDate;
    }

    /**
     * Add Strategy id to the strategies List, otherwise throw exception
     * @param name the identifier id of the strategy
     */

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

    @Override
    public IStock getStock(String symbol){
        return TradingApplication.getInstance().getStock(symbol);
    }

    public void addTrial(String id, String symbol){

        if(!strategyToStocks.containsKey(id)){
            // strategy id does not exist
            this.addStrategy(id);
            this.addStock(symbol);
            this.strategyToStocks.put(id, new ArrayList<String>(Arrays.<String>asList(symbol)));
        } else {
            this.addStock(symbol);
            this.strategyToStocks.get(id).add(symbol);
        }
    }

    /**
     * Run the Experiment for the TradingApplication.
     * @param ts a time set
     * @return ArrayList<Result> for each TimeSet ts. Result is obtained for each TimeSet ts.
     */
    @Override
    public List<Result> runExperiment(TimeSet ts) {
        List<Result> resultList = new ArrayList<Result>();
        IStrategy strategy;
        StrategyTester st;
        IStock stock;

        // currentDate is set for each day from startDate in TimeSet for the length of duration
        LocalDate currentDate;
        LocalDate experimentStartDate;
        int duration;

        List<IDecision> decisions;
        IDecision decision;

        BigDecimal balance;
        int shares;

        while (ts.hasNext()) { // For each TimeSet
            experimentStartDate = ts.next();
            currentDate = experimentStartDate;
            duration = ts.getDuration();
            balance = BigDecimal.valueOf(100);
            Result result = new Result(experimentStartDate, duration, strategyToStocks, balance);

            while (currentDate.isBefore(experimentStartDate.plusDays(duration))) {  // For each Day
                ResultDay resultDay = new ResultDay(currentDate, balance, balance);

                for (Map.Entry<String, ArrayList<String>> entry : strategyToStocks.entrySet()) {    // For each strategy
                    strategy = TradingApplication.getInstance().getStrategy(entry.getKey());

                    for (int i = 0; i < entry.getValue().size(); i++) {     // For each Stock
                        shares = 0;
                        stock = TradingApplication.getInstance().getStock(entry.getValue().get(i));
                        st = strategy.getNewTester();
                        st.setAll(stock);

                        decisions = st.testDate(currentDate);
                        Iterator<IDecision> decisionIter = decisions.iterator();

                        while (decisionIter.hasNext()) {        // For Each decision
                            decision = decisionIter.next();
                            resultDay.addDecision(decision);

                            if (decision.getActionType() == IAction.ActionType.BUY) {
                                // Buy Stocks for
                                shares += decision.getQuantity(balance);
                                balance.subtract(stock.getDay(currentDate).getValue().multiply(new BigDecimal(shares)));

                            } else if (decision.getActionType() == IAction.ActionType.SELL) {
                                shares -= decision.getQuantity(balance);
                                balance.add(stock.getDay(currentDate).getValue().multiply(new BigDecimal(shares)));
                            }
                            this.stocksToShares.put(stock.getSymbol(), this.stocksToShares.get(stock.getSymbol()) + shares);
                        }
                        resultDay.setClosingBalance(balance);
                        result.addResultDay(resultDay);
                    }

                }
                result.setClosingBalance(balance);
                resultList.add(result);
                currentDate = currentDate.plusDays(1);
            }

        }
        return resultList;
    }

//
//            // Go through all the trials, test each one. Output a chunk of results to file for each trial
//            for(int i  = 0; i < trials.size(); i++){
//                strategy = TradingApplication.getInstance().getStrategy(strategies.get(trials.get(i)[0]));
//                stock = TradingApplication.getInstance().getStock(stocksToShares.get(trials.get(i)[1]));
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
//                stock = TradingApplication.getInstance().getStock(stocksToShares.get(trial[1]));
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