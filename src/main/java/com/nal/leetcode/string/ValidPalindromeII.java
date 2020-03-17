package com.nal.leetcode.string;

/**
 * Created by nishant on 14/03/20.
 * 680. Valid Palindrome II
 * Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.
 * Example 1:
 * Input: "aba"
 * Output: True
 * Example 2:
 * Input: "abca"
 * Output: True
 * Explanation: You could delete the character 'c'.
 */
public class ValidPalindromeII {
    public boolean validPalindrome(String s) {
        if (s == null || s.length() <= 1)
            return true;

        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return isValidPalindrome(s.substring(left, right)) ||
                        isValidPalindrome(s.substring(left + 1, right + 1));
            }
            left++;
            right--;
        }
        return true;
    }

    private boolean isValidPalindrome(String input) {
        int left = 0;
        int right = input.length() - 1;
        while (left < right) {
            if (input.charAt(left++) != input.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}
