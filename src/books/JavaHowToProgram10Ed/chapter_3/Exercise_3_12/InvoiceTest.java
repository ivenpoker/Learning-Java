// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 3.12 from book.                       #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 24/05/2019                                                 #
// #                                                                                  #
// ####################################################################################

package books.JavaHowToProgram10Ed.chapter_3.Exercise_3_12;

public class InvoiceTest {

    public static void main(String[] args) {
        Invoice invoice1 = new Invoice("C12DEF","External keyboard", 10, 20);

        // Display invoices...
        System.out.println("Invoice1's data...\n");
        System.out.printf("Part number: %s\nPart description: %s\n", invoice1.getPartNumber(), invoice1.getPartDescription());
        System.out.printf("Part Quantity: %d\nPrice Per Item: $%.2f\n", invoice1.getQuantityPurchased(), invoice1.getPricePerItem());
        System.out.printf("Invoice amount: $%.2f\n", invoice1.getInvoiceAmount());

    }
}
