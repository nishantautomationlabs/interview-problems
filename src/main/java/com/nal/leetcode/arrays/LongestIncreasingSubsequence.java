package com.nal.leetcode.arrays;

import java.util.Arrays;

/**
 * Created by nishant on 11/02/20.
 * 300. Longest Increasing Subsequence
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 * Example:
 * Input: [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 */
public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
        int res = lis.lengthOfLIS2(new int[]{10,9,2,5,3,7,101,18});
        System.out.println(res);
    }

    public int lengthOfLIS2(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int[] dp = new int[nums.length];
        int len = 0;
        for(int num : nums)
        {
            int index = Arrays.binarySearch(dp, 0, len, num);
            if(index < 0)
                index = -(index + 1);
            dp[index] = num;
            if(index == len)
                len++;
        }
        return len;
    }

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int[] dp = new int[nums.length];
        int res = 1;
        Arrays.fill(dp, 1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i])
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
