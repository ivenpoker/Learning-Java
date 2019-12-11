package w3resource.basicPartTwo;

// ####################################################################################
// #                                                                                  #
// #    Program Purpose: Accepts 4 integers from the user and determines if all four  #
// #                     integers are equal or not.                                   #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                        #
// #    Creation Date  : December 11, 2019                                            #
// #                                                                                  #
// ####################################################################################

import java.util.stream.IntStream;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.List;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Set;

public class Exercise_152 {

    private static Scanner scanner = new Scanner(System.in);

    private static int readUserData(String inputMessage) {
        boolean isValid = false;
        int userData = -1;

        while (!isValid) {
            try {
                System.out.print(inputMessage);
                userData = scanner.nextInt();
                isValid = true;

            } catch (InputMismatchException inputExc) {
                System.err.println("Oops, invalid input");

            } catch (Exception exc) {
                System.out.println(exc.getMessage());
            }
        }
        return userData;
    }

    private static boolean areAllEqual(int[] data) {
        List<Integer> mainData = new ArrayList<>();
        for (int temp : data) {
            mainData.add(temp);
        }
        Set<Integer> newSet = new HashSet<>(mainData);
        return newSet.size() == 1;
    }

    public static void main(String[] args) {
        int[] mainData = new int[4];
        int[] tmp = {0};
        mainData = IntStream.of(mainData).map((val) -> {
            val = readUserData(String.format("Enter integer #%d: ", tmp[0]+1));
            tmp[0]++;
            return val;
        }).toArray();

        System.out.printf("Are all %d integers same: [%s]\n",
                mainData.length, (areAllEqual(mainData) ? "YES" : "NO"));
    }
}
