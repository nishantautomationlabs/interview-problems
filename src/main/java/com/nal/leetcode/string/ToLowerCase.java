package com.nal.leetcode.string;

/**
 * Created by nishant on 10/02/20.
 * 709. To Lower Case
 * Implement function ToLowerCase() that has a string parameter str, and returns the same string in lowercase.
 */
public class ToLowerCase {
    public String toLowerCase(String str) {
        if (str == null || str.length() == 0)
            return str;

        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (c >= 65 && c <= 90)
                c = (char) (c + 32);
            sb.append(c);
        }
        return sb.toString();
    }
}
