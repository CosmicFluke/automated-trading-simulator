package team9L5101.experiment;

import java.util.*;

/**
 * Created by Asher on 2015-10-26.
 *
 * Given certain parameters, randomly generates and stores an appropriate set of time periods for an experiment.
 *
 */
public class TimeSet implements Iterator {

    private List<Calendar> startDates;

    /**
     *
     * @param numTrials : Number of date ranges to generate
     * @param trialDuration : Duration (in days) of each trial
     */
    public TimeSet (int numTrials, int trialDuration, Date start, Date end) {
        /* TODO: generate a list of random start dates within the given range
        Each start date should allow for a period trialDuration days long within the given range
        Periods should overlap as little as possible
         */
    }

    public Calendar next() {
        // TODO: implement
        return null;
    }

    public boolean hasNext(){
        // TODO: implement
        return false;
    }

}
