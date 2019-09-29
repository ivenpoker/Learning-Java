package w3resource.basicPartOne;

// #######################################################################################################
// #                                                                                                     #
// #    Program Purpose: Computes the square root of a number.                                           #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                           #
// #    Creation Date  : September 29, 2019                                                              #
// #                                                                                                     #
// #######################################################################################################

import java.util.Scanner;

public class Exercise_117 {

    private static Scanner scanner = new Scanner(System.in);

    private static int getUserInt(String mess) {
        boolean isValid = false;
        int userData = 0;

        while (!isValid) {
            try {
                System.out.print(mess);
                userData = scanner.nextInt();
                isValid = true;

            } catch (IllegalStateException illegalStateException) {
                System.err.print("[WARNING]: Scanner closed prematurely. Re-opening...");
                scanner = new Scanner(System.in);
                System.out.println("[DONE]");

            } catch (Exception exception) {
                System.err.println(exception.getMessage());
            }
        }
        return userData;
    }

    private static int computeSquareRoot(int num) {
        if (num == 0 || num == 1) {
            return num;
        }
        int a = 0;
        int b = num;
        while (a <= b) {
            int mid = (a + b) >> 1;
            if (num / mid < mid) {
                b = mid-1;
            } else {
                if (num / (mid + 1) <= mid) {
                    return mid;
                }
                a = mid + 1;
            }
        }
        return a;
    }

    public static void main(String[] args) {
        int userVal = getUserInt("Enter a integer to compute square: ");
        int squareVal = computeSquareRoot(userVal);
        System.out.printf("Square of '%d' is: %d\n", userVal, squareVal);
    }
}
