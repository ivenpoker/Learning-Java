// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 3.15 from book.                       #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 24/05/2019                                                 #
// #                                                                                  #
// ####################################################################################

package books.JavaHowToProgram10Ed.chapter_3.Exercise_3_15;

public class Account {

    private String _name;
    private double _balance;

    public Account(String _name, double _balance) {
        this._name = _name;
        if (_balance > 0.0)
            this._balance = _balance;
    }
    public void deposit(double _depositAmount) {
        if (_depositAmount > 0.0)
            this._balance = _depositAmount;
    }
    public double getBalance() {
        return this._balance;
    }
    public void setName(String _newName) {
        this._name = _newName;
    }
    public String getName() {
        return this._name;
    }
}
