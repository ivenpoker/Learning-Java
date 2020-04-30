package books.JavaHowToProgram10Ed.chapter_5;

public class Exercise_5_22 {

    public static void printAllTrianglesSideBySide(int maxHeight) {

        for (int i = 0; i < maxHeight; i++) {

            // print ith line number of stars for first triangle
            printIthLineForTriangleAandB(i+1, maxHeight);

            // Separate previous triangle print from the next one.
            System.out.print("\t");

            // print ith line number of stars for second triangle
            printIthLineForTriangleAandB((maxHeight -i), maxHeight);

            // Separate previous triangle print from the next one.
            System.out.print("\t");

            // print ith line number of stars for third triangle
            printIthLineForTriangleCandD((maxHeight-i), maxHeight);

            // Separate previous triangle print from the next one.
            System.out.print("\t");

            // print ith line number of stars for fourth triangle
            printIthLineForTriangleCandD(i+1, maxHeight);

            System.out.println();
        }
    }

    public static void printIthLineForTriangleAandB(int numStars, int maxWidth) {
        for (int i = 0; i < numStars; i++) {
            System.out.print('*');
        }
        int numSpaces = maxWidth - numStars;
        for (int i = 0; i < numSpaces; i++) {
            System.out.print(' ');
        }
    }

    public static void printIthLineForTriangleCandD(int numStars, int maxWidth) {
        int numSpaces = maxWidth - numStars;

        // Print spaces
        for (int i = 0; i < numSpaces; i++) {
            System.out.print(' ');
        }

        // Print stars
        for (int i = 0; i < numStars; i++) {
            System.out.print('*');
        }
    }

    public static void main(String[] args) {

        int maxAppTriangleHeight = 10;
        printAllTrianglesSideBySide(maxAppTriangleHeight);

    }

}
