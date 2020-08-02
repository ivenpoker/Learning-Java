package books.JavaHowToProgram10Ed.chapter_15.Exercises.Exercise_15_5;

import java.util.Objects;

public class Account implements Comparable<Account> {

    private int account;
    private String firstName;
    private String lastName;
    private double balance;

    public Account() {
        this(0, "", "", 0.0);
    }

    public Account(int account, String firstName,
                   String lastName, double balance) {
        this.setAccount(account);
        this.setBalance(balance);
        this.setFirstName(firstName);
        this.setLastName(lastName);
    }

    // SETTERS METHODS

    public void setAccount(int newAcct) {
        if (newAcct < 0) {
            throw new IllegalArgumentException("Invalid account number. Must be positive");
        }
        this.account = newAcct;
    }

    public void setFirstName(String newFirstName) {
        if (Objects.isNull(newFirstName)) {
            throw new NullPointerException("Account first name cannot be 'null'");
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
        this.balance = newBalance;
    }

    // GETTERS METHODS

    public int getAccount() {
        return this.account;
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
        this.balance =  transRec.getTransactionAmount() + this.getBalance();
    }

    @Override
    public int compareTo(Account other) {
        return this.account - other.account;
    }
}
