package w3resource.strings;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Prints the current date and time in the specified format.           #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : November 22, 2020                                                   #
// #                                                                                         #
// ###########################################################################################

import java.util.Calendar;

public class Exercise_15 {

    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        System.out.println("Current Date and Time: ");
        System.out.format("%tB %te, %tY%n", c, c, c);
        System.out.format("%tl:%tM %tp%n", c, c, c);
    }

}
