package com.nal.leetcode.arrays;

/**
 * Created by nishant on 05/02/20.
 * 42. Trapping Rain Water
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
 * Input: [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 */
public class TrappingRainWater {
    public int trap(int[] height) {
        if (height == null || height.length <= 1)
            return 0;
        int left = 0, right = height.length - 1, level = 0, result = 0;

        while (left < right) {
            int lower = height[left] < height[right] ? height[left++] : height[right--];
            level = Math.max(level, lower);
            result += (level - lower);
        }
        return result;
    }
}
