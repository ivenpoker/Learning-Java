package books.JavaHowToProgram10Ed.chapter_6.Exercise_6_17;

import java.util.Scanner;

public class AlternativeImplementation {

    private static final int SENTINEL_TERMINAL_VALUE = 0;
    private static final Scanner input = new Scanner(System.in);

    private static boolean isEven(int someNum) {
        return someNum % 2 == 0;
    }

    private static int obtainUserNumber(String message) {
        System.out.print(message);
        return input.nextInt();
    }

    public static void main(String[] args) {

        int userVal;
        do {
            userVal = obtainUserNumber("Enter some integer value [0: to stop]: ");
            if (userVal != SENTINEL_TERMINAL_VALUE) {
                System.out.printf("Number %d is%s even%n", userVal,
                        isEven(userVal) ? "" : " NOT");
            }
        } while (userVal != SENTINEL_TERMINAL_VALUE);

    }

}
