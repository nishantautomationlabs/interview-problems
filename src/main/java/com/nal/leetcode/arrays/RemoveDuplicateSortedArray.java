package com.nal.leetcode.arrays;

/**
 * Created by nishant on 03/02/20.
 * 26. Remove Duplicates from Sorted Array
 * Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * Example 1:
 * Given nums = [1,1,2],
 * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
 */
public class RemoveDuplicateSortedArray {
    public int removeDuplicates(int[] nums) {
        if (nums == null)
            return -1;
        if (nums.length < 2)
            return nums.length;

        int left = 0;
        for (int right = 1; right < nums.length; right++) {
            if (nums[right] != nums[left])
                nums[++left] = nums[right];
        }
        return left + 1;
    }
}
