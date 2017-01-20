class Money {

    private int amount;
    private String currency;

    public Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public int getAmount() {
        return amount;
    }

    public static Money franc(int amount)
    {
        return new Money(amount, "CHF");
    }

    public static Money zloty (int amount)
    {
        return new Money(amount, "PLN");
    }

    public String getCurrency() {
        return currency;
    }


    public Money add(Money m) {
        if(!m.getCurrency().equals(getCurrency()))
        {
            throw new IllegalArgumentException("Currencies don't match.");
        }
        return new Money(getAmount() + m.getAmount(), getCurrency());
    }

    public Money multiply(int multiplyBy)
    {
        return new Money (getAmount() * multiplyBy, getCurrency());
    }

    //TODO:
//	public Money addDifferentCurrencies(Money targetCurrency, Money otherCurrency, int rate)
//	{
//		return new Money ()
//	}

    public boolean equals(Object anObject) {
        if (anObject instanceof Money) {
            Money a = (Money) anObject;

            return a.getCurrency().equals(getCurrency()) && getAmount() == a.getAmount();
        }
        return false;

    }

}