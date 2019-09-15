package w3resource.basicPartOne;

// ###############################################################################################
// #                                                                                             #
// #    Program Purpose: Insert another string in the middle of another string.                  #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                   #
// #    Creation Date  : September 15, 2019                                                      #
// #                                                                                             #
// ###############################################################################################

import java.util.Scanner;

public class Exercise_67 {

    private static Scanner scanner = new Scanner(System.in);

    private static String readData(String inputMessage) {
        boolean isValid = false;
        String mainData = "";

        do {
            try {
                System.out.print(inputMessage);
                mainData = scanner.nextLine().trim();
                isValid = true;

            } catch (IllegalStateException illegalStateException) {
                System.err.print("Scanner has been closed. Re-opening...");
                scanner = new Scanner(System.in);

            } catch (Exception exception) {
                System.err.println(exception.getMessage());
                System.out.println("Please, try again.");
            }
        } while (!isValid);
        return mainData;
    }

    private static String processData(String mainData, String middleData) {
        String[] mainTokens = mainData.split(" ");
        int mid = mainTokens.length / 2;
        StringBuilder newData = new StringBuilder();

        for (int i = 0; i < mid; i++)
            newData.append(mainTokens[i]).append(" ");
        newData.append(middleData).append(" ");

        for (int i = mid; i < mainTokens.length; i++)
            newData.append(mainTokens[i]).append(" ");

        return newData.toString().trim();
    }

    public static void main(String[] args) {
        String mainData = readData("Enter a sentence: ");
        String middleData = readData("Enter string to add in middle of sentence: ").split(" ")[0];
        String newData = processData(mainData, middleData);
        System.out.printf("New string is: %s\n", newData);
    }
}
