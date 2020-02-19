package com.nal.leetcode;

/**
 * Created by nishant on 01/02/20.
 */
public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        if(nums == null || nums.length <= 1)
            return;

        int i = 0;
        for(int j = 0; j < nums.length; j++)
        {
            if(nums[j] != 0)
            {
                nums[i++] = nums[j];
            }
        }
        for(int k = i; k < nums.length; k++)
        {
            nums[k] = 0;
        }
    }
}
