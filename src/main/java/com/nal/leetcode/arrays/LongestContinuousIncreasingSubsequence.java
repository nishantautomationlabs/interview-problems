package com.nal.leetcode.arrays;

/**
 * Created by nishant on 03/02/20.
 * 674. Longest Continuous Increasing Subsequence
 * Given an unsorted array of integers, find the length of longest continuous increasing subsequence (subarray).
 * Example 1:
 * Input: [1,3,5,4,7]
 * Output: 3
 */
public class LongestContinuousIncreasingSubsequence {

    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int count = 1;
        int maxLength = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                count++;
                maxLength = Math.max(maxLength, count);
            } else {
                count = 1;
            }
        }
        return maxLength;
    }
}
