package books.JavaHowToProgram10Ed.chapter_15.Exercises.Exercise_15_5;

public class TransactionRecord implements Comparable<TransactionRecord> {

    private int accountNumber;
    private double transactionAmount;

    public TransactionRecord(int accountNumber, double transactionAmount) {
        this.setAccountNumber(accountNumber);
        this.setTransactionAmount(transactionAmount);
    }

    public int getAccountNumber() {
        return this.accountNumber;
    }

    public double getTransactionAmount() {
        return this.transactionAmount;
    }

    public void setAccountNumber(int newAccountNumber) {
        if (newAccountNumber < 0 ) {
            throw new IllegalArgumentException("Invalid account number. Must be positive.");
        }
        this.accountNumber = newAccountNumber;
    }

    public void setTransactionAmount(double newTransactionAmount) {
        if (newTransactionAmount < 0.0) {
            throw new IllegalArgumentException("Invalid transaction amount. Must be > 0");
        }
        this.transactionAmount = newTransactionAmount;
    }

    @Override
    public int compareTo(TransactionRecord otherTransRec) {
        return this.accountNumber - otherTransRec.accountNumber;
    }
}
