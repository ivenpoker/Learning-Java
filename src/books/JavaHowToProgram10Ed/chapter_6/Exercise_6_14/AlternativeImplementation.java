package books.JavaHowToProgram10Ed.chapter_6.Exercise_6_14;

import java.util.Scanner;

public class AlternativeImplementation {

    private static final Scanner input = new Scanner(System.in);

    private static class BaseExpo {
        public final int base;
        public final int expo;

        public BaseExpo(int base, int expo) {
            this.base = base;
            this.expo = expo;
        }
    }

    private static int integerPower(int base, int expo) {
        int result = 1;
        for (int i = 0; i < expo; i++) {
            result *= base;
        }
        return result;
    }

    public static BaseExpo obtainBaseAndExponent(String message) {
        System.out.print(message);
        int base = input.nextInt();
        int expo = input.nextInt();
        return new BaseExpo(base, expo);
    }


    public static void main(String[] args) {
        BaseExpo baseExpo = obtainBaseAndExponent("Enter base and exponent [as: b e]: ");
        System.out.printf("Operation %d^%d is: %d%n", baseExpo.base, baseExpo.expo,
                integerPower(baseExpo.base, baseExpo.expo));

    }

}
