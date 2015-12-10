package autotradingsim.util;

import autotradingsim.strategy.rules.Action;
import autotradingsim.strategy.rules.IAction;

import java.math.BigDecimal;

/**
 * Created by Asher on 2015-12-07.
 */
public class ActionFactory {

    public enum ActionPrefabType {
        BUY_STATIC_QUANTITY, BUY_PERCENTAGE_OF_AVAILABLE, BUY_FIXED_CASH_VALUE, SELL_STATIC_QUANTITY,
        SELL_PERCENTAGE_OF_AVAILABLE, SELL_FIXED_CASH_VALUE
    }

    /**
     * <p>Use the {@link ActionPrefabType} enumerable to specify the type of Action you would like to create.  Each
     * ActionPrefabType gives different meaning to the <tt>value</tt> parameter.</p>
     * <p>If an invalid prefab type is passed as an argument, the function will return <tt>null</tt>.</p>
     * @param type Action type you would like to create (see {@link ActionPrefabType})
     * @param value value associated with the action type
     * @return a new Action instance with type and quantity function corresponding to the selected prefab type and value
     */
    public static IAction newPrefabAction(ActionPrefabType type, BigDecimal value) {
        if (type == null || value == null)
            throw new NullPointerException("At least one of the arguments was null");
        if (value.equals(BigDecimal.ZERO)) {
            throw new IllegalArgumentException("Zero is not a valid argument value");
        }
        switch (type) {
            case BUY_STATIC_QUANTITY:
                return newBuyActionStaticQuantity(value.intValue());
            case BUY_FIXED_CASH_VALUE:
                return newBuyActionFixedCashValue(value);
            case BUY_PERCENTAGE_OF_AVAILABLE:
                return newBuyActionPercentageOfCash(value);
            case SELL_STATIC_QUANTITY:
                return newSellActionStaticQuantity(value.intValue());
            case SELL_FIXED_CASH_VALUE:
                return newSellActionFixedCashValue(value);
            case SELL_PERCENTAGE_OF_AVAILABLE:
                return newSellActionPercentageOfShares(value);
            default:
                return null;
        }
    }

    public static IAction newBuyActionStaticQuantity(int quantity) {
        return new Action(IAction.ActionType.BUY, quantity);
    }

    public static IAction newSellActionStaticQuantity(int quantity) {
        return new Action(IAction.ActionType.SELL, quantity);
    }

    public static IAction newBuyActionPercentageOfCash(BigDecimal cashBalanceMultiplier) {
        return new Action(
                IAction.ActionType.BUY,
                (cashBalance, stockValue, numSharesOwned, confidence) ->
                        cashBalance.multiply(cashBalanceMultiplier).divideAndRemainder(stockValue)[0].intValue());
    }

    public static IAction newBuyActionFixedCashValue(BigDecimal cashValue) {
        return new Action(
                IAction.ActionType.BUY,
                (cashBalance, stockValue, numSharesOwned, confidence) ->
                        cashValue.divideAndRemainder(stockValue)[0].intValue());
    }

    public static IAction newSellActionPercentageOfShares(BigDecimal sharesMultiplier) {
        return new Action(
                IAction.ActionType.SELL,
                (cashBalance, stockValue, numSharesOwned, confidence) ->
                        BigDecimal.valueOf(numSharesOwned).multiply(sharesMultiplier).intValue());
    }

    public static IAction newSellActionFixedCashValue(BigDecimal cashValue) {
        return new Action(
                IAction.ActionType.SELL,
                (cashBalance, stockValue, numSharesOwned, confidence) ->
                        cashValue.divideAndRemainder(BigDecimal.valueOf(numSharesOwned))[0].intValue());
    }
}
