package w3resource.basicPartTwo;

// ############################################################################################
// #                                                                                          #
// #    Program Purpose: Finds all start indices of a given string's anagrams in another      #
// #                     given string.                                                        #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                #
// #    Creation Date  : March 21, 2020                                                       #
// #                                                                                          #
// ############################################################################################

import java.util.Arrays;
import java.util.Objects;
import java.util.LinkedList;
import java.util.Set;
import java.util.List;
import java.util.HashSet;
import java.util.Scanner;

public class Exercise_188 {

    private static class StringFindAllPermutations {
        public static Set<String> permutationFinder(String str) {
            Set<String> perm = new HashSet<>();

            // Handling error scenarios
            if (Objects.isNull(str)) {
                return null;
            } else if (str.length() == 0) {
                perm.add("");
                return perm;
            }
            char initial = str.charAt(0);                   // first character
            String rem = str.substring(1);                  // Full String without first character
            Set<String> words = permutationFinder(rem);
            for (String strNew : words) {
                for (int i = 0; i <= strNew.length(); i++) {
                    perm.add(charInsert(strNew, initial, i));
                }
            }
            return perm;
        }
        private static String charInsert(String str, char ch, int j) {
            String begin = str.substring(0, j);
            String end = str.substring(j);
            return begin + ch + end;
        }
    }

    private static Scanner scanner = new Scanner(System.in);

    private static String obtainUserData(String inputMessage) {
        String userData = "";
        boolean cont = true;

        while (cont) {
            try {
                System.out.print(inputMessage);
                userData = scanner.next().trim();
                cont = false;

            } catch (IllegalStateException illegalStateExc) {
                System.err.print("[SCANNER_CLOSED]: Re-opening ...");
                scanner = new Scanner(System.in);
                System.out.println("[DONE]");

            } catch (Exception exc) {
                System.err.println("[ERROR]: " + exc.getMessage());
            }
        }
        return userData;
    }

    private static Integer[] findStartIndices(String mainData, String searchAnagram) {

        if (searchAnagram.length() == 0) {
            return new Integer[0];
        }

        Set<String> allPermsSet = StringFindAllPermutations.permutationFinder(searchAnagram);

        // if we couldn't find a permutation (which shouldn't be the case at this point, there
        // could be a bug in the 'permutationFinder' static method) we return an empty integer array.

        if (Objects.isNull(allPermsSet)) {
            return new Integer[0];
        }


        // Temporary store for found indices

        List<Integer> tempList = new LinkedList<>();


        for (int i = 0; i < mainData.length(); i++) {

            // We check to make sure there is still more data in 'mainData' to work with
            // based on the length of the 'searchAnagram' parameter. That is, if we can
            // continue search (this is for the first test condition in 'if' statement
            // below.

            // Second test condition entails, checking if the the substring at this index
            // (from this index 'i' to 'i + searchAnagram.length()' is found in the permutation
            // set obtained from above. If that is the case, we add to 'store' else we continue
            // searching till we're not able to search.

            if (((mainData.length() - i) >= searchAnagram.length()) &&
                    allPermsSet.contains(mainData.substring(i , i + searchAnagram.length()))) {
                tempList.add(i);
            }
        }

        // We have to convert the found indices in list to an array
        return tempList.toArray(new Integer[0]);
    }

    public static void main(String[] args) {
        String mainData = obtainUserData("Enter an anagram: ");
        String searchData = obtainUserData("Enter search anagram: ");

        Integer[] indices = findStartIndices(mainData, searchData);
        System.out.printf("Starting anagram indices of %s: %s\n",
                searchData, Arrays.toString(indices));

    }

}
