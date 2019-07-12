// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 8.6 from book.                        #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 14/06/2019                                                 #
// #                                                                                  #
// ####################################################################################

package books.JavaHowToProgram10Ed.chapter_8.Exercise.Exercise_8_6;

public class SavingsAccount {

    public static double annualInterestRate = 12.0;
    private double _savingsBalance;

    public SavingsAccount(double amountOnDeposite) {
        if (amountOnDeposite < 0.0)
            throw new IllegalArgumentException("Invalid initial deposite amount");
        this._savingsBalance = amountOnDeposite;
    }

    public double calculateMonthlyInterest() {
        double val =  (this._savingsBalance * SavingsAccount.annualInterestRate) / 12;
        this._savingsBalance += val;
        return val;
    }

    public double getBalance() {
        return this._savingsBalance;
    }

    public static void modifyInterestRate(double newRate) {
        SavingsAccount.annualInterestRate = newRate;
    }
}
