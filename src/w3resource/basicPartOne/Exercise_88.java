package w3resource.basicPartOne;

// ##################################################################################################
// #                                                                                                #
// #    Program Purpose: Get the current system environment and system properties.                  #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                      #
// #    Creation Date  : September 20, 2019                                                         #
// #                                                                                                #
// ##################################################################################################

public class Exercise_88 {

    public static void main(String[] args) {
        System.out.println("[ ================ CURRENT SYSTEM ENVIRONMENT ============== ]");
        System.out.println(System.getenv());
        System.out.println("[ ================ CURRENT SYSTEM PROPERTIES  ============== ]");
        System.out.println(System.getProperties());
    }
}
