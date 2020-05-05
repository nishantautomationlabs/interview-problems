package com.nal.leetcode.arrays;

/**
 * Created by nishant on 31/01/20.
 * 821. Shortest Distance to a Character
 * Given a string S and a character C, return an array of integers representing the shortest distance from the character C in the string.
 * Example 1:
 * Input: S = "loveleetcode", C = 'e'
 * Output: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]
 *
 */
public class ShortestDistToAChar {

    public int[] shortestToChar(String S, char C) {
        int[] result = new int[S.length()];

        setDistInForwardTraversal(S, C, result);
        setDistInReverseTraversal(S, C, result);
        return result;
    }

    private void setDistInForwardTraversal(String S, char C, int[] result) {
        int dist = Integer.MAX_VALUE / 2;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == C)
                dist = 0;
            else
                dist++;

            result[i] = dist;
        }
    }

    private void setDistInReverseTraversal(String S, char C, int[] result) {
        int dist = Integer.MAX_VALUE / 2;
        for (int i = S.length() - 1; i >= 0; i--) {
            if (S.charAt(i) == C)
                dist = 0;
            else
                dist++;

            if (result[i] > dist)
                result[i] = dist;
        }
    }
}
