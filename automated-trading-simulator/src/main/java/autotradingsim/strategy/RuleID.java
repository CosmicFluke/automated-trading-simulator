package autotradingsim.strategy;

/**
 * Created by Asher on 2015-10-30.
 *
 * Provides a unique ID value for each rule.  Don't need this for current phase, but potentially useful later.
 *
 */
public class RuleID{

	private final int id;

    /**
     * <p>Create a RuleID for an IRule object.<br><br>
     * RuleIDs are unique for each IRule object, but are *not* serializable.  If deserializing a rule, make sure
     * to instantiate and set a new RuleID</p>
     * @param rule The Rule to be linked to the RuleID
     */
    public RuleID(IRule rule) {
        this.id = rule.hashCode();
    }

    /**
     * ID getter
     * @return
     */
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
