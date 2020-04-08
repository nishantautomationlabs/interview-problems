package com.nal.leetcode.string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by nishant on 19/03/20.
 * 859. Buddy Strings
 * Given two strings A and B of lowercase letters, return true if and only if we can swap two letters in A so that the result equals B.
 * Example 1:
 * Input: A = "ab", B = "ba"
 * Output: true
 */
public class BuddyStrings {
    public boolean buddyStrings(String A, String B) {
        if (A == null || B == null || A.length() != B.length())
            return false;

        if (A.equals(B)) {
            HashSet<Character> unique_chars = new HashSet<>();
            for (char c : A.toCharArray()) {
                unique_chars.add(c);
            }
            return unique_chars.size() < A.length();
        }

        List<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) != B.charAt(i)) {
                indexes.add(i);
            }
        }

        if (indexes.size() == 2 &&
                A.charAt(indexes.get(0)) == B.charAt(indexes.get(1)) &&
                A.charAt(indexes.get(1)) == B.charAt(indexes.get(0)))
            return true;
        return false;
    }
}
