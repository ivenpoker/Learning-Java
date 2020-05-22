package books.JavaHowToProgram10Ed.chapter_7.Exercise_7_19;

import java.util.Scanner;

public class AlternativeImplementation {

    private static Scanner input = new Scanner(System.in);
    private enum UserChoice {FIRST, SECOND, TERMINATE_PROG}

    private static boolean inBounds(int low, int val, int high) {
        return low <= val && val <= high;
    }

    private static UserChoice printMenuGetUserChoice() {
        System.out.printf("\n=========== [AIRLINE RESERVATION SYSTEM] ============%n%n");
        System.out.println("-- Please type 1 for First Class");
        System.out.println("-- Please type 2 for Economy.");
        System.out.println("-- Please type 0 to quite program");
        System.out.printf("\n=====================================================%n");
        System.out.print("\tEnter your choice: ");
        int userInput = input.nextInt();

        while (!inBounds(0, userInput, 2)) {
            System.out.print("\tPlease enter VALID choice: ");
            userInput = input.nextInt();
        }

        if (userInput == 1) {
            return UserChoice.FIRST;
        } else if (userInput == 2){
            return UserChoice.SECOND;
        } else {
            return UserChoice.TERMINATE_PROG;
        }

    }

    public static void main(String[] args) {
        AirlineReservation airlineReservation = new AirlineReservation();
        UserChoice userChoice;
        do {
            userChoice = printMenuGetUserChoice();

            switch (userChoice) {
                case FIRST:
                    // Try assigning first class seat
                    if (!airlineReservation.assignSeat(AirlineReservation.SeatType.FIRST_CLASS)) {
                        // seats are full. we try economy.
                        System.out.print("Oops, first class seats are full. Want economy ?(y/n): ");
                        String resp = input.next().trim().charAt(0) + "";
                        while (!resp.equals("y") && !resp.equals("n")) {
                            System.out.printf("%100s", "Plase ENTER VALIID response ?(y/n): ");
                            resp = input.next().trim().charAt(0) + "";
                        }
                        if (resp.equals("y")) {
                            if (!airlineReservation.assignSeat(AirlineReservation.SeatType.ECONOMY)) {
                                //
                                System.out.printf("\n\n\t===== [Next flight leaves in 3 hours] =====%n%n");
                            }
                            // At this point user has been reassigned and economy seat.
                        }
                        // If 'no' we continue program by showing menu.
                    }
                    System.out.printf("%n================= [AIRLINE RESERVATION] ===============%n%n");
                    System.out.printf("\t%s%n", airlineReservation);
                    break;

                case SECOND:
                    // Try assigning second class seat
                    if (!airlineReservation.assignSeat(AirlineReservation.SeatType.ECONOMY)) {
                        System.out.print("Oops, economy seats are full. Want first class ?(y/n): ");
                        String resp = input.next().trim().charAt(0) + "";

                        while (!resp.equals("y") && !resp.equals("n")) {
                            System.out.printf("%s100s", "Please ENTER VALID response ?(y/n): ");
                        }

                        if (resp.equals("y")) {
                            if (!airlineReservation.assignSeat(AirlineReservation.SeatType.FIRST_CLASS)) {
                                System.out.printf("\n============= [Next flight leaves in 3 hours] ==============%n%n");
                            }
                        }
                    }
                    System.out.printf("%n================= [AIRLINE RESERVATION] ===============%n%n");
                    System.out.printf("\t%s%n", airlineReservation);

                case TERMINATE_PROG:
                    break;

                default:
                    System.out.print("\n\n\t\t[SYSTEM_ERROR]: TERMINATING ...\n\n");
                    userChoice = UserChoice.TERMINATE_PROG;
                    break;
            }
        } while (userChoice != UserChoice.TERMINATE_PROG);
    }

}
