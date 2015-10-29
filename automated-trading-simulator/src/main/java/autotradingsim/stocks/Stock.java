package autotradingsim.stocks;

import java.util.ArrayList;

/**
 * Created by Asher on 2015-10-25.
 *
 * Each instance of a Stock is associated with a single stock.
 * Stocks can produce iterators which provide a sequence of day-by-day entries for that stock.
 */
public class Stock {

    private String symbol;
    private String name;
    private ArrayList<StockDay> data;

    public Stock(String symbol, String name, ArrayList<StockDay> data) {
        this.symbol = symbol;
        this.name = name;
        this.data = data;
    }

    public String getSymbol(){
        return this.symbol;
    }

    public String getName(){
        return this.getName();
    }

}
