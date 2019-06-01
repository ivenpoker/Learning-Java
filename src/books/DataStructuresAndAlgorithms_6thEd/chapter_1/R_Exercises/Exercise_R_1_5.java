// #############################################################################
// #                                                                           #
// #      Program purpose: Solution to Exercise R.1.5 in Book                  #
// #      Program author : Happi Yvan <ivensteinpoker@gmail.com>               #
// #      Program Date   : 1/06/2019                                           #
// #                                                                           #
// #############################################################################


package books.DataStructuresAndAlgorithms_6thEd.chapter_1.R_Exercises;

import java.util.Scanner;

public class Exercise_R_1_5 {

    public static long computeSum(int someVal) {
        long resp = 0;
        for (int i = 0; i <= someVal; i++)
            resp += i;
        return resp;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.printf("Enter some integer val: ");
        int intVal = input.nextInt();

        System.out.printf("Sum of all positives <= %d: %d\n",
                intVal, Exercise_R_1_5.computeSum(intVal));
    }
}
