package w3resource.array;


// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Checks if a sub-array is formed by consecutive integers from a      #
// #                     given array of integers.                                            #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : November 8, 2020                                                    #
// #                                                                                         #
// ###########################################################################################

import w3resource.utils.ArrayUtils;
import w3resource.utils.BasicUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Exercise_57 {

    private static final int LOWER_B0UND = -2;
    private static final int UPPER_BOUND = 10;
    private static final int ARRAY_SIZE = 15;
    private static final int LINE_SIZE = 60;

    private static boolean isSetConsecutive(List<Integer> someList) {
        if (someList.size() <= 1) {
            return false;
        }
        List<Integer> list = new ArrayList<>(someList);
        Collections.sort(list);
        for (int i = 0, size = list.size(); i < size; i++) {
            if (i + 1 < size) {
                if (list.get(i+1) - list.get(i) != 1) {
                    return false;
                }
            }
        }
        return true;
    }

    private static List<ArrayList<Integer>> getAllSubConsecutiveSubArrays(int[] dataSource) {
        List<ArrayList<Integer>> listOfConsecutives = new LinkedList<>();

        // Parsing using first algorithm set
        for (int i = 0; i < dataSource.length; i++) {

            List<Integer> tmpList = new ArrayList<>();
            tmpList.add(dataSource[i]);

            for (int j = i+1; j < dataSource.length; j++) {
                tmpList.add(dataSource[j]);
                if (isSetConsecutive(tmpList)) {
                    listOfConsecutives.add(new ArrayList<>(tmpList));
                }
            }
        }
        return  listOfConsecutives;
    }

    public static void main(String[] args) {
        int[] randomArray = ArrayUtils.randomIntArrayData(LOWER_B0UND, UPPER_BOUND, ARRAY_SIZE);
        System.out.printf("Generated data: %s%n", Arrays.toString(randomArray));


        List<ArrayList<Integer>> listOfConsecs = getAllSubConsecutiveSubArrays(randomArray);

        BasicUtils.printLine('-', LINE_SIZE);

        if (listOfConsecs.isEmpty()) {
            System.out.printf("[NO CONSECUTIVES FOUND]%n");
        } else {
            for (int i = 0, size = listOfConsecs.size(); i < size; i++) {
                System.out.printf("Consecutive #%02d: %s%n", i+1,
                        Arrays.toString(listOfConsecs.get(i).toArray()));
            }

            BasicUtils.printLine('-', LINE_SIZE);

            // Find the largest sub array
            ArrayList<Integer> maxList = listOfConsecs.get(0);

            for (int i = 1, size = listOfConsecs.size(); i < size; i++) {
                if (listOfConsecs.get(i).size() > maxList.size()) {
                    maxList = listOfConsecs.get(i);
                }
            }

            System.out.printf("Elements of the largest sub-array is: %s%n",
                    Arrays.toString(maxList.toArray()));
        }
        BasicUtils.printLine('-', LINE_SIZE);
        System.out.println("\n");

        BasicUtils.printLineMessage("[ SOURCE-TEST ]", '=', LINE_SIZE);
        int[] testData = {2, 5, 0, 2, 1, 4, 3, 6, 1, 0};

        System.out.printf("Test Data: %s%n", Arrays.toString(testData));
        BasicUtils.printLine('-', LINE_SIZE);

        List<ArrayList<Integer>> sourceTestListOfConsecs = getAllSubConsecutiveSubArrays(testData);
        if (sourceTestListOfConsecs.isEmpty()) {
            System.out.printf("[NO CONSECUTIVES FOUND]%n");
        } else {
            for (int i = 0, size = sourceTestListOfConsecs.size(); i < size; i++) {
                System.out.printf("Consecutive #%02d: %s%n", i+1,
                        Arrays.toString(sourceTestListOfConsecs.get(i).toArray()));
            }

            BasicUtils.printLine('-', LINE_SIZE);

            List<Integer> maxList = sourceTestListOfConsecs.get(0);
            for (int i = 1, size = maxList.size(); i < size; i++) {
                if (sourceTestListOfConsecs.get(i).size() > maxList.size()) {
                    maxList = sourceTestListOfConsecs.get(i);
                }
            }
            System.out.printf("Elements of the sub-array: %s%n", Arrays.toString(maxList.toArray(new Integer[0])));
        }
    }


}
