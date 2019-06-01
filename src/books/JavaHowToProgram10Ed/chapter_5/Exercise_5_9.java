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
        // ANS a): The 'For' has capital letter 'F' in head. It should be lowercase.
        // ANS b): The problem is that the 'case's don't have the 'break' keyword.
        //         As a result, whether the value of 'value % 2 is 0 or 1, it'll
        //         always print 'Even integer' then 'Odd integer'. To fix this,
        //         we need to put a break keyword at the end of the 'case's.
        // ANS c): The problem is the 'for loop' is going to iterate infinitely.
        //         FIX: change the 'i += 2 ' to 'i -= 2'
        // ANS d): do-while is to print till 100, but will print till 98, to fix it
        //         let the condition in the 'while' statement be 'counter <= 100'
    }
}
