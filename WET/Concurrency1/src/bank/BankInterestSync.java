package bank;

import java.util.*;
import java.util.concurrent.locks.*;

public class BankInterestSync {

	private final double[] accounts;
	private Lock bankLock;
	private Condition sufficientFunds;

	public BankInterestSync(int n, double initialBalance) {
		accounts = new double[n];
		Arrays.fill(accounts, initialBalance);
		bankLock = new ReentrantLock();
		sufficientFunds = bankLock.newCondition();

	}

	public synchronized void transfer(int from, int to, double amount) throws InterruptedException {
		while (accounts[from] < amount)
			wait();
		System.out.print(Thread.currentThread());
		accounts[from] -= amount;
		System.out.printf(" %10.2f from %d to %d", amount, from, to);
		accounts[to] += amount;
		System.out.printf(" Total Balance: %10.2f%n", getTotalBalance());
		notifyAll();
	}

	public synchronized void addInterest(int account, double interestRate) {
		System.out.println("Account number: " + account + " Amount before: " + accounts[account]);
		accounts[account] += interestRate / 100;
		System.out.println("Account number: " + account + " Amount after: " + accounts[account]);
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
