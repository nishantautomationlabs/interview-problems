package com.nal.leetcode.arrays;

/**
 * Created by nishant on 10/03/20.
 * 852. Peak Index in a Mountain Array
 * Let's call an array A a mountain if the following properties hold:
 * A.length >= 3
 * There exists some 0 < i < A.length - 1 such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
 * Given an array that is definitely a mountain, return any i such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1].
 * Example 1:
 * Input: [0,1,0]
 * Output: 1
 */
public class PeakIndexInAMountainArray {

    public int peakIndexInMountainArray(int[] A) {
        int left = 0;
        int right = A.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (A[mid] > A[mid - 1] && A[mid] > A[mid + 1])
                return mid;
            else if (A[mid] > A[mid - 1]) {
                left = mid + 1;
            } else
                right = mid - 1;
        }
        return left;
    }
}
