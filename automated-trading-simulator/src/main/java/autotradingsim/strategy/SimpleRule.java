package autotradingsim.strategy;

import java.util.ArrayList;

/**
 * Created by Asher on 2015-10-26.
 */
public class SimpleRule extends AbstractRule {

    Action a;

    ArrayList<ICondition> conditions;
    public SimpleRule() {
        this.a = null;
        this.conditions = new ArrayList<>();
    }

    @Override
    public void setAction(Action a){
        this.a = a;
    }

    @Override
    public void addCondition(ICondition condition){
        this.conditions.add(condition);
    }

    @Override
    public void deleteCondition(int i){
        this.conditions.remove(i);
    }



    public IDecision getDecision(){
        // TODO: Implement
        return null;
    }

}
