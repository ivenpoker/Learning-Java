package w3resource.basicPartOne;

// #######################################################################################################
// #                                                                                                     #
// #    Program Purpose: Finds a number that appears only once in a given array of integers, all numbers #
// #                     occur twice.                                                                    #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                           #
// #    Creation Date  : October 31, 2019                                                                #
// #                                                                                                     #
// #######################################################################################################

import java.util.List;
import java.util.LinkedList;
import java.util.Arrays;

public class Exercise_129 {

    private static class DataInfo {
        public boolean found;
        public int val;

        public DataInfo(boolean found, int val) {
            this.found = found;
            this.val = val;
        }
    }

    private static DataInfo getSingleNumber(int[] mainData) {

        boolean foundDouble = false;
        List<Integer> tempList = new LinkedList<>();
        DataInfo infoData = new DataInfo(false, Integer.MAX_VALUE);

        for (int i = 0; i < mainData.length; i++) {
            if (tempList.contains(mainData[i]))
                continue;
            for (int j = i + 1; j < mainData.length; j++) {
                if (mainData[i] == mainData[j]) {
                    foundDouble = true;
                    tempList.add(mainData[i]);
                    break;
                }
            }
            if (!foundDouble || (i == mainData.length - 1 && !tempList.contains(mainData[i]))) {
                infoData.found = true;
                infoData.val = mainData[i];
                break;
            }
        }
        return infoData;
    }

    public static void main(String[] args) {

        int[] tempData = { 10, 20, 10, 20, 30, 40, 40, 30, 50 };

        System.out.printf("Main array data: %s\n", Arrays.toString(tempData));
        DataInfo dataInfo = getSingleNumber(tempData);

        System.out.printf("Number appearing only once: %s\n", (dataInfo.found ? dataInfo.val : "[NONE]"));
    }
}
