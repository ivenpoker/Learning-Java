package books.JavaHowToProgram10Ed.chapter_4.Exercise_4_30;

import java.util.Scanner;

public class AlternativeSolution {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter five digit number: ");
        int digit = input.nextInt();

        // Making sure digits provided is a five digit number

        while (!(digit / 10000 > 0)) {
            System.out.print("Enter five (5) digit number: ");
            digit = input.nextInt();
        }

        // Check if digit is palindrome

        int fifthNum = digit % 10;
        int fourthNum = (digit / 10) % 10;
        int thirdNum = (digit / 100) % 10;
        int sndNum = (digit / 1000) % 10;
        int fstNum = digit / 10000;

        System.out.printf("Digits: %d %d %d %d %d\n", fstNum, sndNum, thirdNum, fourthNum, fifthNum);

        if (fifthNum == fstNum) {
            if (fourthNum == sndNum) {
                System.out.printf("Number '%d' is a PALINDROME%n", digit);
            } else {
                System.out.printf("Number '%d' is NOT A PALINDROME%n", digit);
            }
        } else {
            System.out.printf("Number '%d' is NOT A PALINDROME%n", digit);
        }

    }

}
