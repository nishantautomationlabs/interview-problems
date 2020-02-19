package com.nal.leetcode.numbers;

/**
 * Created by nishant on 09/02/20.
 * 231. Power of Two
 * Given an integer, write a function to determine if it is a power of two.
 * Example 1:
 * Input: 1
 * Output: true
 * Explanation: 20 = 1
 */
public class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        int count = 0;
        while (n > 0) {
            count += n & 1;
            n = n >>> 1;
        }
        return count == 1;
    }

    public boolean isPowerOfTwo2(int n) {

        return (n > 0) && (n & (n - 1)) == 0;
    }
}
