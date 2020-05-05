package books.JavaHowToProgram10Ed.chapter_6.Exercise_6_28;

import java.util.Scanner;

public class AlternativeImplementation {

    private static final Scanner input = new Scanner(System.in);

    public static double readStudentAverage(String inputMessage) {
        System.out.print(inputMessage);
        return input.nextInt();
    }

    public static boolean inRange(double low, double val, double high) {
        return low <= val && val <= high;
    }

    public static int qualityPoints(double someAverage) {
        if (inRange(60, someAverage, 69)) {
            return 1;
        } else if (inRange(70, someAverage, 79)) {
            return 2;
        } else if (inRange(80, someAverage,89)) {
            return 3;
        } else if (inRange(90, someAverage, 100)) {
            return 4;
        }
        return 0;
    }

    public static void main(String[] args) {

        double userAverage = readStudentAverage("Enter student average: ");
        System.out.printf("Quality point is: %d%n", qualityPoints(userAverage));

    }

}
