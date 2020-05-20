package books.JavaHowToProgram10Ed.chapter_7.Exercise_7_15;

public class Exercise_7_15 {

    private static boolean inRange(int low, int val, int high) {
        return low <= val && val <= high;
    }

    public static void main(String[] args) {
        if (!inRange(2, args.length, 3)) {
            System.out.printf("Error: Please re-enter the entire command, including%n" +
                    "an array size (optional, defaults to 10), initial value and increment");
        } else {

            int[] array;
            int initialValue = 0;
            int increment = 0;

            // if the user provided just 2 arguments, we default
            // the array size to 10

            if (args.length == 2) {
                array = new int[10];
                initialValue = Integer.parseInt(args[0]);
                increment = Integer.parseInt(args[1]);
            } else {

                // get array size from first command-line argument
                int arrayLength = Integer.parseInt(args[0]);
                array = new int[arrayLength];

                // get initial value and increment from command-line arguments
                initialValue = Integer.parseInt(args[1]);
                increment = Integer.parseInt(args[2]);

            }

            // Calculate value for each array element
            for (int cnt = 0; cnt < array.length; cnt++) {
                array[cnt] = initialValue + increment * cnt;
            }
            System.out.printf("%s%8s%n", "Index", "Value");

            // Display array index and value
            for (int cnt = 0; cnt < array.length; cnt++) {
                System.out.printf("%5d%8d%n", cnt, array[cnt]);
            }
        }
    }
}
