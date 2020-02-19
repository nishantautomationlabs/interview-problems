package com.nal.leetcode;

/**
 * Created by nishant on 05/02/20.
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
