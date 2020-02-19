package com.nal.leetcode;

/**
 * Created by nishant on 02/02/20.
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
