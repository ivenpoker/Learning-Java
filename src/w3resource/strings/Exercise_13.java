package w3resource.strings;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Checks whether two String objects contain the same data.            #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : November 22, 2020                                                   #
// #                                                                                         #
// ###########################################################################################

public class Exercise_13 {

    public static void main(String[] args) {
        String columnist1 = "Stephen Edwin King";
        String columnist2 = "Walter Winchell";
        String columnist3 = "Mike Royko";

        // Are any of the above equal to another ?
        boolean equals1 = columnist1.equals(columnist2);
        boolean equals2 = columnist1.equals(columnist3);

        // Display the results of the equality checks.
        System.out.printf("\"%s\" equals \"%s\": %s%n", columnist1, columnist2, equals1 ? "YES" : "NO");
        System.out.printf("\"%s\" equals \"%s\": %s%n", columnist1, columnist3, equals2 ? "YES" : "NO");
    }

}
