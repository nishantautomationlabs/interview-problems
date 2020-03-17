package com.nal.leetcode.arrays;

/**
 * Created by nishant on 14/03/20.
 * 209. Minimum Size Subarray Sum
 * Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.
 * Example:
 * Input: s = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: the subarray [4,3] has the minimal length under the problem constraint.
 */
public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums == null || nums.length == 0 || s == 0)
            return 0;

        int left = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;
        for(int right = 0; right < nums.length; right++) {
            sum +=nums[right];
            while(sum >= s) {
                minLen = Math.min(minLen, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
