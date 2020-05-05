package com.nal.leetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by nishant on 03/02/20.
 * 47. Permutations II
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 * Example:
 * Input: [1,1,2]
 * Output:
 * [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 * ]
 */
public class PermutationsII {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return result;

        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        List<Integer> permutation = new ArrayList<>();
        permute(nums, used, permutation, result);
        return result;

    }

    private void permute(int[] nums, boolean[] used, List<Integer> permutation, List<List<Integer>> result) {
        if (permutation.size() == nums.length) {
            result.add(new ArrayList<>(permutation));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                permutation.add(nums[i]);
                permute(nums, used, permutation, result);
                permutation.remove(permutation.size() - 1);
                used[i] = false;
                while (i + 1 < nums.length && nums[i] == nums[i + 1])
                    i++;
            }
        }
    }
}
