// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 7.14 from book.                       #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 10/06/2019                                                 #
// #                                                                                  #
// ####################################################################################

package books.JavaHowToProgram10Ed.chapter_7.Exercise_7_17;

public class Exercise_7_17 {

    private static double computeSum(double... someData) {
        double sum = 0.0;
        for (double data : someData)
            sum += data;
        return sum;
    }

    public static void main(String[] args) {
        if (args.length >= 1) {
            double[] mainData = new double[args.length];
            try {
                for (int i = 0; i < args.length; i++)
                    mainData[i] = Double.parseDouble(args[i]);
            } catch (Exception ex) {
                System.out.print("Error while reading argument(s).\n");
            }
            System.out.printf("Sum: %.2f\n", computeSum(mainData));
        }
    }
}
