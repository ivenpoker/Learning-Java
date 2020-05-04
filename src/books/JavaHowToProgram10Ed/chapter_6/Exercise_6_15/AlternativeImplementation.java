package books.JavaHowToProgram10Ed.chapter_6.Exercise_6_15;

import java.util.Scanner;

public class AlternativeImplementation {

    private static final Scanner input = new Scanner(System.in);

    private static class BaseHeight {
        public final double base;
        public final double height;

        public BaseHeight(double base, double height) {
            this.base = base;
            this.height = height;
        }
    }

    public static BaseHeight obtainTriangleSpecs(String message) {
        System.out.print(message);
        int base = input.nextInt();
        int height = input.nextInt();
        return new BaseHeight(base, height);
    }

    public static double computeHypotenuse(BaseHeight baseHeight) {
        return Math.sqrt(Math.pow(baseHeight.base, 2)  + Math.pow(baseHeight.height, 2));
    }

    public static void main(String[] args) {

        System.out.printf("Side A: %.2f -- Side B: %.2f -- Hypotenuse: %.2f\n", 3.0, 4.0, computeHypotenuse(new BaseHeight(3.0, 4.0)));
        System.out.printf("Side A: %.2f -- Side B: %.2f -- Hypotenuse: %.2f\n", 5.0, 12.0, computeHypotenuse(new BaseHeight(5.0, 12.0)));
        System.out.printf("Side A: %.2f -- Side B: %.2f -- Hypotenuse: %.2f\n", 8.0, 15.0, computeHypotenuse(new BaseHeight(8.0, 15.0)));

        System.out.printf("====================================================%n");
        BaseHeight triangleBaseAndHeight = obtainTriangleSpecs("Enter base and height of triangle [as: b h]: ");
        System.out.printf("Hypotenuse: %.2f%n", computeHypotenuse(triangleBaseAndHeight));


    }
}
