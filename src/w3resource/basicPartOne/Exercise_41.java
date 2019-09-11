package w3resource.basicPartOne;

// ########################################################################################
// #                                                                                      #
// #    Program Purpose: Prints the ASCII value of a given character.                     #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                            #
// #    Creation Date  : September 11, 2019                                               #
// #                                                                                      #
// ########################################################################################

import java.util.Scanner;

public class Exercise_41 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a character to get ASCII value: ");
        char someChar = scanner.next().charAt(0);

        System.out.printf("The ASCII value of %c is: %d\n", someChar, (int) someChar);

    }


}
