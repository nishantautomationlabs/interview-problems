package com.nal.leetcode;

/**
 * Created by nishant on 03/02/20.
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
