package com.nal.leetcode.string;

/**
 * Created by nishant on 04/02/20.
 * 8. String to Integer (atoi)
 * Implement atoi which converts a string to an integer.
 * The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.
 * The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.
 * If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.
 * If no valid conversion could be performed, a zero value is returned.
 * Note:
 * Only the space character ' ' is considered as whitespace character.
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. If the numerical value is out of the range of representable values, INT_MAX (231 − 1) or INT_MIN (−231) is returned.
 * Example 1:
 * Input: "42"
 * Output: 42
 * Example 2:
 * Input: "   -42"
 * Output: -42
 */
public class StringToIntegerATOI {

    public int myAtoi(String str) {
        if (str == null || str.length() == 0)
            return 0;

        int sign = 1, i = 0, n = str.length();
        long result = 0;
        while (i < n && str.charAt(i) == ' ')
            i++;
        if (i < n && (str.charAt(i) == '-' || str.charAt(i) == '+'))
            sign = str.charAt(i++) == '-' ? -1 : 1;

        while (i < n && Character.isDigit(str.charAt(i))) {
            result = result * 10 + (str.charAt(i++) - '0');
            if (result * sign > Integer.MAX_VALUE || result * sign < Integer.MIN_VALUE)
                return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
        return (int) result * sign;
    }
}
