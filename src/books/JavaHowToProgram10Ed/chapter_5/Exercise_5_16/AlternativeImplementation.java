package books.JavaHowToProgram10Ed.chapter_5.Exercise_5_16;

import java.util.Scanner;

public class AlternativeImplementation {

    private static void printBarchart(int mainNum) {
        System.out.printf("%3d: ", mainNum);
        for (int i = 0; i < mainNum; i++) {
            System.out.print("*");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int maxUserInput = 5;

        // Stores for the five numbers to be given by the user.
        int intA = 0;
        int intB = 0;
        int intC = 0;
        int intD = 0;
        int intE = 0;

        Scanner input = new Scanner(System.in);

        System.out.printf("Enter five (%d) numbers in range [1,30]: ", maxUserInput);

        // Read all five numbers from the user
        for (int i = 0; i < maxUserInput; i++) {
            switch (i) {
                case 0:
                    intA = input.nextInt();
                    break;
                case 1:
                    intB = input.nextInt();
                    break;
                case 2:
                    intC = input.nextInt();
                    break;
                case 3:
                    intD = input.nextInt();
                    break;
                case 4:
                    intE = input.nextInt();
                    break;
                default:
                    System.out.print("Oops! invalid input!");
                    break;
            }
        }

        // display asterisks based on numbers user provided.

        for (int i = 0; i < maxUserInput; i++) {
            switch (i) {
                case 0:
                    AlternativeImplementation.printBarchart(intA);
                    break;
                case 1:
                    AlternativeImplementation.printBarchart(intB);
                    break;
                case 2:
                    AlternativeImplementation.printBarchart(intC);
                    break;
                case 3:
                    AlternativeImplementation.printBarchart(intD);
                    break;
                case 4:
                    AlternativeImplementation.printBarchart(intE);
                    break;
                default:
                    System.out.println("[ERROR]: Something is wrong!");
                    break;
            }

        }
    }

}
