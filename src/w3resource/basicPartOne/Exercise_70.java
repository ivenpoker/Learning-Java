package w3resource.basicPartOne;

// #################################################################################################
// #                                                                                               #
// #    Program Purpose: Process two strings of different lengths to produce a third.              #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                     #
// #    Creation Date  : September 17, 2019                                                        #
// #                                                                                               #
// #################################################################################################

import java.util.Scanner;

public class Exercise_70 {

    private static Scanner scanner = new Scanner(System.in);

    private static String readAndProcessStrings() {
        boolean isValid = false;
        StringBuilder builder = new StringBuilder();

        do {
            try {
                System.out.print("Enter the first string: ");
                String strA = scanner.nextLine().trim();

                System.out.print("Enter the second string: ");
                String strB = scanner.nextLine().trim();

                if (strA.length() == strB.length())
                    throw new IllegalArgumentException("Both strings shouldn't have same lengths");

                if (strA.length() < strB.length()) {
                    builder.append(strA).append(strB).append(strA);
                } else {
                    builder.append(strB).append(strA).append(strB);
                }
                isValid = true;

            } catch (IllegalStateException illegalStateException) {
                System.err.print("Scanner closed. Re-opening...");
                scanner = new Scanner(System.in);
                System.out.println("[DONE]");

            } catch (IllegalArgumentException illegalArgumentException) {
                System.err.println(illegalArgumentException.getMessage());
            }

        } while (!isValid);
        return builder.toString().trim();
    }

    public static void main(String[] args) {
        String newString = readAndProcessStrings();
        System.out.printf("Final string: %s\n", newString);
    }

}
