package books.JavaHowToProgram10Ed.chapter_6.Exercise_6_18;

import java.util.Scanner;

public class AlternativeImplementation {

    private static final Scanner input = new Scanner(System.in);

    public static int obtainSquareSides(String message) {
        System.out.print(message);
        return input.nextInt();
    }

    public static void printSquareOfAsterisks(int sideLength) {
        for (int i = 0; i < sideLength; i++) {
            for (int j = 0; j < sideLength; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int sidesLength = obtainSquareSides("Enter side length for square: ");
        printSquareOfAsterisks(sidesLength);

    }
}
