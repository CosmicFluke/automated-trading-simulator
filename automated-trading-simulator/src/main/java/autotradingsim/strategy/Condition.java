package autotradingsim.strategy;

import autotradingsim.stocks.StockEntry;

import java.util.function.Predicate;

/**
 * Not yet implemented.
 */
public class Condition implements ICondition {

	public Condition() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getBufferSize() {
		return 0;
	}

	@Override
	public Predicate<IBufferAdapter<? extends StockEntry>> getFunction() {
		// TODO Auto-generated method stub
		return null;
	}

}
