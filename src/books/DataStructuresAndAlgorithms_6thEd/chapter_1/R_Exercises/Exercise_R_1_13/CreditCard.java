// #############################################################################
// #                                                                           #
// #      Program purpose: Solution to Exercise R.1.13 in Book                 #
// #      Program author : Happi Yvan <ivensteinpoker@gmail.com>               #
// #      Program Date   : 1/06/2019                                           #
// #                                                                           #
// #############################################################################

package books.DataStructuresAndAlgorithms_6thEd.chapter_1.R_Exercises.Exercise_R_1_13;

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

    public static void printSummary(CreditCard card) {
        System.out.printf("Customer = %s\n", card._customer);
        System.out.printf("Bank = %s\n", card._bank);
        System.out.printf("Account = %s\n", card._account);
        System.out.printf("Balance = %s\n", card._balance);
        System.out.printf("Limit = %s\n", card._limit);
    }
}