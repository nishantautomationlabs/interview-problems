package com.nal.leetcode;

import java.util.List;
import java.util.ArrayList;

/**
 * Created by nishant on 04/02/20.
 */
public class LetterCombinationsOfAPhoneNumber {

    public static final String[] MAPPING = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

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
