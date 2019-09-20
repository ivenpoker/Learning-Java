package w3resource.basicPartOne;

import java.util.Scanner;

// ##################################################################################################
// #                                                                                                #
// #    Program Purpose: Reads two string from console and determines if the first string starts    #
// #                     with the second string.                                                    #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                      #
// #    Creation Date  : September 20, 2019                                                         #
// #                                                                                                #
// ##################################################################################################

public class Exercise_85 {

    private static Scanner scanner = new Scanner(System.in);

    private static String readStringFromUser(String inputMess, boolean line) {
        boolean isValid = false;
        String mainData = "";

        do {
            try {
                System.out.print(inputMess);
                if (line) {
                    mainData = scanner.nextLine().trim();
                } else {
                    mainData = scanner.next().trim();
                }
                isValid = true;

            } catch (IllegalStateException illegalStateException) {
                System.err.print("Scanner closed unexpectedly. Re-opening...");
                scanner = new Scanner(System.in);
                System.err.println("[DONE]");

            } catch (Exception exception) {
                System.err.println(exception.getMessage());
            }
        } while (!isValid);

        return mainData;
    }

    public static void main(String[] args) {

        String mainData = readStringFromUser("Enter a sentence or word: ", true);
        String keyStr = readStringFromUser("Enter string to check text above starts with: ", false);

        System.out.printf("Does string starts with '%s': %s\n", keyStr,
                mainData.startsWith(keyStr) ? "YES" : "NO");
    }
}
