package com.nal.leetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by nishant on 31/01/20.
 * 18. 4Sum
 * Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
 * Note:
 * The solution set must not contain duplicate quadruplets.
 * Example:
 * Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
 * A solution set is:
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 */
public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();

        if (nums == null || nums.length < 4)
            return result;

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        List<Integer> sol = new ArrayList<>();
                        sol.add(nums[i]);
                        sol.add(nums[j]);
                        sol.add(nums[left]);
                        sol.add(nums[right]);
                        result.add(sol);

                        int leftValue = nums[left];
                        int rightValue = nums[right];
                        while (left < nums.length - 1 && nums[left] == leftValue)
                            left++;
                        while (right > left && nums[right] == rightValue)
                            right--;
                    } else if (sum < target)
                        left++;
                    else
                        right--;
                }
                while (j + 1 < nums.length - 1 && nums[j] == nums[j + 1])
                    j++;
            }
            while (i + 1 < nums.length - 1 && nums[i] == nums[i + 1])
                i++;
        }
        return result;
    }
}
