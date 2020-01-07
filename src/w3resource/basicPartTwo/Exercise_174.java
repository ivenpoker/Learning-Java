package w3resource.basicPartTwo;

// ##########################################################################################
// #                                                                                        #
// #    Program Purpose: Finds the maximum number inside the number in the window (size k)  #
// #                     at each moving in a given array of integers with duplicate         #
// #                     members. Move the window from the start of the array.              #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                              #
// #    Creation Date  : January 07, 2019                                                   #
// #                                                                                        #
// ##########################################################################################

import java.util.*;

public class Exercise_174 {

    private static ArrayList<Integer> maxSlideWindow(int[] mainArray, int k) {
        ArrayList<Integer> rstArray = new ArrayList<>();
        if (Objects.isNull(mainArray) || mainArray.length == 0 || k < 0) {
            return rstArray;
        }
        Deque<Integer> dequeNum = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            while (!dequeNum.isEmpty() && mainArray[dequeNum.peekLast()] <= mainArray[i]) {
                dequeNum.pollLast();
            }
            dequeNum.offerLast(i);
        }
        for (int i = k; i < mainArray.length; i++) {
            rstArray.add(mainArray[dequeNum.peekFirst()]);
            if (!dequeNum.isEmpty() && dequeNum.peekFirst() <= i - k) {
                dequeNum.pollFirst();
            }
            while (!dequeNum.isEmpty() && mainArray[dequeNum.peekLast()] <= mainArray[i]) {
                dequeNum.pollLast();
            }
            dequeNum.offerLast(i);
        }
        rstArray.add(mainArray[dequeNum.peekFirst()]);
        return rstArray;
    }

    public static void main(String[] args) {
        int[] mainArray = {1, 2, 3, 4, 5, 6, 7, 8, 8};
        int k = 3;

        System.out.printf("\nOriginal Array: %s", Arrays.toString(mainArray));
        System.out.printf("\nValue of k: %d\n", k);
        System.out.println("\nResult: ");

        ArrayList<Integer> result = maxSlideWindow(mainArray, k);
        for (int i = 0, j = result.size(); i < j; i++) {
            System.out.println(result.get(i));
        }
    }
}
