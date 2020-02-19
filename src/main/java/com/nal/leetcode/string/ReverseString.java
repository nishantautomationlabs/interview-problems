package com.nal.leetcode.string;

/**
 * Created by nishant on 09/02/20.
 * 344. Reverse String
 * Write a function that reverses a string. The input string is given as an array of characters char[].
 */
public class ReverseString {
    public void reverseString(char[] s) {
        if (s == null || s.length == 0)
            return;

        int left = 0, right = s.length - 1;
        while (left < right) {
            char temp = s[right];
            s[right--] = s[left];
            s[left++] = temp;
        }
    }
}
