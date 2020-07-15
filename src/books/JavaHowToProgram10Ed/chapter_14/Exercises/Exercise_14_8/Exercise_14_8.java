package books.JavaHowToProgram10Ed.chapter_14.Exercises.Exercise_14_8;

import java.util.Scanner;

public class Exercise_14_8 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.printf("Enter telephone number [as (xxx) xxx-xxxx]: ");
        String userTelephoneNumber = input.nextLine().trim();

        // Process user telephone number, convert it to
        // individual tokens

        String[] tokens = userTelephoneNumber.split(" ");
        int areaCode = -1;
        int firstThree = -1;
        int lastFour = -1;

        try {
            if (tokens[0].substring(1, tokens[0].length()-1).length() != 3)
                throw new NumberFormatException("Invalid area code");

            areaCode = Integer.parseInt(tokens[0].substring(1, tokens[0].length()-1));
            String[] lastTwo = tokens[1].split("-");

            if (lastTwo[0].length() != 3)
                throw new NumberFormatException("First three digits (after area code) must be of length 3");

            if (lastTwo[1].length() != 4)
                throw new NumberFormatException("Last four digits must be of length 4");

            firstThree = Integer.parseInt(lastTwo[0]);
            lastFour   = Integer.parseInt(lastTwo[1]);

            // At this point the user has provided
            // valid input. We just display then to console.

            System.out.printf("Area code: %d\nPhone number: %d %d\n", areaCode, firstThree, lastFour);
            System.out.printf("Phone number: %s\n", String.format("%d%d%d", areaCode, firstThree, lastFour));

        } catch (NumberFormatException exception) {
            System.err.println("Invalid input. Please follow the format.");
        }

    }
}
