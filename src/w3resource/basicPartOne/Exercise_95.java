package w3resource.basicPartOne;

// #####################################################################################################
// #                                                                                                   #
// #    Program Purpose: Creates an array (length # 0) of string values. The elements will contain "0" #
// #                     , "1", "2", .... through ... n-1.                                             #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                         #
// #    Creation Date  : September 23, 2019                                                            #
// #                                                                                                   #
// #####################################################################################################

import java.util.Arrays;

public class Exercise_95 {

    private static String[] createArrayOfIntegerString(int size) {
        if (size <= 0)
            throw new IllegalArgumentException("Invalid array size. Size must be >= 0");
        String[] newData = new String[size];
        for (int i = 0; i < size; i++)
            newData[i] = String.format("%d", i);
        return newData;
    }

    public static void main(String[] args) {
        System.out.printf("Generated array is: %s\n", Arrays.toString(createArrayOfIntegerString(10)));
    }
}
