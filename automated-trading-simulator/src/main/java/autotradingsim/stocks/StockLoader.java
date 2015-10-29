package autotradingsim.stocks;

import java.io.*;
import java.util.Calendar;
import java.util.ArrayList;

/**
 * Created by Asher on 2015-10-25.
 * Contributors: Bill
 *
 * public methods:
 *      load(String, Calendar, Calendar)
 *      loadStock(String)
 *
 * private methods:
 *      exists(String)
 *      getName(String)
 */
public class StockLoader{


    ArrayList<String[]> stockListing;
    public StockLoader() {
        // StockLoader keeps a list of stock symbols matched with stock names
        this.stockListing = getStockList();
    }

    /**
     * @param   symbol  the symbol of a stock
     * @param   start   a starting date
     * @param   end     an ending date
     *
     * @return  array list of StockDay objects for the stock with the given symbol, from start date to end date
     *
     * NOTE:    1. Returns NULL if starting date is later than ending date
     *          2. If start date is earlier than the earliest day on record, the missing days will be omitted
     *          3. If end date is later than the latest day on record, the missing days will be omitted
     */
    public ArrayList<StockDay> load(String symbol, Calendar start, Calendar end){

        if(start.compareTo(end) > 0){
            return null;
        }

        // Create array list to hold results
        ArrayList<StockDay> result = new ArrayList<>();

        try{
            // Create buffered reader
            BufferedReader br = new BufferedReader(new FileReader("file/DATA/STOCKS/" + symbol + ".csv"));
            br.readLine(); // Skip the header line

            // Make variable holders
            Calendar now = Calendar.getInstance();
            String line;
            String[] lineSplit, dateSplit;

            // Read in the date of the first entry, which must exist in all the files
            line = br.readLine();
            lineSplit = line.split(",");
            dateSplit = lineSplit[0].split("-");
            now.set(Integer.parseInt(dateSplit[0]), Integer.parseInt(dateSplit[1]), Integer.parseInt(dateSplit[2]));

            // Find the starting line by comparing to ending date
            while(now.compareTo(end) > 0){

                // If we hit EOF before finding the ending date, return null
                if ((line = br.readLine()) == null){
                    return null;
                }

                lineSplit = line.split(",");
                dateSplit = lineSplit[0].split("-");
                now.set(Integer.parseInt(dateSplit[0]), Integer.parseInt(dateSplit[1]), Integer.parseInt(dateSplit[2]));
            }

            // Loop through the time period from end to start, and generate the list of StockDays
            Double open, high, low, close, volume; StockDay sd;// Make variable holders
            while(now.compareTo(start) >= 0){

                // Create a StockDay object from the current iteration and add it to the result list
                open = Double.parseDouble(lineSplit[1]);
                high = Double.parseDouble(lineSplit[2]);
                low = Double.parseDouble(lineSplit[3]);
                close = Double.parseDouble(lineSplit[4]);
                volume = Double.parseDouble(lineSplit[5]);
                sd = new StockDay(symbol, now, open, high, low, close, volume);
                result.add(0, sd);

                // Read the next line. If EOF, return current list of added StockDays
                if((line = br.readLine()) == null){
                    return result;
                }else{
                    lineSplit = line.split(",");
                    dateSplit = lineSplit[0].split("-");
                    now.set(Integer.parseInt(dateSplit[0]), Integer.parseInt(dateSplit[1]), Integer.parseInt(dateSplit[2]));
                }
            }

        }catch(IOException e){
            System.out.println(e);
        }
        return result;
    }

    /**
     * @param   symbol  symbol of a stock
     *
     * @return  Stock object for the stock with given symbol
     *
     * NOTE:    Returns null if the symbol does not exist
     */
    public Stock loadStock(String symbol){

        if(exists(symbol) == false){
            return null;
        }

        ArrayList<StockDay> result = new ArrayList<>();

        try{
            BufferedReader br = new BufferedReader(new FileReader("file/DATA/STOCKS/" + symbol + ".csv"));
            br.readLine(); // Skip the header line

            // Make variable holders
            Calendar now = Calendar.getInstance();
            String line;
            String[] lineSplit, dateSplit;
            Double open, high, low, close, volume; StockDay sd;// Make variable holders

            while((line = br.readLine()) != null){
                lineSplit = line.split(",");
                dateSplit = lineSplit[0].split("-");
                now.set(Integer.parseInt(dateSplit[0]), Integer.parseInt(dateSplit[1]), Integer.parseInt(dateSplit[2]));
                open = Double.parseDouble(lineSplit[1]);
                high = Double.parseDouble(lineSplit[2]);
                low = Double.parseDouble(lineSplit[3]);
                close = Double.parseDouble(lineSplit[4]);
                volume = Double.parseDouble(lineSplit[5]);
                sd = new StockDay(symbol, now, open, high, low, close, volume);
                result.add(0, sd);
            }

        }catch(IOException e){
            System.out.println(e);
        }
        return new Stock(symbol, getName(symbol), result);
    }

    /**
     * @param   symbol symbol of a stock
     *
     * @return  if a stock with the given symbol exists in stockListing
     */
    private boolean exists(String symbol){
        for(int i = 0; i < stockListing.size(); i++){
            if(stockListing.get(i)[0] == symbol){
                return true;
            }
        }
        return false;
    }

    /**
     * @param   symbol symbol of a stock
     *
     * @return  the name of the stock with the given symbol
     */
    private String getName(String symbol){
        int i = 0;
        while(stockListing.get(i)[0] != symbol){
            i++;
        }
        return stockListing.get(i)[1];
    }

    /**
     * @return  array list of stock symbols with their corresponding stock names
     */
    private ArrayList<String[]> getStockList(){
        ArrayList<String[]> result = new ArrayList<>();
        try{
            BufferedReader br = new BufferedReader(new FileReader("file/DATA/S&P-500-symbol-name-list.csv"));
            br.readLine();
            String line, holder[];
            while((line = br.readLine()) != null){
                holder = line.split(",");
                result.add(holder);
            }
        }catch(IOException e){
            System.out.println(e);
        }
        return result;
    }
}