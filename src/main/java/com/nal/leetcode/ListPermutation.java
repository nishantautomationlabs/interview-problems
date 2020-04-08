package com.nal.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nishant on 02/02/20.
 */
public class ListPermutation {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        if (nums == null || nums.length == 0)
            return result;

        boolean[] used = new boolean[nums.length];
        List<Integer> permutation = new ArrayList<>();
        permute(nums, used, permutation, result);
        return result;
    }

    //O(N!)
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
            }
        }
    }
}
