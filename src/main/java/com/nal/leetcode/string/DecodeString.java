package com.nal.leetcode.string;

import java.util.Stack;

/**
 * Created by nishant on 16/02/20.
 * 394. Decode String
 * Given an encoded string, return its decoded string.
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
 * You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
 * Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].
 * Examples:
 * s = "3[a]2[bc]", return "aaabcbc".
 * s = "3[a2[c]]", return "accaccacc".
 * s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 */
public class DecodeString {
    public static void main(String[] args) {
        String input = "3[a]2[bc]";
        DecodeString sol = new DecodeString();
        System.out.println(sol.decodeString(input));
    }

    public String decodeString(String s) {
        if(s == null || s.length() == 0)
            return "";

        Stack<Integer> numbers = new Stack<>();
        Stack<String> words = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            char c  = s.charAt(i);
            if(c == '[') {
                words.push(sb.toString());
                sb = new StringBuilder();
            }
            else if(c == ']') {
                int count = numbers.pop();
                StringBuilder temp = new StringBuilder();
                if(words.size() > 0) {
                    temp.append(words.pop());
                }
                for(int j = 0; j < count; j++) {
                    temp.append(sb.toString());
                }
                sb = new StringBuilder(temp.toString());
            }
            else if(Character.isDigit(c)) {
                int value = 0;
                while(Character.isDigit(s.charAt(i))) {
                    value = value * 10 + s.charAt(i++) - '0';
                }
                i--;
                numbers.push(value);
            }
            else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
