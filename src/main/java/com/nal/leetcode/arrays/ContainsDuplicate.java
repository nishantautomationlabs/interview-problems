package com.nal.leetcode.arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by nishant on 16/02/20.
 * 217. Contains Duplicate
 * Given an array of integers, find if the array contains any duplicates.
 * Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
 * Example 1:
 * Input: [1,2,3,1]
 * Output: true
 */
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        Set<Integer> distinctValues = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (distinctValues.contains(nums[i])) {
                return true;
            }
            distinctValues.add(nums[i]);
        }
        return false;
    }
}
