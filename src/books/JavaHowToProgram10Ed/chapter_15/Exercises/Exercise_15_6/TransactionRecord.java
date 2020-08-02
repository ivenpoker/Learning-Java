package books.JavaHowToProgram10Ed.chapter_15.Exercises.Exercise_15_6;

import java.io.Serializable;

public class TransactionRecord implements Comparable<TransactionRecord>, Serializable {

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
        if (newAccountNumber < 0) {
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
    public int compareTo(TransactionRecord other) {
        return this.accountNumber - other.accountNumber;
    }

    @Override
    public String toString() {
        return String.format("Transaction #%d -- [balance: %.2f]",
                this.getAccountNumber(), this.getTransactionAmount());
    }

}
