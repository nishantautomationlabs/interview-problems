package com.nal.leetcode.arrays;

import java.util.Arrays;

/**
 * Created by nishant on 22/03/20.
 * 455. Assign Cookies
 * Assume you are an awesome parent and want to give your children some cookies. But, you should give each child at most one cookie. Each child i has a greed factor gi, which is the minimum size of a cookie that the child will be content with; and each cookie j has a size sj. If sj >= gi, we can assign the cookie j to the child i, and the child i will be content. Your goal is to maximize the number of your content children and output the maximum number.
 * Note:
 * You may assume the greed factor is always positive.
 * You cannot assign more than one cookie to one child.
 * Example 1:
 * Input: [1,2,3], [1,1]
 * Output: 1
 */
public class AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        if (g == null || g.length == 0)
            return 0;

        Arrays.sort(g);
        Arrays.sort(s);
        int result = 0;
        int gIndex = 0;
        for (int i = 0; i < s.length; i++) {
            if (gIndex < g.length && g[gIndex] <= s[i]) {
                gIndex++;
            }
        }
        return gIndex;
    }
}
