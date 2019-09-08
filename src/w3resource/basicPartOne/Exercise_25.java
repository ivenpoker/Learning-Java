package w3resource.basicPartOne;


import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise_25 {

    private static long octalToDecimal(long octalNumber) {
        long decimalNum = 0;
        int i = 0;

        while (octalNumber != 0) {
            decimalNum = (long) (decimalNum + (octalNumber % 10) * Math.pow(8, i++));
            octalNumber /= 10;
        }
        return decimalNum;

    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        long octalNum = 0;
        boolean valid = false;

        do {
            try {
                System.out.print("Enter any octal number: ");
                octalNum = input.nextLong();
                valid = true;

            } catch (InputMismatchException inputMismatchException) {
                input.nextLine();           // clear input stream, discarding stream data.
                System.err.println("Invalid input. Please, try again.");
            }
        } while (!valid);

        System.out.printf("Equivalent decimal number: %d\n", octalToDecimal(octalNum));
    }
}
