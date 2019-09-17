package w3resource.basicPartOne;

// #################################################################################################
// #                                                                                               #
// #    Program Purpose: Extracts the first half of a string of even length.                       #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                     #
// #    Creation Date  : September 17, 2019                                                        #
// #                                                                                               #
// #################################################################################################

import java.util.Scanner;

public class Exercise_69 {

    private static Scanner scanner = new Scanner(System.in);

    private static String readString(String inputMessage) {
        boolean isValid = false;
        String mainString = "";

        do {
            try {
                System.out.print(inputMessage);
                mainString = scanner.nextLine();

                if (mainString.length() % 2 != 0) {
                    throw new IllegalArgumentException("Invalid input. Must be of " +
                            "+ve length.");
                } else {
                    isValid = true;
                }
            } catch (IllegalStateException illegalStateException) {
                System.err.print("Scanner has closed. Re-opening...");
                scanner = new Scanner(System.in);

            } catch (IllegalArgumentException illegalArgumentException) {
                System.err.println(illegalArgumentException.getMessage());
            }
        } while (!isValid);

        return mainString;
    }

    private static String processData(String someString) {
        return someString.substring(0, someString.length() / 2);
    }

    public static void main(String[] args) {
        String mainString = readString("Enter a string (of +ve length): ");
        String newString = processData(mainString);
        System.out.printf("New string is: %s\n", newString);
    }

}
