package com.nal.leetcode.string;

import java.util.BitSet;

/**
 * Created by nishant on 26/03/20.
 * 266. Palindrome Permutation
 * 916. Palindrome Permutation - LintCode
 * Given a string, determine if a permutation of the string could be a palindrome
 */
public class PalindromePermutation {

    public boolean canPermutePalindrome2(String s) {
        if (s == null)
            return false;
        BitSet bitSet = new BitSet(256);
        for (char c : s.toCharArray()) {
            bitSet.flip(c);
        }
        return bitSet.cardinality() <= 1;
    }

    public boolean canPermutePalindrome(String s) {
        if (s == null || s.length() == 0)
            return false;

        s = s.toLowerCase();
        int[] charFreq = new int[256];
        for (char c : s.toCharArray()) {
            charFreq[c]++;
        }

        boolean oddEncountered = false;
        for (int val : charFreq) {
            if (val % 2 == 1) {
                if (!oddEncountered)
                    oddEncountered = true;
                else
                    return false;
            }
        }
        return true;
    }
}
