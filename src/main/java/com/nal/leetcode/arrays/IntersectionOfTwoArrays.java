package com.nal.leetcode.arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by nishant on 07/02/20.
 * 349. Intersection of Two Arrays
 * Given two arrays, write a function to compute their intersection.
 * Example 1:
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2]
 * Example 2:
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [9,4]
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
