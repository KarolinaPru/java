package bank.homework;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by karol on 11.05.2017.
 */
public class BankInterestTimeout {
    private final double[] accounts;
    private Lock bankLock;
    private Condition sufficientFunds;
    private Condition minimumBalance;

    public BankInterestTimeout(int n, double initialBalance) {
        accounts = new double[n];
        Arrays.fill(accounts, initialBalance);
        bankLock = new ReentrantLock();
        sufficientFunds = bankLock.newCondition();
        minimumBalance = bankLock.newCondition();
    }

    public void transfer(int from, int to, double amount, long timeout) throws InterruptedException
    {
        bankLock.lock();
        try
        {
            while (accounts[from] < amount) {
                System.out.println("Account no " + from + " has insufficient funds. Waiting for transfer.");
                sufficientFunds.await(timeout, TimeUnit.MILLISECONDS);
            }
            System.out.print(Thread.currentThread());
            accounts[from] -= amount;
            System.out.printf(" %10.2f from %d to %d", amount, from, to);

            accounts[to] += amount;
            System.out.printf(" Total Balance: %10.2f%n", getTotalBalance());

            minimumBalance.signalAll();
            sufficientFunds.signalAll();
        }
        finally
        {
            bankLock.unlock();
        }
    }

    public void addInterest(int account, double interestRate, double requiredFunds, long timeout) throws InterruptedException {
        bankLock.lock();
        try {
            while (accounts[account] < requiredFunds) {
                System.out.print("Account " + account + ": minimum balance is not reached. Current funds: " + accounts[account] + " ");
                System.out.println("Waiting " + timeout + " milliseconds.");

                minimumBalance.await(timeout, TimeUnit.MILLISECONDS);
            }
            System.out.println("Account number: " + account + " Amount before: " + accounts[account]);
            accounts[account] += interestRate / 100;
            System.out.println("Amount after: " + accounts[account] + " at " + interestRate/100 + "%");

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
