package com.nal.leetcode.string;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by nishant on 16/03/20.
 * 1119. Remove Vowels from a String
 */
public class RemoveVowelsFromAString {

    public static void main(String[] args) {
        RemoveVowelsFromAString vowelsFromAString = new RemoveVowelsFromAString();
        String input = "asasasssafdf";
        String result = vowelsFromAString.removeVowels(input);
        System.out.println(result);

        //using String replaceAll
        result = input.replaceAll("[aeiou]", "");
        System.out.println(result);
    }

    private String removeVowels(String S) {
        if (S == null || S.length() == 0)
            return S;

        HashSet<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        StringBuilder sb = new StringBuilder(S);
        for (int i = 0; i < sb.length(); i++) {
            if (vowels.contains(sb.charAt(i))) {
                sb.deleteCharAt(i);
            }
        }
        return sb.toString();
    }
}
