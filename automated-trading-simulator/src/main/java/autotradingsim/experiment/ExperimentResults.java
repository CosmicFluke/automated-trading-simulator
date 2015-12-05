package autotradingsim.experiment;

import autotradingsim.strategy.IDecision;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by myunginkim on 15-12-05.
 * This Class has a Observer and Observerable Pattern with Result.
 * Whenever ResultDay is added to Result Class, it notifies this class and send the contents so that ExperimentResults
 * update this variables.
 */
public class ExperimentResults {
    private List<Result> results;
    private int NumStocksForEachTimePeriodForEachStock;
    private BigDecimal AvgEndingCashBalanceForEachTimePeriod;

    private double avgBuyActions, avgSellActions;
    private int numBuyActionsForAllTimePeriods;
    private int numSellActionsForAllTimePeriods;
    private TimeSet timeSet;


    public ExperimentResults(TimeSet timeSet) {
        this.results = new ArrayList<>();
        this.numBuyActionsForAllTimePeriods = 0;
        this.numSellActionsForAllTimePeriods = 0;
        this.timeSet = timeSet;
    }

    public void onUpdate(Result result, ResultDay resultDay) {
        // TODO: Need to update the statistical storage variables.

        // Updating Buy/Sell Actions
        Iterator<IDecision> decisions = resultDay.getDecisions().iterator();
        while (decisions.hasNext()) {
            IDecision decision = decisions.next();
            switch (decision.getActionType()) {
                case BUY:
                    this.increaseBuyActionByOne();
                    break;

                case SELL:
                    this.increaseSellActionByOne();

                    break;
            }
        }
        avgBuyActions = (numBuyActionsForAllTimePeriods / timeSet.getNumTrials());
        avgSellActions = (numSellActionsForAllTimePeriods / timeSet.getNumTrials());

    }

    private void increaseBuyActionByOne() {
        this.numBuyActionsForAllTimePeriods += 1;
    }

    private void increaseSellActionByOne() {
        this.numSellActionsForAllTimePeriods += 1;
    }

    public double getAvgBuyActions() {
        return avgBuyActions;
    }

    public double getAvgSellActions() {
        return avgSellActions;
    }

    public List<Result> getResults() { return this.results; }

    public Iterator<Result> getExperimentResultsIterator() {
        return results.iterator();
    }

    public void addResults(Result result) {
        this.results.add(result);
    }

    public int size() {
        return results.size();
    }

    public Result getResultAt(int index) {
        return results.get(index);
    }

    public int getNumStocksForEachTimePeriodForEachStock() {
        return NumStocksForEachTimePeriodForEachStock;
    }

    public void setNumStocksForEachTimePeriodForEachStock(int numStocksForEachTimePeriodForEachStock) {
        NumStocksForEachTimePeriodForEachStock = numStocksForEachTimePeriodForEachStock;
    }

    public BigDecimal getAvgEndingCashBalanceForEachTimePeriod() {
        return AvgEndingCashBalanceForEachTimePeriod;
    }

    public void setAvgEndingCashBalanceForEachTimePeriod(BigDecimal avgEndingCashBalanceForEachTimePeriod) {
        this.AvgEndingCashBalanceForEachTimePeriod = avgEndingCashBalanceForEachTimePeriod;
    }

    public int getNumBuyActionsForAllTimePeriods() {
        return numBuyActionsForAllTimePeriods;
    }

    public void setNumBuyActionsForAllTimePeriods(int numBuyActionsForAllTimePeriods) {
        this.numBuyActionsForAllTimePeriods = numBuyActionsForAllTimePeriods;
    }

    public int getNumSellActionsForAllTimePeriods() {
        return numSellActionsForAllTimePeriods;
    }

    public void setNumSellActionsForAllTimePeriods(int numSellActionsForAllTimePeriods) {
        this.numSellActionsForAllTimePeriods = numSellActionsForAllTimePeriods;
    }
}
