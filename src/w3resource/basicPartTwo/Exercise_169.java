package w3resource.basicPartTwo;

// ####################################################################################
// #                                                                                  #
// #    Program Purpose: Reverses the content of a sentence (assuming a single space  #
// #                     between two words) without reverse every word.               #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                        #
// #    Creation Date  : December 29, 2019                                            #
// #                                                                                  #
// ####################################################################################

import java.util.Scanner;

public class Exercise_169 {

    private static Scanner scanner = new Scanner(System.in);

    private static String obtainUserData(String inputMessage) {
        String userData = "";
        boolean isValid = false;

        while (!isValid) {
            try {
                System.out.print(inputMessage);
                userData = scanner.nextLine().trim();
                isValid = true;

            } catch (Exception exc) {
                System.err.println("[ERROR]: " + exc.getMessage());
            }
        }
        return userData;
    }

    private static String obtainReverse(String sentence) {
        if (sentence.indexOf(' ') < 0)
            return sentence;
        String[] tokens = sentence.split(" ");

        // remove spaces from individual words (trimming)
        for (int i = 0; i < tokens.length; i++) {
            tokens[i] = tokens[i].trim();
        }

        StringBuilder sb = new StringBuilder();
        for (int i = tokens.length-1; i >= 0; i--) {
            sb.append(tokens[i]).append(" ");
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        String userData = obtainUserData("Enter some sentence: ");
        System.out.printf("Reverse sentence is: %s\n", obtainReverse(userData));
    }
}
