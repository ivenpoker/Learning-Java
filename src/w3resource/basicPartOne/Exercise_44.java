package w3resource.basicPartOne;

// ########################################################################################
// #                                                                                      #
// #    Program Purpose: Accepts an integer and computes the value of n+nn+nnn.           #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                            #
// #    Creation Date  : September 11, 2019                                               #
// #                                                                                      #
// ########################################################################################

import java.util.Scanner;

public class Exercise_44 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number: ");
        int number = scanner.nextInt();

        System.out.printf("%d + %d%d + %d%d%d = %d\n",
                number, number, number, number, number, number,
                (number + (number * number) + (number * number * number)));
    }

}
