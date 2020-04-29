package books.JavaHowToProgram10Ed.chapter_5.Exercise_5_15;

public class AlternativeImplementation {

    private static void printPatternA(int maxHeight) {
        for (int i = 0; i < maxHeight; i++) {
            for (int j = 0; j < i+1; j++) {
                System.out.print('*');
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void printPatternB(int maxHeight) {
        for (int i = maxHeight; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print('*');
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void printPatternC(int maxHeight) {
        for (int i = maxHeight; i > 0; i--) {

            // compute number of spaces to print for this level
            int spacesCnt = maxHeight - i;

            // print number of spaces for this level.
            for (int j = 0; j < spacesCnt; j++) {
                System.out.print(' ');
            }

            // compute number of stars to print for this level.
            int starsCnt = maxHeight - spacesCnt;

            // print stars for this level
            for (int j = 0; j < starsCnt; j++) {
                System.out.print('*');
            }

            // Move to new line.
            System.out.println();
        }
        System.out.println();
    }

    private static void printPatternD(int maxHeight) {
        for (int i = 1; i <= maxHeight; i++) {

            // compute number of spaces to print for this level
            int spacesCnt = maxHeight - i;

            // print number of spaces for this level
            for (int j = 0; j < spacesCnt; j++) {
                System.out.print(' ');
            }

            // compute number of starts to print for this level
            int starsCnt = maxHeight - spacesCnt;

            // print stars for this level
            for (int j = 0; j < starsCnt; j++) {
                System.out.print('*');
            }

            // Move to new line
            System.out.println();
        }
        System.out.println();
    }



    public static void main(String[] args) {

        int MAX_TRIANGLE_HEIGHT = 10;

        AlternativeImplementation.printPatternA(MAX_TRIANGLE_HEIGHT);
        AlternativeImplementation.printPatternB(MAX_TRIANGLE_HEIGHT);
        AlternativeImplementation.printPatternC(MAX_TRIANGLE_HEIGHT);
        AlternativeImplementation.printPatternD(MAX_TRIANGLE_HEIGHT);

    }
}
