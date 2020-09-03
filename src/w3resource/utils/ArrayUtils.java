package w3resource.utils;

import java.security.SecureRandom;
import java.util.stream.IntStream;

public class ArrayUtils {

    private static final SecureRandom secureRandom = new SecureRandom();

    public static int[] randomIntArrayData(int lower, int upper, int size) {
        if (lower > upper) {
            throw new IllegalArgumentException(
                    String.format("Invalid specified bounds. Lower bound (%d) must be <= Upper bound (%d)",
                            lower, upper));
        } else if (size < 0) {
            throw new IllegalArgumentException(String.format("Invalid specified size (%d). Must be > 0", size));
        }
        return IntStream.of(new int[size]).map((i) -> lower + secureRandom.nextInt(upper)).toArray();
    }

}
