package books.JavaHowToProgram10Ed.chapter_7.Exercise_7_15;

public class AlternativeImplementation {

    private static double sumOfArgs(double[] doubleArgs) {
        double sum = 0.0;
        for (double val : doubleArgs) {
            sum += val;
        }
        return sum;
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.printf("usage: java <compiled-class> arg1 arg2 ...%n");
        } else {
            double[] argDoubles = new double[args.length];
            try {
                for (int i = 0; i < args.length; i++) {
                    argDoubles[i] = Double.parseDouble(args[i]);
                }
                double sum = sumOfArgs(argDoubles);
                System.out.printf("Sum of arguments: %.2f%n", sum);

            } catch (NumberFormatException nfe) {
                nfe.printStackTrace();
            }
        }
    }

}
