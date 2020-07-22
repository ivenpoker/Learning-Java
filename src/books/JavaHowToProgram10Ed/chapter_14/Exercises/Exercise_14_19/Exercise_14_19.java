package books.JavaHowToProgram10Ed.chapter_14.Exercises.Exercise_14_19;

import java.util.Scanner;

public class Exercise_14_19 {

    private static Scanner scanner = new Scanner(System.in);
    private static final int[] daysPerMonth =
            { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
    private static final String[] monthNames =
            {"", "January", "February", "March", "April", "May", "June", "July", "August",
             "September", "October", "November", "December"};

    private static boolean inRange(int low, int val, int high) {
        return low <= val && val <= high;
    }

    private static int[] readUserDateInput(String inputMess) {
        boolean valid = false;
        String[] dateComp;
        int[] dataIntComps = new int[3];

        while (!valid) {
            try {
                System.out.print(inputMess);
                dateComp = scanner.nextLine().trim().split("/");

                if (dateComp.length != 3) {
                    throw new IllegalArgumentException("Invalid date. Try again");
                }
                // parse month and validate
                int month = Integer.parseInt(dateComp[0]);
                if (!inRange(1, month, 12)) {
                    throw new IllegalArgumentException("Invalid month. Must be in range [1, 12]");
                }

                // parse day and validate
                int day = Integer.parseInt(dateComp[1]);
                if (!inRange(1, day, daysPerMonth[day])) {
                    throw new IllegalArgumentException(
                            String.format("Invalid day for specified month. Must be in range [1, %d]", daysPerMonth[day]));
                }

                // parse year
                int year = Integer.parseInt(dateComp[2]);

                dataIntComps[0] = month;
                dataIntComps[1] = day;
                dataIntComps[2] = year;

                valid = true;

            } catch (IllegalStateException iSe) {
                System.out.print("[re-opening__scanner] ... ");
                scanner = new Scanner(System.in);
                System.out.println("[DONE]");

            } catch (Exception exc) {
                System.out.printf("[EXCEPTION]: %s%n", exc.getMessage());
            }
        }
        return dataIntComps;
    }

    private static void printDateComponents(int[] dateComps) {
        System.out.printf("Date is: [%s %d, %4d]", monthNames[dateComps[0]], dateComps[1], dateComps[2]);
    }

    public static void main(String[] args) {

        int[] dateComps = readUserDateInput("Enter a date [as: MM/DD/YYYY]: ");

        // Print the obtained date to the console
        printDateComponents(dateComps);
    }

}
