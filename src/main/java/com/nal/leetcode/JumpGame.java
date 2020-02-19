package com.nal.leetcode;

/**
 * Created by nishant on 03/02/20.
 */
public class JumpGame {

    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0)
            return false;

        int maxJump = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxJump || maxJump >= nums.length - 1)
                break;
            maxJump = Math.max(maxJump, i + nums[i]);
        }
        return maxJump >= nums.length - 1;
    }
}
