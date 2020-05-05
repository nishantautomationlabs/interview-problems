package com.nal.leetcode.arrays;

/**
 * Created by nishant on 01/02/20.
 * 283. Move Zeroes
 * of it while maintaining the relative order of the non-zero elements.
 * Example:
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 */
public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length <= 1)
            return;

        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != 0) {
                nums[i++] = nums[j];
            }
        }
        for (int k = i; k < nums.length; k++) {
            nums[k] = 0;
        }
    }
}
