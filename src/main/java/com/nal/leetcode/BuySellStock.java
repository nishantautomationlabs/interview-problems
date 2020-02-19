package com.nal.leetcode;

/**
 * Created by nishant on 04/02/20.
 */
public class BuySellStock {
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
