package com.nal.leetcode.arrays;

/**
 * Created by nishant on 15/03/20.
 * 485. Max Consecutive Ones
 * Given a binary array, find the maximum number of consecutive 1s in this array.
 * Example 1:
 * Input: [1,1,0,1,1,1]
 * Output: 3
 */
public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int noOfZero = 0;
        int maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                noOfZero++;
                maxLen = Math.max(maxLen, noOfZero);
            } else {
                noOfZero = 0;
            }
        }
        return maxLen;
    }
}
