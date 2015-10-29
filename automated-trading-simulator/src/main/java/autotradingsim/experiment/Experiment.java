package autotradingsim.experiment;

import autotradingsim.stocks.*;
import autotradingsim.strategy.Action;

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
    ArrayList<Stock> samples;
    ArrayList<Action> strategy;
    public Experiment(){
        this.loader = new StockLoader();
        this.samples = new ArrayList<>();
        this.strategy = new ArrayList<>();
    }

    /**
     * Use a StockLoader to load a stock with the given symbol, if it does not exist in the sample already
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
            Stock temp = loader.loadStock(symbol);
            if (temp != null) {
                samples.add(temp);
            }
        }
    }


}
