package com.nal.leetcode.string;

/**
 * Created by nishant on 20/03/20.
 * 925. Long Pressed Name
 * Your friend is typing his name into a keyboard.  Sometimes, when typing a character c, the key might get long pressed, and the character will be typed 1 or more times.
 * You examine the typed characters of the keyboard.  Return True if it is possible that it was your friends name, with some characters (possibly none) being long pressed.
 * Example 1:
 * Input: name = "alex", typed = "aaleex"
 * Output: true
 */
public class LongPressedName {
    public boolean isLongPressedName(String name, String typed) {
        if (name == null || typed == null || typed.length() < name.length())
            return false;

        int j = 0;
        for (int i = 0; i < typed.length(); i++) {
            if (j < name.length() && typed.charAt(i) == name.charAt(j)) {
                j++;
            } else if (i == 0 || typed.charAt(i) != typed.charAt(i - 1)) {
                return false;
            }
        }
        return j == name.length();
    }
}
