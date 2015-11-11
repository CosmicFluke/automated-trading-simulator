package autotradingsim.strategy;

/**
 * Created by Asher on 2015-10-30.
 *
 * Provides a unique ID value for each rule.  Don't need this for current phase, but potentially useful later.
 *
 */
public class RuleID {

    private final int id;

    public RuleID(IRule rule) {
        this.id = rule.hashCode();
    }

    public int getID() {
        return this.id;
    }

    @Override
    public boolean equals(Object o) {
        return (o instanceof RuleID) && (((RuleID) o).getID() == this.getID());
    }

    @Override
    public int hashCode() {
        return (new Long(this.id)).hashCode();
    }

}
