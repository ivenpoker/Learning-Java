package books.JavaHowToProgram10Ed.chapter_6.Exercise_6_19;

import java.util.Scanner;

public class AlternativeImplementation {

    private static final Scanner input = new Scanner(System.in);

    private static int obtainSquareSideLength(String message) {
        System.out.print(message);
        return input.nextInt();
    }

    private static char obtainFillCharacterFromUser(String message) {
        System.out.print(message);
        return input.next().charAt(0);
    }

    private static void printSquareOfCharacters(int sideLength, char fillCharacter) {
        for (int i = 0; i < sideLength; i++) {
            for (int j = 0; j < sideLength; j++) {
                System.out.print(fillCharacter);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int userSpecifiedNum = obtainSquareSideLength("Enter side length of square: ");
        char fillCharacter = obtainFillCharacterFromUser("Enter fill character to be used: ");

        // Print the square based on side length and specified fill character
        printSquareOfCharacters(userSpecifiedNum, fillCharacter);
    }

}
