package com.nal.leetcode.arrays;

/**
 * Created by nishant on 03/02/20.
 * 80. Remove Duplicates from Sorted Array II
 * Given a sorted array nums, remove the duplicates in-place such that duplicates appeared at most twice and return the new length.
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * Example 1:
 * Given nums = [1,1,1,2,2,3],
 * Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.
 */
public class RemoveDuplicateSortedArrayII {
    public int removeDuplicates(int[] nums) {
        if (nums == null)
            return 0;
        if (nums.length <= 2)
            return nums.length;

        int left = 1;
        for (int right = 2; right < nums.length; right++) {
            if (nums[right] != nums[left - 1]) {
                nums[++left] = nums[right];
            }
        }
        return left + 1;
    }
}
