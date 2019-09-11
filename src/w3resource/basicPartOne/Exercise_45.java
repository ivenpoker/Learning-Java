package w3resource.basicPartOne;

// ########################################################################################
// #                                                                                      #
// #    Program Purpose: Find the size of a specified file.                               #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                            #
// #    Creation Date  : September 11, 2019                                               #
// #                                                                                      #
// ########################################################################################

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Exercise_45 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter file or directory name: ");
        try {
            Path path = Paths.get(input.nextLine());

            if (Files.exists(path)) {
                System.out.printf("%s: %s bytes", path, Files.size(path));
            }
        } catch (SecurityException securityException) {
            System.err.println("Security issues. Terminating...");

        } catch (IOException ioException) {
            System.err.println("I/O Exception");
        }
    }

}
