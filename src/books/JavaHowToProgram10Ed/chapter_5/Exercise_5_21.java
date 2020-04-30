package books.JavaHowToProgram10Ed.chapter_5;

public class Exercise_5_21 {

    public static void findAllPythagoreanTriples(int maxRange) {

        // Using a brute force algorithm to find the triples
        // Using formula C = sqrt(A^2 + B^2)

        for (int i = 1; i < maxRange; i++) {                                            // for 'C' in formula
            for (int j = 1; j < maxRange; j++) {                                        // for 'A' in formula
                for (int k = 1; k < maxRange; k++) {                                    // for 'B' in formula
                    if ((double) i == (Math.sqrt(Math.pow(j, 2) + Math.pow(k, 2)))) {

                        // we've found a triple
                        System.out.printf("Triplets found: [C = %d, A = %d, B = %d]]%n", i, j, k);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        findAllPythagoreanTriples(500);
    }

}
