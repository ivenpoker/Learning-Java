package w3resource.utils;

public class BasicUtils {

    public static void printLine(char ch, int maxLineLen) {
        for (int i = 0; i < maxLineLen; i++) {
            System.out.printf("%c", ch);
        }
        System.out.println();
    }

}
