package com.nal.leetcode.string;

/**
 * Created by nishant on 26/03/20.
 * 266. Palindrome Permutation
 * Given a string, determine if a permutation of the string could be a palindrome
 */
public class PalindromePermutation {

    public boolean canPermutePalindrome(String s) {
        if (s == null || s.length() == 0)
            return false;

        s = s.toLowerCase();
        int[] charFreq = new int[128];
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
