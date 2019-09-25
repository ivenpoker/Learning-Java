package w3resource.basicPartOne;

// #######################################################################################################
// #                                                                                                     #
// #    Program Purpose: Checks if a certain number of elements in the array from the beginning and end  #
// #                     match.                                                                          #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                           #
// #    Creation Date  : September 25, 2019                                                              #
// #                                                                                                     #
// #######################################################################################################

import java.security.SecureRandom;
import java.util.*;

public class Exercise_105 {

    private static SecureRandom random = new SecureRandom();
    private static Scanner scanner = new Scanner(System.in);

    private static int[] randomIntegerArray(int low, int high, int size) {
        if (size <= 0)
            throw new IllegalArgumentException("Invalid size of array. Size must be > 0");
        int[] newData = new int[size];
        for (int i = 0; i < newData.length; i++)
            newData[i] = low + random.nextInt(high);
        return newData;
    }

    private static int getIntegerVal(String mess, int min, int max) {
        boolean isValid = false;
        int val = 0;
        while (!isValid) {
            try {
                System.out.print(mess);
                val = scanner.nextInt();
                if (val >= min && val <= max) {
                    isValid = true;
                } else {
                    throw new IllegalArgumentException(String.format("Invalid number " +
                            "of elements. Must be in range [%d, %d]\n", min, max));
                }

            } catch (InputMismatchException inputMismatchException) {
                System.err.println("[ERROR]: Please provide an integer");

            } catch (IllegalStateException illegalStateException) {
                System.err.print("[WARNING]: Scanner has been closed unexpectedly. Re-opening...");
                scanner = new Scanner(System.in);
                System.out.println("[DONE]");
            }
        }
        return val;
    }

    private static boolean checkBackAndFrontEquivalence(Integer[] someData, int maxCheck) {

        boolean isValid = true;
        List<Integer> mainData = Arrays.asList(someData);
        List<Integer> valA = mainData.subList(0, maxCheck);
        List<Integer> valB = mainData.subList(mainData.size()-maxCheck, mainData.size());

        if (valA.size() == valB.size()) {
            Iterator<Integer> itA = valA.iterator();
            Iterator<Integer> itB = valB.iterator();

            while (itA.hasNext()) {
                if (!itA.next().equals(itB.next())) {
                    isValid = false;
                    break;
                }
            }
        } else {
            isValid = false;
        }

        return isValid;
    }

    public static void main(String[] args) {
        Integer[] dataA = {11, 15, 13, 10, 45, 20, 11, 15};
        System.out.printf("Generated array data: %s\n", Arrays.toString(dataA));

        int userMaxCheck = getIntegerVal("Enter number of elements to check from both sides of array: ", 0, 20);
        System.out.printf("Are %d array elements same from back and front of array: %s\n",
                userMaxCheck, checkBackAndFrontEquivalence(dataA, userMaxCheck) ? "YES" : "NO");

    }
}
