package com.nal.leetcode.arrays;

/**
 * Created by nishant on 14/03/20.
 * 905. Sort Array By Parity
 * Given an array A of non-negative integers, return an array consisting of all the even elements of A, followed by all the odd elements of A.
 * You may return any answer array that satisfies this condition.
 * Example 1:
 * Input: [3,1,2,4]
 * Output: [2,4,3,1]
 * The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
 */
public class SortArrayByParity {

    public int[] sortArrayByParity(int[] A) {
        if (A == null || A.length <= 1)
            return A;

        int left = 0;
        int right = A.length - 1;

        while (left < right) {
            while (left < A.length && A[left] % 2 == 0) {
                left++;
            }
            while (right > 0 && A[right] % 2 == 1) {
                right--;
            }
            if (left < right) {
                int temp = A[left];
                A[left] = A[right];
                A[right] = temp;
            }
        }
        return A;
    }
}
