package autotradingsim.util;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import org.apache.commons.io.FileUtils;

/**
 * <p>Created by Asher on 2015-11-17.</p>
 *
 * <p>Utility class with a single static method that downloads a stock to the folder specified in the static
 * variable {@link #pathToStocks}</p>
 *
 */
public class StockDownloader {

    static String pathToStocks = "//DATA/DOWNLOAD/STOCKS//";

    public static void downloadStockData(String symbol) {
        URL url = null;
        try {

            // Create the URL by inserting the symbol
            url = new URL(
                    "http://real-chart.finance.yahoo.com/table.csv?s=" + symbol +
                            "&d=10&e=17&f=2015&g=d&a=3&b=12&c=1996&ignore=.csv");
        } catch (MalformedURLException e) {
            System.out.println("Malformed URL Exception thrown.");
            return;
        }

        // Define a new file
        File f = new File(System.getProperty("user.dir") + pathToStocks + symbol + ".csv");
        if (!f.exists()) {
            // Create the file if it doesn't exist -- this will need to be changed/modified to account for updating a
            // file that already exists.
            try {
                // Copy the URL-file to a local file using class FileUtils from apache.commons.io package
                FileUtils.copyURLToFile(url, f);
            } catch (IOException e) {
                System.out.println("IOException when writing to stock file.");
            }
        }
    }

}
