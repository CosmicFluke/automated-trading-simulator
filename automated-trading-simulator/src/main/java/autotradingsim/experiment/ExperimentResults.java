package autotradingsim.experiment;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by myunginkim on 15-12-05.
 */
public class ExperimentResults {
    private List<Result> results;
    private int NumStocksForEachTimePeriodForEachStock;
    private BigDecimal endingCashBalanceForEachTimePeriod;
    private int numBuyActionsForAllTimePeriods;
    private int numSellActionsForAllTimePeriods;
    private int numTimePeriods;


    public ExperimentResults() {
        this.results = new ArrayList<>();
    }

    public void addResults(Result result) {
        this.results.add(result);
    }

    public int getNumStocksForEachTimePeriodForEachStock() {
        return NumStocksForEachTimePeriodForEachStock;
    }

    public void setNumStocksForEachTimePeriodForEachStock(int numStocksForEachTimePeriodForEachStock) {
        NumStocksForEachTimePeriodForEachStock = numStocksForEachTimePeriodForEachStock;
    }

    public BigDecimal getEndingCashBalanceForEachTimePeriod() {
        return endingCashBalanceForEachTimePeriod;
    }

    public void setEndingCashBalanceForEachTimePeriod(BigDecimal endingCashBalanceForEachTimePeriod) {
        this.endingCashBalanceForEachTimePeriod = endingCashBalanceForEachTimePeriod;
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

    public int getNumTimePeriods() {
        return numTimePeriods;
    }

    public void setNumTimePeriods(int numTimePeriods) {
        this.numTimePeriods = numTimePeriods;
    }
}
