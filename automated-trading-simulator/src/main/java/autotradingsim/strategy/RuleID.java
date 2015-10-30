package autotradingsim.strategy;

/**
 * Created by Asher on 2015-10-30.
 *
 * Provides a unique ID value for each strategy.
 *
 */
public class RuleID {

    private long id;

    public RuleID(Strategy strat) {
        this.id = strat.hashCode();
    }

    public long getID() {
        return this.id;
    }

}
