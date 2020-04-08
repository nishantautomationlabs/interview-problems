package com.nal.leetcode.arrays;

import java.util.HashMap;

/**
 * Created by nishant on 27/03/20.
 * 525. Contiguous Array
 * Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.
 * Example 1:
 * Input: [0,1]
 * Output: 2
 */
public class ContiguousArray {
    public int findMaxLength(int[] nums) {
        if (nums == null || nums.length < 2)
            return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int result = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count--;
            } else if (nums[i] == 1) {
                count++;
            }
            if (map.containsKey(count)) {
                result = Math.max(result, i - map.get(count));
            } else {
                map.put(count, i);
            }
        }
        return result;
    }
}
