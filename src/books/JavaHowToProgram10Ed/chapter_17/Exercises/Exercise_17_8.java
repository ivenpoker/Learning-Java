package books.JavaHowToProgram10Ed.chapter_17.Exercises;

// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 17.7 from book.                       #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : January 12, 2020                                           #
// #                                                                                  #
// ####################################################################################

import java.security.SecureRandom;

public class Exercise_17_8 {

    public static void main(String[] args) {
        SecureRandom random = new SecureRandom();

        // random.ints(1000000, 1, 3)           // create a stream of size '1000000' with random numbers in range [1, 3)
        //            .boxed()                  // converts the 'ints' to 'Integers
        //            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))   // group the data by itself and it's frequency
        //            .forEach((side, freq) -> System.out.printf("%-6d%d%n", side, freq)); // for each key data in 'Map' returned, reveal some info to console.
    }
}
