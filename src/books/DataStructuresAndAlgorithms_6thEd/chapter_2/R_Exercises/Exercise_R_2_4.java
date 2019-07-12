// #############################################################################
// #                                                                           #
// #      Program purpose: Solution to Exercise R-2.4 in Book                  #
// #      Program author : Happi Yvan <ivensteinpoker@gmail.com>               #
// #      Program Date   : 4/06/2019                                           #
// #                                                                           #
// #############################################################################


package books.DataStructuresAndAlgorithms_6thEd.chapter_2.R_Exercises;

public class Exercise_R_2_4 {

    public static void main(String[] args) {
        // FLAW:
        //
        // If the 'charge' price (for PredatoryCreditCard) class is called with
        // a price of 5.0 and say, 'super.charge(price)' returns 'false' (for price = 5.0)
        // we get stuck inside and infinite loop, in which the function will never return.
    }
}
