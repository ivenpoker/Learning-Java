package w3resource.basicPartTwo;

// #############################################################################################
// #                                                                                           #
// #    Program Purpose: Use the letter H to mean "hundred", the letter T to mean "ten" and    #
// #                     “1, 2, . . . n” to represent the ones digit n (<10). Program converts #
// #                     3 digits positive number in a given format.                           #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                 #
// #    Creation Date  : August 07, 2020                                                       #
// #                                                                                           #
// #############################################################################################

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise_246 {

    private static final Scanner input = new Scanner(System.in);
    private static final int LOWER_BOUND = 0;
    private static final int UPPER_BOUND = 999;
    private static final int EXIT_FAILURE = 1;

    private static boolean inRange(int low, int val, int high) {
        return low <= val && val <=  high;
    }

    private static int readScoreFromUser(String inputMess, int lowerBound, int upperBound) {
        boolean inputValid = false;
        int userInput = -1;

        while (!inputValid) {
            try {
                System.out.print(inputMess);
                userInput = input.nextInt();

                if (!inRange(lowerBound, userInput, upperBound)) {
                    throw new InputMismatchException(
                            String.format("please enter integer in range [%d, %d]", lowerBound, upperBound));
                }
                inputValid = true;
            } catch (InputMismatchException iMe) {
                System.err.printf("[invalid_input]: %s%n", iMe.getMessage());

            } catch (Exception exc) {
                System.err.printf("[MAIN_EXCEPTION]: Something 'bad' occurred.%n");
            }
        }
        return userInput;
    }

    private static String processUserInteger(int userInt) {
        String userIntStr = String.format("%d", userInt);
        StringBuilder sb = new StringBuilder();

        while (userIntStr.length() > 1) {

            int nowLen = userIntStr.length();
            int numHund = Integer.parseInt(userIntStr.charAt(0) + "");
            for (int i = 0; i < numHund; i++) {
                switch (nowLen) {
                    case 3: sb.append("H"); break;
                    case 2: sb.append("T"); break;
                    default:
                        System.err.printf("[ALGORITHM_ERROR]: Terminating .... %n");
                        System.exit(EXIT_FAILURE);
                }
            }
            userIntStr = userIntStr.substring(1);
        }

        String tmp = String.format("%d", userInt);
        int lastDigit = Integer.parseInt(tmp.charAt(tmp.length()-1) + "");

        for (int i = 1; i <= lastDigit; i++) {
            sb.append(i);
        }

        return sb.toString();
    }

    public static void main(String[] args) {

        int mainUserInput = readScoreFromUser(String.format("Enter some integer in range [%d, %d]: ",
                                    LOWER_BOUND, UPPER_BOUND), LOWER_BOUND, UPPER_BOUND);
        System.out.printf("After processing string: %s%n", processUserInteger(mainUserInput));

    }

}
