package w3resource.basicPartTwo;

// ####################################################################################
// #                                                                                  #
// #    Program Purpose: Finds the kth largest and smallest element in a given array. #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                        #
// #    Creation Date  : December 29, 2019                                            #
// #                                                                                  #
// ####################################################################################

import java.util.*;
import java.security.SecureRandom;
import java.util.stream.IntStream;

public class Exercise_161 {

    private static Scanner scanner = new Scanner(System.in);
    private static SecureRandom random = new SecureRandom();

    private static boolean inRange(int low, int val, int high) {
        return low <= val  && val <= high;
    }

    private static int obtainUserData(String inputMess) {
        int userData = 0;
        boolean valid = false;

        while (!valid) {
            try {
                System.out.print(inputMess);
                userData = scanner.nextInt();
                valid = true;

            } catch (InputMismatchException inputMismatch) {
                System.err.println("[INPUT_ERROR]: " + inputMismatch.getMessage());

            } catch (IllegalStateException illegalStateExc) {
                System.err.print("[REBOOTING-SCANNER] ... ");
                scanner = new Scanner(System.in);
                System.out.println("[DONE]");

            } catch (Exception exc) {
                System.err.println("[MAJOR-ERROR]: " + exc.getMessage());
            }
        }
        return userData;
    }

    private static int[] randomIntegerArray(int low, int high, int size) {
        if (size < 0) {
            throw new IllegalArgumentException(String.format("Invalid size (%d) for new array. " +
                    "Must be > 0.", size));
        }
        int[] newArrayData = new int[size];
        newArrayData = IntStream.of(newArrayData).map(val -> low + random.nextInt(high + 1)).toArray();
        return newArrayData;
    }

    private static int findKthSmallestInArray(int[] mainData, int kthVal) {
        if (!inRange(1, kthVal, mainData.length)) {
            throw new IllegalArgumentException(String.format("Invalid kth-value (%d). " +
                    "Must be in range [1, %d]", kthVal, mainData.length));
        }

        // Create a list of integers (a collection actually)
        List<Integer> tempList = new ArrayList<>();
        for (int val : mainData)
            tempList.add(val);

        // Extract the unique ones with the 'Set' class
        Set<Integer> uniqueVals = new TreeSet<>(tempList);
        Integer[] uniqueData = uniqueVals.toArray(new Integer[0]);

        // Return the 'kth' largest in array.
        Arrays.sort(uniqueData);
        return uniqueData[kthVal-1];
    }

    private static int findKthLargestInArray(int[] mainData, int kthVal) {
        if (!inRange(1, kthVal, mainData.length)) {
            throw new IllegalArgumentException(String.format("Invalid kth-value (%d). " +
                    "Must be in range [1, %d]", kthVal, mainData.length));
        }

        // Create a list of integers (a collection actually)
        List<Integer> tempList = new ArrayList<>();
        for (int val : mainData)
            tempList.add(val);

        // Extract the unique ones with the `Set` class
        Set<Integer> uniqueVals = new TreeSet<>(tempList);
        Integer[] uniqueData = uniqueVals.toArray(new Integer[0]);

        // Sort the unique data
        Arrays.sort(uniqueData);

        if (uniqueData.length < kthVal) {
            throw new IllegalArgumentException(String.format("Unique items in array '%s' " +
                    "can't find the value at index '%d'", Arrays.toString(uniqueData), kthVal));
        }

        // Return the 'kth' largest in array.
        return uniqueData[uniqueData.length - kthVal];
    }

    private static void printLine(char mainChar, int len) {
        for (int i = 0; i < len; i++) {
            System.out.printf("%c", mainChar);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] newData = randomIntegerArray(0, 20, 15);
        System.out.printf("Random integer array: %s\n", Arrays.toString(newData));

        int[] tempData = Arrays.copyOf(newData, newData.length);
        Arrays.sort(tempData);

        printLine('-', 70);
        System.out.printf("Sorted Array data: %s\n", Arrays.toString(tempData));
        printLine('-', 70);

        int userKthSmall = obtainUserData("Enter the kth-val for smallest: ");
        int userKthLargest = obtainUserData("Enter the kth-val for largest: ");

        printLine('-', 70);

        try {
            int kthSmall = findKthSmallestInArray(newData, userKthSmall);
            int kthLargest = findKthLargestInArray(newData, userKthLargest);
            System.out.printf("Kth-smallest element: %d\n", kthSmall);
            System.out.printf(" Kth-largest element: %d\n", kthLargest);

        } catch (IllegalArgumentException illegalExc) {
            System.err.println("[ERROR]: " + illegalExc.getMessage());
        }
    }
}
