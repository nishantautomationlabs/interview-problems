package com.nal.leetcode.arrays;

/**
 * Created by nishant on 10/02/20.
 * 198. House Robber
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
 * Input: [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 * Total amount you can rob = 1 + 3 = 4.
 */
public class HouseRobber {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int evenMax = 0, oddMax = 0;
        for (int i = 1; i <= nums.length; i++) {
            if (i % 2 == 0)
                evenMax = Math.max(evenMax + nums[i - 1], oddMax);
            else
                oddMax = Math.max(oddMax + nums[i - 1], evenMax);
        }
        return Math.max(evenMax, oddMax);
    }
}
