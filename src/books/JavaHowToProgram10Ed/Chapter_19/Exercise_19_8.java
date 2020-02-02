package books.JavaHowToProgram10Ed.Chapter_19;

// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 19.8 from book.                       #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : February 02, 2020                                          #
// #                                                                                  #
// ####################################################################################

import java.util.Arrays;
import java.security.SecureRandom;
import java.util.Scanner;

public class Exercise_19_8 {

    private static SecureRandom random = new SecureRandom();
    private static Scanner scanner = new Scanner(System.in);

    private static int obtainUserKey(String inputMessage) {
        int userKey = 0;
        boolean cont = true;
        while (cont) {
            try {
                System.out.print(inputMessage);
                userKey = scanner.nextInt();
                cont = false;

            } catch (IllegalStateException stateExc) {
                System.err.print("[SCANNER_ERROR]: RE-BOOTING ...");
                scanner = new Scanner(System.in);
                System.err.println("[DONE]");

            } catch (Exception exc) {
                System.err.printf("[ERROR]: %s\n", exc.getMessage());
            }
        }
        return userKey;
    }

    private static int recursiveLinearSearch(int[] data, int key, int start, int end) {
        if (data.length == 1 && data[0] != key) {
            return -1;
        }
        if (data[start] != key) {
            return recursiveLinearSearch(data, key, start+1, end);
        } else {
            return start;
        }
    }

    private static int[] randomIntegerArray(int low, int high, int size) {
        if (size < 0) {
            throw new IllegalArgumentException(String.format("Invalid " +
                    "array size '%d' for new array", size));
        }
        return Arrays.stream(new int[size]).map((val) -> low + random.nextInt(high))
                .toArray();
    }

    public static void main(String[] args) {
        int[] sourceData = randomIntegerArray(0, 50, 15);
        System.out.printf("Generated Array: %s\n", Arrays.toString(sourceData));

        int userKey = obtainUserKey("Enter your search key: ");
        int result = recursiveLinearSearch(sourceData, userKey, 0, sourceData.length);

        System.out.printf("Is '%d' found in array: %s\n", userKey,
                (result >= 0 ? "YES" : "NO"));
        System.out.printf("Results: %d\n", result);
    }
}
