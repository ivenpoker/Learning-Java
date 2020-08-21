package w3resource.conditionalStatement;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Displays the number rhombus structure using alphabetic characters.  #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : August 21, 2020                                                     #
// #                                                                                         #
// ###########################################################################################

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise_26 {

    private static final Scanner input = new Scanner(System.in);

    private static int obtainUserNumberOfRows(String inputMess) {
        boolean inputValid = false;
        int userInput = 0;

        while (!inputValid) {
            try {
                System.out.print(inputMess);
                userInput = input.nextInt();

                if (userInput < 0) {
                    throw new InputMismatchException(String.format("Input (%d) must be > 0.", userInput));
                }
                inputValid = true;

            } catch (InputMismatchException iMe) {
                System.err.printf("[invalid_input]: %s%n", iMe.getMessage());
                input.nextLine();                   // clear input stream.

            } catch (Exception exc) {
                System.out.printf("[MAIN_EXCEPTION]: %s%n", exc.getMessage());
            }
        }
        return userInput;
    }

    private static void printAlphabeticStructure(int numOfRows) {
        int count = 1;
        int count2 = 1;
        char c = 'A';

        for (int i = 1; i < (numOfRows * 2); i++)
        {
            for (int spc = numOfRows - count2; spc > 0; spc--)
            //print space
            {
                System.out.print(" ");
            }
            if (i < numOfRows)
            {
                count2++;
            }
            else
            {
                count2--;
            }
            for (int j = 0; j < count; j++)
            {
                System.out.print(c);//print Character
                if (j < count / 2)
                {
                    c++;
                } else
                {
                    c--;
                }
            }
            if (i < numOfRows)
            {
                count = count + 2;
            }
            else
            {
                count = count - 2;
            }
            c = 'A';

            System.out.println();
        }
    }

    public static void main(String[] args) {

        int mainUserInput = obtainUserNumberOfRows("Enter number of rows: ");
        printAlphabeticStructure(mainUserInput);

    }

}
