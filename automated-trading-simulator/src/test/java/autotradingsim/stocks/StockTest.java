
package autotradingsim.stocks;

import java.util.List;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertNotNull;

import autotradingsim.stocks.StockLoader;

public class StockTest{
	private IStock stock;
	private IStock stock2;
	private String symbol;
    private String name;
    private ArrayList<StockDay> data = new ArrayList<StockDay>();
    private Calendar startDate;
    private Calendar endDate;
    
    @Before
	public void setUp() throws Exception {
		startDate = Calendar.getInstance();
		startDate.set(1990, 10,1);
		Calendar date = (Calendar) startDate.clone();
		for (int i = 0; i < 20; i++){
			date.set(1990, 10, i+1);
			this.data.add(new StockDay("AAPL", date, new BigDecimal(50+(i/10)),new BigDecimal(50+(i/5)) ,new BigDecimal(50-(i/5)) ,new BigDecimal(50+(i/20)) , i * 100000));
			endDate = (Calendar) date.clone();
			date = (Calendar) date.clone();
		}
		
		this.stock = new Stock("AAPL", "Apple Inc.",this.data);
		this.stock2 = new StockLoader().fetchStock("AAPL");
	}
	
	@Test
	public void verifyStocksNotNull(){
		assertNotNull(this.stock);
		assertNotNull(this.stock2);
	}
	
	@Test
	public void verifyGetSymbol(){
		assertEquals(this.stock.getSymbol(),"AAPL");
        assertEquals(this.stock2.getSymbol(),"AAPL");    
    }
	
	@Test
    public void verifyGetName(){
		assertEquals(this.stock.getName(),"Apple Inc.");
        assertEquals(this.stock2.getName(),"Apple Inc");
    }


    @Test
    public void verifyGetDay(){
        StockDay test;
        test = this.stock.getDay(startDate);
        assertNotNull(test);
    }

    @Test
    public void verifyGetStartDate() {
        this.stock.getStartDate();
        assertEquals(startDate, this.stock.getStartDate());
    }

    @Test
    public void verifyGetEndDate() {
        this.stock.getEndDate();
        assertEquals(endDate, this.stock.getEndDate());
    }
/*
    public IBufferAdapter getNewBuffer(Calendar date, int size) {
        return getNewDayBuffer(date, size);
    }

    public StockDayBufferAdapter getNewDayBuffer(Calendar date, int size) {
        return new StockDayBufferAdapter(this, date, size);
    }
*/
	
	
	
}
