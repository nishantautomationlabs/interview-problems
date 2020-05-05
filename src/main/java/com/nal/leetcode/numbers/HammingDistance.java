package com.nal.leetcode.numbers;

/**
 * Created by nishant on 04/02/20.
 * 461. Hamming Distance
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 * Given two integers x and y, calculate the Hamming distance.
 * Note:
 * 0 ≤ x, y < 231.
 * Example:
 * Input: x = 1, y = 4
 * Output: 2
 */
public class HammingDistance {

    public int hammingDistance(int x, int y) {
        int result = 0;
        for (int i = 0; i < Integer.SIZE; i++) {
            result += ((x >> i) & 1) ^ ((y >> i) & 1);
        }
        return result;
    }
}
