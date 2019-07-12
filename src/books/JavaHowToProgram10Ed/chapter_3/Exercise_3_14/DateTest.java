// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 3.14 from book.                       #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 24/05/2019                                                 #
// #                                                                                  #
// ####################################################################################

package books.JavaHowToProgram10Ed.chapter_3.Exercise_3_14;

public class DateTest {

    public static void main(String[] args) {

        Date date1 = new Date(5, 24, 2019);
        Date date2 = new Date(3, 5, 2020);

        // Display the dates using object methods
        System.out.printf("Date1: %d/%d/%d\n", date1.getMonth(), date1.getDay(), date1.getYear());
        System.out.printf("Date2: %d/%d/%d\n\n", date2.getMonth(), date2.getDay(), date2.getYear());

        // Display the dates using single method call
        System.out.print("Date1: ");
        date1.displayDate();
        System.out.print("Date2: ");
        date2.displayDate();

        // Modify date...
        date1.setDay(12);
        date2.setMonth(7);

        System.out.printf("\nDate1: %d/%d/%d\n", date1.getMonth(), date1.getDay(), date1.getYear());
        System.out.printf("Date2: %d/%d/%d\n\n", date2.getMonth(), date2.getDay(), date2.getYear());





    }
}
