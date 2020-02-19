package com.nal.leetcode;

/**
 * Created by nishant on 04/02/20.
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
