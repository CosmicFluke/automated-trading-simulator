package autotradingsim.strategy;

import java.util.Iterator;

/**
 * Created by Asher on 2015-10-30.<br>
 *
 * <p>Classes implementing this interface <b>arrange, validate, and store</b> sets of conditions and actions.</p>
 * <p>Members of this class do *not* produce decisions, but rather produce {@link IDecisionMaker IDecisionMaker}
 * objects to fulfill that responsibility.  Rules are blind to Stocks.</p>
 *
 */
public abstract class IRule {

    /**
     * Produces the decision-making object.
     * @return A decision maker.
     */
    public abstract IDecisionMaker getDecisionMaker();

}
