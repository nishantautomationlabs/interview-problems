package com.nal.leetcode.arrays;

import java.util.HashMap;

/**
 * Created by nishant on 06/04/20.
 * 518. Coin Change 2
 * You are given coins of different denominations and a total amount of money. Write a function to compute the number of combinations that make up that amount. You may assume that you have infinite number of each kind of coin.
 * Example 1:
 * Input: amount = 5, coins = [1, 2, 5]
 * Output: 4
 * Explanation: there are four ways to make up the amount:
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 */
public class CoinChange2 {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = 1; i <= amount; i++) {
                if (i >= coin) {
                    dp[i] += dp[i - coin];
                }
            }
        }
        return dp[amount];
    }

    public int change2(int amount, int[] coins) {
        if(amount == 0)
            return 1;
        if(coins.length == 0)
            return 0;

        HashMap<String, Integer> memo = new HashMap<>();
        return findWays(amount, coins, 0, memo);
    }

    private int findWays(int amount, int[] coins, int index, HashMap<String, Integer> memo) {
        if(amount == 0)
            return 1;
        if(index >= coins.length)
            return 0;

        String key = amount + "_" + index;
        if(memo.containsKey(key))
            return memo.get(key);
        int ways = 0;
        int amountWithCoins = 0;
        while(amountWithCoins <= amount) {
            int remaining = amount - amountWithCoins;
            ways += findWays(remaining, coins, index + 1, memo);
            amountWithCoins += coins[index];
        }
        memo.put(key, ways);
        return ways;
    }
}
