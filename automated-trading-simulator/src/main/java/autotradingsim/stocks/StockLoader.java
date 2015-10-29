package autotradingsim.stocks;

import java.io.*;
import java.util.Calendar;
import java.util.ArrayList;

/**
 * Created by Asher on 2015-10-25.
 */
public class StockLoader{


    ArrayList<String[]> stockListing;
    public StockLoader() {
        this.stockListing = getStockList();
    }

    public ArrayList<StockDay> load(String symbol, Calendar start, Calendar end){

        // Starting date cannot be later than ending date
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