package autotradingsim.experiment;

import java.time.LocalDate;
import java.util.*;

/**
 * Created by Asher on 2015-10-26.
 *
 * Given certain parameters, randomly generates and stores an appropriate set of time periods for an experiment.
 *
 */
public class TimeSet implements Iterator<LocalDate> {
	
    private Iterator<LocalDate> startDates;
    private int duration;

    /**
     *
     * @param numTrials : Number of date ranges to generate
     * @param trialDuration : Duration (in days) of each trial
     */
    public TimeSet (int numTrials, int trialDuration, LocalDate start, LocalDate end) {
        /* TODO: generate a list of random start dates within the given range
        Each start date should allow for a period trialDuration days long within the given range
        Periods should overlap as little as possible
         */
        this.duration = trialDuration;
        List<LocalDate> tempDates = new ArrayList<LocalDate>();
        for (int i = 0; i < numTrials; i++){
        	if (start.isBefore(end)){
        		tempDates.add(start);
                start = start.plusDays(trialDuration);
            } else {
        		break;
        	}
        }
        startDates = tempDates.iterator();
        System.out.println(tempDates.size());
    }


    public LocalDate next() {
        return startDates.next();
    }

    public boolean hasNext(){
        return startDates.hasNext();
    }

    public int getDuration(){
        return this.duration;
    }
}