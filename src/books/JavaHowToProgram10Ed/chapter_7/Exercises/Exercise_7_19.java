// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 7.19 from book.                       #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 11/06/2019                                                 #
// #                                                                                  #
// ####################################################################################

package books.JavaHowToProgram10Ed.chapter_7.Exercises;

import java.util.Scanner;

public class Exercise_7_19 {

    private static enum Seat {ECONOMIC, FIRST_CLASS}

    private static class Resp {
        public int _ind;
        public boolean _resp;

        public Resp(int ind, boolean resp) {
            this._ind = ind;
            this._resp = resp;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean[] seats = new boolean[10];
        boolean loopContinue = true;

        while (loopContinue) {
            System.out.print("\n[===== AIR LINE RESERVATION SYSTEM ===]\n");
            System.out.print("Please type '1' for First Class\n");
            System.out.print("Please type '2' for Economy.\n");
            System.out.print("---------------------------------------\n");
            System.out.print("Enter our choice: ");

            int choice = input.nextInt();
            switch (choice) {
                case 1: {
                    Resp resp = isThereSeatAvailable(seats, Seat.FIRST_CLASS);
                    if (resp._resp) {
                        seats[resp._ind] = true;
                    } else {
                        System.out.print("First class seats are full. Assign economy ? (y/n): ");
                        char ans = input.next().charAt(0);
                        if (ans == 'Y' || ans == 'y') {
                            resp = isThereSeatAvailable(seats, Seat.ECONOMIC);
                            if (resp._resp) {
                                seats[resp._ind] = true;
                            } else {
                                System.out.print("\nOops! All seats have been reserved.\n");
                                loopContinue = false;
                            }
                        } else {
                            System.out.print("\nNext flight leaves in 3 hours\n");
                        }
                    }
                    break;
                }
                case 2: {
                    Resp resp = isThereSeatAvailable(seats, Seat.ECONOMIC);
                    if (resp._resp) {
                        seats[resp._ind] = true;
                    } else {
                        System.out.print("Economy seats are full. Assign first class ? (y/n): ");
                        char ans = input.next().charAt(0);
                        if (ans == 'Y' || ans == 'y') {
                            resp = isThereSeatAvailable(seats, Seat.FIRST_CLASS);
                            if (resp._resp) {
                                seats[resp._ind] = true;
                            } else {
                                System.out.print("\nOops! All seats have been reserved\n");
                                loopContinue = false;
                            }
                        } else {
                            System.out.print("\nNext flight leaves in 3 hours\n");
                        }
                    }
                    break;
                }
                default:
                    System.out.print("Invalid choice!");
            }
            System.out.print("---------------------------------------\n");
            System.out.print("Seats: ");
            for (int i = 0; i < seats.length; i++)
                System.out.printf("%s%s", seats[i] ? "T" : "_", (i == seats.length-1) ? "\n" : " | ");
        }
    }

    private static Resp isThereSeatAvailable(boolean[] seats, Seat type) {
        if (type == Seat.FIRST_CLASS) {
            for (int i = 0; i < 5; i++)
                if (!seats[i])
                    return new Resp(i, true);
            return new Resp(-1, false);
        } else if (type == Seat.ECONOMIC) {
            for (int i = 5; i < seats.length; i++)
                if (!seats[i])
                    return new Resp(i, true);
            return new Resp(-1, false);
        }
        return null;
    }
}
