package w3resource.utils;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Concatenates two string together and display concatenated string.   #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : November 22, 2020                                                   #
// #                                                                                         #
// ###########################################################################################

public class Exercise_7 {

    public static void main(String[] args) {

        // Obtain string from user
        String fsStr = BasicUtils.readUserInputString("Enter first string: ", true);
        String sndStr = BasicUtils.readUserInputString("Enter second string: ", true);

        // Concatenate obtained strings.
        String newStr = fsStr.concat(sndStr);

        // Display concatenated string
        System.out.printf("Concatenated string: %s%n", newStr);
    }

}

