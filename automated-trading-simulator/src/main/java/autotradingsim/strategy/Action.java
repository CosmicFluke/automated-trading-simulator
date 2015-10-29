package autotradingsim.strategy;

import java.util.ArrayList;

/**
 * Created by Asher on 2015-10-26.
 */
public class Action {

    action a;
    ArrayList<AbsCondition> conditions;
    public Action(){
        this.a = null;
        this.conditions = new ArrayList<>();
    }

    public enum action{
        BUY, SELL, SHORT, COVER
    }

    public void setAction(action a){
        this.a = a;
    }

    public void addCondition(AbsCondition condition){
        this.conditions.add(condition);
    }

    public void deleteCondition(int i){
        this.conditions.remove(i);
    }

}
