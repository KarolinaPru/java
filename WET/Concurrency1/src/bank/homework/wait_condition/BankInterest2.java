package bank.homework.wait_condition;

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankInterest2 {
    private final double[] accounts;
    private Lock bankLock;
    private Condition sufficientFunds;
    private Condition minimumBalance;

    public BankInterest2(int n, double initialBalance) {
        accounts = new double[n];
        Arrays.fill(accounts, initialBalance);
        bankLock = new ReentrantLock();
        sufficientFunds = bankLock.newCondition();
    }

    /**
     * Transfers money from one account to another.
     * @param from the account to transfer from
     * @param to the account to transfer to
     * @param amount the amount to transfer
     */
    public void transfer(int from, int to, double amount) throws InterruptedException
    {
        bankLock.lock();
        try
        {
            while (accounts[from] < amount) {
                sufficientFunds.await();
            }
            System.out.print(Thread.currentThread());
            accounts[from] -= amount;
            System.out.printf(" %10.2f from %d to %d", amount, from, to);
            accounts[to] += amount;
            System.out.printf(" Total Balance: %10.2f%n", getTotalBalance());
            sufficientFunds.signalAll();
        }
        finally
        {
            bankLock.unlock();
        }
    }

    public void addInterest(int account, double interestRate, double requiredFunds) throws InterruptedException {
        bankLock.lock();
        try
        {
            while(accounts[account] < requiredFunds) {
                System.out.println("Account " + account + ": minimum balance is not reached. Current funds: " + accounts[account]);
                sufficientFunds.await();
            }
            double currentBalance =  accounts[account];
            System.out.println("Account number: " + account + " Amount before: " + currentBalance);
            currentBalance += currentBalance * interestRate / 100;
            System.out.println("Amount after: " + currentBalance + " at " + interestRate/100 + "%");

            sufficientFunds.signalAll();
        }
        finally
        {
            bankLock.unlock();

        }
    }

    public double getTotalBalance()
    {
        bankLock.lock();
        try
        {
            double sum = 0;

            for (double a : accounts)
                sum += a;

            return sum;
        }
        finally
        {
            bankLock.unlock();
        }
    }

    public int size()
    {
        return accounts.length;
    }

}
