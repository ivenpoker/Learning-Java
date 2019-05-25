// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 3.11 from book.                       #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 24/05/2019                                                 #
// #                                                                                  #
// ####################################################################################

package books.JavaHowToProgram10Ed.chapter_3.Exercise_3_11;

public class AccountTest {

    public static void main(String[] args) {
        Account account1 = new Account("Happi Yvan", 200000);
        Account account2 = new Account("James King", 3000);

        // Display account data

        System.out.println("Initial accounts data:\n");
        System.out.printf("Account1 [name: %s] [balance: $%.2f]%n", account1.getName(), account1.getBalance());
        System.out.printf("Account1 [name: %s] [balance: $%.2f]%n", account1.getName(), account1.getBalance());

        // Successful withdrawal

        account1.withDraw(3000);
        account2.withDraw(400);

        System.out.println("\nModified accounts data:\n");
        System.out.printf("Account1 [name: %s] [balance: $%.2f]%n", account1.getName(), account1.getBalance());
        System.out.printf("Account1 [name: %s] [balance: $%.2f]%n", account1.getName(), account1.getBalance());

        // Let's try invalid account1 withdrawal

        double newWithDrawal = account1.withDraw(30000000);
        System.out.print("After attempting bad withdrawal for account 1....\n\n");
        System.out.printf("Account1 [name: %s] [balance: $%.2f]%n", account1.getName(), account1.getBalance());



    }
}
