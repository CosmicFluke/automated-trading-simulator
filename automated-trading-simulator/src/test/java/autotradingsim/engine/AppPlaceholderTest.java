package autotradingsim.engine;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import autotradingsim.autoTradingSim;

/**
 * Unit test for simple AppPlaceholder.
 */
public class AppPlaceholderTest
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppPlaceholderTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppPlaceholderTest.class );
    }

    
    public void testBasicOutput()
    {
    	assertTrue(true);
    }
}
