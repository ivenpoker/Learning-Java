package w3resource.utils;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Test if a given string contains the specified sequence of char      #
// #                     values.                                                             #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : November 22, 2020                                                   #
// #                                                                                         #
// ###########################################################################################

public class Exercise_8 {

    private static final int MAX_LINE_LENGTH = 75;

    private static boolean foundInString(String sourceStr, String checkStr) {
        return sourceStr.contains(checkStr);
    }

    public static void main(String[] args) {
        String mainStr = BasicUtils.readUserInputString("Enter original string: ", true);
        String searchStr = BasicUtils.readUserInputString("Enter search string: ", true);

        BasicUtils.printLineInfo("[ RESULTS ]", '=', MAX_LINE_LENGTH);
        System.out.printf("Is search string found: %s%n", foundInString(mainStr, searchStr));
        System.out.printf("Is search string found: %s%n", mainStr.indexOf(searchStr) >= 0);
    }

}
