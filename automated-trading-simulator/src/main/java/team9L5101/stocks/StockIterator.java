package team9L5101.stocks;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Iterator;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by Asher on 2015-10-25.
 */
public class StockIterator implements Iterator {

    BufferedReader br;
    Date start;
    Date end;
    StockDay next;
    public StockIterator (InputStream file, Date start, Date end) {
        // TODO: implement!
        this.br = new BufferedReader(new InputStreamReader(file));
        this.start = start;
        this.end = end;
        this.next = null;
        loadNext();
    }

    // TODO: docs
    @Override
    public StockDay next() {
        // load the next StockDay and return the current one
        StockDay temp = next;
        loadNext();
        return temp;
    }

    // TODO: docs
    @Override
    public boolean hasNext() {
        return next != null;
    }

    private void loadNext(){
        try {
            String line = br.readLine();
            String[] record = line.split(",");
            if(new Date(record[0]).compareTo(start) >= 0){
                next = new StockDay(null, new Date(record[0]), new BigDecimal(record[1]), new BigDecimal(record[2]), new BigDecimal(record[3]), new BigDecimal(record[4]));
            }
        }catch(IOException e){
            System.out.println(e);
        }

    }
}