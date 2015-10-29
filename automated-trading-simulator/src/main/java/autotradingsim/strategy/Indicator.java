package autotradingsim.strategy;

import autotradingsim.stocks.StockDay;

/**
 * Created by Asher on 2015-10-25.
 * Contributors: Bill
 */
public class Indicator {

    private String name;
    private String description;
    private double value;
    public Indicator(String name, String description, double init){
        this.name = name;
        this.description = description;
        this.value = init;
    }

    public String getName(){
        return this.name;
    }

    public String getDescription(){
        return this.description;
    }

    public Double getValue(){
        return this.value;
    }

    public void setValue(double value){
        this.value = value;
    }

}
