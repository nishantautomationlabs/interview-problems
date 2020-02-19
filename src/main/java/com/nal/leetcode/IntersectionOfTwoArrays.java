package com.nal.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by nishant on 07/02/20.
 */
public class IntersectionOfTwoArrays {

    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null)
            return null;

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int num : nums1)
            set1.add(num);
        for (int num : nums2)
            if (set1.contains(num))
                set2.add(num);

        int[] result = new int[set2.size()];
        int i = 0;
        for (int val : set2)
            result[i++] = val;
        return result;
    }
}
