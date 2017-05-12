package bank.homework.deadlock;

import java.util.Arrays;

public class BankDeadlock {
    private final double[] accounts;

    public BankDeadlock(int n, double initialBalance) {
        accounts = new double[n];

        Arrays.fill(accounts, initialBalance);
    }

    public void transfer(Transaction transaction) {
        int from = transaction.getFrom();
        int to = transaction.getTo();
        double amount = transaction.getAmount();

        if (accounts[from] >= amount) {
            transaction.transfer(from, to, amount);
            System.out.println("Transfer from " + from + " to " + to + " amount " + amount + ". Total Balance: " + getTotalBalance());
        } else {
            System.out.println("Account number " + from + " has insufficient funds.");
        }
    }

    public double getTotalBalance() {
        try {
            double sum = 0;

            for (double a : accounts)
                sum += a;

            return sum;
        } finally {
        }
    }

    public int size() {
        return accounts.length;
    }
}
