package com.nal.leetcode.string;

import java.util.Stack;

/**
 * Created by nishant on 29/03/20.
 * 856. Score of Parentheses
 * Given a balanced parentheses string S, compute the score of the string based on the following rule:
 * <p>
 * () has score 1
 * AB has score A + B, where A and B are balanced parentheses strings.
 * (A) has score 2 * A, where A is a balanced parentheses string.
 * Example 1:
 * Input: "(()(()))"
 * Output: 6
 */
public class ScoreOfParentheses {
    public int scoreOfParentheses(String S) {
        if (S == null || S.length() == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int score = 0;
        for (char c : S.toCharArray()) {
            if (c == '(') {
                stack.push(score);
                score = 0;
            } else {
                score = stack.pop() + Math.max(1, score * 2);
            }
        }
        return score;
    }
}
