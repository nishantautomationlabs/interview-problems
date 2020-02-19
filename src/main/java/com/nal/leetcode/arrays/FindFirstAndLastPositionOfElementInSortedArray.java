package com.nal.leetcode.arrays;

/**
 * Created by nishant on 11/02/20.
 * 34. Find First and Last Position of Element in Sorted Array
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * If the target is not found in the array, return [-1, -1].
 * Example 1:
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 */
public class FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        if (nums == null || nums.length == 0)
            return result;

        int first = searchNum(nums, target, true);
        if (first == -1)
            return result;
        int last = searchNum(nums, target, false);
        result[0] = first;
        result[1] = last;
        return result;
    }

    private int searchNum(int[] nums, int target, boolean first) {
        int start = 0, end = nums.length - 1;
        int res = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                res = mid;
                if (first)
                    end = mid - 1;
                else
                    start = mid + 1;
            } else if (nums[mid] < target)
                start = mid + 1;
            else
                end = mid - 1;
        }
        return res;
    }
}
