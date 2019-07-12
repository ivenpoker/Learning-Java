// #############################################################################
// #                                                                           #
// #      Program purpose: Solution to Exercise R.1.1 in Book                  #
// #      Program author : Happi Yvan <ivensteinpoker@gmail.com>               #
// #      Program Date   : 1/06/2019                                           #
// #                                                                           #
// #############################################################################

package books.DataStructuresAndAlgorithms_6thEd.chapter_1.R_Exercises;

import java.util.Scanner;

public class Exercise_R_1_1 {

    public static void inputAllBasetypes() {
        int intVal;
        double doubleVal;
        String stringVal;
        char charVal;
        boolean booleanVal;

        Scanner input = new Scanner(System.in);
        System.out.print("Enter values of base types (int, double, string, char, boolean): ");

        intVal = input.nextInt();
        doubleVal = input.nextDouble();
        stringVal = input.next();
        charVal   = (char) input.next().charAt(0);
        booleanVal = input.nextBoolean();

        System.out.printf("Your values are: %d %.2f %s %c %s", intVal,
                doubleVal, stringVal, charVal, booleanVal);
    }

    public static void main(String[] args) {
        Exercise_R_1_1.inputAllBasetypes();
    }
}
