package w3resource.array;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Inserts element in an array at a specific index.                    #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : August 27, 2020                                                     #
// #                                                                                         #
// ###########################################################################################

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Exercise_9 {

    private static final int LOWER_BOUND = 1;
    private static final int UPPER_BOUND = 100;
    private static final int ARRAY_SIZE = 15;
    private static final int EXIT_FAILURE = 1;

    private static final Scanner scanner = new Scanner(System.in);
    private static final SecureRandom secureRandom = new SecureRandom();

    private static int[] createRandomDataIntegerArray(int lower, int upper, int size) {
        if (lower > upper) {
            throw new IllegalArgumentException(
                    String.format("Invalid bounds. Lower bound (%d) must be > Upper bound (%d).",
                            lower, upper));
        } else if (size < 0) {
            throw new IllegalArgumentException(String.format("Invalid size (%d). Must be > 0", size));
        }
        return IntStream.of(new int[size]).map((i) -> lower + secureRandom.nextInt(upper)).toArray();
    }

    private static int obtainIntFromUser(String inputMess, int endIf, boolean considerEndIf) {
        boolean isInputValid = false;
        int userInput = -1;

        while (!isInputValid) {
            try {
                System.out.print(inputMess);
                userInput = scanner.nextInt();

                if (considerEndIf && userInput == endIf) {
                    System.exit(EXIT_FAILURE);
                }

                isInputValid = true;

            } catch (InputMismatchException iMe) {
                System.err.printf("[invalid_input]: %s%n", iMe.getMessage());

            } catch (Exception exc) {
                System.err.printf("[MAIN_EXCEPTION]: %s%n", exc.getCause().getMessage());
            }
        }
        return userInput;
    }

    private static void proccessArrayContents(int[] mainArrayData) {

        int[] dataCopy = IntStream.of(mainArrayData).toArray();

        while (true) {
            int elem = obtainIntFromUser("Enter to insert element: ", 0, false);
            int idx = obtainIntFromUser("Enter index to insert at [-1 to end program]: ", -1, true);

            while (idx < 0 || idx >= dataCopy.length) {
                idx = obtainIntFromUser("Enter VALID index to insert at [-1 to end program]: ", -1, true);
            }

            int[] newDataArray = new int[dataCopy.length + 1];
            newDataArray[idx] = elem;
            for (int i = 0, cp = 0; i < newDataArray.length; i++) {
                if (i == idx) {
                    continue;
                } else {
                    newDataArray[i] = dataCopy[cp];
                    cp += 1;
                }
            }
            dataCopy = IntStream.of(newDataArray).toArray();
            System.out.printf("NEW ARRAY: %s%n", Arrays.toString(dataCopy));
        }

    }


    public static void main(String[] args) {

        int[] randomData = createRandomDataIntegerArray(LOWER_BOUND, UPPER_BOUND, ARRAY_SIZE);
        System.out.printf("Generated random data: %s%n", Arrays.toString(randomData));

        proccessArrayContents(randomData);
    }

}
