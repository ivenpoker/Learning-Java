package books.JavaHowToProgram10Ed.chapter_14.Exercises.Exercise_14_16;

import java.util.Scanner;

public class Exercise_14_16 {

    private static Scanner scanner = new Scanner(System.in);

    private static String obtainUserString(String inputMess) {
        boolean valid = false;
        String userText = "";

        while (!valid) {
            try {
                System.out.print(inputMess);
                userText = scanner.nextLine().trim();

                if (userText.isEmpty()) {
                    throw new IllegalArgumentException("please enter some text input");
                }
                valid = true;

            } catch (IllegalStateException iSe) {
                System.out.print("[re-opening__scanner] ... ");
                scanner = new Scanner(System.in);

                System.out.println("[DONE]");

            } catch (Exception exc) {
                System.err.printf("[EXCEPTION]: %s%n", exc.getMessage());
            }
        }
        return userText;
    }

    public static void main(String[] args) {

        String userInput = obtainUserString("Enter some text: ");
        DemoString demoString = new DemoString(userInput);

        String searchTxt = obtainUserString("Enter search query: ");

        System.out.printf("Index of '%s': %s%n", searchTxt, demoString.indexOf(searchTxt));
        System.out.printf("Last index of '%s': %s%n", searchTxt, demoString.lastIndexOf(searchTxt));

    }
}

class DemoString {
    private String coreStr;

    public DemoString(String string) {
        this.coreStr = string;
    }

    public int indexOf(String subStr) {
        int strLen = this.coreStr.length();
        for (int i = 0; i < strLen; i++) {
            if (strLen - i >= subStr.length()) {
                if (this.coreStr.substring(i, i + subStr.length()).equals(subStr)) {
                    return i;
                }
            } else {
                break;
            }
        }
        return -1;
    }

    public int indexOf(char ch) {
        for (int len = this.coreStr.length(), i = 0; i < len; i++) {
            if (this.coreStr.charAt(i) == ch) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(String subStr) {
        int strLen = this.coreStr.length();
        for (int i = strLen-1; i >= 0; i--) {
            if (strLen - i >= subStr.length()) {
                if (this.coreStr.substring(i, i + subStr.length()).equals(subStr)) {
                    return i;
                }
            }
        }
        return -1;
    }

    public int lastIndexOf(char ch) {
        for (int i = this.coreStr.length()-1; i >= 0; i--) {
            if (this.coreStr.charAt(i) == ch) {
                return i;
            }
        }
        return -1;
    }
}
