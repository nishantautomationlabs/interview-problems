package com.nal.leetcode.string;

/**
 * Created by nishant on 29/03/20.
 * 392. Is Subsequence
 * Given a string s and a string t, check if s is subsequence of t.
 * You may assume that there is only lower case English letters in both s and t. t is potentially a very long (length ~= 500,000) string, and s is a short string (<=100).
 * A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ace" is a subsequence of "abcde" while "aec" is not).
 * Example 1:
 * s = "abc", t = "ahbgdc"
 * Return true.
 */
public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        if (s == null || t == null)
            return false;

        int i = 0;
        for (int j = 0; j < t.length(); j++) {
            if (i < s.length() && s.charAt(i) == t.charAt(j)) {
                i++;
            }
        }
        return i == s.length();
    }
}
