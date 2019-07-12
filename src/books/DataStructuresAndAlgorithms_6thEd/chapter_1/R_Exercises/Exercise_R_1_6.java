// #############################################################################
// #                                                                           #
// #      Program purpose: Solution to Exercise R.1.6 in Book                  #
// #      Program author : Happi Yvan <ivensteinpoker@gmail.com>               #
// #      Program Date   : 1/06/2019                                           #
// #                                                                           #
// #############################################################################

package books.DataStructuresAndAlgorithms_6thEd.chapter_1.R_Exercises;

import java.util.Scanner;

public class Exercise_R_1_6 {

    public static boolean isEven(int someVal) {
        return someVal % 2 == 0;
    }

    public static long computeOddSum(int someVal) {
        long sum = 0;
        for (int i = 0; i <= someVal; i++)
            if (!Exercise_R_1_6.isEven(i))
                sum += i;
        return sum;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.printf("Enter max integer: ");
        int val = input.nextInt();

        System.out.printf("Sum of all odd integers <= %d: %d",
                val, Exercise_R_1_6.computeOddSum(val));
    }
}
