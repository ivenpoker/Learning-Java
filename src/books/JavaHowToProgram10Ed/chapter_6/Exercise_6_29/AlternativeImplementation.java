package books.JavaHowToProgram10Ed.chapter_6.Exercise_6_29;

import java.security.SecureRandom;
import java.util.Scanner;

public class AlternativeImplementation {

    private static final Scanner input = new Scanner(System.in);
    private static final SecureRandom random = new SecureRandom();

    private static final int CONSOLE_PRINT_DELAY_MILLS = 10;
    private static final int MAX_TOSSING_COUNT = 1000000;
    private static final int EXIT_FAILURE = 1;

    private static enum MenuOption {TOSS_COIN, EXIT_PROGRAM}
    private static enum Coin {HEADS, TAILS}

    public static void sysAppPrint(String message) {
        try {
            for (char ch : message.toCharArray()) {
                System.out.print(ch);
                Thread.sleep(CONSOLE_PRINT_DELAY_MILLS);
            }
        } catch (InterruptedException intExc) {
            System.err.printf("[APP-ERROR]: %s", intExc.getMessage());
            intExc.printStackTrace();
        }
    }

    private static MenuOption userMenu() {
        System.out.println("================= [COIN TOSSING MENU ]================");
        System.out.printf("\t1. Toss coin (%d times)%n", MAX_TOSSING_COUNT);
        System.out.printf("\t2. End program.%n");
        System.out.println("======================================================");
        System.out.print("\tEnter your choice: ");

        // Default menu option in case of bad choice.
        MenuOption userOption = MenuOption.EXIT_PROGRAM;

        switch (input.nextInt()) {
            case 1:
                userOption = MenuOption.TOSS_COIN;
                break;
            case 2:
                userOption = MenuOption.EXIT_PROGRAM;
                break;
            default:
                System.out.printf("\t====== [Invalid option] =====%n");
                break;
        }
        System.out.println("======================================================");
        return userOption;
    }

    private static Coin flip() {
        int randVal = random.nextInt(2);
        return randVal == 0 ? Coin.HEADS : Coin.TAILS;
    }

    private static void performTossing() {

        int headCnt = 0;
        int tailCnt = 0;

        for (int i = 0; i < MAX_TOSSING_COUNT; i++) {
            Coin coin = flip();
            switch (coin) {
                case HEADS: headCnt += 1; break;
                case TAILS: tailCnt += 1; break;
                default:
                    System.err.println("[CRITICAL-SYSTEM-ERROR]: Invalid coin state");
                    System.exit(EXIT_FAILURE);
                    break;
            }
            System.out.print(String.format("\rProcessing [%.0f%%]: %10s | %10s", (((double) i /MAX_TOSSING_COUNT) * 100),
                    String.format("Heads: %5d", headCnt), String.format("Tails: %5d", tailCnt)));
        }
        System.out.println();
    }

    public static void main(String[] args) {

        MenuOption userChoice = userMenu();

        switch (userChoice) {
            case TOSS_COIN:
                performTossing();
                System.out.println("======================================================");
                break;
            case EXIT_PROGRAM:
                break;
        }



    }
}
