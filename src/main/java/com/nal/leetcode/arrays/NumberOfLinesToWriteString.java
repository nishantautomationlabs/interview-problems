package com.nal.leetcode.arrays;

/**
 * Created by nishant on 21/03/20.
 * 806. Number of Lines To Write String
 * We are to write the letters of a given string S, from left to right into lines. Each line has maximum width 100 units, and if writing a letter would cause the width of the line to exceed 100 units, it is written on the next line. We are given an array widths, an array where widths[0] is the width of 'a', widths[1] is the width of 'b', ..., and widths[25] is the width of 'z'.
 * Now answer two questions: how many lines have at least one character from S, and what is the width used by the last such line? Return your answer as an integer list of length 2.
 * Example :
 * Input:
 * widths = [10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10]
 * S = "abcdefghijklmnopqrstuvwxyz"
 * Output: [3, 60]
 */
public class NumberOfLinesToWriteString {
    public int[] numberOfLines(int[] widths, String S) {
        int currChar = 0;
        int lines = 1;
        for (char c : S.toCharArray()) {
            if (currChar + widths[c - 'a'] > 100) {
                currChar = 0;
                lines++;
            }
            currChar += widths[c - 'a'];
        }
        return new int[]{lines, currChar};
    }
}
