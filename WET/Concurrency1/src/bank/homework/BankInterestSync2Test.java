package bank.homework;

import bank.homework.BankInterestSync2;

public class BankInterestSync2Test {

    public static final int NACCOUNTS = 100;
    public static final double INITIAL_BALANCE = 1000;
    public static final double MAX_AMOUNT = 1000;
    public static final int DELAY = 10;
    public static final double REQUIRED_FUNDS = 800;

    public static void main(String[] args)
    {
        BankInterestSync2 bank = new BankInterestSync2(NACCOUNTS, INITIAL_BALANCE);
        for (int i = 0; i < NACCOUNTS; i++)
        {
            int fromAccount = i;
            Runnable r = () -> {
                try
                {
                    while (true)
                    {
                        int toAccount = (int) (bank.size() * Math.random());
                        double amount = MAX_AMOUNT * Math.random();
                        bank.transfer(fromAccount, toAccount, amount);
                        Thread.sleep((int) (DELAY * Math.random()));

                        double interestRate = (double)(10 * Math.random());
                        bank.addInterest(fromAccount, interestRate, REQUIRED_FUNDS);
                        Thread.sleep((int) (DELAY * Math.random()));
                    }
                }
                catch (InterruptedException e)
                {
                }
            };
            Thread t = new Thread(r);
            t.start();
        }
    }

}
