import exceptions.NoCurrenciesPairFoundException;

import java.math.BigDecimal;
import java.util.Map;

public class Exchange {

    private Map<CurrenciesPair, BigDecimal> ratesMap;

    public Exchange(Map<CurrenciesPair, BigDecimal> ratesMap) {

        this.ratesMap = ratesMap;
    }

    public BigDecimal getRate(CurrenciesPair currenciesPair) throws NoCurrenciesPairFoundException {
        if(!ratesMap.containsKey(currenciesPair))
        {
            throw new NoCurrenciesPairFoundException();
        }

        return ratesMap.get(currenciesPair);
    }

    public Money convert(int amount, CurrenciesPair currenciesPair) throws NoCurrenciesPairFoundException {

        BigDecimal rate = this.getRate(currenciesPair);

        int convertedAmount = new BigDecimal(amount).multiply(rate).intValue();
        String currency = currenciesPair.getCurrencyTo();

        return new Money(convertedAmount, currency);
    }
}
