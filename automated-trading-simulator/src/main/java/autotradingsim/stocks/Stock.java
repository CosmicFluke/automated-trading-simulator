package autotradingsim.stocks;

import autotradingsim.strategy.IBufferAdapter;
import autotradingsim.strategy.StockDayBufferAdapter;

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
public class Stock implements IStock {

    private String symbol;
    private String name;
    private ArrayList<StockDay> data;

    public Stock(String symbol, String name, ArrayList<StockDay> data) {
        this.symbol = symbol;
        this.name = name;
        this.data = data;
    }

    @Override
    public String getSymbol(){
        return this.symbol;
    }

    @Override
    public String getName(){
        return this.name;
    }

    @Override
    public StockDay getDay(Calendar date){
        for(int i = 0; i < data.size(); i++){
            if(data.get(i).getDate().compareTo(date) == 0){
                return data.get(i);
            }
        }
        return null;
    }

    @Override
    public Calendar getStartDate() {
        // TODO: implement
        return null;
    }

    @Override
    public Calendar getEndDate() {
        // TODO: implement
        return null;
    }

    @Override
    public IBufferAdapter getNewBuffer(Calendar date, int size) {
        return getNewDayBuffer(date, size);
    }

    public StockDayBufferAdapter getNewDayBuffer(Calendar date, int size) {
        return new StockDayBufferAdapter(this, date, size);
    }
}
