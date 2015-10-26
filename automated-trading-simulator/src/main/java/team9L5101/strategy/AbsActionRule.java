package team9L5101.strategy;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Asher on 2015-10-25.
 * Set of conditions and an associated action, to be used in a Strategy.
 */
public abstract class AbsActionRule {

    private Action action;

    // TODO: docs

    // TODO: Use AbsCondition?
    public abstract void addCondition(String id, AbsCondition condition);

    public abstract void removeCondition(String id);

    public abstract List<AbsCondition> getConditions();

    public abstract void setAmount(BigDecimal amount);

    public abstract BigDecimal getAmount();

    public void setAction(Action action) {
        this.action = action;
    }

}
