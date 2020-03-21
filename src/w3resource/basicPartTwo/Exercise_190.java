package w3resource.basicPartTwo;

// ############################################################################################
// #                                                                                          #
// #    Program Purpose: Finds the missing string(s) from two given strings.                  #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                #
// #    Creation Date  : March 21, 2020                                                       #
// #                                                                                          #
// ############################################################################################

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Exercise_190 {

    private static Scanner scanner = new Scanner(System.in);

    private static String obtainUserData(String inputMessage) {
        String userData = "";
        boolean cont = true;

        while (cont) {
            try {
                System.out.print(inputMessage);
                userData = scanner.nextLine().trim();
                cont = false;

            } catch (IllegalStateException illegalStateExc) {
                System.err.print("[SCANNER_CLOSE]: Re-opening ...");
                scanner = new Scanner(System.in);
                System.out.println("[DONE]");

            } catch (Exception exc) {
                System.err.printf("[ERROR]: %s\n", exc.getMessage());
            }
        }
        return userData;
    }

    private static String[] findMissingInStrings(String fstData, String sndData) {
        List<String> fstStrList = Arrays.asList(fstData.split(" "));
        List<String> sndStrList = Arrays.asList(sndData.split(" "));
        List<String> missingStrs = new LinkedList<>();

        for (String tmpStr : fstStrList) {
            if (!sndStrList.contains(tmpStr)) {
                missingStrs.add(tmpStr);
            }
        }
        for (String tmpStr : sndStrList) {
            if (!missingStrs.contains(tmpStr) && !fstData.contains(tmpStr)) {
                missingStrs.add(tmpStr);
            }
        }
        return missingStrs.toArray(new String[0]);
    }

    public static void main(String[] args) {
        String firstUserInput = obtainUserData("Enter first strings: ");
        String secondUserInput = obtainUserData("Enter second strings: ");
        System.out.printf("Missing strings in second: %s\n",
                Arrays.toString(findMissingInStrings(firstUserInput, secondUserInput)));
    }
}
