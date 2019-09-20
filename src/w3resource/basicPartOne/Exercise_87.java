package w3resource.basicPartOne;

// ###################################################################################################
// #                                                                                                 #
// #    Program Purpose: Read an integer and calculate the sum of the digits and write the number of #
// #                     each digit of the sum in English.                                           #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                       #
// #    Creation Date  : September 20, 2019                                                          #
// #                                                                                                 #
// ###################################################################################################

import java.util.Scanner;

public class Exercise_87 {

    private static Scanner scanner = new Scanner(System.in);
    private static String[] digitWords = {"", "One", "Two", "Three", "Four", "Five", "Six",
                                          "Seven", "Eight", "Nine"};

    private static int readIntegerFromUser(String inputMessage) {
        boolean isValid = false;
        int userInt = 0;

        do {
            try {
                System.out.print(inputMessage);
                userInt = scanner.nextInt();
                isValid = true;

            } catch (IllegalStateException illegalStateException) {
                System.err.print("[ERROR]: Scanner closed unexpectedly. Re-opening...");
                scanner = new Scanner(System.in);
                System.err.println("[DONE]");

            } catch (Exception exception) {
                System.err.println(exception.getMessage());
            }
        } while (!isValid);
        return userInt;
    }

    private static int getSumOfDigits(int someNum) {
        String[] chars = Integer.toString(someNum).split("");
        int sum = 0;
        for (String aChar : chars)
            sum += Integer.parseInt(aChar);
        return sum;
    }

    private static String processData(int mainInt) {
        String[] chars = Integer.toString(mainInt).split("");
        int[] digits = new int[chars.length];
        for (int i = 0; i < digits.length; i++)
            digits[i] = Integer.parseInt(chars[i]);
        StringBuilder builder = new StringBuilder();

        for (Integer intVal : digits)
            builder.append(digitWords[intVal]).append(" ");
        return builder.toString();
    }

    public static void main(String[] args) {

        int mainInt = readIntegerFromUser("Enter some integer (positive): ");
        int mainSum = getSumOfDigits(mainInt);
        System.out.printf("Sum of digits in '%d': %d\n", mainInt, mainSum);
        System.out.printf("Words for digits in sum: %s\n", processData(mainSum));
    }
}
