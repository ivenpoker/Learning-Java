package books.JavaHowToProgram10Ed.chapter_16.Exercises.Exercise_16_21;

import java.util.Collections;
import java.util.PriorityQueue;

public class AlternativeImplementation {

    public static void main(String[] args) {
        PriorityQueue<Double> queue = new PriorityQueue<>(Collections.reverseOrder());

        // insert elements to queue
        queue.offer(3.2);
        queue.offer(9.8);
        queue.offer(5.4);

        System.out.print("Polling from queue: ");

        // Display elements in queue
        while (queue.size() > 0) {
            System.out.printf("%.1f ", queue.peek());
            queue.poll();
        }
    }

}
