// #############################################################################
// #                                                                           #
// #      Program purpose: Solution to Exercise C-2.17 in Book                 #
// #      Program author : Happi Yvan <ivensteinpoker@gmail.com>               #
// #      Program Date   : 4/06/2019                                           #
// #                                                                           #
// #############################################################################

package books.DataStructuresAndAlgorithms_6thEd.chapter_2.C_Exercises;

import java.security.SecureRandom;

public class Exercise_C_2_17 {

    public static void testMethod() {
        SecureRandom random = new SecureRandom();
        int val = random.nextInt(2);

        if (val > 3) {
            System.out.println("This will never be displayed as long.");
            System.out.println("This is due to the fact that the random");
            System.out.println("value produced by 'nextInt()' of the ");
            System.out.println("'random' instance variable is always < 2, as");
            System.out.println("2 is the upper bound");
        }
    }

    public static void main(String[] args) {
        testMethod();
    }
}
