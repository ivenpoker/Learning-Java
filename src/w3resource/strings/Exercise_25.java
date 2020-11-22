package w3resource.strings;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Replaces each substring of a given string that matches the given    #
// #                     regular expression with the given replacement.                      #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : November 22, 2020                                                   #
// #                                                                                         #
// ###########################################################################################

import w3resource.utils.BasicUtils;

public class Exercise_25 {

    private static final int MAX_PRINT_LENGTH = 75;

    public static void main(String[] args) {
        String userStr = BasicUtils.readUserInputString("Enter target text: ", true);
        String textToReplace = BasicUtils.readUserInputString("Enter text to replace: ", true);
        String replacementText = BasicUtils.readUserInputString("Enter replacement text: ", true);

        String updatedText = userStr.replaceAll(textToReplace, replacementText);
        BasicUtils.printLineInfo("[ RESULTS ]", '=', MAX_PRINT_LENGTH);

        System.out.println(updatedText);
    }

}
