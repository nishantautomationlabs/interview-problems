package com.nal.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by nishant on 31/01/20.
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
