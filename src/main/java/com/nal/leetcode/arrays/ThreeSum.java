package com.nal.leetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * Created by nishant on 30/01/20.
 * 15. 3Sum
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * The solution set must not contain duplicate triplets.
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 * A solution set is:
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length < 3)
            return result;
        Arrays.sort(nums);

        for(int i = 0; i < nums.length - 2; i++)
        {
            int left = i+1;
            int right = nums.length-1;
            while(left < right)
            {
                if(nums[i] + nums[left] + nums[right] == 0)
                {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    int leftValue = nums[left];
                    int rightValue = nums[right];
                    while(left < nums.length && nums[left] == leftValue)
                        left++;
                    while(right > left && nums[right] == rightValue)
                        right--;
                }
                else if(nums[i] + nums[left] + nums[right] < 0)
                    left++;
                else if(nums[i] + nums[left] + nums[right] > 0)
                    right--;
            }
            while(i + 1 < nums.length && nums[i+1] == nums[i])
                i++;
        }
        return result;
    }
}
