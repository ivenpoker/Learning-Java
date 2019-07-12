// #############################################################################
// #                                                                           #
// #      Program purpose: Solution to Exercise R-2.11 in Book                 #
// #      Program author : Happi Yvan <ivensteinpoker@gmail.com>               #
// #      Program Date   : 4/06/2019                                           #
// #                                                                           #
// #############################################################################

package books.DataStructuresAndAlgorithms_6thEd.chapter_2.R_Exercises;

public class Exercise_R_2_11 {

    public static class MaryLand extends State {
        public MaryLand() {}
        public void printMe() {
            System.out.println("Read it");
        }
    }

    public static class State extends Region {
        public State() {}
        public void printMe() {
            System.out.println("Ship it");
        }
    }

    public static class Region extends Place {
        public Region() {}
        public void printMe() {
            System.out.println("Box it");
        }
    }

    public static class Place extends Object {
        public Place() {}
        public void printMe() {
            System.out.println("Buy it.");
        }
    }

    public static void main(String[] args) {

        // Just run it, and try to understand :)!

        Region east = new State();
        State md = new MaryLand();
        Object obj = new Place();
        Place usa = new Region();

        md.printMe();
        east.printMe();
        ((Place) obj).printMe();
        obj = md;
        ((Place) obj).printMe();
        obj = usa;
        ((Place) obj).printMe();
        usa = md;
        ((Place) usa).printMe();
    }
}
