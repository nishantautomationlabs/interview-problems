package com.nal.leetcode.string;

import java.util.HashSet;

/**
 * Created by nishant on 14/03/20.
 * 804. Unique Morse Code Words
 * International Morse Code defines a standard encoding where each letter is mapped to a series of dots and dashes, as follows: "a" maps to ".-", "b" maps to "-...", "c" maps to "-.-.", and so on.
 * For convenience, the full table for the 26 letters of the English alphabet is given below:
 * [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
 * Now, given a list of words, each word can be written as a concatenation of the Morse code of each letter. For example, "cba" can be written as "-.-..--...", (which is the concatenation "-.-." + "-..." + ".-"). We'll call such a concatenation, the transformation of a word.
 * Return the number of different transformations among all words we have.
 * Example:
 * Input: words = ["gin", "zen", "gig", "msg"]
 * Output: 2
 */
public class UniqueMorseCodeWords {
    public int uniqueMorseRepresentations(String[] words) {
        if (words == null || words.length == 0)
            return 0;

        HashSet<String> transformedWords = new HashSet<>();
        for (String word : words) {
            transformedWords.add(getMorseCode(word));
        }
        return transformedWords.size();
    }

    private String getMorseCode(String word) {
        String[] codes = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

        StringBuilder result = new StringBuilder();
        for (char c : word.toCharArray()) {
            result.append(codes[c - 'a']);
        }
        return result.toString();
    }
}
