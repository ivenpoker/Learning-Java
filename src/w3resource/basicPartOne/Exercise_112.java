package w3resource.basicPartOne;

// #######################################################################################################
// #                                                                                                     #
// #    Program Purpose: Compute the number of trailing zeros in a factorial.                            #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                           #
// #    Creation Date  : September 25, 2019                                                              #
// #                                                                                                     #
// #######################################################################################################

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise_112 {

    private static Scanner scanner = new Scanner(System.in);

    private static long readInteger(String mess) {
        boolean isValid = false;
        long mainInt = 0;
        while (!isValid) {
            try {
                System.out.print(mess);
                mainInt = scanner.nextInt();
                isValid = true;

            } catch (InputMismatchException inputMismatchException) {
                System.err.println("[ERROR]: Input is not an integer. Please try again.");

            } catch (IllegalStateException illegalStateException) {
                System.err.print("[WARNING]: Scanner closed unexpectedly. Re-opening...");
                scanner = new Scanner(System.in);
                System.out.println("[DONE]");

            } catch (Exception exception) {
                System.err.println(exception.getMessage());
            }
        }
        return mainInt;
    }

    private static long factorial(long num) {
        if (num <= 1)
            return 1;
        return num * factorial(num-1);
    }

    private static int countNumberOfTrailingZeros(long mainNum, int keyVal) {
        String numStr = String.format("%d", mainNum);
        int cnt = 0;
        for (int i = numStr.length()-1; i >= 0; i--) {
            if ((numStr.charAt(i) + "").equals(keyVal + "") && (i == numStr.length()-1)) {
                cnt++;
            } else if ((numStr.charAt(i) + "").equals(String.format("%d", keyVal)) &&
                    (numStr.charAt(i+1) + "").equals(String.format("%d", keyVal))) {
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        long userNum = readInteger("Enter number to compute factorial: ");
        long fact = factorial(userNum);
        int numOfZeros = countNumberOfTrailingZeros(fact, 0);
        System.out.printf("%d! = %d, number of trailing zeros is %d",
                userNum, fact, numOfZeros);
    }
}
