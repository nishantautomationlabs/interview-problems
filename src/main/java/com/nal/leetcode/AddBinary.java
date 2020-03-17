 package com.nal.leetcode;

/**
 * Created by nishant on 04/02/20.
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        if (a == null || b == null)
            return null;

        int m = a.length() - 1;
        int n = b.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (m >= 0 || n >= 0) {
            int val1 = m >= 0 ? a.charAt(m--) - '0' : 0;
            int val2 = n >= 0 ? b.charAt(n--) - '0' : 0;
            int sum = val1 + val2 + carry;
            carry = sum / 2;
            sb.insert(0, sum % 2);
        }
        if (carry != 0)
            sb.insert(0, carry);
        return sb.toString();
    }
}
