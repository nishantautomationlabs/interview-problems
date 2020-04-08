package com.nal.leetcode.arrays;

import java.util.List;

/**
 * Created by nishant on 27/03/20.
 * 539. Minimum Time Difference
 * Given a list of 24-hour clock time points in "Hour:Minutes" format, find the minimum minutes difference between any two time points in the list.
 * Example 1:
 * Input: ["23:59","00:00"]
 * Output: 1
 */
public class MinimumTimeDifference {
    public int findMinDifference(List<String> timePoints) {
        boolean[] timeArr = new boolean[1440];
        for (String time : timePoints) {
            String[] arr = time.split(":");
            int index = Integer.parseInt(arr[0]) * 60 + Integer.parseInt(arr[1]);
            if (timeArr[index])
                return 0;
            timeArr[index] = true;
        }

        int minVal = 1440;
        int firstIndex = -1;
        int lastIndex = -1;
        for (int i = 0; i < timeArr.length; i++) {
            if (timeArr[i]) {
                if (firstIndex == -1) {
                    firstIndex = i;
                    lastIndex = i;
                } else {
                    minVal = Math.min(minVal, i - lastIndex);
                    minVal = Math.min(minVal, 1440 - i + lastIndex);
                    lastIndex = i;
                }
            }
        }
        minVal = Math.min(minVal, 1440 - lastIndex + firstIndex);
        return minVal;
    }
}
