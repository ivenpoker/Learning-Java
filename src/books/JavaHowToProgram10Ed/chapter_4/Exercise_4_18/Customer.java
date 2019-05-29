// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 4.18 from book.                       #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 26/05/2019                                                 #
// #                                                                                  #
// ####################################################################################

package books.JavaHowToProgram10Ed.chapter_4.Exercise_4_18;

public class Customer {

    private String _accountNumber;
    private double _initialBalance;
    private int    _totalItemsCharged;
    private double _allowedCredit;

    public Customer(String _accountNumber, double _initialBalance,
                    int _totalItemsCharged, int _allowedCredit) {
        this._accountNumber = _accountNumber;
        this._initialBalance = _initialBalance;
        this._totalItemsCharged = _totalItemsCharged;
        this._allowedCredit = _allowedCredit;
    }

    public void setAllowedCredit(int _allowedCredit) {
        this._allowedCredit = _allowedCredit;
    }

    public void setNewBalance(double _newBalance) {
        this._initialBalance = _newBalance;
    }

    public double getAllowedCredit() {
        return this._allowedCredit;
    }

    public String getAccountNumber() {
        return this._accountNumber;
    }

    public double getInitialBalance() {
        return this._initialBalance;
    }

    public int getItemsChargedCount() {
        return this._totalItemsCharged;
    }

}
