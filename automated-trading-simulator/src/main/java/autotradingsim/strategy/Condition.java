package autotradingsim.strategy;

import autotradingsim.stocks.StockEntry;

import java.util.Calendar;
import java.util.function.Predicate;

public class Condition implements ICondition {

	public Condition() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean evaluate(Calendar date) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Predicate<IBufferAdapter<? extends StockEntry>> getFunction() {
		// TODO Auto-generated method stub
		return null;
	}

}
