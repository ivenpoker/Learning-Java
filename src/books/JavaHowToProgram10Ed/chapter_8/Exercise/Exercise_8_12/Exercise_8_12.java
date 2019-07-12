// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 8.12 from book.                       #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 14/06/2019                                                 #
// #                                                                                  #
// ####################################################################################

package books.JavaHowToProgram10Ed.chapter_8.Exercise.Exercise_8_12;

public class Exercise_8_12 {

    public static void main(String[] args) {
        DateAndTime dateAndTime = new DateAndTime(new DateAndTime.Time(23, 30, 20),
                new DateAndTime.Date(10, 12, 2019));

        System.out.printf("Date and time: %s\n", dateAndTime);

        // Incrementing the hour (moving date to next day)
        dateAndTime.incrementHour();

        System.out.printf("After incrementing hour: %s\n", dateAndTime);

    }
}
