package w3resource.array;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Finds the index of an array element when searched for.              #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : August 27, 2020                                                     #
// #                                                                                         #
// ###########################################################################################

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Exercise_6 {

    private static final int LOWER_BOUND = 1;
    private static final int UPPER_BOUND = 100;
    private static final int ARRAY_SIZE = 15;
    private static final String TERMINATION_CHAR = ".";

    private static final SecureRandom random = new SecureRandom();
    private static final Scanner scanner = new Scanner(System.in);

    private enum InputState {CONTINUE, STOP}

    private static int[] createRandomIntegerArray(int lower, int upper, int size) {
        if (lower > upper) {
            throw new IllegalArgumentException(
                    String.format("Invalid arguments. Lower bound (%d) must be > Upper bound (%d)",
                            lower, upper));
        } else if (size < 0) {
            throw new IllegalArgumentException(
                    String.format("Invalid specified size (%d). Must be > 0", size));
        }
        return IntStream.of(new int[size]).map((i) -> lower + random.nextInt(upper)).toArray();
    }

    private static void processArrayData(int[] data) {
        InputState inputState = InputState.CONTINUE;
        String userInput = "";

        while (inputState == InputState.CONTINUE) {
            try {
                System.out.print("Enter array element to find index: ");
                userInput = scanner.next().trim();

                int userIntVal = Integer.parseInt(userInput);

                if (IntStream.of(data).anyMatch((val) -> val == userIntVal)) {
                    int idx = -1;
                    for (int i = 0; i < data.length; i++) {
                        if (data[i] == userIntVal) {
                            idx = i;
                            break;
                        }
                    }
                    System.out.printf("Number '%d' found at index #%d%n", userIntVal, idx);
                } else {
                    System.out.printf("Oops, '%d' not found in array.%n", userIntVal);
                }

            } catch (NumberFormatException nFe) {
                if (userInput.equals(TERMINATION_CHAR)) {
                    inputState = InputState.STOP;
                } else {
                    System.err.printf("[invalid_input]: %s%n", nFe.getMessage());
                }
            } catch (Exception exc) {
                System.err.print("[MAIN_EXCEPTION]: Something fishy is going on ...%n");
            }
        }
    }

    public static void main(String[] args) {

        int[] randomIntegerArray = createRandomIntegerArray(LOWER_BOUND, UPPER_BOUND, ARRAY_SIZE);
        System.out.printf("Generated array is: %s%n", Arrays.toString(randomIntegerArray));

        processArrayData(randomIntegerArray);

    }

}
