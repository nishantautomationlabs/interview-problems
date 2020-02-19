package com.nal.leetcode;

/**
 * Created by nishant on 04/02/20.
 */
public class StringToInteger {

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
