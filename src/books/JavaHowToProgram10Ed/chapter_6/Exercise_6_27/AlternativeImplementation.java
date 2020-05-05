package books.JavaHowToProgram10Ed.chapter_6.Exercise_6_27;

import java.util.Scanner;

public class AlternativeImplementation {

    private static final Scanner input = new Scanner(System.in);

    private static class GCDNums {
        public final int intA;
        public final int intB;

        public GCDNums(int intA, int intB) {
            this.intA = intA;
            this.intB = intB;
        }
    }

    private static int gcd(int uVal, int vVal) {
        int tmp;
        while (uVal > 0) {
            if (uVal < vVal) {
                tmp = uVal;
                uVal = vVal;
                vVal = tmp;
            }
            uVal = uVal - vVal;
        }
        return vVal;
    }

    public static GCDNums readUserNums(String inputMessage) {
        System.out.print(inputMessage);
        int intA = input.nextInt();
        int intB = input.nextInt();
        return new GCDNums(intA, intB);
    }

    public static void main(String[] args) {

        GCDNums userNums = readUserNums("Enter two numbers to compute their GCD: ");
        System.out.printf("GCD of %d and %d: %d%n", userNums.intA, userNums.intB, gcd(userNums.intA, userNums.intB));

    }

}
