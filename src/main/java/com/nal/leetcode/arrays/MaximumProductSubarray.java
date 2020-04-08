package com.nal.leetcode.arrays;

/**
 * Created by nishant on 19/03/20.
 * 152. Maximum Product Subarray
 * Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.
 * Example 1:
 * Input: [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 */
public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int result = nums[0];
        int maxVal = nums[0];
        int minVal = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int tempPrevMaxVal = maxVal;
            maxVal = Math.max(nums[i], Math.max(nums[i] * maxVal, nums[i] * minVal));
            minVal = Math.min(nums[i], Math.min(nums[i] * tempPrevMaxVal, nums[i] * minVal));
            result = Math.max(result, maxVal);
        }
        return result;
    }
}
