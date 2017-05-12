package bank.homework.timeout_synchronized;

import java.util.Arrays;

public class BankInterestTimeoutSync {
    private final double[] accounts;

    public BankInterestTimeoutSync(int numberOfAccounts, double initialBalance) {
        accounts = new double[numberOfAccounts];
        Arrays.fill(accounts, initialBalance);
    }

    public synchronized void transfer(int from, int to, double amount) throws InterruptedException {
        long currentThread = Thread.currentThread().getId();

        while (accounts[from] < amount) {
            System.out.println("Thread " + currentThread + " Account number " + from + " has insufficient funds. Waiting for transfer.");
            wait(100);
        }
        System.out.print("Thread " + currentThread);
        accounts[from] -= amount;
        System.out.printf(" %10.2f from %d to %d", amount, from, to);
        accounts[to] += amount;
        System.out.printf(" Total Balance: %10.2f%n", getTotalBalance());

        notifyAll();
    }

    public synchronized void addInterest(int account, double interestRate, double requiredFunds, long timeout) throws InterruptedException {
        long currentThread = Thread.currentThread().getId();

        while(accounts[account] < requiredFunds) {
            System.out.println("Thread " + currentThread + ": minimum balance is not reached. Current funds: " +accounts[account] + " Waiting " + timeout + " milliseconds.");
            wait(timeout);
        }
        System.out.println("Account number: " + account + " Amount before: " + accounts[account]);
        accounts[account] += accounts[account] * interestRate / 100;
        System.out.println("Amount after: " + accounts[account] + " at " + interestRate/100 + "%");

        notifyAll();
    }

    public synchronized double getTotalBalance() {
        double sum = 0;

        for (double a : accounts)
            sum += a;
        return sum;
    }

    /**
     * Gets the number of accounts in the bank.
     *
     * @return the number of accounts
     */
    public int size() {
        return accounts.length;
    }

}
