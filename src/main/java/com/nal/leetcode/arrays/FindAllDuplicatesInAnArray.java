package com.nal.leetcode.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nishant on 27/03/20.
 * 442. Find All Duplicates in an Array
 * Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 * Find all the elements that appear twice in this array.
 * Could you do it without extra space and in O(n) runtime?
 * Example:
 * Input:
 * [4,3,2,7,8,2,3,1]
 * Output:
 * [2,3]
 */
public class FindAllDuplicatesInAnArray {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            return result;
        }

        for (int val : nums) {
            val = Math.abs(val);
            if (nums[val - 1] < 0) {
                result.add(val);
            }
            nums[val - 1] = -nums[val - 1];
        }
        return result;
    }
}
