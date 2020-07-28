package books.JavaHowToProgram10Ed.chapter_14.Exercises.Exercise_14_22;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise_14_22 {

    private static final Scanner scanner = new Scanner(System.in);
    private static final int MAX_LINE_LENGTH = 40;
    private enum OperationType {CONVERT_T0_MORSE, CONVERT_FROM_MORSE, EXIT_APP};

    private static final String morseCodeChars = "abcdefghijklmnopqrstuvwxyz1234567890";
    private static final String[] morseCodes =
            {".-", "-...", "-.-.", "-..",".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..",
             "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-",
            "-.--", "--..", ".----", "..---", "...--", "....-", ".....", "-....", "--...", "---..",
            "----.", "-----"};

    private static void printLine(char ch, int times) {
        for (int i = 0; i < times; i++) {
            System.out.printf("%c", ch);
        }
        System.out.println();
    }

    private static boolean inRange(int low, int val, int high) {
        return low <= val && val <= high;
    }

    private static String readUserStrInput(String inputMess) {
        boolean valid = false;
        String userInput = "";

        while (!valid) {
            try {
                System.out.print(inputMess);
                userInput = scanner.nextLine().trim();

                if (userInput.isEmpty()) {
                    throw new InputMismatchException("please enter some text");
                }
                valid = true;
            } catch (InputMismatchException iMe) {
                System.err.printf("[invalid_input]: %s%n", iMe.getMessage());
                scanner.nextLine();             // clear input stream.

            } catch (Exception exc) {
                System.err.printf("[EXCEPTION]: %s%n", exc.getMessage());
                scanner.nextLine();             // clear input stream.
            }
        }
        return userInput;
    }

    private static OperationType printMenuAndGetUserChoice() {

        printLine('=', MAX_LINE_LENGTH);
        System.out.println("1. Convert text TO morse.");
        System.out.println("2. Convert FROM morse TO text");
        System.out.println("3. Exit application");
        printLine('=', MAX_LINE_LENGTH);

        boolean valid = false;
        int userChoice = 0;

        while (!valid) {
            try {
                System.out.print("Enter your choice: ");
                String userChoiceStr = scanner.nextLine().trim();

                userChoice = Integer.parseInt(userChoiceStr);

                if (!inRange(1, userChoice, 3)) {
                    throw new InputMismatchException("choice must be in range [1, 3]");
                }

                valid = true;

            } catch (InputMismatchException iMe) {
                System.err.printf("[invalid_input]: %s%n", iMe.getMessage());
                scanner.nextLine();             // clear input stream.

            } catch (Exception exc) {
                System.err.printf("[EXCEPTION]: %s%n", exc.getMessage());
                scanner.nextLine();             // clear input stream.
            }
        }
        switch (userChoice) {
            case 1: return OperationType.CONVERT_T0_MORSE;
            case 2: return OperationType.CONVERT_FROM_MORSE;
            case 3: return OperationType.EXIT_APP;
            default:
                System.out.printf("\n\t[INTERNAL___ERROR]%n%n");
                return OperationType.EXIT_APP;
        }
    }

    private static ArrayList<CharacterAndCode> createCharacterCodeDatabase() {
        ArrayList<CharacterAndCode> charCodeList = new ArrayList<>();

        for (int i = 0, len = morseCodeChars.length(); i < len; i++) {
            char currChar = Character.toUpperCase(morseCodeChars.charAt(i));
            String currCharCode = morseCodes[i];

            CharacterAndCode newCharCode = new CharacterAndCode(currChar, currCharCode);
            if (!charCodeList.contains(newCharCode)) {
                charCodeList.add(newCharCode);
            }
        }
        return charCodeList;
    }

    private static String convertTextToMorse(String mainText, ArrayList<CharacterAndCode> charCodeDatabase) {
        String[] words = mainText.split("\\s+");            // split on words
        StringBuilder sb = new StringBuilder();

        for (String word: words) {
            for (char ch : word.toCharArray()) {
                // append  equivalent morse code for this character to accumulator
                // and add a space.

                // if character is lowercase, convert to upper, since database has
                // only uppercase chars
                ch = Character.toLowerCase(ch) == ch ? Character.toUpperCase(ch) : ch;
                String morseCode = "";
                for (CharacterAndCode charCode : charCodeDatabase) {
                    if (charCode.getChar() == ch) {
                        morseCode = charCode.getMorseCode();
                        break;
                    }
                }
                sb.append(morseCode).append(" ");
            }
            // Add three spaces after each 'word' for which we
            // created an equivalent morse codes
            sb.append("   ");
        }
        return sb.toString().trim();
    }

    private static String convertMorseCodeToText(String morseCode, ArrayList<CharacterAndCode> charCodeDatabase) {
        String[] morseWordCodes = morseCode.split(" {3}");           // split on three spaces based on specs in book
        StringBuilder sb = new StringBuilder();

        for (String morseWord : morseWordCodes) {
            // Each morse 'word' is made up of a sequence of morse 'letters' separated by a space
            // from the specs in the book
            String[] morseLetters = morseWord.split(" ");
            for (String morseLett : morseLetters) {

                // We now search for the character equivalent for the morse
                // letter in the database
                for (CharacterAndCode charCode : charCodeDatabase) {
                    if (charCode.getMorseCode().equals(morseLett)) {
                        sb.append(charCode.getChar());
                    }
                }
            }
            sb.append(" "); // append a space after converting a morse 'word' to a letter 'word'
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {

//        System.out.printf("%d | %d", morseCodeChars.length(), morseCodes.length);

        ArrayList<CharacterAndCode> charCodeDatabase = createCharacterCodeDatabase();
        OperationType userOpChoice = OperationType.EXIT_APP;

        do {
            userOpChoice = printMenuAndGetUserChoice();

            switch (userOpChoice) {

                case CONVERT_T0_MORSE: {
                    printLine('=', MAX_LINE_LENGTH);
                    System.out.print("Enter text to convert to morse: ");
                    String userText = readUserStrInput("Enter some text to convert: ");
                    System.out.printf("Equivalent morse code: %s%n",
                            convertTextToMorse(userText, charCodeDatabase));
                    break;
                }

                case CONVERT_FROM_MORSE: {
                    printLine('=', MAX_LINE_LENGTH);
                    System.out.print("Enter morse code to convert to text: ");
                    String userMorseCode = readUserStrInput("Enter some morse code: ");
                    System.out.printf("Equivalent text for code: %s%n",
                            convertMorseCodeToText(userMorseCode, charCodeDatabase));
                }

                case EXIT_APP:
                default:
                    break;
            }
        } while  (userOpChoice != OperationType.EXIT_APP);
    }
}

class CharacterAndCode {
    private final char ch;
    private final String morseCode;

    public CharacterAndCode(char ch, String morseCode) {
        if (morseCode.isEmpty()) {
            throw new IllegalArgumentException("Invalid morse code. Cannot be empty");
        }
        this.ch = ch;
        this.morseCode = morseCode;
    }

    public char getChar() {
        return this.ch;
    }

    public String getMorseCode() {
        return this.morseCode;
    }

    @Override
    public String toString() {
        return String.format("(%c, %s)", this.ch, this.morseCode);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof CharacterAndCode)) {
            return false;
        }
        CharacterAndCode objCharCode = (CharacterAndCode) obj;
        return objCharCode.morseCode.equals(this.morseCode) && objCharCode.ch == this.ch;
    }
}
