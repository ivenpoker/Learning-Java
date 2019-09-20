package w3resource.basicPartOne;

// ##################################################################################################
// #                                                                                                #
// #    Program Purpose: Get the value of the environment variable PATH, TEMP, USERNAME.            #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                      #
// #    Creation Date  : September 20, 2019                                                         #
// #                                                                                                #
// ##################################################################################################

public class Exercise_90 {

    public static void main(String[] args) {
        System.out.printf("Environment variable PATH: %s\n", System.getenv("PATH"));
        System.out.printf("Environment variable TEMP: %s\n", System.getenv("TEMP"));
        System.out.printf("Environment variable USERNAME: %s\n", System.getenv("TEMP"));
    }
}
