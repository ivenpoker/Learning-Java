package w3resource.basicPartOne;

// #################################################################################################
// #                                                                                               #
// #    Program Purpose: Concatenates two strings removing the first character in each.            #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                     #
// #    Creation Date  : September 17, 2019                                                        #
// #                                                                                               #
// #################################################################################################

import java.util.Scanner;

public class Exercise_71 {

    private static Scanner scanner = new Scanner(System.in);

    private static String readAndProcessData() {
        boolean isValid = false;
        StringBuilder builder = new StringBuilder();

        do {
            try {
                System.out.print("Enter first string: ");
                String strA = scanner.nextLine().trim();

                System.out.print("Enter second string: ");
                String strB = scanner.nextLine().trim();

                builder.append(strA.substring(1)).append(strB.substring(1));
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
        String mainStr = readAndProcessData();
        System.out.printf("Final string is: %s\n", mainStr);
    }
}
