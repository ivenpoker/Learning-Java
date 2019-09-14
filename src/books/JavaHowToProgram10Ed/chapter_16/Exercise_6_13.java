package books.JavaHowToProgram10Ed.chapter_16;

// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 16.13 from book.                      #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : September 14, 2019                                         #
// #                                                                                  #
// ####################################################################################

import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class Exercise_6_13 {

    private static TreeSet<String> firstNames = new TreeSet<>();
    private static Scanner scanner = new Scanner(System.in);

    private static void readAndStoreFirstNames() {
        String firstName = "";
        int i = 0;
        boolean cont = true;

        while (cont) {
            try {
                System.out.print("Enter first name [enter '0' to stop]: ");
                firstName = scanner.next().trim();
                if (firstName.equals("0")) {
                    cont = false;
                    continue;
                }
                try {
                    firstNames.add(firstName);
                } catch (Exception exception) {
                    System.err.println("Exception with set object: " + exception.getMessage());
                }

            } catch (Exception exception) {
                System.err.println(exception.getMessage());
            }
        }
    }

    private static void printStoredFirstNames() {
        System.out.println("\nFirst names entered are...\n");
        Iterator<String> iterator = firstNames.iterator();
        for (int i = 1; i <= firstNames.size(); i++) {
            if (iterator.hasNext()) {
                System.out.printf("%d. %s\n", i, iterator.next());
            }
        }
    }

    public static void main(String[] args) {
        readAndStoreFirstNames();
        printStoredFirstNames();
    }

}
