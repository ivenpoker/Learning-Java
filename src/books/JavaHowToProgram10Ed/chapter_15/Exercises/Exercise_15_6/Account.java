package books.JavaHowToProgram10Ed.chapter_15.Exercises.Exercise_15_6;

import java.io.Serializable;
import java.util.Objects;

public class Account implements Comparable<Account>, Serializable {

    private int accountNum;
    private String firstName;
    private String lastName;
    private double balance;

    public Account() {
        this(0, "", "", 0.0);
    }

    public Account(int accountNum, String firstName,
                   String lastName, double balance) {

    }

    // SETTERS METHODS

    public void setAccount(int newAcct) {
        if (newAcct < 0) {
            throw new IllegalArgumentException("Invalid account number. Must be positive");
        }
        this.accountNum = newAcct;
    }

    public void setFirstName(String newFirstName) {
        if (Objects.isNull(newFirstName)) {
            throw new NullPointerException("Account first cannot be 'null'");
        }
        this.firstName = newFirstName;
    }

    public void setLastName(String newLastName) {
        if (Objects.isNull(newLastName)) {
            throw new NullPointerException("Account last name cannot be 'null'");
        }
        this.lastName = newLastName;
    }

    public void setBalance(double newBalance) {
        this.balance = balance;
    }

    // GETTERS METHODS

    public int getAccount() {
        return this.accountNum;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public double getBalance() {
        return this.balance;
    }

    // HELPER METHODS

    public void combine(TransactionRecord transRec) {
        this.balance += transRec.getTransactionAmount();
    }

    @Override
    public int compareTo(Account other) {
        return this.accountNum - other.accountNum;
    }

    @Override
    public String toString() {
        return String.format("Account #%d -- [%s %s]", this.getAccount(),
                this.getFirstName(), this.getLastName());
    }
}
