package books.JavaHowToProgram10Ed.chapter_4.Exercise_4_38;

import java.util.Scanner;

public class AlternativeImplementation {

    private static String encryptDigits(int number) {

        // Extract all 4 digits from number, individually.

        int fstDigit = number / 1000;
        int sndDigit = (number / 100) % 10;
        int thrdDigit = (number % 100) / 10;
        int fourthDigit = number % 10;

        System.out.printf("Before encryption digits: %d %d %d %d\n", fstDigit, sndDigit, thrdDigit, fourthDigit);

        // Step 1: Adding 7 to number and assigning the results of remainder when divided by 10

        fstDigit = (fstDigit + 7) % 10;
        sndDigit = (sndDigit + 7) % 10;
        thrdDigit = (thrdDigit + 7) % 10;
        fourthDigit = (fourthDigit + 7) % 10;

        // Step 2: Swap the first and the third digit, and swap the second and fourth digit;

        int temp = fstDigit;
        fstDigit = thrdDigit;
        thrdDigit = temp;

        temp = sndDigit;
        sndDigit = fourthDigit;
        fourthDigit = temp;

        // Step 3: Combine individual digits to a single numbers

        // NB: We're working with integers here in string format because if the encrypted number has a leading
        //     zero (as in the case of '1234' encryption), it will not be revealed to the caller, instead he/she
        //     will see '189' as the results of the encryption and NOT '0189'. So we use strings here
        //     and our return type is a string instead of int, to preserve leading zero.

        String tempNumStr = String.format("%d%d%d%d", fstDigit, sndDigit, thrdDigit, fourthDigit);

        System.out.printf(" After encryption digits: %d %d %d %d\n", fstDigit, sndDigit, thrdDigit, fourthDigit);
        System.out.printf("Final num (as integer): %d\n", Integer.parseInt(tempNumStr));

        // Step 4: Return the results to the caller

        return tempNumStr;
    }

    private static String decryptDigits(String someStr) {

        // NB: Here we're using String object method 'charAt' to obtain the digit (as a character here)
        //     at a particular index, then we add it to a string (to convert the character [digit] to string)
        //     and later convert it back to an integer, using the 'Integer' class 'parseInt' method.
        //     All of this is done because, if we convert the string directly to integer using 'parseInt' on original
        //     string parameter, we will loose the first digit in case it was zero.

        int fstDigit = Integer.parseInt("" + someStr.charAt(0));
        int sndDigit = Integer.parseInt("" + someStr.charAt(1));
        int thrdDigit = Integer.parseInt("" + someStr.charAt(2));
        int fourthDigit = Integer.parseInt("" + someStr.charAt(3));

        System.out.printf("Decrypting digit obtained: %d %d %d %d\n", fstDigit, sndDigit, thrdDigit, fourthDigit);

        // FROM HERE HENCEFORTH WE REVERSE PROCESS OF ENCRYPTION OF THE DATA

        // Step 1: Swap the first and the third digit, and swap the second and fourth digit;

        int temp = fstDigit;
        fstDigit = thrdDigit;
        thrdDigit = temp;

        temp = sndDigit;
        sndDigit = fourthDigit;
        fourthDigit = temp;

        // Step 2: Undo the operations (addition and modulation)

        fstDigit = 10 - ((fstDigit - 7) * -1);

        if (fstDigit >= 10) fstDigit %= 10;

        sndDigit = 10 - ((sndDigit - 7) * -1);

        if (sndDigit >= 10) sndDigit %= 10;

        thrdDigit = 10 - ((thrdDigit - 7) * -1);

        if (thrdDigit >= 10) thrdDigit %= 10;

        fourthDigit = 10 - ((fourthDigit - 7) * -1);

        if (fourthDigit >= 10) fourthDigit %= 10;

        // Convert the results to a single number using String.format(...)

        return String.format("%d%d%d%d", fstDigit, sndDigit, thrdDigit, fourthDigit);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Read user four digit number

        System.out.print("Enter a four digit number: ");
        int user4digit = input.nextInt();

        // Valid user input, making sure it's actually a 4 digit number

        while (!(user4digit / 1000 > 0)) {
            System.out.print("Enter a FOUR (4) digit number: ");
            user4digit = input.nextInt();
        }

        String encryptedNum = encryptDigits(user4digit);

        System.out.println();

        System.out.printf("Encrypted digits: %s\n", encryptedNum);

        String decryptedNum = decryptDigits(encryptedNum);
        System.out.printf("Decrypted digits: %s\n", decryptedNum);
    }
}
