package w3resource.basicPartOne;

// ########################################################################################
// #                                                                                      #
// #    Program Purpose: Divides two numbers and print results.                           #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                            #
// #    Creation Date  : September 3, 2019                                                #
// #                                                                                      #
// ########################################################################################


import java.util.Scanner;


public class Exercise_3 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.printf("Enter first number: ");
        double firstInput = input.nextDouble();

        System.out.print("Enter second number: ");
        double secondInput = input.nextDouble();

        System.out.printf("%.1f / %.1f is: %.3f\n", firstInput, secondInput,
                (firstInput / secondInput));
    }
}
