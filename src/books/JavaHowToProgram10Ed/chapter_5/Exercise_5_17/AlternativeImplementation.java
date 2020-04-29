package books.JavaHowToProgram10Ed.chapter_5.Exercise_5_17;

import java.util.Scanner;

public class AlternativeImplementation {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        double price1 = 2.98;
        double price2 = 4.50;
        double price3 = 9.98;
        double price4 = 6.87;

        int productNum = 0;
        int qtySold = 0;
        int sentinel = -1;

        double total = 0.0;

        System.out.print("Enter product number and quantity sold [-1 to quit]: ");
        productNum = input.nextInt();

        while (productNum != sentinel) {
            qtySold = input.nextInt();
            switch (productNum) {
                case 1:
                    total += (price1 + qtySold);
                    break;
                case 2:
                    total += (price2 + qtySold);
                    break;
                case 3:
                    total += (price3 + qtySold);
                    break;
                case 4:
                    total += (price4 + qtySold);
                    break;
                default:
                    break;
            }
            System.out.print("Enter product number and quantity sold: ");
            productNum = input.nextInt();
        }
        System.out.printf("%nTotal retailed for all products: $%,.2f%n", total);

    }

}
