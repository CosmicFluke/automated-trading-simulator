package autotradingsim.stocks;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.Calendar;

import autotradingsim.stocks.StockDay;

public class StockDayTest{
	private StockDay dayStock;
	private StockDay dayStock2;
	private final String symbol = "APPL";
	private final Calendar date = Calendar.getInstance();
	private final Double open = 50.01;
	private final Double high = 50.51;
	private final Double low = 49.01;
	private final Double close = 50.31;
	private final Double volume = 20000.00;
	private Calendar date2 = Calendar.getInstance();
	/*
	@Before
	public void setUp() {
		this.dayStock = new StockDay(this.symbol, this.date, this.open, this.high, this.low, this.close, this.volume);
		this.dayStock2 = new StockDay(this.symbol, this.date2, this.open, this.high, this.low, this.close, this.volume);
	}
	
	@Test
	public void verifyDate(){
		assertEquals(this.dayStock.getDate(),this.date);
    }
	
	@Test
	public void verifyDateNotMutable(){
		this.date2.set(1990, 10, 10);
        assertNotEquals(this.dayStock2.getDate(),this.date2);
	}
	
	@Test
    public void verifyOpen() {
		assertEquals(this.dayStock.getOpen(),this.open);
    }

    @Test
    public void verifyHigh() {
    	assertEquals(this.dayStock.getHigh(),this.high);
    }

    @Test
    public void verifyLow() {
    	assertEquals(this.dayStock.getLow(),this.low);
    }

    @Test
    public void verifyClose() {
    	assertEquals(this.dayStock.getClose(),this.close);
    }

    @Test
    public void verifyVolume() {
    	assertEquals(this.dayStock.getVolume(),this.volume);
    }
    
    /** 
     * StockDay.getSingleValue() method returns BigDecimal, only test if we decide to move to this method.
     * 
    
    @Test
    public void verifySingleValues() {
    	assertEquals(this.dayStock.getSingleValue(OPEN),this.open);
    }
    
    **/

}
