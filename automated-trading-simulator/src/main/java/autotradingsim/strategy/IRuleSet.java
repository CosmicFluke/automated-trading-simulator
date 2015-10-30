package autotradingsim.strategy;


import java.util.Iterator;

/**
 * A data type that stores a list of rules.
 */
public interface IRuleSet {

    public void addRule();
    public void deleteRule(SimpleRule rule);
    public Iterator<SimpleRule> getRules();

}
