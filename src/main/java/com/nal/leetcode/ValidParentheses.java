package com.nal.leetcode;

import java.util.Stack;

/**
 * Created by nishant on 05/02/20.
 */
public class ValidParentheses {
    private static final char[][] brackets = {{'(', ')'}, {'{', '}'}, {'[', ']'}};

    public boolean isValid(String s) {
        if (s == null || s.length() == 0)
            return true;

        if(s.length() % 2 == 1)
            return false;

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (isOpenBracket(s.charAt(i))) {
                stack.push(s.charAt(i));
            } else {
                if (stack.isEmpty())
                    return false;
                char open = stack.pop();
                char close = s.charAt(i);
                if (!isValidCloseBracket(open, close))
                    return false;
            }
        }
        return stack.isEmpty();
    }

    private boolean isOpenBracket(char c) {
        for (char[] bracket : brackets) {
            if (bracket[0] == c)
                return true;
        }
        return false;
    }

    private boolean isValidCloseBracket(char open, char close) {
        for (char[] bracket : brackets) {
            if (bracket[0] == open && bracket[1] == close)
                return true;
        }
        return false;
    }
}
