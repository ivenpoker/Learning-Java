package w3resource.conditionalStatement;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Reads a positive integer and count the number of digits the number  #
// #                     (less than ten billion) has.                                        #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : August 21, 2020                                                     #
// #                                                                                         #
// ###########################################################################################

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise_29 {

    private static final Scanner input = new Scanner(System.in);

    private static long obtainUserInput(String inputMess) {
        boolean inputValid = false;
        long userInput = 0;

        while (!inputValid) {
            try {
                System.out.print(inputMess);
                userInput = input.nextInt();
                inputValid = true;

            } catch (InputMismatchException iMe) {
                System.err.printf("[invalid_input]: %s%n", iMe.getMessage());
                input.nextLine();                   // clear input message

            } catch (Exception exc) {
                System.err.printf("[MAIN_EXCEPTION]: %s%n", exc.getMessage());
            }
        }
        return userInput;
    }

    private static int countNumberOfDigitsA(long someNum) {
        return String.format("%d", someNum).length();
    }

    private static int countNumberOfDigitsB(long someNum) {
        int cnt = 0;
        while (someNum > 0) {
            someNum /= 10;
            cnt += 1;
        }
        return cnt;
    }

    public static void main(String[] args) {

        long mainUserInput = obtainUserInput("Enter your input here: ");

        System.out.printf("Number of digit in '%d' using algorithm A: %d%n",
                mainUserInput, countNumberOfDigitsA(mainUserInput));
        System.out.printf("Number of digit in '%d' using algorithm B: %d%n",
                mainUserInput, countNumberOfDigitsB(mainUserInput));
    }
}
