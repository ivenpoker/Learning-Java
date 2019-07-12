// #############################################################################
// #                                                                           #
// #      Program purpose: Solution to Exercise C.1.21 in Book                 #
// #      Program author : Happi Yvan <ivensteinpoker@gmail.com>               #
// #      Program Date   : 3/06/2019                                           #
// #                                                                           #
// #############################################################################

package books.DataStructuresAndAlgorithms_6thEd.chapter_1.C_Exercises;

import java.util.Collections;
import java.util.LinkedList;
import java.security.SecureRandom;
import java.util.List;

public class Exercise_C_1_21 {

    private static SecureRandom random = new SecureRandom();

    public static void randomFill(List<Integer> list, int low, int high, int max) {
        for (int i = 0; i < max; i++)
            list.add(low + random.nextInt(high));
    }

    public static void shuffleAndPrint(List<Integer> list, int maxTimes) {
        for (int i = 0; i < maxTimes; i++) {
            Collections.shuffle(list);
            System.out.printf("Shuffle #%02d: ", (i+1));
            for (Integer val : list)
                System.out.printf("%02d ", val);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();

        randomFill(list, 1, 52, 10);

        shuffleAndPrint(list, 10);
    }
}
