package books.JavaHowToProgram10Ed.chapter_3;

// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 3.1 from book.                        #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 1/01/2021                                                 #
// #                                                                                  #
// ####################################################################################

import javax.swing.JOptionPane;

public class Exercise_3_1 {
    public static void main(String[] args) {

        // Obtain first and second integer value from user
        String userFirstInt = JOptionPane.showInputDialog(null, "Enter first integer:");
        String userSecondInt = JOptionPane.showInputDialog(null, "Enter second integer: ");

        // Convert first and second integer (strings) to ints (integers)
        int fstInt = Integer.parseInt(userFirstInt);
        int sndInt = Integer.parseInt(userSecondInt);

        // From the 'sum' string.
        String sumStr = String.format("Sum is %d", fstInt + sndInt);

        // Display the sum as a dialog
        JOptionPane.showMessageDialog(null, sumStr);
    }
}
