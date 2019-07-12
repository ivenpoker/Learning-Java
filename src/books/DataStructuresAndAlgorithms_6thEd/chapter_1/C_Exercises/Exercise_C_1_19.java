// #############################################################################
// #                                                                           #
// #      Program purpose: Solution to Exercise C.1.19 in Book                 #
// #      Program author : Happi Yvan <ivensteinpoker@gmail.com>               #
// #      Program Date   : 1/06/2019                                           #
// #                                                                           #
// #############################################################################

package books.DataStructuresAndAlgorithms_6thEd.chapter_1.C_Exercises;

import java.util.Scanner;

public class Exercise_C_1_19 {

    public static int numberOfTimesBeforeLessThanTwo(int someVal) {
        if (someVal < 2)
            return 0;
        int cnt = 0;
        while (someVal > 2) {
            someVal /= 2;
            cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter test integer value: ");
        int someInt = input.nextInt();

        System.out.printf("Number of times before less than 2: %d\n",
                numberOfTimesBeforeLessThanTwo(someInt));
    }
}
