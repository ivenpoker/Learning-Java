// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 5.14 from book.                        #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 29/05/2019                                                 #
// #                                                                                  #
// ####################################################################################

package books.JavaHowToProgram10Ed.chapter_5;

public class Exercise_5_14 {

    public static void main(String[] args) {
        double amount;
        double principal = 1000.0;
        double rate = 0.05;

        for (int k = 5; k <= 10; k++) {
            System.out.printf("--------[ %d%% ]----------\n", k);
            System.out.printf("%s%20s%n", "Year", "Amount on deposit");
            for (int year = 1; year <= 10; ++year) {
                amount = principal * Math.pow(1.0  + ((double) k / 100), year);
                System.out.printf("%4d%,20.2f%n", year, amount);
            }
            System.out.println();
        }
    }

}
