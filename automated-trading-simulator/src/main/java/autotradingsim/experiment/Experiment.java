package autotradingsim.experiment;

import autotradingsim.stocks.*;
import autotradingsim.strategy.Strategy;

import java.util.ArrayList;

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
    ArrayList<String> stocks;
    ArrayList<Strategy> strategies;
    String name;
    public Experiment(String name){
        this.loader = new StockLoader();
        this.stocks = new ArrayList<>();
        this.strategies = new ArrayList<>();
        this.name = name;
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
        if("Strategy exists"){
            strategies.add(Strategy);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public IStrategy getStrategy(int id){
        return strategy;
    }
}
