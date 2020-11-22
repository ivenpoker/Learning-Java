package w3resource.strings;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Gets the canonical representation of the string object.             #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : November 22, 2020                                                   #
// #                                                                                         #
// ###########################################################################################

public class Exercise_20 {

    public static void main(String[] args) {
        String str1 = "Java Exercises";
        String str2 = new StringBuffer("Java").append(" Exercises").toString();
        String str3 = str2.intern();

        System.out.printf("str1 == str2 ?: %s%n", (str1 == str2 ? "YES" : "NO"));
        System.out.printf("str1 == str3 ?: %s%n", (str1 == str3 ? "YES" : "NO") );
    }
}
