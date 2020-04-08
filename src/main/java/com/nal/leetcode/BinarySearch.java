package com.nal.leetcode;

/**
 * Created by nishant on 02/02/20.
 */
public class BinarySearch {

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;

        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target)
                return mid;
            else if (target < nums[mid])
                right = mid - 1;
            else
                left = mid + 1;
        }
        return -1;
    }
}
