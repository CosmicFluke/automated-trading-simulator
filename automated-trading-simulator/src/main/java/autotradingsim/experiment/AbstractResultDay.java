package autotradingsim.experiment;

import autotradingsim.stocks.IStock;
import autotradingsim.strategy.IDecision;
import autotradingsim.strategy.IStrategy;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Asher on 2015-11-18.
 */
public abstract class AbstractResultDay {

    LocalDate date;
    List<IDecision> decisions;
    Map<String, String> strategyIDtoStockSymbol;
    BigDecimal openingBalance;
    BigDecimal closingBalance;

    public AbstractResultDay(
            LocalDate date,
            List<IDecision> decisions, Map<IStrategy, IStock> strategyToStock,
            BigDecimal opening, BigDecimal closing){
        this.date = date;
        this.decisions = decisions;
        this.strategyIDtoStockSymbol = new HashMap<>();
        strategyToStock.entrySet().stream()
                .map(entry -> new String[]{entry.getKey().getName(), entry.getValue().getName()})
                .reduce();
    }

    abstract BigDecimal getBalanceRelativeChange();
    abstract BigDecimal getBalanceAbsoluteChange();
    abstract LocalDate getDate();
    abstract List<IDecision> getDecisions();
    abstract String getStockForStrategy(String strategyID);
    abstract BigDecimal getOpeningBalance();
    abstract BigDecimal getClosingBalance();

}
