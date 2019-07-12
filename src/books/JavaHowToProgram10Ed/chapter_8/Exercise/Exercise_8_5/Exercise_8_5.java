// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 8.5 from book.                        #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 11/06/2019                                                 #
// #                                                                                  #
// ####################################################################################

package books.JavaHowToProgram10Ed.chapter_8.Exercise.Exercise_8_5;

public class Exercise_8_5 {

    public static void main(String[] args) {
        Time2 time1 = new Time2();
        Time2 time2 = new Time2(1, 45, 20);
        Time2 time3 = new Time2(12, 43, 12);

        System.out.println("The time1: " + time1);
        System.out.println("The time2: " + time2);
        System.out.println("The time3: " + time3);

        time2.setHour(time2.getHour() + 1);             // adding 1 hour to time1's hour
        time2.setMinute(time2.getMinute() + 10);        // adding 20 minutes to time1's current minutes
        time2.setSecond(time2.getSecond() + 10);        // adding 10 seconds to the total seconds in time 1 object.

        System.out.println("After modification of time1 object: " + time2);
    }

}
