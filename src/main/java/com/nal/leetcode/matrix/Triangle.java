package com.nal.leetcode.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nishant on 11/02/20.
 * 120. Triangle
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
 * For example, given the following triangle
 * [
 * [2],
 * [3,4],
 * [6,5,7],
 * [4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 */
public class Triangle {
    public int minimumTotal2(List<List<Integer>> triangle) {
        if(triangle.size() == 0)
            return 0;

        List<Integer> dp = new ArrayList<>(triangle.get(triangle.size()-1));
        for(int i = triangle.size() - 2; i >= 0 ; i--)
        {
            for(int j = 0; j <= i; j++)
            {
                dp.set(j, Math.min(dp.get(j), dp.get(j + 1)) + triangle.get(i).get(j));
            }
        }
        return dp.get(0);
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0)
            return 0;

        int rows = triangle.size();
        int lastRowCols = triangle.get(rows - 1).size();
        int[] dp = new int[lastRowCols];
        for (int i = 0; i < lastRowCols; i++) {
            dp[i] = triangle.get(rows - 1).get(i);
        }
        for (int i = triangle.get(rows - 1).size() - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = Math.min(dp[j] + triangle.get(i).get(j), dp[j + 1] + triangle.get(i).get(j));
            }
        }
        return dp[0];
    }
}
