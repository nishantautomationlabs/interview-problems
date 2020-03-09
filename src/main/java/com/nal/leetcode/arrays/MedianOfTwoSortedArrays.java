package com.nal.leetcode.arrays;

/**
 * Created by nishant on 29/02/20.
 * 4. Median of Two Sorted Arrays
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * You may assume nums1 and nums2 cannot be both empty.
 * Example 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 * The median is 2.0
 */
public class MedianOfTwoSortedArrays {

    public static void main(String[] args) {
        MedianOfTwoSortedArrays median = new MedianOfTwoSortedArrays();
        System.out.println(median.findMedianSortedArrays(new int[]{1, 2}, new int[]{4, 5, 6, 7, 8, 9}));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null)
            return -1;

        int l1 = nums1.length;
        int l2 = nums2.length;

        if (l1 > l2) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int left = 0;
        int right = l1;
        while (left <= right) {
            int midX = left + (right - left) / 2;
            int midY = (l1 + l2 + 1) / 2 - midX;
            int maxLeftX = midX == 0 ? Integer.MIN_VALUE : nums1[midX - 1];
            int minRightX = midX == l1 ? Integer.MAX_VALUE : nums1[midX];
            int maxLeftY = midY == 0 ? Integer.MIN_VALUE : nums2[midY - 1];
            int minRightY = midY == l2 ? Integer.MAX_VALUE : nums2[midY];

            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                if ((l1 + l2) % 2 == 1) {
                    return Math.max(maxLeftX, maxLeftY);
                } else
                    return (double) (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2;
            } else if (maxLeftX > minRightY) {
                right = midX - 1;
            } else
                left = midX + 1;
        }
        return -1;
    }
}
