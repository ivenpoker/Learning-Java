package w3resource.array;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Removes specific element from an array.                             #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : August 27, 2020                                                     #
// #                                                                                         #
// ###########################################################################################

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Exercise_7 {

    private static final int LOWER_BOUND = 1;
    private static final int UPPER_BOUND = 100;
    private static final int ARRAY_SIZE = 10;
    private static final String TERMINATION_CHAR = ".";

    private static final SecureRandom secureRandom = new SecureRandom();
    private static final Scanner scanner = new Scanner(System.in);

    private enum InputState {CONTINUE, STOP}

    private static int[] createRandomIntegerArray(int lower, int upper, int size) {
        if (lower > upper) {
            throw new IllegalArgumentException(
                    String.format("Invalid bounds. Lower bound (%d) must be > Upper bound (%d)",
                            lower, upper));
        } else if (size < 0) {
            throw new IllegalArgumentException(
                    String.format("Invalid specified size (%d). Must be > 0", size));
        }
        return IntStream.of(new int[size]).map((val) -> lower + secureRandom.nextInt(upper)).toArray();
    }

    private static void obtainAndRemoveSpecificDataFromArray(int[] mainData) {
        InputState inputState = InputState.CONTINUE;
        String userInput = "";

        // Make a copy of mainData.
        int[] stateArray = IntStream.of(mainData).toArray();

        while (inputState == InputState.CONTINUE) {
            try {
                System.out.printf("== Main Data: %s ==%n", Arrays.toString(stateArray));
                System.out.print("Enter number to delete/remove from array [Enter '.' to stop]: ");
                userInput = scanner.next().trim();

                int userIntVal = Integer.parseInt(userInput);

                System.out.printf("Removing '%d' ... ", userIntVal);
                if (IntStream.of(stateArray).anyMatch((val) -> val == userIntVal)) {
                    stateArray = IntStream.of(stateArray).filter((val) -> val != userIntVal).toArray();
                    System.out.println("[DONE]");
                } else {
                    System.out.println("[FAILED]");
                }

            } catch (NumberFormatException nFe) {
                if (userInput.equals(TERMINATION_CHAR)) {
                    inputState = InputState.STOP;
                } else {
                    System.err.printf("[invalid_input]: %s%n", nFe.getMessage());
                }
            } catch (Exception exc) {
                System.err.printf("[MAIN_EXCEPTION]: Something fishy is just happened ...%n");
            }
        }
    }

    public static void main(String[] args) {

        int[] userRandomData = createRandomIntegerArray(LOWER_BOUND, UPPER_BOUND, ARRAY_SIZE);
        System.out.printf("Generated data: %s%n", Arrays.toString(userRandomData));

        obtainAndRemoveSpecificDataFromArray(userRandomData);

    }

}
