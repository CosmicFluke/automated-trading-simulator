/**
 * 
 */
package testTradingApplication;

import static org.junit.Assert.*;

import java.io.IOException;
import java.text.ParseException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import autotradingsim.engine.TradingApplication;

/**
 * @author Shirley
 *
 */
public class testdisplayResults {

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
		testapp.displayResults("test1.txt");
	}

}
