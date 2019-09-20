package w3resource.basicPartOne;

// #################################################################################################
// #                                                                                               #
// #    Program Purpose: Reads a starting integer n, divide n by 2 if n is even or multiply by 3   #
// #                     and add 1 if n is odd, repeat the process until n = 1.                    #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                     #
// #    Creation Date  : September 20, 2019                                                        #
// #                                                                                               #
// #################################################################################################

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise_86 {

    private static Scanner scanner = new Scanner(System.in);

    private static int readSomeIntegerFromUser(String inputMessage) {
        boolean isValid = false;
        int userInt = 0;
        do {
            try {
                System.out.print(inputMessage);
                userInt = scanner.nextInt();
                if (userInt <= 0)
                    throw new IllegalArgumentException("Invalid integer input. Must be > 0.");
                isValid = true;

            } catch (InputMismatchException inputMismatchException) {
                System.err.println("[ERROR]: Invalid input. Must be an integer");

            } catch (IllegalStateException illegalStateException) {
                System.err.print("[ERROR]: Scanner closed unexpectedly. Try again.");
                scanner = new Scanner(System.in);
                System.out.println("[DONE]");

            } catch (Exception exception) {
                System.err.println(exception.getMessage());
            }
        } while (!isValid);
        return userInt;
    }

    private static void processInteger(int someInt) {
        while (someInt != 1) {
            System.out.printf("Processing %d...\n", someInt);
            if (someInt % 2 == 0) {
                someInt /= 2;
            } else {
                someInt *= 3;
                someInt += 1;
            }
        }
        System.out.printf("Final processing on '%d'...\n", someInt);
    }

    public static void main(String[] args) {
        int userInt = readSomeIntegerFromUser("Enter starting integer [> 0]: ");
        processInteger(userInt);
    }
}
