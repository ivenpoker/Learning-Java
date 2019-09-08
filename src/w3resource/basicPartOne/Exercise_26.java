package w3resource.basicPartOne;

// ########################################################################################
// #                                                                                      #
// #    Program Purpose: Converts octal number to binary number.                          #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                            #
// #    Creation Date  : September 8, 2019                                                #
// #                                                                                      #
// ########################################################################################

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise_26 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] octalNumValues = {0, 1, 10, 11, 100, 101, 110, 111};
        long octalNum = 0;
        long tempOctalNum = 0;
        long binaryNum = 0;
        long place = 0;
        int rem = 0;
        boolean valid = false;

        do {
            try {
                System.out.print("Input any octal number: ");
                octalNum = input.nextLong();
                valid = true;

            } catch (InputMismatchException inputMismatchException) {
                input.nextLine();       // clear line and discard any input stream data.
                System.out.println("Invalid input. Please, try again.");
            }
        } while (!valid);

        try {
            tempOctalNum = octalNum;
            place = 1;

            while (tempOctalNum != 0) {
                rem = (int)(tempOctalNum % 10);
                binaryNum = octalNumValues[rem] * place + binaryNum;
                tempOctalNum /= 10;
                place *= 1000;
            }

            System.out.printf("Equivalent binary number: %d\n", binaryNum);

        } catch (Exception exception) {
            System.err.println("Error during conversion...");
            exception.printStackTrace();
        }
    }
}
