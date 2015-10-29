package autotradingsim.experiment;

import autotradingsim.stocks.*;
import java.util.ArrayList;

/**
 * Created by Asher on 2015-10-25.
 * Contributors: Bill
 *
 * Experiments apply Strategies to particular stocks over a set of time periods.
 *
 * addStock(String s)
 * Use a StockLoader to load a stock with symbol s, if it does not exist in the sample already.
 */
public class Experiment {

    StockLoader loader;
    ArrayList<Stock> samples;
    public Experiment(){
        this.loader = new StockLoader();
        this.samples = new ArrayList<>();
    }

    // Use the StockLoader to load a stock with symbol s, if it does not exist in the sample already.
    public void addStock(String symbol){
        boolean existing = false;
        for(int i = 0; i < samples.size(); i++){
            if(samples.get(i).getSymbol() == symbol){
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
