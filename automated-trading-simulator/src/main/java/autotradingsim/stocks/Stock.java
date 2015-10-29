package autotradingsim.stocks;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by Asher on 2015-10-25.
 * Contributors: Bill
 *
 * Each instance of a Stock is associated with a single stock.
 * An instance of a Stock holds all the data there is for that stock on record.
 *
 * Public Methods:
 *      getDay(Calendar)
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

    /**
     * Get the data for a given day in the data list of this stock
     *
     * @param   date a initialized date variable
     * @return  a StockDay object for this stock on the given date
     *
     * NOTE:    Returns NULL if this stock does not have an entry for the given date
     */
    public StockDay getDay(Calendar date){
        for(int i = 0; i < data.size(); i++){
            if(data.get(i).getDate().compareTo(date) == 0){
                return data.get(i);
            }
        }
        return null;
    }

}
