package autotradingsim;
import autotradingsim.ui.AutomatedTradingSimulator;
import autotradingsim.util.TemporaryTestingStrategies;
public class autoTradingSim
{
    public static void main( String[] args )
    {
    	//AutomatedTradingSimulator terminal = new AutomatedTradingSimulator();
    	TemporaryTestingStrategies.createStrats();
        AutomatedTradingSimulator.main(args);
        //TemporaryTestingStrategies.clearStrats();
    }
}
