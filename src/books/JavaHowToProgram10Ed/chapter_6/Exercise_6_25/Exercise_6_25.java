// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 6.25 from book.                       #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 07/06/2019                                                 #
// #                                                                                  #
// ####################################################################################

package books.JavaHowToProgram10Ed.chapter_6.Exercise_6_25;

public class Exercise_6_25 {

    private static int countFactors(int val) {
        int cnt = 0;
        for (int i = 1; i <= val/2; i++)
            if (val % i == 0)
                cnt++;
        return cnt + 1;

    }

    private static boolean isPrime(int val) {
        return countFactors(val) == 2;
    }

    public static void main(String[] args) {
        for (int i = 1, j = 0; i < 10000; i++) {
            if (isPrime(i)) {
                System.out.printf("[#%04d prime number:%4d]%4s", j++, i,
                        (j % 5 == 0 ? "\n" : ""));
            }
        }
    }
}
