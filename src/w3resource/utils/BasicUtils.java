package w3resource.utils;

public class BasicUtils {

    public static void printLine(char ch, int maxLineLength) {
        for (int i = 0; i < maxLineLength; i++) {
            System.out.printf("%c", ch);
        }
        System.out.println();
    }

    public static void printLineMessage(String mess, char ch, int maxLineLength) {
        if (mess.length() > maxLineLength) {
            throw new IllegalArgumentException(
                    String.format("Message length (%d) must be greater than" +
                            " specified char line length (%d)", mess.length(), maxLineLength));
        }
        if (mess.length() == maxLineLength) {
            System.out.println(mess);
        }
        int maxSideChars = (maxLineLength - mess.length()) / 2;
        for (int i = 0; i < maxSideChars; i++) {
            System.out.printf("%c", ch);
        }
        System.out.printf("%s", mess);
        for (int i = 0; i < maxSideChars; i++) {
            System.out.printf("%c", ch);
        }
        System.out.println();
    }

    public static void printLineInfo(String mess, char ch, int maxLineLength) {
        System.out.println();
        BasicUtils.printLineMessage(mess, ch, maxLineLength);
        System.out.println();
    }

}
