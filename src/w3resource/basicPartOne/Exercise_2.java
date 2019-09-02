package w3resource.basicPartOne;

// ########################################################################################
// #                                                                                      #
// #    Program Purpose: Sum two numbers from user.                                       #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                            #
// #    Creation Date  : September 3, 2019                                                #
// #                                                                                      #
// ########################################################################################

import java.util.Scanner;

public class Exercise_2 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter first integer: ");
        int firstInt = input.nextInt();

        System.out.print("Enter second integer: ");
        int secondInt = input.nextInt();

        System.out.printf("Sum of %d and %d is: %d", firstInt,
                secondInt, (firstInt + secondInt));
    }

}


