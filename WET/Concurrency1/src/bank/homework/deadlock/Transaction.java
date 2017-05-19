package bank.homework.deadlock;

public class Transaction {
    private final int from;
    private final int to;
    private final double amount;

    public Transaction(int from, int to, double amount) {

        this.from = from;
        this.to = to;
        this.amount = amount;
    }

    public void transfer(int from, int to, double amount) {
        from -= amount;
        to += amount;
    }
    public int getFrom() {
        return from;
    }

    public int getTo() {
        return to;
    }

    public double getAmount() {
        return amount;
    }
}
