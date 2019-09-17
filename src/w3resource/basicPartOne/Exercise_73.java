package w3resource.basicPartOne;

// ##################################################################################################
// #                                                                                                #
// #    Program Purpose: Create a new string, taking first and last characters from 2 given strings #
// #                     if the length of the fist or second is 0, replace with '#'                 #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                      #
// #    Creation Date  : September 17, 2019                                                         #
// #                                                                                                #
// ##################################################################################################

import java.util.Scanner;

public class Exercise_73 {

    private static Scanner scanner = new Scanner(System.in);

    private static String readAndProcessString() {
        boolean isValid = false;
        StringBuilder builder = new StringBuilder();

        do {
            try {
                System.out.print("Enter first string: ");
                String strA = scanner.nextLine().trim();

                System.out.print("Enter second string: ");
                String strB = scanner.nextLine().trim();

                if (strA.length() != 0) {
                    builder.append(strA.charAt(0));
                } else {
                    builder.append("#");
                }

                if (strB.length() != 0) {
                    builder.append(strB.charAt(0));
                } else {
                    builder.append("#");
                }

                isValid = true;

            } catch (IllegalStateException illegalStateException) {
                System.err.print("Scanner closed. Re-opening...");
                scanner = new Scanner(System.in);
                System.out.println("[DONE]");

            } catch (Exception exception) {
                System.err.println(exception.getMessage());
            }

        } while (!isValid);
        return builder.toString();
    }

    public static void main(String[] args) {
        String newData = readAndProcessString();
        System.out.printf("New string is: %s\n", newData);
    }
}
