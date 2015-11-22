
package autotradingsim.stocks;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

import autotradingsim.application.StockLoader;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class StockTest{
	private IStock stock;
	private IStock stock2;
	private String symbol;
    private String name;
    private ArrayList<StockDay> data;
    private LocalDate startDate;
    private LocalDate endDate;
    
    @Before
	public void setUp() throws Exception {
		data = new ArrayList<>();
		endDate = LocalDate.of(1990, 10,1);
		LocalDate date = endDate;
		for (int i = 0; i < 20; i++){
			date = endDate.minusDays(i);
			this.data.add(
					new StockDay(
							"AAPL", date,
							new BigDecimal(50+(i/10)),
							new BigDecimal(50+(i/5)),
							new BigDecimal(50-(i/5)),
							new BigDecimal(50+(i/20)),
							i * 100000));
		}
		startDate = date;
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
    	this.stock.getDay(startDate);
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
	
}
