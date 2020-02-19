package com.nal.leetcode;

/**
 * Created by nishant on 05/02/20.
 */
public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        if (height == null || height.length <= 1)
            return 0;

        int left = 0, right = height.length - 1, result = 0;
        while (left < right) {
            int lower = Math.min(height[left], height[right]);
            result = Math.max(result, lower * (right - left));
            if (height[left] < height[right])
                left++;
            else
                right--;
        }
        return result;
    }
}
