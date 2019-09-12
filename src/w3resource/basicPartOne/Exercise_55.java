package w3resource.basicPartOne;

// ##########################################################################################
// #                                                                                        #
// #    Program Purpose: Converts seconds to hour, minutes and seconds.                     #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                              #
// #    Creation Date  : September 12, 2019                                                 #
// #                                                                                        #
// ##########################################################################################

import com.sun.org.apache.xml.internal.security.encryption.CipherReference;

import java.util.*;

public class Exercise_55 {

    private static Scanner input = new Scanner(System.in);

    private static int readNumberOfSeconds(String mess) {
        int numSeconds = 0;
        boolean isValid = false;

        do {
            try {
                System.out.print(mess);
                numSeconds = input.nextInt();

                if (numSeconds < 0)
                    throw new IllegalArgumentException("Invalid number of seconds. Must be > 0");

                isValid = true;

            } catch (InputMismatchException inputMismatchException) {
                System.err.println(inputMismatchException.getMessage());

            } catch (NoSuchElementException noSuchElementException) {
                System.err.println("Input has been exhausted");

            } catch (IllegalStateException illegalStateException) {
                System.err.println("Scanner has been closed.");
            }
        } while (!isValid);

        return numSeconds;
    }

    private static Map<String, Integer> processNumberOfSeconds(int numberOfSeconds) {
        int minutes = 0;
        while (numberOfSeconds >= 60) {
            numberOfSeconds -= 60;
            minutes += 1;
        }
        int hours = 0;
        while (minutes >= 60) {
            minutes -= 60;
            hours += 1;
        }
        Map<String, Integer> timeData = new HashMap<>();
        timeData.put("hours", hours);
        timeData.put("minutes", minutes);
        timeData.put("seconds", numberOfSeconds);

        return timeData;
    }

    private static void printData(Map<String, Integer> timeData) {
        System.out.printf(String.format("%02d:%02d:%02d", timeData.get("hours"), timeData.get("minutes"), timeData.get("seconds")));
    }

    public static void main(String[] args) {
        int numberOfSeconds = readNumberOfSeconds("Enter number of seconds: ");
        Map<String, Integer> newData = processNumberOfSeconds(numberOfSeconds);
        printData(newData);
    }

}
