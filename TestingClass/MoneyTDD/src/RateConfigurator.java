package src;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by karol_000 on 21.01.2017.
 */
public abstract class RateConfigurator {
    public static Map<CurrenciesPair, BigDecimal> configureRatesMap() {
        CurrenciesPair fromCHFtoPLN = new CurrenciesPair(Currency.CHF, Currency.PLN);
        CurrenciesPair fromPLNtoCHF = new CurrenciesPair(Currency.PLN, Currency.CHF);

        Map<CurrenciesPair, BigDecimal> ratesMap = new HashMap<>();
        ratesMap.put(fromCHFtoPLN, new BigDecimal(4));
        ratesMap.put(fromPLNtoCHF, new BigDecimal(0.25));

        return ratesMap;
    }
}