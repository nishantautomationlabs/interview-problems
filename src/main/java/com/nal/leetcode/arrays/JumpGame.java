package com.nal.leetcode.arrays;

/**
 * Created by nishant on 03/02/20.
 * 55. Jump Game
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Determine if you are able to reach the last index.
 * Example 1:
 * Input: nums = [2,3,1,1,4]
 * Output: true
 */
public class JumpGame {

    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0)
            return false;

        int maxJump = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxJump || maxJump >= nums.length - 1)
                break   ;
            maxJump = Math.max(maxJump, i + nums[i]);
        }
        return maxJump >= nums.length - 1;
    }
}
