package autotradingsim.stocks;

import autotradingsim.strategy.BufferAdapter;
import autotradingsim.strategy.IBufferAdapter;

import java.time.LocalDate;
import java.util.ArrayList;

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
    public StockDay getDay(LocalDate date){
        for(int i = 0; i < data.size(); i++){
            if(data.get(i).getDate().equals(date)){
                return data.get(i);
            }
        }
        return null;
    }

    @Override
    public LocalDate getStartDate() {
        if (data.isEmpty()) {
            return null;
        }
        return data.get(data.size() - 1).getDate();
    }

    @Override
    public LocalDate getEndDate() {
        if (data.isEmpty()) {
            return null;
        }
        return data.get(0).getDate();
    }

    @Override
    public IBufferAdapter getNewBuffer(LocalDate date, int size) {
        return new BufferAdapter(this, date, size);
    }

}
