package w3resource.basicPartOne;

// #######################################################################################################
// #                                                                                                     #
// #    Program Purpose: Finds the subarray with smallest sum from a given array of integers and prints  #
// #                     it's sum.                                                                       #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                           #
// #    Creation Date  : October 26, 2019                                                                #
// #                                                                                                     #
// #######################################################################################################

import java.util.ArrayList;

public class Exercise_123 {
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<Integer>();
        nums.add(-2);
        nums.add(1);
        nums.add(-3);
        nums.add(4);
        System.out.print(min_SubArray(nums));
    }
    public static int min_SubArray(ArrayList<Integer> nums) {
        int[] nums1 = new int[nums.size()];
        nums1[0] = nums.get(0);
        int min = nums1[0];
        for (int i = 1; i < nums.size(); ++i) {
            nums1[i] = Math.min(nums.get(i), nums.get(i) + nums1[i - 1]);
            min = Math.min(min, nums1[i]);
        }
        return min;
    }
}
