package com.nal.leetcode;

/**
 * Created by nishant on 06/02/20.
 */
public class MultiplyStrings {

    public String multiply(String num1, String num2) {
        if (num1 == null || num2 == null || num1.length() == 0 || num2.length() == 0)
            return "";

        int length = num1.length() + num2.length();
        int[] result = new int[length];

        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                int product = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int sum = result[i + j + 1] + product;
                result[i + j + 1] = sum % 10;
                result[i + j] += sum / 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int value : result) {
            if (sb.length() != 0 || value != 0)
                sb.append(value);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
