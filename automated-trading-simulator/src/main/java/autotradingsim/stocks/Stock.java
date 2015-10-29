package autotradingsim.stocks;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by Asher on 2015-10-25.
 * Contributors: Bill
 *
 * Each instance of a Stock is associated with a single stock.
 * An instance of a Stock holds all the data there is for that stock on record.
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
        return this.name;
    }

    public StockDay getDay(Calendar date){
        int i = 0;
        while(data.get(i).getDate().compareTo(date) != 0){
            i++;
        }
        return data.get(i);
    }

}
