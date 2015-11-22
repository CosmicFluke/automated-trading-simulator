package autotradingsim.strategy.indicators;

import autotradingsim.strategy.rules.IMeasurement;

/**
 * Created by Asher on 2015-11-15.
 *
 * Abstract Indicator that collects information about another indicator's value over time.
 */
public abstract class MetaIndicator extends Indicator {

    static String default_name = "Meta Indicator";
    static String default_description =
            "This Indicator collects information about another indicator's value over time.";

    IMeasurement indicator;
    int numDays;

    public MetaIndicator(IMeasurement indicator, int numDays, String name, String description) {
        super(name, description);
        this.indicator = indicator;
        this.numDays = numDays;
    }
    @Override
    public int getBufferSize() {
        return indicator.getBufferSize();
    }

    public IMeasurement getIndicator(){
        return indicator;
    }
}
