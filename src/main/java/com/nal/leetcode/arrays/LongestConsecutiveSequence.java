package com.nal.leetcode.arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by nishant on 11/02/20.
 * 128. Longest Consecutive Sequence
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 * Your algorithm should run in O(n) complexity.
 * Example:
 * Input: [100, 4, 200, 1, 3, 2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 */
public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums)
            set.add(num);

        int res = 0;
        while (!set.isEmpty()) {
            int value = set.iterator().next();
            set.remove(value);
            int lesser = value - 1;
            while (set.contains(lesser))
                set.remove(lesser--);
            int greater = value + 1;
            while (set.contains(greater))
                set.remove(greater++);

            res = Math.max(res, greater - lesser - 1);
        }
        return res;
    }
}
