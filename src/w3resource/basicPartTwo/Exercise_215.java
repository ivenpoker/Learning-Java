package w3resource.basicPartTwo;

// #############################################################################################
// #                                                                                           #
// #    Program Purpose: Computes the amount of the depth in 'n' months. The borrowing amount  #
// #                     is $100,000 and the loan adds 4% interest of the dept and rounds it   #
// #                     to the nearest 1,000 above month by month.                            #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                 #
// #    Creation Date  : July 02, 2020                                                         #
// #                                                                                           #
// #############################################################################################

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise_215 {

    private static Scanner scanner = new Scanner(System.in);

    private static int obtainUserNumberOfMonths(String inputMess) {
        boolean isValid = false;
        int userNumOfMonths = 0;

        while (!isValid) {
            try {
                System.out.print(inputMess);
                userNumOfMonths = scanner.nextInt();

                if (userNumOfMonths < 1 || userNumOfMonths > 12) {
                    throw new IllegalArgumentException("Invalid input. Must be in range [1, 12]");
                }
                isValid = true;
            } catch (IllegalArgumentException | InputMismatchException iAMe) {
                System.err.printf("[INVALID__INPUT]: %s%n", iAMe.getMessage());
                scanner.nextLine();                 // clear input stream.

            } catch (IllegalStateException iSe) {
                System.err.print("[RE-OPENING__SCANNER] ... ");
                scanner = new Scanner(System.in);
                scanner.nextLine();                 // clear input stream.

            } catch (Exception exc) {
                System.err.printf("[CORE__ERROR]: %s%n", exc.getMessage());
            }
        }
        return userNumOfMonths;
    }

    public static void main(String[] args) {

        int month = obtainUserNumberOfMonths("Input number of months: ");
        double c = 100000;
        for (int i = 0; i < month; i++) {
            c += c * 0.04;
            if (c % 1000 != 0) {
                c -= c % 1000;
                c += 1000;
            }
        }
        System.out.printf("Amount of dept: %.0f%n", c);
    }

}
