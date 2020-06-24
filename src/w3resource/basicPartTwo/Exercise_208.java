package w3resource.basicPartTwo;

// #############################################################################################
// #                                                                                           #
// #    Program Purpose: Compress string using a basic compression method that uses the counts #
// #                     of repeated characters in the string.                                 #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                 #
// #    Creation Date  : June 24, 2020                                                         #
// #                                                                                           #
// #############################################################################################

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise_208 {

    private static Scanner scanner = new Scanner(System.in);

    private static String obtainUserStringInput(String inputMess) {
        boolean valid = false;
        String userStr = "";

        while (!valid) {
            try {
                System.out.print(inputMess);
                userStr = scanner.nextLine().trim();
                if (userStr.length() > 0) {
                    valid = true;
                }
            } catch (InputMismatchException iMe) {
                System.err.println("[INPUT_ERROR]: Invalid input");

            } catch (IllegalStateException iSe) {
                System.err.print("[RE-BOOTING_SCANNER]: ... ");
                scanner = new Scanner(System.in);
            }
        }
        return userStr;
    }

    private static HashMap<Character, Integer> mapUserData(String stringData) {
        HashMap<Character, Integer> dataMap = new HashMap<>();
        for (char ch : stringData.toCharArray()) {
            if (dataMap.containsKey(ch)) {
                int oldKeyVal = dataMap.get(ch);
                dataMap.put(ch, oldKeyVal + 1);
            } else {
                dataMap.put(ch, 1);
            }
        }
        return dataMap;
    }

    private static String processMappedData(HashMap<Character, Integer> mappedData) {
        StringBuilder sb = new StringBuilder();
        for (Character key : mappedData.keySet()) {
            sb.append(String.format("%s%d", key, mappedData.get(key)));
        }
        return sb.toString();
    }

    private static String compressString(String data) {
        HashMap<Character, Integer> userDataMap = mapUserData(data);
        return processMappedData(userDataMap);
    }

    public static void main(String[] args) {

        String userData = obtainUserStringInput("Enter a string: ");
        System.out.printf("Compressed string: %s%n", compressString(userData));
    }

}


