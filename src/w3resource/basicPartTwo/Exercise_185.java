package w3resource.basicPartTwo;

// ############################################################################################
// #                                                                                          #
// #    Program Purpose: Determines if two strings are isomorphic.                            #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                #
// #    Creation Date  : January 29, 2020                                                     #
// #                                                                                          #
// ############################################################################################

import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;
import java.util.Map;

public class Exercise_185 {

    private static Scanner scanner = new Scanner(System.in);

    private static String obtainUserData(String inputMess) {
        String userData = "";
        boolean cont = true;

        while (cont) {
            try {
                System.out.print(inputMess);
                userData = scanner.next().trim();
                cont = false;

            } catch (IllegalStateException stateExc) {
                System.err.print("[SCANNER_ERROR]: RE-BOOTING ... ");
                scanner = new Scanner(System.in);
                System.out.println("[DONE]");

            } catch (Exception exc) {
                System.err.printf("[ERROR]: %s\n", exc.getMessage());
            }
        }
        return userData;
    }

    private static boolean isIsomorphic(String dataA, String dataB) {
        if (Objects.isNull(dataA) || Objects.isNull(dataB)) {
            return false;
        }
        if (dataA.length() != dataB.length()) {
            return false;
        }
        int len = dataA.length();           // could have been dataB
        Map<Character, Character> store = new HashMap<>();

        for (int i = 0; i < len; i++) {
            char charA = dataA.charAt(i);
            char charB = dataB.charAt(i);

            if (store.containsKey(charA)) {
                if (store.get(charA) != charB) {
                    return false;
                }
            } else {
                if (store.containsValue(charB)) {
                    return false;
                }
                store.put(charA, charB);
            }
        }
        return true;

    }

    public static void main(String[] args) {
        String dataA = obtainUserData(" Enter first string: ");
        String dataB = obtainUserData("Enter second string: ");

        System.out.printf("Are both strings isomorphic: %s\n", isIsomorphic(dataA, dataB));
    }
}
