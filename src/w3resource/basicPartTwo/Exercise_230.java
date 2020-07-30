package w3resource.basicPartTwo;

// #############################################################################################
// #                                                                                           #
// #    Program Purpose: Replaces the string 'python' with 'java' and 'java' with 'python' in  #
// #                     a given string.                                                       #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                 #
// #    Creation Date  : July 30, 2020                                                         #
// #                                                                                           #
// #############################################################################################

import java.util.Scanner;

public class Exercise_230 {

    private static final Scanner input = new Scanner(System.in);

    private static String obtainUserInputString(String inputMess) {
        boolean valid = false;
        String userStr = "";

        while (!valid) {
            try {
                System.out.print(inputMess);
                userStr = input.nextLine().trim();

                if (userStr.isEmpty()) {
                    throw new IllegalArgumentException("please provide some input text");
                }
                valid = true;
            } catch (IllegalArgumentException iAe) {
                System.err.printf("[invalid_input]: %s%n", iAe.getMessage());

            } catch (Exception exc) {
                System.err.printf("[EXCEPTION]: %s%n", exc.getMessage());
            }
        }
        return userStr;
    }

    private static String performReplacements(String mainText) {
        String target1 = "python";
        String target2 = "java";

        StringBuilder sb = new StringBuilder();

        for (int i = 0, len = mainText.length(); i < len; i++) {
             if (i + target1.length() < len) {
                 if (mainText.substring(i, i + target1.length()).toLowerCase().equals(target1)) {
                     sb.append(target2);
                     i += target1.length()-1;
                     continue;
                 }
             }
             if (i + target2.length() < len) {
                 if (mainText.substring(i, i + target2.length()).toLowerCase().equals(target2)) {
                     sb.append(target1);
                     i += target2.length()-1;
                     continue;
                 }
             }
             sb.append(mainText.charAt(i));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String mainText = obtainUserInputString("Enter some text: ");
        System.out.printf("After all replacements: %s%n", performReplacements(mainText));
    }
}
