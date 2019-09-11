package w3resource.basicPartOne;

// ########################################################################################
// #                                                                                      #
// #    Program Purpose: List the available character sets in charset objects.            #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                            #
// #    Creation Date  : September 11, 2019                                               #
// #                                                                                      #
// ########################################################################################

import java.nio.charset.Charset;

public class Exercise_40 {

    public static void main(String[] args) {

        System.out.println("List of available character sets: ");
        for (String str : Charset.availableCharsets().keySet())
            System.out.println(str);
    }

}
