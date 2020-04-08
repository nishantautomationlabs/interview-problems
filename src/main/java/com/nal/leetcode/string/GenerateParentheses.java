package com.nal.leetcode.string;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nishant on 29/03/20.
 * 22. Generate Parentheses
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * For example, given n = 3, a solution set is:
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if (n == 0)
            return result;

        StringBuilder sb = new StringBuilder();
        generate(n, 0, 0, result, sb);
        return result;
    }

    private void generate(int n, int open, int close, List<String> result, StringBuilder sb) {
        if (sb.length() == n * 2) {
            result.add(sb.toString());
        }
        if (open < n) {
            generate(n, open + 1, close, result, sb.append("("));
            sb.deleteCharAt(sb.length() - 1);
        }
        if (close < open) {
            generate(n, open, close + 1, result, sb.append(")"));
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
