// #############################################################################
// #                                                                           #
// #      Program purpose: Solution to Exercise R-2.14 in Book                 #
// #      Program author : Happi Yvan <ivensteinpoker@gmail.com>               #
// #      Program Date   : 4/06/2019                                           #
// #                                                                           #
// #############################################################################

package books.DataStructuresAndAlgorithms_6thEd.chapter_2.R_Exercises;

public class Exercise_R_2_14 {

    public static void main(String[] args) {
        int[] data = new int[10];

        // Initialize array with even numbers starting from 2
        // try to access the 10th index of array, this will
        // cause 'ArrayIndexOutOfBoundException' which is caught
        // and processed

        try {
            for (int i = 0, j = 2; i <= data.length; i++, j += 2)
                data[i] = j;
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Don't try buffer overflow attacks in Java!");
        }
    }
}
