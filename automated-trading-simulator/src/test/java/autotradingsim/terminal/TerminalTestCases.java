package autotradingsim.terminal;

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
public class TerminalTestCases
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public TerminalTestCases( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( TerminalTestCases.class );
    }

    
    public void testBasicOutput()
    {
    	OutputStream OutputText = new ByteArrayOutputStream();
    	System.setOut(new PrintStream(OutputText));
    	
    	String Input = "\n";
    	
    	InputStream stringStream = new ByteArrayInputStream(Input.getBytes());
    	System.setIn(stringStream);
    	
    	String[] input = null;
    	autoTradingSim.main(input);
    	
    	assertEquals("$>$>", OutputText.toString());
    	
    	System.setIn(null);
    	System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
    }
    
    public void testHelpOutput_h()
    {
    	OutputStream OutputText = new ByteArrayOutputStream();
    	System.setOut(new PrintStream(OutputText));
    	
    	String Input = "h\n";
    	
    	InputStream stringStream = new ByteArrayInputStream(Input.getBytes());
    	System.setIn(stringStream);
    	
    	String[] input = null;
    	autoTradingSim.main(input);
    	
    	assertEquals("Welcome to the auto stock trading simulator!\r\n> ", OutputText.toString());
    	
    	System.setIn(null);
    	System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
    }
    
    public void testBasicOutput_help()
    {
    	OutputStream OutputText = new ByteArrayOutputStream();
    	System.setOut(new PrintStream(OutputText));
    	
    	String Input = "help\n";
    	
    	InputStream stringStream = new ByteArrayInputStream(Input.getBytes());
    	System.setIn(stringStream);
    	
    	String[] input = null;
    	autoTradingSim.main(input);
    	
    	assertEquals("> Welcome to the auto stock trading simulator!\r\n> ", OutputText.toString());
    	
    	System.setIn(null);
    	System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
    }
    
    public void testBasicOutput_Help()
    {
    	OutputStream OutputText = new ByteArrayOutputStream();
    	System.setOut(new PrintStream(OutputText));
    	
    	String Input = "Help\n";
    	
    	InputStream stringStream = new ByteArrayInputStream(Input.getBytes());
    	System.setIn(stringStream);
    	
    	String[] input = null;
    	autoTradingSim.main(input);
    	
    	assertEquals("Welcome to the auto stock trading simulator!\r\n> ", OutputText.toString());
    	
    	System.setIn(null);
    	System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
    }
    
    public void testBasicOutput_InvalidInput()
    {
    	OutputStream OutputText = new ByteArrayOutputStream();
    	System.setOut(new PrintStream(OutputText));
    	
    	String Input = "InvalidInput\n\n";
    	
    	InputStream stringStream = new ByteArrayInputStream(Input.getBytes());
    	System.setIn(stringStream);
    	
    	String[] input = null;
    	autoTradingSim.main(input);
    	
    	String expected = "Please enter a valid command.\r\n"
    			+ "Valid commands include:\r\n"
    			+ "help [<command>]\r\n"
    			+ "viewStrat <name>\r\n"
    			+ "modifyStrat <name>\r\n"
    			+ "viewExp <name>\r\n"
    			+ "modifyExp <name>\r\n"
    			+ "run <experiment_name>\r\n"
    			+ "> ";
    	
    	assertEquals(expected, OutputText.toString());
    	
    	System.setIn(null);
    	System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
    }
    
    public void testBasicOutput_InvalidHelp()
    {
    	OutputStream OutputText = new ByteArrayOutputStream();
    	System.setOut(new PrintStream(OutputText));
    	
    	String Input = "help invalid\n";
    	
    	InputStream stringStream = new ByteArrayInputStream(Input.getBytes());
    	System.setIn(stringStream);
    	
    	String[] input = null;
    	autoTradingSim.main(input);
    	
    	String expected = "> "
    			+ "Did not understand invalid as a valid input. "
    			+ "Needs to be one of viewstrat, modifystrat, viewexp, modifyex, run, experimentModification, "
    			+ "or strategyModification\r\n"
    			+ "> ";
    	
    	assertEquals(expected, OutputText.toString());
    	
    	System.setIn(null);
    	System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
    }
    
    public void testBasicOutput_viewstratHelp()
    {
    	OutputStream OutputText = new ByteArrayOutputStream();
    	System.setOut(new PrintStream(OutputText));
    	
    	String Input = "help viewstrat\n";
    	
    	InputStream stringStream = new ByteArrayInputStream(Input.getBytes());
    	System.setIn(stringStream);
    	
    	String[] input = null;
    	autoTradingSim.main(input);
    	
    	String expected = "> "
    			+ "View an existing trading strategy. If none is specified, "
    			+ "displays a list of available strategies. Usage: viewStrat [name]\r\n"
    			+ "> ";
    	
    	assertEquals(expected, OutputText.toString());
    	
    	System.setIn(null);
    	System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
    }
    
    public void testBasicOutput_viewexpHelp()
    {
    	OutputStream OutputText = new ByteArrayOutputStream();
    	System.setOut(new PrintStream(OutputText));
    	
    	String Input = "help viewexp\n";
    	
    	InputStream stringStream = new ByteArrayInputStream(Input.getBytes());
    	System.setIn(stringStream);
    	
    	String[] input = null;
    	autoTradingSim.main(input);
    	
    	String expected = "> "
    			+ "viewExp - view an existing experiment. "
    			+ "If none is specified, displays a list of available experiments. "
    			+ "Usage: viewExp [name]\r\n"
    			+ "> ";
    	
    	assertEquals(expected, OutputText.toString());
    	
    	System.setIn(null);
    	System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
    }
    
    public void testBasicOutput_modifyexHelp()
    {
    	OutputStream OutputText = new ByteArrayOutputStream();
    	System.setOut(new PrintStream(OutputText));
    	
    	String Input = "help modifyex\n";
    	
    	InputStream stringStream = new ByteArrayInputStream(Input.getBytes());
    	System.setIn(stringStream);
    	
    	String[] input = null;
    	autoTradingSim.main(input);
    	
    	String expected = "> "
    			+ "Modify an existing experiment by name. "
    			+ "If that experiment doesn't exist, create one under given name. "
    			+ "After specifying a experiment to be modified, the prompt will "
    			+ "change to Experiment [name] >. "
    			+ "See help experimentModification for sub-commands.\r\n"
    			+ "Usage: modifyExp [name]\r\n"
    			+ "> ";
    	
    	assertEquals(expected, OutputText.toString());
    	
    	System.setIn(null);
    	System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
    }
    
    public void testBasicOutput_modifystratHelp()
    {
    	OutputStream OutputText = new ByteArrayOutputStream();
    	System.setOut(new PrintStream(OutputText));
    	
    	String Input = "help modifystrat\n";
    	
    	InputStream stringStream = new ByteArrayInputStream(Input.getBytes());
    	System.setIn(stringStream);
    	
    	String[] input = null;
    	autoTradingSim.main(input);
    	
    	String expected = "> "
    			+ "Modify an existing strategy, by name. "
    			+ "If strategy doesn't exist, one is created by that name. "
    			+ "After specifying an strategy to be modified, the prompt will change to Strat [name] >. "
    			+ "See help strategyModification for sub-commands.\r\n"
    			+ "Usage: modifyStrat [name]\r\n"
    			+ "> ";
    	
    	assertEquals(expected, OutputText.toString());
    	
    	System.setIn(null);
    	System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
    }
    
    public void testBasicOutput_runHelp()
    {
    	OutputStream OutputText = new ByteArrayOutputStream();
    	System.setOut(new PrintStream(OutputText));
    	
    	String Input = "help run\n";
    	
    	InputStream stringStream = new ByteArrayInputStream(Input.getBytes());
    	System.setIn(stringStream);
    	
    	String[] input = null;
    	autoTradingSim.main(input);
    	
    	String expected = "> "
    			+ "run - Runs a selected experiment. "
    			+ "Usage: run [experiment_name]\r\n"
    			+ "> ";
    	
    	assertEquals(expected, OutputText.toString());
    	
    	System.setIn(null);
    	System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
    }
}
