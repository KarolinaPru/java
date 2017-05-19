package bank.homework.deadlock;

import java.util.concurrent.LinkedBlockingQueue;

public class BankDeadlockTest {
    private static LinkedBlockingQueue<Transaction> queue = new LinkedBlockingQueue();
    public static final int NACCOUNTS = 3;
    public static final double INITIAL_BALANCE = 1000;
    public static final double MAX_AMOUNT = 3000;	// przy większym limicie - zakleszczenie - z zewnątrz
    public static final int DELAY = 10;


    public static void main(String[] args) {
        BankDeadlock bank = new BankDeadlock(NACCOUNTS, INITIAL_BALANCE);
        for (int i = 0; i < NACCOUNTS; i++) {
            int fromAccount = i;
            Runnable r = () -> {
                try {
                    while (true) {
                        int toAccount = (int) (bank.size() * Math.random());
                        double amount = MAX_AMOUNT * Math.random();
                        queue.put(new Transaction(fromAccount, toAccount, amount));

                    }
                } catch (InterruptedException e) {

                }
            };
            Thread t = new Thread(r);
            t.start();

            Runnable r2 = () -> {
                try {
                    while (true) {
                        int toAccount = (int) (bank.size() * Math.random());
                        double amount = MAX_AMOUNT * Math.random();
                        bank.transfer(queue.take());
                    }
                } catch (InterruptedException e) {

                }
            };
            Thread t2 = new Thread(r2);
            t2.start();



        }
    }
}
