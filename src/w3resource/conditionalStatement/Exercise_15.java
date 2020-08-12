package w3resource.conditionalStatement;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Display the 'n' terms of odd natural number and their sum.          #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : August 12, 2020                                                     #
// #                                                                                         #
// ###########################################################################################

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.List;

public class Exercise_15 {

    private static final Scanner input = new Scanner(System.in);

    private static boolean isOdd(int num) {
        return num % 2 != 0;
    }

    private static int obtainOddNumberFromUser(String inputMess) {
        boolean inputValid = false;
        int userInt = 0;

        while (!inputValid) {
            try {
                System.out.print(inputMess);
                userInt = input.nextInt();

                if (userInt < 0) {
                    throw new InputMismatchException("please enter number > 0");
                }
                inputValid = true;

            } catch (InputMismatchException iMe) {
                System.err.printf("[invalid_input]: %s%n", iMe.getMessage());

            } catch (Exception exc) {
                System.err.printf("[MAIN_EXCEPTION]: %s%n", exc.getMessage());
            }
        }
        return userInt;
    }

    private static int[] findAllNOddNumbers(int maxNum) {
        List<Integer> oddFound = new ArrayList<>();
        for (int i = 1, cnt = 0; cnt < maxNum; i++) {
            if (isOdd(i)) {
                oddFound.add(i);
                cnt += 1;
            }
        }
        return oddFound.stream().mapToInt((val) -> val).toArray();
    }

    public static void main(String[] args) {
        int userOddNum = obtainOddNumberFromUser("Enter number of terms (odd number > 0): ");
        int[] oddFound = findAllNOddNumbers(userOddNum);

        System.out.printf("The first %d odd numbers are: %s%n", userOddNum, Arrays.toString(oddFound));
    }

}
