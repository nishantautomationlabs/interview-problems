package com.nal.leetcode.string;

import java.util.List;
import java.util.ArrayList;

/**
 * Created by nishant on 04/02/20.
 * 17. Letter Combinations of a Phone Number
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 * Example:
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
public class LetterCombinationsOfAPhoneNumber {

    public static final String[] MAPPING = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

//    O(3^N * 4^M) N - no in string digit which maps to 3 char number and M - no of digits which maps to 4 char number
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0)
            return result;
        StringBuilder sb = new StringBuilder();
        createCombinations(digits, 0, result, sb);
        return result;
    }

    private void createCombinations(String digits, int index, List<String> result, StringBuilder sb) {
        if (index == digits.length()) {
            result.add(sb.toString());
            return;
        }
        for (char c : MAPPING[digits.charAt(index) - '0'].toCharArray()) {
            createCombinations(digits, index + 1, result, sb.append(c));
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
