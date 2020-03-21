package w3resource.basicPartTwo;

// ############################################################################################
// #                                                                                          #
// #    Program Purpose: Finds the index of first non-repeating character in a given string.  #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                #
// #    Creation Date  : March 21, 2020                                                       #
// #                                                                                          #
// ############################################################################################

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class Exercise_187 {

    private static Scanner scanner = new Scanner(System.in);

    private static String obtainUserData(String inputMessage) {
        String userData = "";
        boolean cont = true;

        while (cont) {
            try {
                System.out.print(inputMessage);
                userData = scanner.next().trim();
                cont = false;

            } catch (IllegalStateException illegalStateExc) {
                System.err.print("[SCANNER_CLOSED]: RE-OPENING ...");
                scanner = new Scanner(System.in);

            } catch (Exception exc) {
                System.err.print("[ERROR]: " + exc.getMessage());
            }
        }
        return userData;
    }

    private static char findSmallestChar(String mainData) {
        Map<Character, Integer> mapData = new HashMap<>();
        for (Character ch : mainData.toCharArray()) {
            if (mapData.containsKey(ch)) {
                int tempCnt = mapData.get(ch);
                mapData.put(ch, tempCnt);
            } else {
                mapData.put(ch, 1);
            }
        }

        // Now, we find the first character (key) in map whose
        // value is 1.

        char foundChar = ' ';

        for (Character key : mapData.keySet()) {
            if (mapData.get(key) == 1) {
                foundChar = key;
                break;
            }
        }
        return foundChar;
    }

    public static void main(String[] args) {
        String userData  = obtainUserData("Enter some string: ");
        char foundChar = findSmallestChar(userData);

        System.out.printf("Index of first non-repeating character: %d\n",
                userData.indexOf(foundChar)-1);
    }
}
