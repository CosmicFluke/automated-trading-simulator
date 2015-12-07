package autotradingsim.application;

import static org.junit.Assert.*;

import org.junit.*;

public class ApplicationBasicTest {

    ITradingApplication applicationUnderTest;

    @BeforeClass
    public static void beforeClass() {
        TradingApplication.clearMemoryAndFileSystem();
        TradingApplication.destructObject();
    }

    @AfterClass
    public static void afterClass() {
        TradingApplication.clearMemoryAndFileSystem();
        TradingApplication.destructObject();
    }

    @Before
    public void setUp() throws Exception {
        TradingApplication.clearMemoryAndFileSystem();
        TradingApplication.destructObject();
        applicationUnderTest = TradingApplication.getInstance();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testSingleton() {
        assertEquals(applicationUnderTest, TradingApplication.getInstance());
    }

    @Test
    public void testEmptyStrategy(){
        assertTrue(applicationUnderTest.getAvailableStrategies().isEmpty());
    }

    @Test
    public void testEmptyExperiments(){
        assertTrue(applicationUnderTest.getAvailableExperiments().isEmpty());
    }
}
