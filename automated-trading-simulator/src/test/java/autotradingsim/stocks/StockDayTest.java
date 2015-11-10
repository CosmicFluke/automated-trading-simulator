package autotradingsim.stocks;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.math.BigDecimal;
import java.util.Calendar;

import autotradingsim.stocks.StockDay;

public class StockDayTest{
	private StockDay dayStock;
	private StockDay dayStock2;
	private final String symbol = "APPL";
	private final Calendar date = Calendar.getInstance();
	private final BigDecimal open = new BigDecimal(50.01);
	private final BigDecimal high = new BigDecimal(50.51);
	private final BigDecimal low = new BigDecimal(49.80);
	private final BigDecimal close = new BigDecimal(50.25);
	private final int volume = 20000;
	private Calendar date2 = Calendar.getInstance();
	
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
    public void verifySymbol() {
		assertEquals(this.dayStock.getSymbol(),this.symbol);
    }

    @Test
    public void verifyClose() {
    	assertEquals(0,this.dayStock.getValue().compareTo(this.close));
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
