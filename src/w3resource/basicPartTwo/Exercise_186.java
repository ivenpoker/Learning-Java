package w3resource.basicPartTwo;

// ############################################################################################
// #                                                                                          #
// #    Program Purpose: Determines if a number is strobrogrammatic.                          #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                #
// #    Creation Date  : January 29, 2020                                                     #
// #                                                                                          #
// ############################################################################################

import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

public class Exercise_186 {

    private static Scanner scanner = new Scanner(System.in);

    private static String obtainUserData(String inputMess) {
        String userData = "";
        boolean cont = true;

        while (cont) {
            try {
                System.out.print(inputMess);
                userData = scanner.next().trim();
                cont = false;

            } catch (IllegalStateException exc) {
                System.err.print("[SCANNER_ERROR]: RE-BOOTING ... ");
                scanner = new Scanner(System.in);
                System.out.println("[DONE]");

            } catch (Exception exc) {
                System.err.printf("[ERROR]: %s\n", exc.getMessage());
            }
        }
        return userData;
    }

    private static boolean isStrobogrammatic(String someStr) {
        if (Objects.isNull(someStr) || someStr.length() == 0) {
            return true;
        }
        HashMap<Character, Character> map = new HashMap<>();
        map.put('0', '0');
        map.put('1', '1');
        map.put('8', '8');
        map.put('6', '9');
        map.put('9', '6');

        int left = 0;
        int right = someStr.length()-1;
        while (left <= right) {
            if (!map.containsKey(someStr.charAt(right)) ||
                    someStr.charAt(left) != map.get(someStr.charAt(right))) {
                return false;
            }
            left += 1;
            right -= 1;
        }
        return true;
    }

    public static void main(String[] args) {
        String mainData = obtainUserData("Enter number: ");
        System.out.printf("Is '%s' strobrogrammatic ?: %s\n", mainData, isStrobogrammatic(mainData));
    }

}
