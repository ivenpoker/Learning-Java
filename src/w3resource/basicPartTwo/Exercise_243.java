package w3resource.basicPartTwo;

// #############################################################################################
// #                                                                                           #
// #    Program Purpose: Reads a list of pairs of a word and a page number, and prints the     #
// #                     word and a list of the corresponding page numbers. The number of      #
// #                     pairs of a word and a page number is less than or equal to 1000. A    #
// #                     word never appear in a page more than once. The words should be       #
// #                     printed in alphabetical order and the page numbers should be printed  #
// #                     in ascending order.                                                   #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                 #
// #    Creation Date  : August 06, 2020                                                       #
// #                                                                                           #
// #############################################################################################

import java.util.PriorityQueue;
import java.util.Scanner;

public class Exercise_243 {

    private static Scanner input = new Scanner(System.in);
    private static final String STOP_STR = ".";

    private static class Pair implements Comparable<Pair> {
        public String word;
        public int page;

        public Pair(String word, int page) {
            this.word = word;
            this.page = page;
        }

        @Override
        public int compareTo(Pair pair) {
            if (this.word.equals(pair.word)) {
                return this.page - pair.page;
            } else {
                return this.word.compareTo(pair.word);
            }
        }

        @Override
        public String toString() {
            return String.format("%s %s", this.word, this.page);
        }
    }

    private static PriorityQueue<Pair> readUserInput(String inputMess, String stopStr) {
        PriorityQueue<Pair> pairsList = new PriorityQueue<>();

        while (true) {
            try {
                System.out.print(inputMess);
                String tmp = input.nextLine().trim();

                if (tmp.trim().equals(stopStr)) {
                    break;
                }

                String[] tokens = tmp.split("\\s+");
                if (tokens.length != 2) {
                    throw new IllegalArgumentException(
                            String.format("invalid number of input. Expected %d got %d.", 2, tokens.length));
                }
                pairsList.add(new Pair(tokens[0], Integer.parseInt(tokens[1])));
            } catch (IllegalArgumentException iAe) {
                System.err.printf("[Invalid_input]: %s%n", iAe.getMessage());

            } catch (Exception exc) {
                System.out.printf("[EXCEPTION]: %s%n", exc.getMessage());
            }
        };
        return pairsList;
    }

    private static void displayPairs(PriorityQueue<Pair> pairsQueue) {
        for (Pair pair : pairsQueue) {
            System.out.printf("Pair: %s%n", pair);
        }
    }

    public static void main(String[] args) {

        PriorityQueue<Pair> userPairs = readUserInput(
                String.format("Enter pairs of a word and a page number (enter '%s' to stop): ", STOP_STR), STOP_STR);
        displayPairs(userPairs);
    }
}