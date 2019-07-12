// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 8.7 from book.                        #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 14/06/2019                                                 #
// #                                                                                  #
// ####################################################################################

package books.JavaHowToProgram10Ed.chapter_8.Exercise.Exercise_8_7;

public class Exercise_8_7 {

    public static void main(String[] args) {
        Time time1 = new Time(23, 59, 59);
        Time time2 = new Time(4, 25, 59);

        System.out.println("Time1: " + time1);
        System.out.println("Time2: " + time2);

        // tick 10x for 'time1'
        for (int i = 0; i < 10; i++)
            time1.tick();

        // add 10 minutes to time1
        for (int i = 0; i < 10; i++)
            time2.incrementMinute();

        System.out.println();

        System.out.println("Time1: " + time1);
        System.out.println("Time2: " + time2);

        System.out.println();

        // Add one second to time2 and increment time1 hours

        time1.incrementHour();
        time2.tick();

        System.out.println("Time1: " + time1);
        System.out.println("Time2: " + time2);

    }
}
