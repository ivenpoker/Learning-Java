package w3resource.basicPartTwo;

// ####################################################################################
// #                                                                                  #
// #    Program Purpose: Finds the kth largest element in a given array.              #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                        #
// #    Creation Date  : December 29, 2019                                            #
// #                                                                                  #
// ####################################################################################

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Exercise_159 {

    private static SecureRandom random = new SecureRandom();
    private static Scanner scanner = new Scanner(System.in);

    private static int obtainUserData(String inputMess) {
        int userData = 0;
        boolean valid = false;

        while (!valid) {
            try {
                System.out.print(inputMess);
                userData = scanner.nextInt();
                valid = true;

            } catch (InputMismatchException inputMismatchExc) {
                System.err.println("[ERROR]: " + inputMismatchExc.getMessage());

            } catch (IllegalStateException illegalStateExc) {
                System.err.print("[REBOOTING-SCANNER] ... ");
                scanner = new Scanner(System.in);
                System.out.println("[DONE]");
            }
        }
        return userData;
    }

    private static int[] randomArray(int low, int high, int size) {
        if (size < 0) {
            throw new IllegalArgumentException(String.format("Invalid size " +
                    "(%d) for new array. Must be > 0", size));
        }
        int[] newArrayData = new int[size];
        newArrayData = IntStream.of(newArrayData).map(val -> low + random.nextInt(high)).toArray();
        return newArrayData;
    }

    private static int findKthLargest(int[] mainData, int kthVal) {
        if (kthVal <= 0 || kthVal > mainData.length) {
            throw new IllegalArgumentException(String.format("Invalid kth-value (%d). " +
                    "Must be in range [1, %d]", kthVal, mainData.length));
        }
        int[] tempCopy = Arrays.copyOf(mainData, mainData.length);
        Arrays.sort(tempCopy);
        System.out.printf("Sorted data: %s\n", Arrays.toString(tempCopy));

        return tempCopy[tempCopy.length - kthVal];
    }

    public static void main(String[] args) {
        int[] newData = randomArray(0, 20, 15);
        System.out.printf("Random array: %s\n", Arrays.toString(newData));

        int userKthValue = obtainUserData("Enter the kth-value: ");
        try {
            int kthVal = findKthLargest(newData, userKthValue);
            System.out.printf("Kth-value is: %d\n", kthVal);

        } catch (IllegalArgumentException illegalArgExc) {
            System.err.println(illegalArgExc.getMessage());
        }

    }
}
