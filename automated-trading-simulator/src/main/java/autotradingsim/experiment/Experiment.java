package autotradingsim.experiment;

import autotradingsim.stocks.*;
import autotradingsim.strategy.Strategy;

import java.util.ArrayList;

/**
 * Created by Asher on 2015-10-25.
 * Contributors: Bill
 *
 * Experiments apply Strategies to particular stocks over a set of time periods.
 *
 * Public Methods:
 *      addStock(String)
 */
public class Experiment {

    StockLoader loader;
    ArrayList<IStock> samples;
    ArrayList<Strategy> strategies;
    public Experiment(){
        this.loader = new StockLoader();
        this.samples = new ArrayList<>();
        this.strategies = new ArrayList<>();
    }

    /**
     * Use a StockLoader to fetchStockDateRange a stock with the given symbol, if it does not exist in the sample already
     *
     * @param symbol the symbol of a stock
     */
    public void addStock(String symbol){
        boolean existing = false;
        for(int i = 0; i < samples.size(); i++){
            if(samples.get(i).getSymbol().equals(symbol)){
                existing = true;
            }
        }
        if(!existing) {
            IStock temp = loader.fetchStock(symbol);
            if (temp != null) {
                samples.add(temp);
            }
        }
    }

}
