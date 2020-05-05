package com.nal.leetcode.numbers;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by nishant on 06/02/20.
 * 136. Single Number
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * Example 1:
 * Input: [2,2,1]
 * Output: 1
 * Example 2:
 * Input: [4,1,2,1,2]
 * Output: 4
 */
public class SingleNumber {

    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0)
            return -1;
        if (nums.length == 1)
            return nums[0];

        Set<Integer> set = new HashSet<Integer>();
        for (int num : nums) {
            if (!set.add(num))
                set.remove(num);
        }
        return set.isEmpty() || set.size() > 1 ? -1 : set.iterator().next();
    }

    public int singleNumber2(int[] nums) {
        if (nums == null || nums.length == 0)
            return -1;
        if (nums.length == 1)
            return nums[0];
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }
}
