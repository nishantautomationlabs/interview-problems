package com.nal.leetcode.arrays;

import java.util.HashMap;

/**
 * Created by nishant on 28/03/20.
 * Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency of any one of its elements.
 * Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.
 * Example 1:
 * Input: [1, 2, 2, 3, 1]
 * Output: 2
 */
public class DegreeOfAnArray {
    public int findShortestSubArray(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        HashMap<Integer, Integer> countMap = new HashMap<>();
        HashMap<Integer, Integer> firstIndexMap = new HashMap<>();
        int maxCount = 0;
        int minLength = 0;
        for (int i = 0; i < nums.length; i++) {
            countMap.put(nums[i], countMap.getOrDefault(nums[i], 0) + 1);
            firstIndexMap.putIfAbsent(nums[i], i);
            if (countMap.get(nums[i]) > maxCount) {
                maxCount = countMap.get(nums[i]);
                minLength = i - firstIndexMap.get(nums[i]) + 1;
            } else if (countMap.get(nums[i]) == maxCount) {
                minLength = Math.min(minLength, i - firstIndexMap.get(nums[i]) + 1);
            }
        }
        return minLength;
    }
}
