package w3resource.basicPartTwo;

// #############################################################################################
// #                                                                                           #
// #    Program Purpose: When character are consecutive in a string , it is possible to        #
// #                     shorten the character string by replacing the character with a        #
// #                     certain rule. For example, in the case of the character string YYYYY, #
// #                     if it is expressed as # 5 Y, it is compressed by one character.       #
// #                     Program restores the original string by entering the compressed       #
// #                     string with this rule. However, the # character does not appear in    #
// #                     the restored character string,                                        #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                 #
// #    Creation Date  : July 31, 2020                                                         #
// #                                                                                           #
// #############################################################################################

import java.util.Objects;
import java.util.Scanner;

public class Exercise_238 {

    private static final Scanner scanner = new Scanner(System.in);
    private static final char KEY_DECRYPT_CHAR = '#';

    private static String readUserString(String inputMess) {
        boolean valid = false;
        String userInput = "";

        while (!valid) {
            try {
                System.out.print(inputMess);
                userInput = scanner.nextLine().trim();

                if (userInput.isEmpty()) {
                    throw new IllegalArgumentException("Invalid input. Please enter some text");
                }
                valid = true;
            } catch (IllegalArgumentException iAe) {
                System.err.printf("[invalid_input]: %s%n", iAe.getMessage());

            } catch (Exception exc) {
                System.err.printf("[EXCEPTION]: %s%n", exc.getMessage());
            }
        }
        return userInput;
    }

    private static String processString(String mainInputStr) {
        if (Objects.isNull(mainInputStr) || mainInputStr.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0, len = mainInputStr.length(); i < len; i++) {
            if (mainInputStr.charAt(i) == KEY_DECRYPT_CHAR) {
                String tmpStr = mainInputStr.substring(i+1);
                if (tmpStr.length() < 2) {
                    throw new IllegalArgumentException("Malformed expression");
                }
                try {
                    int cnt = Integer.parseInt(mainInputStr.charAt(i + 1) + "");
                    char keyChar = mainInputStr.charAt(i + 2);
                    for (int j = 0; j < cnt; j++) {
                        sb.append(keyChar);
                    }
                    i += 2;
                } catch (NumberFormatException nFe) {
                    System.out.printf("[invalid_integer]: %s%n", nFe.getMessage());
                }
            } else {
                sb.append(mainInputStr.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        String mainInput = readUserString("Enter some input string: ");
        System.out.printf("Decrypted message: %s%n", processString(mainInput));

    }

}
