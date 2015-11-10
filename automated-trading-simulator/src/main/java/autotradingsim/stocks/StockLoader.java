package autotradingsim.stocks;

import com.sun.xml.internal.ws.api.ResourceLoader;

import java.io.*;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 * Created by Asher on 2015-10-25.<br>
 * Contributors: Bill<br>
 *
 *
 * <p>Public Methods:<br><ul>
 *      <li>fetchStockDateRange(String, Calendar, Calendar)</li>
 *      <li>fetchStock(String)</li>
 *      <li>exists(String)</li>
 *      </ul>
 *
 * Private Methods:<br><ul>
 *      <li>getName(String)</li>
 *      <li>buildStockList()</li>
 *      </ul></p>
 */
public class StockLoader{


    ArrayList<String[]> stockListing;
    public StockLoader() {
        // StockLoader keeps a list of stock symbols matched with stock names
        this.stockListing = buildStockList();
    }

    /**
     * Load the data for a stock between a period of time
     *
     * @param   symbol  the symbol of a stock
     * @param   start   a starting date
     * @param   end     an ending date
     * @return  array list of StockDay objects for the stock with the given symbol, from start date to end date
     *
     * NOTE:    1. Returns NULL if starting date is later than ending date
     *          2. If start date is earlier than the earliest day on record, the missing days will be omitted
     *          3. If end date is later than the latest day on record, the missing days will be omitted
     */
    public ArrayList<StockDay> fetchStockDateRange(String symbol, Calendar start, Calendar end){

        if(start.compareTo(end) > 0){
            return null;
        }

        // Create array list to hold results
        ArrayList<StockDay> result = new ArrayList<>();

        try{
            // Create buffered reader
            BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + "/automated-trading-simulator/src/main/resources/DATA/STOCKS/" + symbol + ".csv"));
            br.readLine(); // Skip the header line

            // Make variable holders
            Calendar now;
            String line;
            String[] lineSplit, dateSplit;

            // Read in the date of the first entry, which must exist in all the files
            line = br.readLine();
            lineSplit = line.split(",");
            dateSplit = lineSplit[0].split("-");
            now = new GregorianCalendar(Integer.parseInt(dateSplit[0]), Integer.parseInt(dateSplit[1]), Integer.parseInt(dateSplit[2]));

            // Find the starting line by comparing to ending date
            while(now.compareTo(end) > 0){

                // If we hit EOF before finding the ending date, return null
                if ((line = br.readLine()) == null){
                	br.close();
                    return null;
                }

                lineSplit = line.split(",");
                dateSplit = lineSplit[0].split("-");
                now = new GregorianCalendar(Integer.parseInt(dateSplit[0]), Integer.parseInt(dateSplit[1]), Integer.parseInt(dateSplit[2]));
            }

            // Loop through the time period from end to start, and generate the list of StockDays
            BigDecimal open, high, low, close; int volume; StockDay sd;// Make variable holders
            while(now.compareTo(start) >= 0){

                // Create a StockDay object from the current iteration and add it to the result list
                open = new BigDecimal(lineSplit[1]);
                high = new BigDecimal(lineSplit[2]);
                low = new BigDecimal(lineSplit[3]);
                close = new BigDecimal(lineSplit[4]);
                volume = Integer.parseInt(lineSplit[5]);
                sd = new StockDay(symbol, now, open, high, low, close, volume);
                result.add(0, sd);

                // Read the next line. If EOF, return current list of added StockDays
                if((line = br.readLine()) == null){
                	br.close();
                    return result;
                }else{
                    lineSplit = line.split(",");
                    dateSplit = lineSplit[0].split("-");
                    now = new GregorianCalendar(Integer.parseInt(dateSplit[0]), Integer.parseInt(dateSplit[1]), Integer.parseInt(dateSplit[2]));
                }
            }
            br.close();
        }catch(IOException e){
            System.out.println(e);
        }
        return result;
    }

    /**
     * Load the data for an entire stock
     *
     * @param   symbol  symbol of a stock
     * @return  Stock object for the stock with given symbol
     *
     * NOTE:    Returns null if the symbol does not exist
     */
    public IStock fetchStock(String symbol){

        if(!exists(symbol)){
            return null;
        }

        ArrayList<StockDay> result = new ArrayList<>();

        try{
            BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + "/automated-trading-simulator/src/main/resources/DATA/STOCKS/" + symbol + ".csv"));
            br.readLine(); // Skip the header line

            // Make variable holders
            Calendar now;
            String line;
            String[] lineSplit, dateSplit;
            BigDecimal open, high, low, close; int volume; StockDay sd;// Make variable holders

            while((line = br.readLine()) != null){
                lineSplit = line.split(",");
                dateSplit = lineSplit[0].split("-");
                now = new GregorianCalendar(Integer.parseInt(dateSplit[0]), Integer.parseInt(dateSplit[1]), Integer.parseInt(dateSplit[2]));
                open = new BigDecimal(lineSplit[1]);
                high = new BigDecimal(lineSplit[2]);
                low = new BigDecimal(lineSplit[3]);
                close = new BigDecimal(lineSplit[4]);
                volume = Integer.parseInt(lineSplit[5]);
                sd = new StockDay(symbol, now, open, high, low, close, volume);
                result.add(0, sd);
            }
            br.close();
        }catch(IOException e){
            System.out.println(e);
        }
        return new Stock(symbol, getName(symbol), result);
    }

    /**
     * Check if a stock exists
     *
     * @param   symbol symbol of a stock
     * @return  if a stock with the given symbol exists in stockListing
     */
    public boolean exists(String symbol){
        for(int i = 0; i < stockListing.size(); i++){
            if(stockListing.get(i)[0].equalsIgnoreCase(symbol)){
                return true;
            }
        }
        return false;
    }

    /**
     * Get the name of a stock for a given symbol
     *
     * @param   symbol symbol of a stock
     * @return  the name of the stock with the given symbol
     */
    private String getName(String symbol){
        for(int i = 0; i < stockListing.size(); i++){
            if(stockListing.get(i)[0].equalsIgnoreCase(symbol)){
                return stockListing.get(i)[1];
            }
        }
        return null;
    }

    /**
     * Load the list of stock symbols with their corresponding names
     *
     * @return  array list of string arrays
     */
    private ArrayList<String[]> buildStockList(){
        ArrayList<String[]> result = new ArrayList<>();
        try{
            BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + "/automated-trading-simulator/src/main/resources/DATA/S&P-500-symbol-name-list.csv"));
            br.readLine();
            String line, holder[];
            while((line = br.readLine()) != null){
                holder = line.split(",");
                result.add(holder);
            }
            br.close();
        }catch(IOException e){
            System.out.println(e);
        }
        return result;
    }
}