package w3resource.basicPartOne;

// #####################################################################################################
// #                                                                                                   #
// #    Program Purpose: Check whether a security manager has already been established for the current #
// #                     application or not.                                                           #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                         #
// #    Creation Date  : September 20, 2019                                                            #
// #                                                                                                   #
// #####################################################################################################

public class Exercise_89 {

    public static void main(String[] args) {
        System.out.print("System security interface: ");
        System.out.println(System.getSecurityManager());
    }
}
