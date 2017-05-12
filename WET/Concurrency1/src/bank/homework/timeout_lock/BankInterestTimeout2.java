package bank.homework.timeout_lock;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankInterestTimeout2 {
    private final double[] accounts;
    private Lock bankLock;
    private Condition sufficientFunds;

    public BankInterestTimeout2(int n, double initialBalance) {
        accounts = new double[n];
        Arrays.fill(accounts, initialBalance);
        bankLock = new ReentrantLock();
        sufficientFunds = bankLock.newCondition();
    }

    public void transfer(int from, int to, double amount, long timeout) throws InterruptedException {
        long currentThread = Thread.currentThread().getId();
        if (bankLock.tryLock(200, TimeUnit.MILLISECONDS)) {
            try {
                while (accounts[from] < amount) {
                    System.out.println("Thread " + currentThread + "Account no " + from + " has insufficient funds. Waiting for transfer.");

                    boolean timedOut = sufficientFunds.await(timeout, TimeUnit.MILLISECONDS);
                    if (timedOut)
                        System.out.println("Thread " + currentThread + " timed out on transfer.");
                }
                System.out.print("Thread " + currentThread);
                accounts[from] -= amount;
                System.out.printf(" %10.2f from %d to %d", amount, from, to);

                accounts[to] += amount;
                System.out.printf(" Total Balance: %10.2f%n", getTotalBalance());

                sufficientFunds.signalAll();

            } finally {
                bankLock.unlock();
            }
        } else {
            System.out.println("Thread " + currentThread + ": lock not acquired on transfer.");
        }
    }

    public void addInterest(int account, double interestRate, double requiredFunds, long timeout) throws InterruptedException {
        double currentBalance = accounts[account];
        long currentThread = Thread.currentThread().getId();

        if (bankLock.tryLock(200, TimeUnit.MILLISECONDS)) {
            try {
                while (currentBalance < requiredFunds) {
                    System.out.println("Thread " + currentThread + ": minimum balance is not reached. Current funds: " + currentBalance + " Waiting.");

                    boolean timedOut = sufficientFunds.await(timeout, TimeUnit.MILLISECONDS);
                    if (timedOut)
                        System.out.println("Thread " + currentThread + " timed out on interest.");
                }
                System.out.println("Account number: " + account + " Amount before: " + currentBalance);
                currentBalance += currentBalance * interestRate / 100;
                System.out.println("Amount after: " + currentBalance + " at " + interestRate / 100 + "%");

                sufficientFunds.signalAll();
            } finally {
                bankLock.unlock();
            }
        } else {
            System.out.println("Thread " + currentThread + ": lock not acquired on interest.");
        }
    }

    public double getTotalBalance() {
        bankLock.lock();
        try {
            double sum = 0;

            for (double a : accounts)
                sum += a;

            return sum;
        } finally {
            bankLock.unlock();
        }
    }

    public int size() {
        return accounts.length;
    }
}
