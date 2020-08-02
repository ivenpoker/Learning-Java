package books.JavaHowToProgram10Ed.chapter_15.Exercises.Exercise_15_7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Exercise_15_7 {

    private static Scanner scanner = new Scanner(System.in);
    private static int MAX_NUMBER_OF_DIGITS = 7;

    private static HashMap<Integer, ArrayList<Character>> numberCharMappingDatabase() {
        HashMap<Integer, ArrayList<Character>> numCharMapping = new HashMap<>();
        for (int i = 2; i < 10; i++) {
            ArrayList<Character> newList = new ArrayList<>();
            switch (i) {
                case 2: {
                    newList.add('A');
                    newList.add('B');
                    newList.add('C');
                    break;
                }
                case 3: {
                    newList.add('D');
                    newList.add('E');
                    newList.add('F');
                    break;
                }
                case 4: {
                    newList.add('G');
                    newList.add('H');
                    newList.add('I');
                    break;
                }
                case 5: {
                    newList.add('J');
                    newList.add('K');
                    newList.add('L');
                    break;
                }
                case 6: {
                    newList.add('M');
                    newList.add('N');
                    newList.add('O');
                    break;
                }
                case 7: {
                    newList.add('P');
                    newList.add('R');
                    newList.add('S');
                    break;
                }
                case 8: {
                    newList.add('T');
                    newList.add('U');
                    newList.add('V');
                    break;
                }
                case 9: {
                    newList.add('W');
                    newList.add('X');
                    newList.add('Y');
                    break;
                }
            }
            numCharMapping.put(i, newList);
        }
        return numCharMapping;
    }

    private static String readUserNDigitsNumber(String inputMess, int maxDigitsCnt, ArrayList<Integer> exceptions) {
        boolean valid = false;
        int userDigits = 0;

        while (!valid) {
            try {
                System.out.print(inputMess);
                userDigits = scanner.nextInt();

                String tempStr = String.format("%d", userDigits);
                if (tempStr.length() != maxDigitsCnt) {
                    throw new InputMismatchException("Invalid input. Must be a 7-digit number");
                }

                // Making digits are a not found in the exception.
                for (char digit : tempStr.toCharArray()) {

                    int intVal = Integer.parseInt("" + digit);

                    if (exceptions.contains(intVal)) {
                        throw new InputMismatchException(String.format("Invalid digit '%d'. Number must NOT contain digits in %s.",
                                intVal, Arrays.toString(exceptions.toArray(new Integer[0]))));
                    }
                }
                valid = true;
            } catch (InputMismatchException inputMismatchException) {
                System.err.printf("[INVALID_INPUT]: %s%n", inputMismatchException.getMessage());
                scanner.nextLine();         // clear input stream.

            } catch (Exception exception) {
                System.err.printf("[EXCEPTION]: %s%n", exception.getMessage());

            }
        }
        return String.format("%d", userDigits);
    }

    private static ArrayList<String> computeAllWordMappings(List<String> allPermutations,
                                                            HashMap<Integer, ArrayList<Character>> numCharMappings) {
        ArrayList<String> wordEquiv = new ArrayList<>();

        for (String currPerm : allPermutations) {
            StringBuilder sbWord = new StringBuilder();

            for (char ch : currPerm.toCharArray()) {
                int intVal = Integer.parseInt("" + ch);

                // Here we use just the first letter in the character list mapping
                // for the key integer value.

                sbWord.append(numCharMappings.get(intVal).get(0));
            }

            wordEquiv.add(sbWord.toString());
        }
        return wordEquiv;
    }

    public static void main(String[] args) {

        HashMap<Integer, ArrayList<Character>> numCharMapping = numberCharMappingDatabase();
        ArrayList<Integer> exceptions = new ArrayList<>();
        exceptions.add(0);
        exceptions.add(1);

        String userDigits = readUserNDigitsNumber(String.format("Enter %d digits: ", MAX_NUMBER_OF_DIGITS),
                                                            MAX_NUMBER_OF_DIGITS, exceptions);
        List<String> allPermutations = StringManipulation.findPermutations(userDigits);
//        for (int i = 0, size = allPermutations.size(); i < size; i++) {
//            System.out.printf("Permutation #%d: %s%n", i, allPermutations.get(i));
//        }

        ArrayList<String> wordEquivalents = computeAllWordMappings(allPermutations, numCharMapping);
        for (int i = 0, size = wordEquivalents.size(); i < size; i++) {
            System.out.printf("Word #%d: %s%n", i + 1, wordEquivalents.get(i));
        }
    }
}

class StringManipulation {

    public static List<String> findPermutations(String s) {
        List<String>combinations=new ArrayList<>();

        if(s.length() == 1) {
            combinations.add(s);
        } else {
            for(int i = 0; i < s.length(); i++){
                List<String> temp = findPermutations(s.substring(0, i) + s.substring(i+1));
                for (String string : temp) {
                    String tmp = s.charAt(i) + string;
                    if (!combinations.contains(tmp)) {
                        combinations.add(s.charAt(i) + string);
                    }
                }
            }
        }
        return combinations;
    }

}
