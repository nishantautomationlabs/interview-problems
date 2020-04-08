package com.nal.leetcode.string;

/**
 * Created by nishant on 29/03/20.
 * 459. Repeated Substring Pattern
 * Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of the substring together. You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.
 * Example 1:
 * Input: "abab"
 * Output: True
 */
public class RepeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String s) {
        if (s == null || s.length() == 0)
            return false;

        for (int i = s.length() / 2; i > 0; i--) {
            if (s.length() % i == 0) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < s.length() / i; j++) {
                    sb.append(s.substring(0, i));
                }
                if (sb.toString().equals(s)) {
                    return true;
                }
            }
        }
        return false;
    }
}
