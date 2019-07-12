// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 9.5 from book.                        #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 19/06/2019                                                 #
// #                                                                                  #
// ####################################################################################

package books.JavaHowToProgram10Ed.chapter_9.Exercises;

public class Exercise_9_5 {

    public static void main(String[] args) {
        //                                       Student
        //                                     /          \
        //                                    /            \
        //                                   /              \
        //                      Undergraduate Student     Graduate student
        //                     /    |        |   \             |          \
        //                    /     |        |    \            |           \
        //                   /      |        |     \           |            \
        //                  /       |        |      \          |             \
        //           Freshman    Sophomore  Junior  Senior  Doctoral Student  Master Student
        //
        //
        //  Hierarchy:
        //       A student could be an 'Undergraduate student' OR a 'Graduate student'
        //       An 'Undergraduate student could be a 'Freshman', 'Sophomore', 'Junior' or 'Senior'
        //       A  'Graduate' student could be a 'Doctoral Student' AND/OR 'Master Student'
        //
    }
}
