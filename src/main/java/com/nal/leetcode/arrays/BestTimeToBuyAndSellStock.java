package com.nal.leetcode.arrays;

/**
 * Created by nishant on 04/02/20.
 * 121. Best Time to Buy and Sell Stock
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 * Note that you cannot sell a stock before you buy one.
 * Example 1:
 * Input: [7,1,5,3,6,4]
 * Output: 5
 */
public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length <= 1)
            return 0;

        int smallest = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int i = 0; i < prices.length; i++)
        {
            if(prices[i] < smallest)
                smallest = prices[i];
            maxProfit = Math.max(maxProfit, prices[i] - smallest);
        }
        return maxProfit;
    }
}
