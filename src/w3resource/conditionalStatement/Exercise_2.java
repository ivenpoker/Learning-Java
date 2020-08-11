package w3resource.conditionalStatement;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Finds the root of a quadratic equation.                             #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : August 11, 2020                                                     #
// #                                                                                         #
// ###########################################################################################

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise_2 {

    private static final Scanner input = new Scanner(System.in);

    private static int obtainEquationVal(String inputMess) {
        boolean inputValid = false;
        int userInput = 0;

        while (!inputValid) {
            try {
                System.out.print(inputMess);
                userInput = input.nextInt();
                inputValid = true;

            } catch (InputMismatchException iMe) {
                System.err.printf("[invalid_input]: %s%n", iMe.getMessage());
                input.nextLine();           // clear input stream.

            } catch (Exception exc) {
                System.err.printf("[MAIN_EXCEPTION]: %s%n", exc.getMessage());
            }
        }
        return userInput;
    }

    public static void main(String[] args) {

        System.out.printf("[PROGRAM: Solves the root of the quadratic equation: ax^2 + bx + c = 0]%n%n");

        int aVal = obtainEquationVal("Enter the value of 'a': ");
        int bVal = obtainEquationVal("Enter the value of 'b': ");
        int cVal = obtainEquationVal("Enter the value of 'c': ");

        double discriminant = Math.pow(bVal, 2) - (4 * aVal * cVal);
        if (discriminant < 0) {
            System.out.printf("%n[RESULTS]: Quadratic equation has complex roots%n");
        } else{
            double rootA = (-bVal - Math.sqrt(discriminant)) / (2 * aVal);
            double rootB = (-bVal + Math.sqrt(discriminant)) / (2 * aVal);

            System.out.printf("%n[RESULTS]: root#1: %.8f | root#2: %.8f%n", rootA, rootB);
        }
    }

}



