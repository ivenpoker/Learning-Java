package w3resource.basicPartOne;

// ########################################################################################
// #                                                                                      #
// #    Program Purpose: Input and display password. (NB: run from command line)          #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                            #
// #    Creation Date  : September 11, 2019                                               #
// #                                                                                      #
// ########################################################################################

import java.io.Console;
import java.util.Arrays;

public class Exercise_42 {

    public static void main(String[] args) {
        Console cons;
        if ((cons = System.console()) != null) {
            char[] pass_word = null;
            try {
                pass_word = cons.readPassword("Enter your password: ");
                System.out.println("Your password was: " + new String(pass_word));

            } finally {
                if (pass_word != null) {
                    Arrays.fill(pass_word, ' ');
                }
            }
        } else {
            throw new RuntimeException("Can't get password...No console");
        }
    }

}
