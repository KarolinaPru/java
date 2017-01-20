import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class MoneyTest {
    private Money m12CHF;
    private Money m14CHF;
    private Money m10PLN;
    private Money m10CHF;

    @Before
    public void setUp() throws Exception {
        m12CHF = new Money(12, "CHF");
        m14CHF = new Money(14, "CHF");
        m10PLN = new Money(10, "PLN");
        m10CHF = new Money(10, "CHF");
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testSimpleAdd2() {
        Money expected = new Money(26, "CHF");
        Money result = m12CHF.add(m14CHF);
        assertTrue(expected.equals(result));
    }

    @Test
    public void testEquals2() {
        assertTrue(!m12CHF.equals(null));
        assertEquals(m12CHF, m12CHF);
        assertEquals(m12CHF, new Money(12, "CHF"));
        assertTrue(!m12CHF.equals(m14CHF));
    }

    @Test
    public void givenMoney_WhenGettingCurrency_ThenAppropriateStringShouldBeReturned() {
        assertEquals("CHF", Money.franc(1).getCurrency());
        assertEquals("PLN", Money.zloty(1).getCurrency());
    }

    @Test
    public void givenMoneyFromFactory_WhenCheckedForEqualityWithCorrespondingAmount_ThenResultIsTrue()
    {
        assertTrue(Money.zloty(1).equals(new Money(1, "PLN")));
        assertEquals(Money.franc(12), m12CHF);
    }

    @Test
    public void givenAmountIs12_WhenMultipliedBy2_ThenResultShouldBe14()
    {
        Money expected = new Money(24, "CHF");
        Money result = m12CHF.multiply(2);
        assertTrue(expected.equals(result));
    }

    @Test
    public void givenAmountIs14_WhenMultipliedByO_ThenResultShouldEqual0()
    {
        Money expected = new Money(0, "CHF");
        Money result = m14CHF.multiply(0);
        assertEquals(expected, result);
    }

    @Test
    public void given10PLNAnd10CHF_WhenCheckedForEquality_ThenResultShouldBeFalse()
    {
        assertFalse(m10PLN.equals(m10CHF));
    }

    @Test (expected = IllegalArgumentException.class)
    public void given2DifferentCurrencies_WhenAdding_ThenExceptionShouldBeThrown() throws IllegalArgumentException
    {
        // Jak tu dodamy coś, co się da dodać, to będzie czerwono, bo expected exception
        m12CHF.add(m10PLN);

    }
    @Test
    public void given4PLNAnd1CHF_WhenAdded_ThenSumShouldBe5PLN()
    {
        Exchange.exchangeRate("CHF", "PLN", 4);
        assertEquals(Money.zloty(4).add(Money.franc(1)), Money.zloty(5));
    }


}
