package w3resource.basicPartOne;

// #################################################################################################
// #                                                                                               #
// #    Program Purpose: Create new string by replacing first three characters in some string. If  #
// #                     less than three characters where in old, new string becomes ###           #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                     #
// #    Creation Date  : September 17, 2019                                                        #
// #                                                                                               #
// #################################################################################################

import java.util.Scanner;

public class Exercise_72 {

    private static Scanner scanner = new Scanner(System.in);

    private static String readAndProcessString() {
        boolean isValid = false;
        StringBuilder builder = new StringBuilder();

        do {
            try {
                System.out.print("Enter a string: ");
                String temp = scanner.nextLine().trim();

                if (temp.length() >= 3) {
                    builder.append(temp.charAt(0)).append(temp.charAt(1))
                            .append(temp.charAt(2));
                } else {
                    builder.append("###");
                }
                isValid = true;

            } catch (IllegalStateException illegalStateException) {
                System.err.print("Scanner closed. Re-opening...");
                scanner = new Scanner(System.in);

            } catch (Exception exception) {
                System.err.println(exception.getMessage());
            }
        } while (!isValid);
        return builder.toString();
    }

    public static void main(String[] args) {
        String newData = readAndProcessString();
        System.out.printf("Processed string is: %s\n", newData);
    }
}
