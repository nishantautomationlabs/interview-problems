package com.nal.leetcode;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by nishant on 04/02/20.
 */
public class ReverseWordsInAString {

    public String reverseWords(String s) {
        s = s.trim();
        String[] words = s.split("\\s+");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }

    public String reverseWords2(String s) {
        s = s.trim();
        if (s == null || s.length() <= 1)
            return s;
        StringBuilder sb = new StringBuilder(s);
        reverseString(sb, 0, s.length() - 1);
        int start = 0;
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == ' ' || i == sb.length() - 1) {
                int end = i == sb.length() - 1 ? sb.length() - 1 : i - 1;
                reverseString(sb, start, end);
                i++;
                while (i < sb.length() && sb.charAt(i) == ' ') {
                    sb.deleteCharAt(i);
                }
                start = i;
            }
        }
        return sb.toString();
    }

    private void reverseString(StringBuilder sb, int left, int right) {
        while (left < right) {
            swapChar(sb, left++, right--);
        }
    }

    private void swapChar(StringBuilder sb, int l, int r) {
        char c = sb.charAt(l);
        sb.setCharAt(l, sb.charAt(r));
        sb.setCharAt(r, c);
    }
}
