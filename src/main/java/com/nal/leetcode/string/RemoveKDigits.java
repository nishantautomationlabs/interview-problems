package com.nal.leetcode.string;

import java.util.Stack;

/**
 * Created by nishant on 14/03/20.
 * 402. Remove K Digits
 * Given a non-negative integer num represented as a string, remove k digits from the number so that the new number is the smallest possible.
 * Note:
 * The length of num is less than 10002 and will be ≥ k.
 * The given num does not contain any leading zero.
 * Example 1:
 * <p>
 * Input: num = "1432219", k = 3
 * Output: "1219"
 */
public class RemoveKDigits {

    public String removeKdigits(String num, int k) {
        if (num == null || num.length() == 0 || k == 0)
            return num;
        // all numbers can be removed
        if(num.length() == k)
            return "0";

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < num.length(); i++) {
            int val = num.charAt(i) - '0';
            while (k > 0 && !stack.isEmpty() && stack.peek() > val) {
                stack.pop();
                k--;
            }
            stack.push(val);
        }
        while (k > 0) {
            stack.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        //remove zeros
        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }
}
