package com.nal.leetcode;

/**
 * Created by nishant on 03/02/20.
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
