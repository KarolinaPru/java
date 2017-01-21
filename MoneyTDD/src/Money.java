import exceptions.NoCurrenciesPairFoundException;

class Money {

    private final int amount;
    private final String currency;
    private Exchange exchange;

    public Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public Money(int amount, String currency, Exchange exchange) {

        this.amount = amount;
        this.currency = currency;
        this.exchange = exchange;
    }

    public int getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    public Money add(Money m) throws NoCurrenciesPairFoundException {
        if(!m.getCurrency().equals(getCurrency()))
        {
            CurrenciesPair conversionPair = new CurrenciesPair(this.getCurrency(), m.getCurrency());
            Money convertedAmount = exchange.convert(this.getAmount(), conversionPair);

            int addedAmount = convertedAmount.getAmount() + m.getAmount();
            return new Money(addedAmount, convertedAmount.getCurrency());
        }
        return new Money(getAmount() + m.getAmount(), getCurrency());
    }

    public Money subtract(Money m) throws NoCurrenciesPairFoundException {
        if(!m.getCurrency().equals(getCurrency()))
        {
            CurrenciesPair conversionPair = new CurrenciesPair(this.getCurrency(), m.getCurrency());
            Money convertedAmount = exchange.convert(this.getAmount(), conversionPair);

            int subtractedAmount = convertedAmount.getAmount() - m.getAmount();
            return new Money(subtractedAmount, convertedAmount.getCurrency());
        }

        return new Money(getAmount() - m.getAmount(), getCurrency());
    }

    public Money multiply(int multiplyBy)
    {
        return new Money (getAmount() * multiplyBy, getCurrency());
    }


    public static Money produce(int amount, String currency) {

        Exchange exchange = new Exchange(RateConfigurator.configureRatesMap());

        return new Money(amount, currency, exchange);
    }

    @Override
    public boolean equals(Object anObject) {
        if (anObject instanceof Money) {
            Money a = (Money) anObject;

            return a.getCurrency().equals(getCurrency()) && getAmount() == a.getAmount();
        }
        return false;
    }
}