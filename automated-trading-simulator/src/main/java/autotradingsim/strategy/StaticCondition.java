package autotradingsim.strategy;

import autotradingsim.util.Pair;

import java.math.BigDecimal;
import java.util.function.Predicate;

/**
 * <p>A general StaticCondition that generates a predicate from an IMeasurement, comparator, and comparison value.</P.
 *
 */
public class StaticCondition implements ICondition {

	private IMeasurement measurement;
	private BigDecimal compareTo;
	private Predicate<Pair<BigDecimal,BigDecimal>> comparator;
	private Comparator comp;

	/**
	 * Instantiates an new condition
	 */
	public StaticCondition(IMeasurement measurement, ICondition.Comparator comp, BigDecimal compareTo) {
		this.comp = comp;
		this.compareTo = compareTo;
		this.measurement = measurement;
		this.comparator = makeComparator(comp);
	}

	/**
	 * Provides the measurement associated with this condition.
	 * @return
     */
	public IMeasurement getMeasurement() {
		return this.measurement;
	}

	/**
	 * Change the comparison value and update the evaluator function.
	 * @param compareTo
     */
	public void changeCompareTo(BigDecimal compareTo) {
		this.compareTo = compareTo;
	}

	@Override
	public int getBufferSize() {
		return measurement.getBufferSize();
	}

	@Override
	public Predicate<IBufferAdapter> getFunction() {
		return (IBufferAdapter buffer) ->
				(comparator.test(new Pair<>(measurement.getFunction().apply(buffer), compareTo)));
	}

	@Override
	public String toString(){

		return String.join(" ",
				new String[]{measurement.getName() + ICondition.compToString(comp) + compareTo.toString()});
	}

}
