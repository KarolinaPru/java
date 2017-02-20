package Test;

import exceptions.NoCurrenciesPairFoundException;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by karol_000 on 21.01.2017.
 */
public class ExchangeTest {

    private Exchange exchange;
    private CurrenciesPair fromCHFtoPLN;
    private CurrenciesPair fromPLNtoCHF;

    @Before
    public void setUp() throws Exception {

        fromCHFtoPLN = new CurrenciesPair(Currency.CHF, Currency.PLN);
        fromPLNtoCHF = new CurrenciesPair(Currency.PLN, Currency.CHF);

        Map<CurrenciesPair, BigDecimal> ratesMap = RateConfigurator.configureRatesMap();

        exchange = new Exchange(ratesMap);
    }

    @Test
    public void givenRatesMap_WhenGetRateIsCalled_ThenCorrectRateIsReturned() throws Exception {
        BigDecimal returnedRate = exchange.getRate(fromPLNtoCHF);

        assertEquals(new BigDecimal(0.25), returnedRate);
    }

    @Test
    public void givenRateAndAmount_WhenConvertIsCalled_ThenCorrectAmountIsReturned() throws Exception {

        Money returnedMoney = exchange.convert(4, fromPLNtoCHF);

        assertEquals(1, returnedMoney.getAmount());
    }

    @Test
    public void givenRateAndAmount_WhenConvertIsCalled_ThenCorrectCurrencyIsReturned() throws Exception {
        Money expectedMoney = new Money(1, "CHF");

        Money returnedMoney = exchange.convert(4, fromPLNtoCHF);

        assertEquals(returnedMoney, expectedMoney);
    }

    @Test(expected = NoCurrenciesPairFoundException.class)
    public void givenNotExistingCurrenciesPair_WhenGetRateIsCalled_ThenNoCurrenciesPairFoundExceptionIsThrown() throws Exception {
        exchange.getRate(new CurrenciesPair("XXX", "YYY"));
    }
}
