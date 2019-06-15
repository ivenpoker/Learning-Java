// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 8.13 from book.                       #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 14/06/2019                                                 #
// #                                                                                  #
// ####################################################################################

package books.JavaHowToProgram10Ed.chapter_8.Exercise.Exercise_8_13;

import java.security.SecureRandom;

public class Exercise_8_13 {

    private static SecureRandom random = new SecureRandom();

    public static void main(String[] args) {
        IntegerSet setA = new IntegerSet(20);
        IntegerSet setB = new IntegerSet(20);
        IntegerSet setC = new IntegerSet(20);

        // Sets are currently empty....

        System.out.printf("Set A: %s\n", setA);
        System.out.printf("Set B: %s\n", setB);
        System.out.printf("Set C: %s\n", setC);

        System.out.println();

        // Randomly set values in both sets
        for (int i = 0; i < setA.getSize(); i++) {
            setA.insertElement(random.nextInt(setA.getSize()));
            setB.insertElement(random.nextInt(setB.getSize()));
            setC.insertElement(random.nextInt(setC.getSize()));
        }

        System.out.printf("Set A: %s\n", setA);
        System.out.printf("Set B: %s\n", setB);
        System.out.printf("Set C: %s\n", setC);

        System.out.println();

        // Testing the 'union' functionality'
        System.out.printf("Union of A and B: %s\n", IntegerSet.union(setA, setB));
        System.out.printf("Union of B and C: %s\n", IntegerSet.union(setB, setC));

        System.out.println();

        // Testing the 'Intersection functionality'
        System.out.printf("Intersection of A and B: %s\n", IntegerSet.intersection(setA, setB));
        System.out.printf("Intersection of B and C: %s\n", IntegerSet.intersection(setB, setC));

        System.out.println();

        // Testing the 'equality functionality'
        System.out.printf("Is set A and B equal ?: %s\n", (setA.isEqualTo(setB) ? "YES" : "NO"));
        System.out.printf("Is set B and C equal ?: %s\n", (setB.isEqualTo(setC) ? "YES" : "NO"));

    }
}
