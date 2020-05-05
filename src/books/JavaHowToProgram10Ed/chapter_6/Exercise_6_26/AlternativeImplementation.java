package books.JavaHowToProgram10Ed.chapter_6.Exercise_6_26;

import java.util.Scanner;

public class AlternativeImplementation {

    private static Scanner input = new Scanner(System.in);

    private static int readUserNumber(String inputMessage) {
        System.out.print(inputMessage);
        return input.nextInt();
    }

    private static int numberOfDigits(int someNum) {
        int cnt = 0;
        someNum = Math.abs(someNum);
        if (someNum == 0) {
            return 1;
        }
        while (someNum > 0) {
            someNum /= 10;
            cnt += 1;
        }
        return cnt;
    }

    private static int reverseDigits(int someNum) {
        boolean isNeg = someNum < 0;
        if (isNeg) {
            someNum = Math.abs(someNum);
        }
        if (someNum < 10) {
            return someNum;
        }
        int num = numberOfDigits(someNum)-1;
        int reverse = 0;
        while (someNum > 0) {
            int lastDigit = someNum % 10;
            reverse += lastDigit * (int)(Math.pow(10, num));

            num -= 1;
            someNum /= 10;
        }
        return isNeg ? -reverse : reverse;
    }

    public static void main(String[] args) {

        int userNum = readUserNumber("Enter a number: ");
        System.out.printf("Reverse of '%d': %d\n", userNum, reverseDigits(userNum));

    }
}
