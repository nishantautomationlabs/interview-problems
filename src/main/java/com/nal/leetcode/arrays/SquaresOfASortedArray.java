package com.nal.leetcode.arrays;

/**
 * Created by nishant on 06/03/20.
 * 977. Squares of a Sorted Array
 * Given an array of integers A sorted in non-decreasing order, return an array of the squares of each number, also in sorted non-decreasing order.
 * Input: [-4,-1,0,3,10]
 * Output: [0,1,9,16,100]
 */
public class SquaresOfASortedArray {
    public int[] sortedSquares(int[] A) {

        if (A == null || A.length == 0)
            return A;

        int[] result = new int[A.length];

        int left = 0;
        int right = A.length - 1;
        int index = A.length - 1;
        while (left <= right) {
            if (A[left] * A[left] > A[right] * A[right]) {
                result[index] = A[left] * A[left];
                left++;
            } else {
                result[index] = A[right] * A[right];
                right--;
            }
            index--;
        }
        return result;
    }
}
