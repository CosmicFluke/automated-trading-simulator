package autotradingsim.application;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import autotradingsim.application.ITradingApplication;
import autotradingsim.application.TradingApplication;

public class BasicTest {

    ITradingApplication ApplicationUnderTest = null;

    @AfterClass
    public static void afterClass() {
        TradingApplication.destructObject();
    }

    @Before
    public void setUp() throws Exception {
        TradingApplication.clearFileSystem();
        ApplicationUnderTest = TradingApplication.getInstance();
    }

    @After
    public void tearDown() throws Exception {
        ApplicationUnderTest.clearMemory();
    }

    @Test
    public void testSingleton() {
        assertTrue(ApplicationUnderTest == TradingApplication.getInstance());
    }

    @Test
    public void testEmptyStrategy(){
        assertTrue(ApplicationUnderTest.getAvailableStrategies().isEmpty());
    }

    @Test
    public void testEmptyExperiments(){
        assertTrue(ApplicationUnderTest.getAvailableExperiments().isEmpty());
    }
}