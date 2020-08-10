package w3resource.dataTypes;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Prints the current time in GMT.                                     #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : August 11, 2020                                                     #
// #                                                                                         #
// ###########################################################################################

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise_5 {

    private static final Scanner input = new Scanner(System.in);

    private static long readUserInputStr(String inputMess) {
        boolean inputValid = false;
        long timezoneOffset = 0;

        while (!inputValid) {
            try {
                System.out.print(inputMess);
                timezoneOffset = input.nextLong();

                inputValid = true;
            } catch (InputMismatchException iMe) {
                System.err.printf("[invalid_input]: %s%n", iMe.getMessage());

            } catch (Exception exc) {
                System.err.printf("[EXCEPTION]: %s%n", exc.getMessage());
            }
        }
        return timezoneOffset;
    }

    private static String getGMTTimeStr(long timezoneOffset) {
        long totalMilliseconds = System.currentTimeMillis();
        long totalSeconds  = totalMilliseconds / 1000;
        long currentSecond = totalSeconds % 60;
        long totalMinutes  = totalSeconds / 60;
        long currentMinute = totalMinutes % 60;
        long totalHours = totalMinutes / 60;
        long currentHour = ((totalHours + timezoneOffset) % 24);

        return String.format("Current time is %d:%d:%d", currentHour, currentMinute, currentSecond);
    }

    public static void main(String[] args) {

        long timezoneOffset = readUserInputStr("Enter timezone offset to GMT: ");
        String timeInfo = getGMTTimeStr(timezoneOffset);

        System.out.println(timeInfo);
    }

}
