package com.nal.leetcode.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nishant on 09/02/20.
 * 78. Subsets
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 * Note: The solution set must not contain duplicate subsets.
 * Example:
 * Input: nums = [1,2,3]
 * Output:
 * [
 * [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 */
public class Subsets {
    public List<List<Integer>> subsetsRecursive(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return result;

        helper(nums, 0, result, new ArrayList<>());
        return result;
    }

    private void helper(int[] nums, int index, List<List<Integer>> result, List<Integer> list) {
        result.add(new ArrayList<>(list));
        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            helper(nums, i + 1, result, list);
            list.remove(list.size() - 1);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        if (nums == null || nums.length == 0)
            return result;

        result.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            for (int j = result.size() - 1; j >= 0; j--) {
                result.add(new ArrayList<>(result.get(j)));
                result.get(result.size() - 1).add(nums[i]);
            }
        }
        return result;
    }
}
