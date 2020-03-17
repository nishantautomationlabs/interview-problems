package com.nal.leetcode.string;

import java.util.Stack;

/**
 * Created by nishant on 14/03/20.
 * 1047. Remove All Adjacent Duplicates In String
 * Given a string S of lowercase letters, a duplicate removal consists of choosing two adjacent and equal letters, and removing them.
 * We repeatedly make duplicate removals on S until we no longer can.
 * Return the final string after all such duplicate removals have been made.  It is guaranteed the answer is unique.
 * Example 1:
 * Input: "abbaca"
 * Output: "ca"
 */
public class RemoveAllAdjacentDuplicatesInString {
    public String removeDuplicates(String S) {
        if(S == null || S.length() <= 1) {
            return S;
        }

        Stack<Character> stack = new Stack<>();
        for(char c : S.toCharArray()) {
            if(!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            }
            else
                stack.push(c);
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        return sb.toString();
    }
}
