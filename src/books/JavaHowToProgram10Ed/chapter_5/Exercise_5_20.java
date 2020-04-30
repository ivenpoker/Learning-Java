package books.JavaHowToProgram10Ed.chapter_5;

public class Exercise_5_20 {

    private static double computePIFromSeries(int numTerms) {
        double series = 4 - ((double) 4 / 3 );
        int denom = 5;                          // for next computation
        for (int i = 2; i <= numTerms; i++) {
            if (i % 2 == 0) {
                series += ((double) 4 / denom);
            } else {
                series -= ((double) 4 / denom);
            }
            denom += 2;
        }
        return series;
    }

    public static void main(String[] args) {

        int maxTerms = 200000;
        for (int i = 1; i < maxTerms; i++) {
            double val = computePIFromSeries(i);
            System.out.printf("PI approximation: %.10f (#%d)%n", val, i);

            String tmpStr = String.format("%.5f", val);
            double trimVal = Double.parseDouble(tmpStr);
            if (trimVal == 3.14159) {
                break;
            }
        }

        // From the computation above, I'll have to use 130657

    }


}
