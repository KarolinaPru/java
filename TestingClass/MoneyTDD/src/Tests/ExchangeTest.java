package src.Tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.math.BigDecimal;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import exceptions.NoCurrenciesPairFoundException;
import src.CurrenciesPair;
import src.Currency;
import src.Exchange;
import src.Money;
import src.RateConfigurator;

/**
 * Created by karol_000 on 21.01.2017.
 */
public class ExchangeTest {

    private Exchange exchange;
    private CurrenciesPair fromPLNtoCHF;

    @Before
    public void setUp() throws Exception {

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
        Money expectedMoney = Money.produce(1, "CHF");

        Money returnedMoney = exchange.convert(4, fromPLNtoCHF);

        assertEquals(returnedMoney, expectedMoney);
    }

    @Test(expected = NoCurrenciesPairFoundException.class)
    public void givenNotExistingCurrenciesPair_WhenGetRateIsCalled_ThenNoCurrenciesPairFoundExceptionIsThrown() throws Exception {
        exchange.getRate(new CurrenciesPair("XXX", "YYY"));
    }
    
    @Test
    public void givenTheSameCurrenciesPair_WhenCheckedForEquality_ThenTrueIsReturned()
    {
    	CurrenciesPair expectedPair = new CurrenciesPair("PLN", "CHF");
    	
    	assertEquals(expectedPair, new CurrenciesPair("PLN", "CHF"));
    	
    }
    
    @Test
    public void givenDifferentCurrenciesPairs_WhenCheckedForEquality_FalseIsReturned()
    {
    	CurrenciesPair expectedPair = new CurrenciesPair("PLN", "CHF");
    	
    	assertNotEquals(expectedPair, new CurrenciesPair("CHF", "PLN"));
    	
    }
    @Test
    public void given2DifferentCurrenciesPairs_WhenCheckedForEquality_FalseIsReturned()
    {
    	CurrenciesPair expectedPair = new CurrenciesPair("CHF", "CHF");
    	
    	assertNotEquals(expectedPair, new CurrenciesPair("CHF", "PLN"));  	
    	assertNotEquals(expectedPair, new CurrenciesPair("PLN", "CHF"));  	
    }
    
     
    @Test
    public void givenCurrencyPairAndOtherObject_WhenCheckedForEquality_FalseIsReturned()
    {
    	CurrenciesPair expectedPair = new CurrenciesPair("PLN", "CHF");
    	
    	assertNotEquals(expectedPair, new Object());
    	
    }
    
    @Test
    public void given5CurrencyPairAndOtherObject_WhenCheckedForEquality_FalseIsReturned()
    {
    	CurrenciesPair expectedPair = new CurrenciesPair("PLN", "CHF");
    	
    	assertNotEquals(expectedPair, new Object());
    	
    } 
    
}