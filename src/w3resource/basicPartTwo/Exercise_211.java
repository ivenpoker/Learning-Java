package w3resource.basicPartTwo;

// #############################################################################################
// #                                                                                           #
// #    Program Purpose: Finds the heights of the top three buildings in descending order from #
// #                     eight given buildings.                                                #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                 #
// #    Creation Date  : July 02, 2020                                                         #
// #                                                                                           #
// #############################################################################################

import java.security.SecureRandom;
import java.util.Arrays;

public class Exercise_211 {

    private static final int LOWER_BOUND = 0;
    private static final int UPPER_BOUND = 100;
    private static final int ARRAY_DATA_SIZE = 10;
    private static final SecureRandom randomNumber = new SecureRandom();

    private static int[] randomArrayOfInts(int low, int high, int size) {
        if (size < 0) {
            throw new IllegalArgumentException(String.format("Invalid array size (%d).", size));
        }
        return Arrays.stream(new int[size]).map((i) -> low + randomNumber.nextInt(high)).toArray();
    }

    private static int[] findTopNBuildHeights(int[] buildingHeights, int numOfBuildings) {
        if (buildingHeights.length < 3) {
            throw new IllegalArgumentException(
                    String.format("Building must be minimum of 3. Passed (%d)", buildingHeights.length));
        }

        // Sort the heights array, but we'll have to make a copy so as not to modify
        // the contents of the array as it is passed by value but sorting modify actual data.

        int[] heightsCopy = Arrays.copyOf(buildingHeights, buildingHeights.length);
        Arrays.sort(heightsCopy);

        // Obtain the top most 5 heights from the sorted list.

        int[] topN_heights = Arrays.stream(heightsCopy, heightsCopy.length - numOfBuildings, heightsCopy.length).toArray();

        // Reverse the sorted data (of length 3) to reflect the 'descending order' fashion.

        for (int i = 0, j = topN_heights.length-1; i < j; i++, j--) {
            int tmp = topN_heights[i];
            topN_heights[i]= topN_heights[j];
            topN_heights[j] = tmp;
        }

        return topN_heights;
    }

    public static void main(String[] args) {

        int[] buildingHeights = randomArrayOfInts(LOWER_BOUND, UPPER_BOUND, ARRAY_DATA_SIZE);
        System.out.printf("Generated heights: %s%n", Arrays.toString(buildingHeights));

        int[] topThreeHeights = findTopNBuildHeights(buildingHeights, 3);

        System.out.printf("Top three heights: %s%n", Arrays.toString(topThreeHeights));
    }
}
