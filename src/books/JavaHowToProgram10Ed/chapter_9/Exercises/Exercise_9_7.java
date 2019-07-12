// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 9.7 from book.                        #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 19/06/2019                                                 #
// #                                                                                  #
// ####################################################################################


package books.JavaHowToProgram10Ed.chapter_9.Exercises;

public class Exercise_9_7 {

    public static void main(String[] args) {

        // MERITS of 'protected' access:
        //          -> The overhead in calling function(s) is avoided as the data is accessed directly
        //             whereas the with private access, there is an overhead in calling function(s) before
        //             'reaching' the actual data.

        // MERIts of 'private' access:
        //          -> The state of the private data is controlled (i.e how the data is modified or change).
        //             Programmer can provide a single point of modification and access of the data, hence controlling
        //             possible state(s) of the data. Ensuring integrity. Whereas, with 'protected' access
        //             the data integrity is not assured as any subclass method OR another class in SAME package can set
        //             the data in an inconsistent state, which could lead to runtime errors, logic errors and/or even
        //             security breaches.
    }
}
