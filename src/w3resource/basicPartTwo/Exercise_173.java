package w3resource.basicPartTwo;

// #########################################################################################
// #                                                                                       #
// #    Program Purpose: Finds the median of the number inside the window (size k) at each #
// #                     moving in a given array of integers with duplicate members. Move  #
// #                     the window from the start of the array.                           #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                             #
// #    Creation Date  : January 07, 2019                                                  #
// #                                                                                       #
// #########################################################################################

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class Exercise_173 {

    private static ArrayList<Integer> medianSlideWindow(int[] mainArray, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if (k == 0 || mainArray.length < k) {
            return result;
        }
        PriorityQueue<Integer> rightNum = new PriorityQueue<>(k);
        PriorityQueue<Integer> leftNum = new PriorityQueue<>(k, Collections.reverseOrder());

        for (int i = 0; i < k-1; i++) {
            add(rightNum, leftNum, mainArray[i]);
        }
        for (int i = k-1; i < mainArray.length; i++) {
            add(rightNum, leftNum, mainArray[i]);
            int median = computeMedian(rightNum, leftNum);
            result.add(median);
            remove(rightNum, leftNum, mainArray[i-k+1]);
        }
        return result;
    }

    private static int computeMedian(PriorityQueue<Integer> rightNum, PriorityQueue<Integer> leftNum) {
        if (leftNum.isEmpty() && rightNum.isEmpty()) {
            return 0;
        }
        while (leftNum.size() < rightNum.size()) {
            leftNum.add(rightNum.poll());
        }
        while (leftNum.size() - rightNum.size() > 1) {
            rightNum.add(leftNum.poll());
        }
        return leftNum.peek();
    }

    private static void add(PriorityQueue<Integer> rightNum ,PriorityQueue<Integer> leftNum, int num) {
        if (leftNum.isEmpty() && rightNum.isEmpty()) {
            leftNum.add(num);
        } else {
            if (num <= computeMedian(rightNum, leftNum)) {
                leftNum.add(num);
            } else {
                rightNum.add(num);
            }
        }
    }

    private static void remove(PriorityQueue<Integer> rightNum, PriorityQueue<Integer> leftNum, int num) {
        if (num <= computeMedian(rightNum, leftNum)) {
            leftNum.remove(num);
        } else {
            rightNum.remove(num);
        }
    }

    public static void main(String[] args) {
        int[] mainArray = {1, 2, 3, 4, 5, 6, 7, 8, 8};
        int k = 3;

        System.out.printf("\nOriginal Array: %s\n", Arrays.toString(mainArray));
        System.out.printf("\nValue of k: %d\n", k);
        System.out.println("\nResult: ");

        ArrayList<Integer> result = medianSlideWindow(mainArray, k);
        for (int i = 0, size = result.size(); i < size; i++) {
            System.out.println(result.get(i));
        }
    }
}
