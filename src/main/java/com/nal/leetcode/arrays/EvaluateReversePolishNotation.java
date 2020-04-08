package com.nal.leetcode.arrays;

import java.util.Stack;

/**
 * Created by nishant on 07/04/20.
 * 150. Evaluate Reverse Polish Notation
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 * Note:
 * Division between two integers should truncate toward zero.
 * The given RPN expression is always valid. That means the expression would always evaluate to a result and there won't be any divide by zero operation.
 * Example 1:
 * Input: ["2", "1", "+", "3", "*"]
 * Output: 9
 * Explanation: ((2 + 1) * 3) = 9
 */
public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0)
            return 0;

        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if ("+-*/".contains(token)) {
                int v2 = stack.pop();
                int v1 = stack.pop();
                int result = 0;
                switch (token) {
                    case "+":
                        result = v1 + v2;
                        break;
                    case "-":
                        result = v1 - v2;
                        break;
                    case "*":
                        result = v1 * v2;
                        break;
                    case "/":
                        result = v1 / v2;
                        break;
                }
                stack.push(result);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.isEmpty() ? 0 : stack.pop();
    }
}
