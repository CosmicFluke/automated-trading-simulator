package autotradingsim.strategy.indicators;

import autotradingsim.strategy.rules.IMeasurement;


/**
 * Created by Asher on 2015-12-05.
 */
public class MeasurementFactory {

    /**
     * <p>Produces a {@link Indicator} that represents the closing value of a stock on a single day.</p>
     * @return new Indicator
     */
    public static Indicator newSingleDailyValue() {
        return new SimpleMovingAverage(1);
    }

    /**
     * <p>Produces a {@link Indicator} that calculates a moving average of the closing values over a given number of
     * days.</p>
     * @param numDays
     * @return new Indicator
     */
    public static Indicator newSimpleMovingAverage(int numDays) {
        if (numDays == 0) {
            throw new IllegalArgumentException("numDays must be at least 1.");
        }
        return new SimpleMovingAverage(numDays);
    }

    /**
     * <p>Produces a {@link MetaIndicator} that calculates the absolute change (difference) in a stock's daily value
     * from the previous day.</p>
     * @return new MetaIndicator
     */
    public static MetaIndicator newAbsoluteChangeDaily() {
        return new IndicatorAbsoluteChange(newSingleDailyValue(), 2, IndicatorAbsoluteChange.CalcMode.NET_CHANGE);
    }

    /**
     * <p>Produces a {@link MetaIndicator} that calculates the relative (percentage) change in a stock's daily value
     * from the previous day.</p>
     * @return new MetaIndicator
     */
    public static MetaIndicator newRelativeChangeDaily() {
        return new IndicatorRelativeChange(newSingleDailyValue(), 2, IndicatorAbsoluteChange.CalcMode.NET_CHANGE);
    }

    /**
     * <p>Produces a {@link MetaIndicator} that calculates the absolute <b>net</b> change in the given {@link IMeasurement}
     * over a given number of days.</p>
     * @param numDays
     * @param measurement
     * @return new MetaIndicator
     */
    public static MetaIndicator newAbsoluteNetChange(int numDays, IMeasurement measurement) {
        if (numDays == 0) {
            throw new IllegalArgumentException("numDays must be at least 1.");
        }
        if (measurement == null) {
            throw new NullPointerException("Null IMeasurement given as parameter.");
        }
        return new IndicatorAbsoluteChange(measurement, numDays, IndicatorAbsoluteChange.CalcMode.NET_CHANGE);
    }

    /**
     * <p>Produces a {@link MetaIndicator} that calculates the <b>average</b> of the day-to-day absolute change in the given
     * {@link IMeasurement} over a given number of days.</p>
     * @param numDays
     * @param measurement
     * @return new MetaIndicator
     */
    public static MetaIndicator newAbsoluteAverageChange(int numDays, IMeasurement measurement) {
        if (numDays == 0) {
            throw new IllegalArgumentException("numDays must be at least 1.");
        }
        if (measurement == null) {
            throw new NullPointerException("Null IMeasurement given as parameter.");
        }
        return new IndicatorAbsoluteChange(measurement, numDays, IndicatorAbsoluteChange.CalcMode.DAILY_AVERAGE_CHANGE);
    }

    /**
     * <p>NOTE: This function is primarily for testing purposes.<br>
     * Produces a {@link MetaIndicator} that calculates the absolute change over 2 days in a 5-day moving average.</p>
     * @return new MetaIndicator for testing and demo purposes
     */
    public static MetaIndicator newPrefabAbsoluteChange1() {
        return new IndicatorAbsoluteChange(newSimpleMovingAverage(5), 2, IndicatorAbsoluteChange.CalcMode.NET_CHANGE);
    }

    /**
     * <p>NOTE: This function is primarily for testing purposes.<br>
     * Produces a {@link MetaIndicator} that calculates the relative change (percentage) over 2 days in a 5-day
     * moving average.</p>
     * @return new MetaIndicator for testing and demo purposes
     */
    public static MetaIndicator newPrefabRelativeChange1() {
        return new IndicatorRelativeChange(newSimpleMovingAverage(5), 2, IndicatorAbsoluteChange.CalcMode.NET_CHANGE);
    }
}
