package com.nal.leetcode.arrays;

/**
 * Created by nishant on 21/03/20.
 * 724. Find Pivot Index
 * Given an array of integers nums, write a method that returns the "pivot" index of this array.
 * We define the pivot index as the index where the sum of the numbers to the left of the index is equal to the sum of the numbers to the right of the index.
 * If no such index exists, we should return -1. If there are multiple pivot indexes, you should return the left-most pivot index.
 * Example 1:
 * Input:
 * nums = [1, 7, 3, 6, 5, 6]
 * Output: 3
 */
public class FindPivotIndex {
    public int pivotIndex(int[] nums) {
        if (nums == null || nums.length == 0)
            return -1;

        int totalSum = 0;
        for (int i = 0; i < nums.length; i++) {
            totalSum += nums[i];
        }

        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (totalSum - leftSum - nums[i] == leftSum)
                return i;
            leftSum += nums[i];
        }
        return -1;
    }
}
