package com.nal.leetcode.string;

/**
 * Created by nishant on 29/03/20.
 * 5. Longest Palindromic Substring
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * Example 1:
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0)
            return s;

        int maxLength = 1;
        int index = 0;
        for (int i = 1; i < s.length(); i++) {
            int l1 = findPalindrome(s, i, i);
            int l2 = findPalindrome(s, i, i - 1);
            int max = Math.max(l1, l2);
            if (max > maxLength) {
                maxLength = max;
                index = i;
            }
        }
        return s.substring(index - (maxLength) / 2, index + (maxLength - 1) / 2 + 1);
    }

    private int findPalindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
