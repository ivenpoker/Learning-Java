package books.JavaHowToProgram10Ed.chapter_14.Exercises.Exercise_14_21;

import java.util.Scanner;

public class Exercise_14_21 {

    private static final Scanner scanner = new Scanner(System.in);
    private static final double MAX_AMOUNT = 1000.0;

    private static final String[] mainDigitStrs =
            {"ZERO", "ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE", "TEN",
             "ELEVEN", "TWELVE", "THIRTEEN", "FOURTEEN", "FIFTEEN", "SIXTEEN", "SEVENTEEN", "EIGHTEEN",
             "NINETEEN", "TWENTY", "THIRTY", "FOURTY", "FIFTY", "SIXTY", "SEVENTY", "EIGHTY", "NINETY"};

    private static boolean inRange(double low, double val, double high) {
        return low <= val && val <= high;
    }

    private static boolean inRange(int low, int val, double high) {
        return low <= val && val <= high;
    }

    private static String generateMessage(double amount) {
        int wholePart = (int) amount;
        int decimalPart = (int) ((amount - wholePart) * 100);
        String amountMsg = "";

        amountMsg = numberToString(wholePart).trim();
//        amountMsg += " | " + numberToString(decimalPart).trim();

        amountMsg = String.format("%s and %d/%d", amountMsg, decimalPart, 100);
        return amountMsg;
    }

    private static String numberToString(int mainInt) {
        StringBuilder sbStore = new StringBuilder();
        if (inRange(0, mainInt, 99)) {
            if (inRange(0, mainInt, 20)) {
                sbStore.append(mainDigitStrs[mainInt]).append(" ");
                return sbStore.toString();

            } else if (inRange(21, mainInt, 99)) {
                int firstDigit = mainInt / 10;
                int lastDigit = mainInt % 10;

                sbStore.append(mainDigitStrs[18 + firstDigit]).append(" ");
                if (lastDigit == 0) {
                    return sbStore.toString();
                }
                sbStore.append(mainDigitStrs[lastDigit]);
                return sbStore.toString();
            }
        } else if (inRange(100, mainInt,999)) {
             int fstDigit = mainInt / 100;
             int sndThrdDigits = mainInt % 100;

             sbStore.append(mainDigitStrs[fstDigit]).append(" HUNDRED");

             // use recursion to generate the remaining digits to the string.
             String sndThrdDigitsStr = numberToString(sndThrdDigits);

             if (!sndThrdDigitsStr.isEmpty() && sbStore.indexOf("ZERO") == -1) {
                 sbStore.append(" AND ").append(sndThrdDigitsStr);
             }
             return sbStore.toString();
        }
        return "";
    }



    private static double obtainUserInput(String inputMess) {
        boolean valid = false;
        double userInputAmount = 0.0;

        while (!valid) {
            try {
                System.out.print(inputMess);
                userInputAmount = scanner.nextDouble();

                if (!inRange(0.0, userInputAmount, MAX_AMOUNT)) {
                    throw new IllegalArgumentException(
                            String.format("Invalid input. Must be in range [0.0, %.2f]", MAX_AMOUNT));
                }
                valid = true;
            } catch (IllegalArgumentException iAe) {
                System.out.printf("[invalid_input]: %s%n", iAe.getMessage());
                scanner.nextLine();                 // clear input stream.

            } catch (Exception exc) {
                System.out.printf("[EXCEPTION]: %s%n", exc.getMessage());
                scanner.nextLine();

            }
        }
        return userInputAmount;
    }

    public static void main(String[] args) {
        double userAmount = obtainUserInput("Enter an amount: ");
        System.out.printf("Entered amount: %.2f%n", userAmount);
        System.out.printf("Message: %s%n", generateMessage(userAmount));
    }
}
