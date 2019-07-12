// #############################################################################
// #                                                                           #
// #      Program purpose: Solution to Exercise R.1.13 in Book                 #
// #      Program author : Happi Yvan <ivensteinpoker@gmail.com>               #
// #      Program Date   : 1/06/2019                                           #
// #                                                                           #
// #############################################################################


package books.DataStructuresAndAlgorithms_6thEd.chapter_1.R_Exercises.Exercise_R_1_13;

public class Exercise_R_1_13 {

    public static void main(String[] args) {
        CreditCard[] wallet = new CreditCard[3];

        wallet[0] = new CreditCard("John Bowman", "California Savings",
                "5391 0375 9387 5309", 5000);
        wallet[1] = new CreditCard("John Bowman", "California Federal",
                "3485 0399 3395 1954", 3500);
        wallet[2] = new CreditCard("John Bowman", "California Finance",
                "5391 0375 9387 5309", 2500, 300);

        for (int val = 1; val < 1250; val++) {
            wallet[0].charge(3 *val);
            wallet[1].charge(2 * val);
            wallet[2].charge(val);
        }

        for (CreditCard card : wallet) {
            CreditCard.printSummary(card);
            while (card.getBalance() > 200.0) {
                card.makePayment(200);
                System.out.printf("New balance: %.2f\n", card.getBalance());
            }
        }
    }
}
