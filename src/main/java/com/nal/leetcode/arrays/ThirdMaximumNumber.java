package com.nal.leetcode.arrays;

/**
 * Created by nishant on 26/03/20.
 * 414. Third Maximum Number
 * Given a non-empty array of integers, return the third maximum number in this array. If it does not exist, return the maximum number. The time complexity must be in O(n).
 * Example 1:
 * Input: [3, 2, 1]
 * Output: 1
 * Explanation: The third maximum is 1.
 */
public class ThirdMaximumNumber {
    public int thirdMax(int[] nums) {
        if (nums == null || nums.length == 0)
            return -1;

        Integer max = null;
        Integer secondMax = null;
        Integer thirdMax = null;

        for (Integer val : nums) {
            if (val.equals(max) || val.equals(secondMax) || val.equals(thirdMax))
                continue;
            if (max == null || val > max) {
                thirdMax = secondMax;
                secondMax = max;
                max = val;
            } else if (secondMax == null || val > secondMax) {
                thirdMax = secondMax;
                secondMax = val;
            } else if (thirdMax == null || val > thirdMax) {
                thirdMax = val;
            }
        }
        return thirdMax == null ? max : thirdMax;
    }
}
