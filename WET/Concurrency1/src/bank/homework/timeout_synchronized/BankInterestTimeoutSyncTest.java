package bank.homework.timeout_synchronized;

public class BankInterestTimeoutSyncTest {

        public static final int NACCOUNTS = 100;
        public static final double INITIAL_BALANCE = 1000;
        public static final double MAX_AMOUNT = 1000;
        public static final int DELAY = 100;
        public static final double REQUIRED_FUNDS = 600;
        public static final long TIMEOUT_IN_MILLISECONDS = 2000;

        public static void main(String[] args)
        {
            BankInterestTimeoutSync bank = new BankInterestTimeoutSync(NACCOUNTS, INITIAL_BALANCE);
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
                            Thread.sleep(DELAY);
                        }
                    }
                    catch (InterruptedException e)
                    {
                    }
                };
                Thread t = new Thread(r);
                t.start();

                Runnable r2 = () -> {
                    try
                    {
                        while (true)
                        {
                            int account = (int) (bank.size() * Math.random());
                            double interestRate = (double)(10 * Math.random());
                            bank.addInterest(account, interestRate, REQUIRED_FUNDS, TIMEOUT_IN_MILLISECONDS);
                            Thread.sleep(DELAY);
                        }
                    }
                    catch (InterruptedException e)
                    {
                    }
                };
                Thread t2 = new Thread(r2);
                t2.start();
            }
        }

    }

