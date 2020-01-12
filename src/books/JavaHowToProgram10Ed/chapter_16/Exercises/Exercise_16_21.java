package books.JavaHowToProgram10Ed.chapter_16.Exercises;

// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 16.21 from book.                      #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : September 15, 2019                                         #
// #                                                                                  #
// ####################################################################################

import java.util.Collections;
import java.util.PriorityQueue;

public class Exercise_16_21 {

    public static void main(String[] args) {

        // queue of capacity 11
        PriorityQueue<Double> queue = new PriorityQueue<>(Collections.reverseOrder());

        // insert elements to queue
        queue.offer(3.2);
        queue.offer(9.8);
        queue.offer(5.4);

        System.out.print("Polling from queue: ");
        while (queue.size() > 0) {
            System.out.printf("%.1f ", queue.peek());
            queue.poll();
        }
    }
}
