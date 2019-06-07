// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 6.24 from book.                       #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 07/06/2019                                                 #
// #                                                                                  #
// ####################################################################################

package books.JavaHowToProgram10Ed.chapter_6;

public class Exercise_6_24 {

    private static boolean isPerfect(int numVal) {
        int sum = 0;
        for (int i = 1; i <= numVal/2; i++)
            if (numVal % i == 0)
                sum += i;
        return sum == numVal;
    }

    private static String stringFactors(int numVal) {
        String str = "";
        for (int i = 1; i <= numVal/2; i++) {
            if (numVal % i == 0) {
                if (i == 1) {
                    str += i;
                } else {
                    str += " + " + i;
                }
            }
        }
        return str;
    }

    public static void main(String[] args) {
        for (int i = 1, j = 1; i < 1000; i++) {
            if (isPerfect(i)) {
                System.out.printf("[#%d]: %d --> %s\n", j++, i, stringFactors(i));
            }
        }
    }
}
