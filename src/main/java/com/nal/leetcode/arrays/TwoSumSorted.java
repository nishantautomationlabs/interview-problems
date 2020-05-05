package com.nal.leetcode.arrays;

/**
 * Created by nishant on 30/01/20.
 *167. Two Sum II - Input array is sorted
 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.
 * Note:
 * Your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution and you may not use the same element twice.
 * Example:
 * Input: numbers = [2,7,11,15], target = 9
 * Output: [1,2]
 */
public class TwoSumSorted {
    public int[] twoSum(int[] numbers, int target) {
        if(numbers == null || numbers.length < 2)
            return null;

        int[] res = new int[2];
        res[0] = -1;
        res[1] = -1;
        int left = 0, right = numbers.length-1;
        while(left < right)
        {
            if(numbers[left] + numbers[right] == target)
            {
                res[0] = left + 1;
                res[1] = right + 1;
                return res;
            }
            if(numbers[left] + numbers[right] < target)
                left++;
            else if(numbers[left] + numbers[right] > target)
                right--;
        }
        return res;
    }
}
