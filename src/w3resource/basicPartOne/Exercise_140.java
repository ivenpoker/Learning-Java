package w3resource.basicPartOne;


// #######################################################################################################
// #                                                                                                     #
// #    Program Purpose: Merges all overlapping intervals from a given collection of intervals.          #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                           #
// #    Creation Date  : November 13, 2019                                                               #
// #                                                                                                     #
// #######################################################################################################

import java.util.ArrayList;
import java.util.Collections;

public class Exercise_140 {

    private static class Interval implements Comparable<Interval> {

        private int start;
        private int end;

        public Interval(int start, int end) {
            this.setStart(start);
            this.setEnd(end);
        }
        public void setStart(int newStart) {
            this.start = newStart;
        }
        public void setEnd(int newEnd) {
            this.end = newEnd;
        }
        public int getStart() {
            return this.start;
        }
        public int getEnd() {
            return this.end;
        }

        @Override
        public int compareTo(Interval i2) {
            return this.start - i2.start;
        }
    }

    private static void printIntervals(String message, ArrayList<Interval> intervals) {
        System.out.print(message);
        for (int i = 0; i < intervals.size(); i++)
            System.out.printf("\tInterval #%02d: [%02d, %02d]\n", i+1,
                    intervals.get(i).getStart(), intervals.get(i).getEnd());
    }

    public static void main(String[] args) {
        ArrayList<Interval> x = new ArrayList<>();

        x.add(new Interval(1, 3));
        x.add(new Interval(2, 6));
        x.add(new Interval(8, 10));
        x.add(new Interval(15, 18));
        x.add(new Interval(17, 20));

        printIntervals("Created intervals:\n", x);

        x = mergeIntervals(x);

        printIntervals("\nAfter merging intervals:\n", x);


    }

    public static ArrayList<Interval> mergeIntervals(ArrayList<Interval> intervals) {
        if (intervals.size() == 0 || intervals.size() == 1)
            return intervals;

        Collections.sort(intervals);
        Interval first = intervals.get(0);

        int start = first.getStart();
        int end = first.getEnd();

        ArrayList<Interval> result = new ArrayList<>();
        for (int i = 1; i < intervals.size(); i++) {
            Interval current = intervals.get(i);
            if (current.getStart() <= end) {
                end = Math.max(current.getEnd(), end);
            } else {
                result.add(new Interval(start, end));
                start = current.getStart();
                end = current.getEnd();
            }
        }
        result.add(new Interval(start, end));
        return result;
    }
}
