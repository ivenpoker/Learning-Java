// #############################################################################
// #                                                                           #
// #      Program purpose: Solution to Exercise R-3.2 in Book                  #
// #      Program author : Happi Yvan <ivensteinpoker@gmail.com>               #
// #      Program Date   : 15/06/2019                                          #
// #                                                                           #
// #############################################################################

package books.DataStructuresAndAlgorithms_6thEd.chapter_3.R_Exercises;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exercise_R_3_2 {

    private static SecureRandom random = new SecureRandom();

    public static void main(String[] args) {

        Integer[] data = new Integer[10];
        for (int i = 0; i < data.length; i++)
            data[i] = random.nextInt(20);

        System.out.printf("Original data: %s\n", Arrays.toString(data));

        // removing the data randomly
        randomRemoveAll(data);
    }

    private static void randomRemoveAll(Integer[] someData) {
        List<Integer> tmp = new ArrayList<>();
        while (tmp.size() !=  someData.length) {
            int randInd = random.nextInt(someData.length);
            while (tmp.indexOf(randInd) >= 0)               // while this 'index' has already been processed.
                randInd = random.nextInt(someData.length);
            System.out.printf("Removing item at index '%d' .... ", randInd);
            tmp.add(randInd);
            someData[randInd] = null;  // 'removes' the item from the array.
            System.out.print("[DONE]\n");
        }
        System.out.print("All data has been removed");
    }
}
