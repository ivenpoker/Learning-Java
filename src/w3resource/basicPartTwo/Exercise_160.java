package w3resource.basicPartTwo;

// ####################################################################################
// #                                                                                  #
// #    Program Purpose: Finds the kth smallest element in a given array.             #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                        #
// #    Creation Date  : December 29, 2019                                            #
// #                                                                                  #
// ####################################################################################

import java.util.InputMismatchException;
import java.util.Scanner;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.Objects;

public class Exercise_160 {

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

            } catch (InputMismatchException inputMistmatchExc) {
                System.err.println("[INPUT-ERROR]: " + inputMistmatchExc.getMessage());

            } catch (IllegalStateException illegalStateExc) {
                System.err.print("[REBOOTING-SCANNER] ... ");
                scanner = new Scanner(System.in);
                System.out.println("[DONE]");
            }
        }
        if (!Objects.isNull(scanner)) {
            scanner.close();
        }

        return userData;
    }

    private static int[] generateRandomArray(int low, int high, int size) {
        if (size < 0) {
            throw new IllegalArgumentException(String.format("Invalid specified size (%d). " +
                    "Must be in >= 0.", size));
        }
        int[] newData = new int[size];
        newData = IntStream.of(newData).map(val -> low + random.nextInt(high + 1)).toArray();
        return newData;
    }

    private static int findKthSmallest(int[] mainData, int kthVal) {
        if (kthVal <= 0 || kthVal > mainData.length) {
            throw new IllegalArgumentException(String.format("Invalid kth-value (%d). " +
                    "Must be in range [1, %d]", kthVal, mainData.length));
        }
        int[] tempCopy = Arrays.copyOf(mainData, mainData.length);
        Arrays.sort(tempCopy);
        return tempCopy[kthVal-1];
    }

    public static void main(String[] args) {
        int[] newRandomData = generateRandomArray(0, 20, 15);
        System.out.printf("Random array data: %s\n", Arrays.toString(newRandomData));

        int userKthValue = obtainUserData("Enter the kth-value: ");
        try {
            int kthVal = findKthSmallest(newRandomData, userKthValue);
            System.out.printf("Kth-smallest value is: %d\n", kthVal);

        } catch (IllegalArgumentException illegalArgExc) {
            System.err.println(illegalArgExc.getMessage());
        }
    }
}
