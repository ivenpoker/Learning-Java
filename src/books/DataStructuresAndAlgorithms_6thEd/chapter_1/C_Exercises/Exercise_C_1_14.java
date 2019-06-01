// #############################################################################
// #                                                                           #
// #      Program purpose: Solution to Exercise C.1.14 in Book                  #
// #      Program author : Happi Yvan <ivensteinpoker@gmail.com>               #
// #      Program Date   : 1/06/2019                                           #
// #                                                                           #
// #############################################################################

package books.DataStructuresAndAlgorithms_6thEd.chapter_1.C_Exercises;

public class Exercise_C_1_14 {

    public static void reverse(int[] someArray) {
        for (int i = 0, j = someArray.length-1; i < j; i++, j--) {
            int temp = someArray[i];
            someArray[i] = someArray[j];
            someArray[j] = temp;
        }
  }

    public static void main(String[] args) {

        // PSEUDO-CODE
        //
        // let i = 0
        // let j = (length of array) - 1
        //
        // while ('i' is greater tan 'j'):
        //      swap the elements in 'i' with that in 'j'.
        //      increment i.
        //      decrement j.

        // ################# TEST CODE ########################

        int[] data = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Exercise_C_1_14.reverse(data);

        System.out.printf("After reversing the array contents: ");
        for (int val : data)
            System.out.printf("%d ", val);
        System.out.println();

        // ################ COMPARISION ######################
        // Both methods will have the same time complexity.
    }
}
