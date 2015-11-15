package autotradingsim.stocks;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertNotNull;

	
public class StockLoaderTest {
	private StockLoader stockLoader;
	private IStock stock;
    private String symbol = "AAPL";
    
    /*
    private Calendar start;
    private Calendar end;
  	*/  
	
    @Before
	public void setUp() {
        this.stockLoader = new StockLoader();
    }
	
	/* Unused method as of now
	public verifyFetchStockDateRange(String symbol, Calendar start, Calendar end){
		this.stockList = this.stockLoader.fetchStockDateRange(symbol, start, end)
	}
	*/
    @Test
    public void loadNotNull(){
    	assertNotNull(this.stockLoader);
    }
    
	@Test
    public void verifyFetchStock(){
    	this.stock = this.stockLoader.fetchStock(this.symbol);
    	assertNotNull(this.stock);
    }
    
	@Test
	public void verifyNullFetchStock(){
		this.stock = this.stockLoader.fetchStock("Doesn't Exist");
    	assertNull(this.stock);
	}
	
	@Test
    public void verifyNotExists(){
    	assertFalse(this.stockLoader.exists("Doesn't Exist"));
    }
	
	@Test
	public void verifyExistsWithNull(){
		assertFalse(this.stockLoader.exists(null));
    }
	
	@Test
	public void verifyExists(){
		assertTrue(this.stockLoader.exists(this.symbol));
	}
}
