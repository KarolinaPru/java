package src.Tests;

import exceptions.NoCurrenciesPairFoundException;
import src.Currency;
import src.Exchange;
import src.Money;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class MoneyTest {
    private Money m12CHF;
    private Money m14CHF;
    private Money m10PLN;
    private Money m10CHF;

    @Before
    public void setUp() throws Exception {
        m12CHF = Money.produce(12, Currency.CHF);
        m14CHF = Money.produce(14, Currency.CHF);
        m10PLN = Money.produce(10, Currency.PLN);
        m10CHF = Money.produce(10, Currency.CHF);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testSimpleAdd2() throws NoCurrenciesPairFoundException {
        Money expected = Money.produce(26, Currency.CHF);
        Money result = m12CHF.add(m14CHF);
        assertTrue(expected.equals(result));
    }

    @Test
    public void testEquals2() {
        assertEquals(m12CHF, m12CHF);
        assertNotEquals(m12CHF, null);
        assertEquals(m12CHF, Money.produce(12, Currency.CHF));
        assertEquals(m10PLN, new Money(10, "PLN", new Exchange(null)));
        assertNotEquals(m12CHF, m14CHF);
    }

    @Test
    public void givenMoney_WhenGettingCurrency_ThenAppropriateStringShouldBeReturned() {
        assertEquals(Currency.CHF, Money.produce(1, Currency.CHF).getCurrency());
        assertEquals(Currency.PLN, Money.produce(1, Currency.PLN).getCurrency());
    }

    @Test
    public void givenMoneyFromFactory_WhenCheckedForEqualityWithCorrespondingAmount_ThenResultIsTrue()
    {
        assertTrue(Money.produce(1, Currency.PLN).equals(Money.produce(1, Currency.PLN)));
        assertEquals(Money.produce(12, Currency.CHF), m12CHF);
    }

    @Test
    public void givenAmountIs12_WhenMultipliedBy2_ThenResultShouldBe14()
    {
        Money expected = Money.produce(24, Currency.CHF);
        Money result = m12CHF.multiply(2);
        assertTrue(expected.equals(result));
    }

    @Test
    public void givenAmountIs14_WhenMultipliedByO_ThenResultShouldEqual0()
    {
        Money expected = Money.produce(0, Currency.CHF);
        Money result = m14CHF.multiply(0);
        assertEquals(expected, result);
    }

    @Test
    public void given10PLNAnd10CHF_WhenCheckedForEquality_ThenResultShouldBeFalse()
    {
        assertFalse(m10PLN.equals(m10CHF));
    }

    @Test
    public void given4PLN_When2PLNSubtracted_Then2ShouldBeReturned() throws Exception
    {
        Money m4PLN = Money.produce(4, Currency.PLN);
        Money m2PLN = Money.produce(2, Currency.PLN);

        Money result = m4PLN.subtract(m2PLN);

        assertEquals(m2PLN, result);
    }

    @Test
    public void givenFourPLNAndOneCHF_WhenAdding_AndRateIsOneToFour_ThenTwoCHFShouldBeReturned() throws Exception {
        Money expectedResult = Money.produce(2, Currency.CHF);
        Money m4PLN = Money.produce(4, Currency.PLN);
        Money m1CHF = Money.produce(1, Currency.CHF);


        assertEquals(expectedResult, m4PLN.add(m1CHF));
    }

    @Test
    public void givenOneCHFAndFourPLN_WhenSubtracting_AndRateIsFourToOne_ThenZeroPLNShouldBeReturned() throws Exception {
        Money expectedResult = Money.produce(0, Currency.PLN);
        Money m1CHF = Money.produce(1, Currency.CHF);
        Money m4PLN = Money.produce(4, Currency.PLN);

        Money returnedResult = m1CHF.subtract(m4PLN);

        assertEquals(expectedResult, returnedResult);
    }
}