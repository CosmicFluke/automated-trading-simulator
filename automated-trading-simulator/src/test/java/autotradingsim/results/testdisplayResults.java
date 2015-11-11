package autotradingsim.results;

import autotradingsim.application.TradingApplication;

import java.io.IOException;
import java.text.ParseException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Shirley
 *
 */
public class TestDisplayResults {

	/**
	 * @throws java.lang.Exception
	 */

	public static TradingApplication testapp;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		testapp = TradingApplication.getInstance();
	}
	
	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws IOException, ParseException {
		testapp.displayResults(System.getProperty("user.dir") + "/automated-trading-simulator/src/main/resources/DATA/RESULTS/test1.txt");
	}

}
