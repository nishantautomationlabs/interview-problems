package com.nal.leetcode.string;

/**
 * Created by nishant on 07/04/20.
 * Given a string s, find the longest palindromic subsequence's length in s. You may assume that the maximum length of s is 1000.
 * Example 1:
 * Input:
 * "bbbab"
 * Output:
 * 4
 * One possible longest palindromic subsequence is "bbbb".
 */
public class LongestPalindromicSubsequence {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] palindrome = new int[n][n];

        for (int i = 0; i < n; i++) {
            palindrome[i][i] = 1;
        }

//        Finding palindrome of length 2 to n and saving the result in matrix
        for (int currLen = 2; currLen <= n; currLen++) {
            for (int startIndex = 0; startIndex + currLen <= n; startIndex++) {
                int endIndex = startIndex + currLen - 1;
                if (s.charAt(startIndex) == s.charAt(endIndex)) {
                    palindrome[startIndex][endIndex] = palindrome[startIndex + 1][endIndex - 1] + 2;
                } else {
                    palindrome[startIndex][endIndex] = Math.max(palindrome[startIndex + 1][endIndex],
                            palindrome[startIndex][endIndex - 1]);
                }
            }
        }

        return palindrome[0][n - 1];
    }
}
