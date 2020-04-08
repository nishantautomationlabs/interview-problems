package com.nal.leetcode.arrays;

/**
 * Created by nishant on 20/03/20.
 * On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).
 * Once you pay the cost, you can either climb one or two steps. You need to find minimum cost to reach the top of the floor, and you can either start from the step with index 0, or the step with index 1.
 * Example 1:
 * Input: cost = [10, 15, 20]
 * Output: 15
 */
public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        if (cost == null || cost.length == 0)
            return 0;
        int[] dp = new int[cost.length + 1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i < cost.length + 1; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[cost.length];
    }

    public int minCostClimbingStairs2(int[] cost) {
        if (cost == null || cost.length == 0)
            return 0;
        int step1 = 0;
        int step2 = 0;
        for (int i = 2; i < cost.length + 1; i++) {
            int currCost = Math.min(step2 + cost[i - 1], step1 + cost[i - 2]);
            step1 = step2;
            step2 = currCost;
        }
        return step2;
    }

    public int minCostClimbingStairs3(int[] cost) {
        if (cost == null || cost.length == 0)
            return 0;
        for (int i = 2; i < cost.length; i++) {
            cost[i] += Math.min(cost[i - 1], cost[i - 2]);
        }
        return Math.min(cost[cost.length - 1], cost[cost.length - 2]);
    }
}
