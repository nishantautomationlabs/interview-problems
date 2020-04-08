package com.nal.leetcode.string;

/**
 * Created by nishant on 29/03/20.
 * 1249. Minimum Remove to Make Valid Parentheses
 * Given a string s of '(' , ')' and lowercase English characters.
 * Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting parentheses string is valid and return any valid string.
 * Formally, a parentheses string is valid if and only if:
 * It is the empty string, contains only lowercase characters, or
 * It can be written as AB (A concatenated with B), where A and B are valid strings, or
 * It can be written as (A), where A is a valid string.
 * Example 1:
 * Input: s = "lee(t(c)o)de)"
 * Output: "lee(t(c)o)de"
 */
public class MinimumRemoveToMakeValidParentheses {
    public String minRemoveToMakeValid(String s) {
        if (s == null || s.length() == 0)
            return s;

        StringBuilder sb = new StringBuilder();
        int open = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                open++;
            } else if (c == ')') {
                if (open == 0) {
                    continue;
                }
                open--;
            }
            sb.append(c);
        }

        StringBuilder result = new StringBuilder();
        for (int i = sb.length() - 1; i >= 0; i--) {
            if (sb.charAt(i) == '(' && open > 0) {
                open--;
                continue;
            }
            result.insert(0, sb.charAt(i));
        }
        return result.toString();
    }
}
