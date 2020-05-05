package com.nal.leetcode.string;

/**
 * Created by nishant on 02/02/20.
 * 205. Isomorphic Strings
 * Given two strings s and t, determine if they are isomorphic.
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.
 * Example 1:
 * Input: s = "egg", t = "add"
 * Output: true
 * Example 2:
 * Input: s = "foo", t = "bar"
 * Output: false
 */
public class IsomorphicString {

    public static void main(String[] args) {
        IsomorphicString string = new IsomorphicString();
        string.isIsomorphic("ab", "aa");
    }

    public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null || s.length() != t.length())
            return false;
        int[] l1 = new int[256];
        int[] l2 = new int[256];
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if (l1[c1] != l2[c2])
                return false;
            l1[c1] = i + 1;
            l2[c2] = i + 1;
        }
        return true;
    }


}
