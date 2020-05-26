package books.JavaHowToProgram10Ed.chapter_7.Exercise_7_21;

import java.util.Scanner;

public class AlternativeImplementation {

    private static final Scanner input = new Scanner(System.in);

    public static boolean inBounds(int low, int val, int high) {
        return low <= val && val <= high;
    }

    public static TurtleGraphics.TurtleCommand displayMenuGetCommand() {
        System.out.printf("%n%n============== [TURTLE GRAPHICS PROGRAM] ================%n");
        System.out.println("1. Pen up");
        System.out.println("2. Pen down");
        System.out.println("3. Turn right");
        System.out.println("4. Turn left");
        System.out.println("5. Turn Up");
        System.out.println("6. Turn Down");
        System.out.println("7. Move 10 spaces");
        System.out.println("8. Display the floor");
        System.out.println("9. End of data (sentinel)");
        System.out.println("============================================================%n");
        System.out.print("Enter your choice: ");
        int userChoice = input.nextInt();

        while (!inBounds(1, userChoice, 9)) {
            System.out.print("Please, enter VALID choice: ");
            userChoice = input.nextInt();
        }
        switch (userChoice) {
            case 1: return TurtleGraphics.TurtleCommand.PEN_UP;
            case 2: return TurtleGraphics.TurtleCommand.PEN_DOWN;
            case 3: return TurtleGraphics.TurtleCommand.TURN_RIGHT;
            case 4: return TurtleGraphics.TurtleCommand.TURN_LEFT;
            case 5: return TurtleGraphics.TurtleCommand.TURN_UP;
            case 6: return TurtleGraphics.TurtleCommand.TURN_DOWN;
            case 7: return TurtleGraphics.TurtleCommand.MOVE_10_SPACES;
            case 8: return TurtleGraphics.TurtleCommand.DISPLAY_FLOOR;
            case 9:
            default:
                return TurtleGraphics.TurtleCommand.END_OF_DATA;
        }
    }

    public static void main(String[] args) {
        TurtleGraphics turtleGraphics = new TurtleGraphics(20);
        TurtleGraphics.TurtleCommand userCmdChoice = displayMenuGetCommand();

        while (userCmdChoice != TurtleGraphics.TurtleCommand.END_OF_DATA) {
            if (turtleGraphics.executeCommand(userCmdChoice)) {
                System.out.printf("################# [COMMAND EXECUTED] ################%n%n");
            } else {
                System.out.printf("############# [COMMAND NOT EXECUTED ] ###############%n%n");
            }
            userCmdChoice = displayMenuGetCommand();
        }
    }
}
