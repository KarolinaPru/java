package bank.homework;

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.*;
import java.util.concurrent.locks.*;

public class BankInterestSync2 {

    private final double[] accounts;
    private Lock bankLock;


    public BankInterestSync2(int n, double initialBalance) {
        accounts = new double[n];
        Arrays.fill(accounts, initialBalance);
        bankLock = new ReentrantLock();
    }

    public synchronized void transfer(int from, int to, double amount) throws InterruptedException {
        while (accounts[from] < amount) {
            wait();
        }
        System.out.print(Thread.currentThread());
        accounts[from] -= amount;
        System.out.printf(" %10.2f from %d to %d", amount, from, to);
        accounts[to] += amount;
        System.out.printf(" Total Balance: %10.2f%n", getTotalBalance());
        notifyAll();
    }

    public synchronized void addInterest(int account, double interestRate, double requiredFunds) throws InterruptedException {


        while(accounts[account] < requiredFunds) {
            System.out.println("Account " + account + ": minimum balance is not reached. Current funds: " + accounts[account]);
            wait();
        }

        double currentBalance =  accounts[account];
        System.out.println("Account number: " + account + " Amount before: " + currentBalance);
        currentBalance += currentBalance * interestRate / 100;
        System.out.println("Amount after: " + currentBalance + " at " + interestRate/100 + "%");
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
