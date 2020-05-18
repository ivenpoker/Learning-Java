// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 7.14 from book.                       #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 10/06/2019                                                 #
// #                                                                                  #
// ####################################################################################

package books.JavaHowToProgram10Ed.chapter_7.Exercise_7_14;

import java.security.SecureRandom;

public class Exercise_7_14 {

    private static SecureRandom random = new SecureRandom();

    private static void randomFill(int[] mainData, int low, int upper) {
        for (int i = 0; i < mainData.length; i++)
            mainData[i] = low + random.nextInt(upper);
    }

    private static long product(int... someData) {
        int prod = 1;
        for (int data : someData)
            prod *= data;
        return prod;
    }

    private static void printData(String mess, int[] someData) {
        System.out.printf("%s", mess);
        int cnt = 0;
        for (int someDatum : someData)
            System.out.printf("%d%s", someDatum,
                    (cnt++ == someData.length - 1) ? "\n" : " ");
    }

    public static void main(String[] args) {
        int[] dataA = new int[10];
        int[] dataB = new int[5];
        int[] dataC = new int[15];

        randomFill(dataA,1, 20);
        randomFill(dataB,1, 20);
        randomFill(dataC,1, 20);

        printData("Data A: ", dataA);
        printData("Data B: ", dataB);
        printData("Data C: ", dataC);

        System.out.printf("Product of A: %d\n", product(dataA));
        System.out.printf("Product of B: %d\n", product(dataB));
        System.out.printf("Product of C: %d\n", product(dataC));

    }
}
