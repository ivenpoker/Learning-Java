// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 8.6 from book.                        #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 14/06/2019                                                 #
// #                                                                                  #
// ####################################################################################

package books.JavaHowToProgram10Ed.chapter_8.Exercise.Exercise_8_6;

public class Exercise_8_6 {

    public static void main(String[] args) {
        SavingsAccount saver1 = new SavingsAccount(2000.00);
        SavingsAccount saver2 = new SavingsAccount(3000.00);

        SavingsAccount.modifyInterestRate(4.0 / 100);

        System.out.printf("%s%20s%20s\n", "Month", "Saver 1", "Saver 2");
        for (int i = 1; i <= 12; i++) {
            System.out.printf("%2d%24s%24s\n", i, String.format("$%.2f", saver1.getBalance()),
                    String.format("$%.2f", saver2.getBalance()));
            saver1.calculateMonthlyInterest();
            saver2.calculateMonthlyInterest();
        }

        SavingsAccount.modifyInterestRate(5.0 / 100);
        saver1.calculateMonthlyInterest();
        saver2.calculateMonthlyInterest();

        System.out.println();

        System.out.printf("Save 1 new balance: $%.2f\n", saver1.getBalance());
        System.out.printf("Save 2 new balance: $%.2f\n", saver2.getBalance());
    }
}
