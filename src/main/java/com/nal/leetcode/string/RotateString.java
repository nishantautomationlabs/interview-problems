package com.nal.leetcode.string;

/**
 * Created by nishant on 15/03/20.
 * 796. Rotate String
 * We are given two strings, A and B.
 * A shift on A consists of taking string A and moving the leftmost character to the rightmost position. For example, if A = 'abcde', then it will be 'bcdea' after one shift on A. Return True if and only if A can become B after some number of shifts on A.
 * Example 1:
 * Input: A = 'abcde', B = 'cdeab'
 * Output: true
 */
public class RotateString {
    public boolean rotateString(String A, String B) {
        if(A == null || B == null || A.length() != B.length())
            return false;

        A = A + A;
        if(A.contains(B))
            return true;
        return false;
    }
}
