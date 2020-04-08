package com.nal.leetcode.string;

/**
 * Created by nishant on 26/03/20.
 * 434. Number of Segments in a String
 * Count the number of segments in a string, where a segment is defined to be a contiguous sequence of non-space characters.
 * Please note that the string does not contain any non-printable characters.
 * Example:
 * Input: "Hello, my name is John"
 * Output: 5
 */
public class NumberOfSegmentsInAString {
    public int countSegments(String s) {
        if(s == null || s.length() == 0)
            return 0;

        int segment = 0;
        for(int i = 0; i < s.length(); i++) {
            if((i == 0 || s.charAt(i - 1) == ' ') && s.charAt(i) != ' ') {
                segment++;
            }
        }
        return segment;
    }
}
