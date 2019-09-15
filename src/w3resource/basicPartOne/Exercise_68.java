package w3resource.basicPartOne;

// #################################################################################################
// #                                                                                               #
// #    Program Purpose: Create a new string of 4 copies of the last 3 characters of the original  #
// #                     string. The length of the original string must be 3 and above.            #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                     #
// #    Creation Date  : September 13, 2019                                                        #
// #                                                                                               #
// #################################################################################################

import java.util.Scanner;

public class Exercise_68 {

    private static Scanner scanner = new Scanner(System.in);

    private static String readData(String inputMessage) {
        boolean isValid = false;
        String mainData = "";

        do {
            try {
                System.out.print(inputMessage);
                mainData = scanner.nextLine().trim();
                isValid = true;

            } catch (IllegalStateException exception) {
                System.err.print("Scanner has closed. Re-opening...");
                scanner = new Scanner(System.in);
                System.err.println("[DONE]");

            } catch (Exception exception) {
                System.err.println(exception.getMessage());
                System.err.println("Please try again.");
            }
        } while (!isValid);
        return mainData;
    }

    private static String makeNewStringOfNCopiesOfYcharacters(String mainData,
                                                              int nCopies, int lastYChars) {
        if (lastYChars > mainData.length())
            throw new IllegalArgumentException("Invalid argument(s)");

        if (nCopies <= 0)
            throw new IllegalArgumentException("Invalid number of copies.");

        StringBuilder builder = new StringBuilder();
        String tempData = mainData.substring(mainData.length()-lastYChars);

        for (int i = 0; i < nCopies; i++)
            builder.append(tempData);

        return builder.toString().trim();
    }

    public static void main(String[] args) {
        String mainData = readData("Enter a string (of length 3 atleast): ");
        System.out.printf("Results is: %s\n",
                makeNewStringOfNCopiesOfYcharacters(mainData, 4, 3));
    }
}
