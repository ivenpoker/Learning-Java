package w3resource.basicPartOne;

// ########################################################################################
// #                                                                                      #
// #    Program Purpose: Checks whether Java is installed on system. If it is, prints     #
// #                     some Java information.                                           #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                            #
// #    Creation Date  : September 8, 2019                                                #
// #                                                                                      #
// ########################################################################################

public class Exercise_31 {

    public static void main(String[] args) {

        System.out.printf("\nJava Version: %s\n", System.getProperty("java.version"));
        System.out.printf("Java Runtime version: %s\n", System.getProperty("java.runtime.version"));
        System.out.printf("Java Home: %s\n", System.getProperty("java.home"));
        System.out.printf("Java Vendor: %s\n", System.getProperty("java.vendor"));
        System.out.printf("Java Vendor URL: %s\n", System.getProperty("java.vendor.url"));
        System.out.printf("Java Class path: %s\n", System.getProperty("java.class.path"));

    }
}
