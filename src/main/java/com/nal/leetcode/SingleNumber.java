package com.nal.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by nishant on 06/02/20.
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
