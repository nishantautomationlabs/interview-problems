package com.nal.leetcode.arrays;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by nishant on 18/03/20.
 * 503. Next Greater Element II
 * Given a circular array (the next element of the last element is the first element of the array), print the Next Greater Number for every element. The Next Greater Number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, output -1 for this number.
 * Example 1:
 * Input: [1,2,1]
 * Output: [2,-1,2]
 */
public class NextGreaterElementII {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[nums.length];
        Arrays.fill(result, -1);
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < n * 2; i++) {
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i % n]) {
                result[stack.pop()] = nums[i % n];
            }

            if(i < n)
                stack.push(i);
        }
        return result;
    }
}
