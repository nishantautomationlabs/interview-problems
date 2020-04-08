package com.nal.leetcode;

import java.util.BitSet;

/**
 * Created by nishant on 02/02/20.
 * 916. Palindrome Permutation
 * Given a String determine if a permutation of the string could form a palindrome
 * aab --> true
 * abc --> false
 */
public class PalindromePermutation {

    public static void main(String[] args) {
        String input = "aabcc";
        boolean result = canPermutePalindrome(input);
        System.out.println(result);
    }

    private static boolean canPermutePalindrome(String s) {
        if (s == null)
            return false;
        BitSet bitSet = new BitSet(256);
        for (char c : s.toCharArray()) {
            bitSet.flip(c);
        }
        return bitSet.cardinality() <= 1;
    }
}
