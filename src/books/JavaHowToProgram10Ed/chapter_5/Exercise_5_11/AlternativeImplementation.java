package books.JavaHowToProgram10Ed.chapter_5.Exercise_5_11;

import java.util.Scanner;

public class AlternativeImplementation {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Obtain number of values user will enter from user.

        System.out.print("How many values will you enter ?: ");
        int inputLen = input.nextInt();

        // Validate user input. Making sure he/she specified a number > 0

        while (inputLen < 0) {
            System.out.print("Please enter +ve number > 0: ");
            inputLen = input.nextInt();
        }

        System.out.printf("Enter %d numbers%n", inputLen);

        int smallest = Integer.MAX_VALUE;           // default smallest value.
        for (int i = 0; i < inputLen; i++) {
            int tmp = input.nextInt();
            if (tmp < smallest) {
                smallest = tmp;
            }
        }
        System.out.printf("Smallest of %d numbers is: %d%n", inputLen, smallest);
    }

}
