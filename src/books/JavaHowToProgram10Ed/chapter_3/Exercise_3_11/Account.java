// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 3.11 from book.                        #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 24/05/2019                                                 #
// #                                                                                  #
// ####################################################################################

package books.JavaHowToProgram10Ed.chapter_3.Exercise_3_11;

public class Account {
    private String _name;
    private double _balance;

    public Account(String _name, double _balance) {
        this._name = _name;
        if (_balance  > 0.0)
            this._balance = _balance;
    }

    public void deposite(double _depositeAmount) {
        if (_depositeAmount > 0.0)
            this._balance = _balance + _depositeAmount;
    }

    public double getBalance() {
        return this._balance;
    }

    public double withDraw(double _withDrawAmount) {
        if (_withDrawAmount > this._balance) {
            System.out.println("\nWithdrawal amount exceeded account balance");
            return 0.0;
        } else {
            this._balance = this._balance - _withDrawAmount;
            return _withDrawAmount;
        }
    }

    public void setName(String _newName) {
        this._name = _newName;
    }

    public String getName() {
        return this._name;
    }
}
