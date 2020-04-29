// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 5.9 from book.                        #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 29/05/2019                                                 #
// #                                                                                  #
// ####################################################################################

package books.JavaHowToProgram10Ed.chapter_5;

public class Exercise_5_9 {

    public static void main(String[] args) {
        // ANS a): - The 'For' has capital letter 'F' in head. It should be lowercase.
        //         - The variable 'i' should be decrementing instead of incrementing. In this case
        //           it will cause an infinite-loop when execution reaches the statement.

        // ANS b): - The error here is that, the outcome of 'value % 2' is either 0 and 1,
        //           and case labels in the switch statement doesn't have to a 'break' statement
        //           for each case. As a result, if the value of 'value % 2' is 0, execution will fall through
        //           'case 0' and 'case 1'.

        // ANS c): - The problem is that, the 'for loop' is going to iterate infinitely.
        //           FIX: change the 'i += 2 ' to 'i -= 2', so we should be decrementing by 2 instead of
        //           incrementing by 2.

        // ANS d): - do-while loop, is to print till 100, but will print till 98. To fix it,
        //           let the condition in the 'while' statement be 'counter <= 100'.
    }
}
