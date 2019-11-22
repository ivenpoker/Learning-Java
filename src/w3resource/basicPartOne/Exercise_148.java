package w3resource.basicPartOne;

// ##############################################################################
// #                                                                            #
// #    Program Purpose: Finds the index of the first unique character in a     #
// #                     given string, assume that there is at least one unique #
// #                     character in the string.                               #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                  #
// #    Creation Date  : November 22, 2019                                      #
// #                                                                            #
// ##############################################################################

import java.util.Scanner;

public class Exercise_148 {

    private static Scanner input = new Scanner(System.in);

    private static String getUserStringData(String inputMessage) {
        String userData = "";
        boolean isValid = false;

        while (!isValid) {
            try {
                System.out.print(inputMessage);
                userData = input.next();
                if (userData.length() == 0)
                    throw new IllegalArgumentException("Oops, data needed");
                isValid = true;

            } catch (IllegalArgumentException illegalExc) {
                System.err.println(String.format("[ERROR]: %s\n", illegalExc.getMessage()));

            } catch (Exception exc) {
                System.err.println(exc.getMessage());
            }
        }
        return userData;
    }

    public static int firstUniqChar(String userData) {
        int[] freq = new int[256];
        for (char temp : userData.toCharArray()) {
            freq[temp - 'a']++;
        }
        for (int i = 0; i < userData.length(); i++) {
            if (freq[userData.charAt(i) - 'a'] == 1)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        String userData = getUserStringData("Enter your string: ");
        System.out.printf("First unique character of the above: %d\n", firstUniqChar(userData));

    }

}
