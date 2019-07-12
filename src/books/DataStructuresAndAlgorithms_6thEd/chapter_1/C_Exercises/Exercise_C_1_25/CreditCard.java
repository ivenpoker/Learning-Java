// #############################################################################
// #                                                                           #
// #      Program purpose: Solution to Exercise R.1.13 in Book                 #
// #      Program author : Happi Yvan <ivensteinpoker@gmail.com>               #
// #      Program Date   : 1/06/2019                                           #
// #                                                                           #
// #############################################################################

package books.DataStructuresAndAlgorithms_6thEd.chapter_1.C_Exercises.Exercise_C_1_25;

public class CreditCard {
    private String _customer;
    private String _bank;
    private String _account;
    private int _limit;
    protected double _balance;

    public CreditCard(String customer, String bank, String account, int lim,
                      double initialBalance) {
        this._account = account;
        this._bank = bank;
        this._account = account;
        this._limit = lim;
        this._balance = initialBalance;
    }

    public CreditCard(String customer, String bank, String account, int lim) {
        this(customer, bank, account, lim, 0.0);
    }

    public String getCustomer() {
        return this._customer;
    }

    public String getBank() {
        return this._bank;
    }

    public String getAccount() {
        return this._account;
    }

    public int getLimit() {
        return this._limit;
    }

    public double getBalance() {
        return this._balance;
    }

    public boolean charge(double price) {
        if (price + this._balance > this._limit)
            return false;
        this._balance += price;
        return true;
    }

    public void makePayment(double amount) {
        this._balance -= amount;
    }

    public void printSummary() {
        System.out.printf("Customer = %s\n", this._customer);
        System.out.printf("Bank = %s\n", this._bank);
        System.out.printf("Account = %s\n", this._account);
        System.out.printf("Balance = %s\n", this._balance);
        System.out.printf("Limit = %s\n", this._limit);
    }

    public String toString() {
        return String.format("Customer = %s\n", this._customer) +
                String.format("Bank = %s\n", this._bank) +
                String.format("Account = %s\n", this._account) +
                String.format("Balance = %s\n", this._balance) +
                String.format("Limit = %s\n", this._limit);
    }
}