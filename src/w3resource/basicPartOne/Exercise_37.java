package w3resource.basicPartOne;

// ########################################################################################
// #                                                                                      #
// #    Program Purpose: Reverses a string.                                               #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                            #
// #    Creation Date  : September 8, 2019                                                #
// #                                                                                      #
// ########################################################################################

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Exercise_37 {

    private static String reverseString(String someString) {
        StringBuilder someStringBuilder = new StringBuilder(someString);
        return someStringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String userString = "";
        boolean valid = false;

        do {
            try {
                System.out.print("Enter string to reverse: ");
                userString = input.nextLine().trim();

                if (userString.length() == 0)
                    throw new IllegalArgumentException("Invalid input. Please provide a string");
                valid = true;

            } catch (IllegalArgumentException illegalArgumentException) {
                System.err.println(illegalArgumentException.getMessage());

            } catch (NoSuchElementException noSuchElementExc) {
                System.err.println(noSuchElementExc.getMessage());
                break;

            } catch (IllegalStateException illegalStateException) {
                System.err.println("Scanner has been closed. Terminating....");
                break;
            }
        } while (!valid);

        System.out.printf("Reverse of string is: %s\n", reverseString(userString));

    }
}
