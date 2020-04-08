package com.nal.leetcode.arrays;

/**
 * Created by nishant on 29/03/20.
 * 581. Shortest Unsorted Continuous Subarray
 * Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order, too.
 * You need to find the shortest such subarray and output its length.
 * Example 1:
 * Input: [2, 6, 4, 8, 10, 9, 15]
 * Output: 5
 */
public class ShortestUnsortedContinuousSubarray {
    public int findUnsortedSubarray(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        boolean flag = false;
        for (int i = 1; i < nums.length; i++) {
            if (!flag && nums[i] < nums[i - 1]) {
                flag = true;
            }
            if (flag) {
                min = Math.min(min, nums[i]);
            }
        }
        flag = false;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (!flag && nums[i + 1] < nums[i]) {
                flag = true;
            }
            if (flag) {
                max = Math.max(max, nums[i]);
            }
        }
        int left = 0;
        for (left = 0; left < nums.length; left++) {
            if (nums[left] > min) {
                break;
            }
        }
        int right = nums.length - 1;
        for (right = nums.length - 1; right >= 0; right--) {
            if (nums[right] < max) {
                break;
            }
        }
        return right - left < 0 ? 0 : right - left + 1;
    }
}
