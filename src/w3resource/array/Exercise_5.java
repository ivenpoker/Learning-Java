package w3resource.array;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Tests if an array contains a specific value.                        #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : August 27, 2020                                                     #
// #                                                                                         #
// ###########################################################################################

import java.security.SecureRandom;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.Arrays;

public class Exercise_5 {

    private static final int LOWER_BOUND = 1;
    private static final int UPPER_BOUND = 100;
    private static final int SIZE = 15;

    private static final String TERMINATION_CHAR = ".";

    private static final SecureRandom randomNum = new SecureRandom();
    private static final Scanner scanner = new Scanner(System.in);

    private enum InputState {CONTINUE, STOP}

    private static int[] createRandomArrayOfInts(int lower, int upper, int size) {
        if (lower > upper) {
            throw new IllegalArgumentException(String.format("Lower bound (%d) must be > Upper bound (%d)",
                    LOWER_BOUND, UPPER_BOUND));
        } else if (size < 0) {
            throw new IllegalArgumentException(String.format("Invalid new array size (%d). Must be >= 0", size));
        }
        return IntStream.of(new int[size]).map((i) -> lower + randomNum.nextInt(upper)).toArray();
    }

    private static void performProcessing(int[] dataStore) {
        InputState inputState = InputState.CONTINUE;
        String userInput = "";

        while (inputState == InputState.CONTINUE) {
            try {
                System.out.print("Enter search number [enter '.' to stop]: ");
                userInput = scanner.next();

                int userSearchVal = Integer.parseInt(userInput);

                if (IntStream.of(dataStore).anyMatch((val) -> val == userSearchVal)) {
                    System.out.printf("Number '%d' is found in array.%n", userSearchVal);
                } else {
                    System.out.printf("Number '%d' is not found in array.%n", userSearchVal);
                }

            } catch (NumberFormatException nFe) {
                if (userInput.equals(TERMINATION_CHAR)) {
                    inputState = InputState.STOP;
                } else {
                    System.out.printf("[invalid_input]: %s%n", nFe.getMessage());
                }
            } catch (Exception exc) {
                System.err.printf("[MAIN_EXCEPTION]: %s%n", exc.getMessage());
            }
        }
    }

    public static void main(String[] args) {

        int[] randIntArray = createRandomArrayOfInts(LOWER_BOUND, UPPER_BOUND, SIZE);
        System.out.printf("Generated Array: %s%n", Arrays.toString(randIntArray));

        performProcessing(randIntArray);

    }

}
