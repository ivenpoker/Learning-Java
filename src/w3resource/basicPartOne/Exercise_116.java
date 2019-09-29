package w3resource.basicPartOne;

// #######################################################################################################
// #                                                                                                     #
// #    Program Purpose: Prints data within a range based on some data properties.                       #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                           #
// #    Creation Date  : September 29, 2019                                                              #
// #                                                                                                     #
// #######################################################################################################

import java.util.stream.IntStream;

public class Exercise_116 {

    private static void doTheProcessing(int low, int high) {
        IntStream.rangeClosed(low, high).forEach( value -> {
            if (value % 3 == 0 && value % 5 == 0) {
                System.out.println("fizz buzz");
            } else if (value % 3 == 0) {
                System.out.println("fizz");
            } else if (value % 5 == 0) {
                System.out.println("buzz");
            } else {
                System.out.println(value);
            }
        });
    }

    public static void main(String[] args) {
        doTheProcessing(1, 100);
    }
}
