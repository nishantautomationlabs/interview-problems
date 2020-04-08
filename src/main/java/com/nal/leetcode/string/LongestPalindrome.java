package com.nal.leetcode.string;

/**
 * Created by nishant on 21/03/20.
 * 409. Longest Palindrome
 * Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.
 * This is case sensitive, for example "Aa" is not considered a palindrome here.
 * Note:
 * Assume the length of given string will not exceed 1,010.
 * Example:
 * Input:
 * "abccccdd"
 * Output:
 * 7
 */
public class LongestPalindrome {
    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int[] freq = new int[128];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i)]++;
        }
        int result = 0;
        for (int val : freq) {
            result += (val / 2) * 2;
            if (result % 2 == 0 && val % 2 == 1) {
                result += 1;
            }
        }
        return result;
    }
}
