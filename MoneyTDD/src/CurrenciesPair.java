/**
 * Created by karol_000 on 21.01.2017.
 */
public class CurrenciesPair {
    private final String currencyFrom;
    private final String currencyTo;

    public CurrenciesPair(String currencyFrom, String currencyTo) {
        this.currencyFrom = currencyFrom;
        this.currencyTo = currencyTo;
    }

    public String getCurrencyFrom() {
        return currencyFrom;
    }
    public String getCurrencyTo() {
        return currencyTo;
    }

    @Override
    public int hashCode() {
        long l = currencyFrom.hashCode() * 2654435761L;
        return (int)l + (int)(l >>> 32) + currencyTo.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof CurrenciesPair)) {
            return false;
        }
        CurrenciesPair currenciesPairObj = (CurrenciesPair) o;
        return this.currencyFrom.equals(currenciesPairObj.getCurrencyFrom()) &&
                this.currencyTo.equals(currenciesPairObj.getCurrencyTo());
    }
}