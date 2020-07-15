package books.JavaHowToProgram10Ed.chapter_14.Exercises.Exercise_14_8;

import java.util.Scanner;

public class AlternativeImplementation {

    private static Scanner scanner = new Scanner(System.in);

    private static String obtainUserInput(String inputMess) {
        boolean isValid = false;
        String userInput = "";

        while (!isValid) {
            try {
                System.out.print(inputMess);
                userInput = scanner.nextLine().trim();

                if (userInput.isEmpty()) {
                    throw new IllegalArgumentException("Please enter a telephone number.");
                }
                isValid = true;

            } catch (IllegalStateException iSe) {
                System.err.print("[re-opening_scanner] ... ");
                scanner = new Scanner(System.in);
                scanner.nextLine();                 // clear input stream

            } catch (Exception exc) {
                System.err.printf("[exception]: %s%n", exc.getMessage());
            }
        }
        return userInput;
    }

    private static String obtainAndValidateUserPhoneNumber() {
        String supposedPhoneNumber = "";
        boolean validPhoneNum = false;

        while (!validPhoneNum) {
            try {
                supposedPhoneNumber = obtainUserInput("Enter telephone number [ as: (xxx) xxx-xxxx ]: ");

                // if this is a valid telephone number (using regex)
                if (!supposedPhoneNumber.matches("\\d{10}|(?:\\d{3}-){2}\\d{4}|\\(\\d{3}\\)\\d{3}-?\\d{4}|\\(\\d{3}\\)-\\d{3}-?\\d{4}|\\(\\d{3}\\) \\d{3} ?\\d{4}|\\(\\d{3}\\)-\\d{3} ?\\d{4}|\\(\\d{3}\\) \\d{3}-?\\d{4}")) {
                    throw new IllegalArgumentException("Invalid phone number");
                }
                validPhoneNum = true;

            } catch (IllegalArgumentException iAe) {
                System.err.printf("[exception]: %s%n", iAe.getMessage());
                scanner.nextLine();         // clear input stream
            }
        }
        return supposedPhoneNumber;
    }

    private static void processPhoneNumber(String phoneNumber) {
        String[] tokens = phoneNumber.split(" ");
        String areaCode = tokens[0].substring(1, 4);
        String firstThreeDigits = tokens[1].substring(0, 3);
        String lastFourDigits = tokens[1].substring(4);

        String phoneNumberDigits = firstThreeDigits + lastFourDigits;
        System.out.printf("Area code: %s | Phone number: %s%n", areaCode, phoneNumberDigits);
    }

    public static void main(String[] args) {

        String phoneNumber = obtainAndValidateUserPhoneNumber();
        processPhoneNumber(phoneNumber);

    }
}
