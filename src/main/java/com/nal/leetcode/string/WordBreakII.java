package com.nal.leetcode.string;

import java.util.*;

/**
 * Created by nishant on 07/05/20.
 * 140. Word Break II
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences.
 * Note:
 * The same word in the dictionary may be reused multiple times in the segmentation.
 * You may assume the dictionary does not contain duplicate words.
 * Example 1:
 * Input:
 * s = "catsanddog"
 * wordDict = ["cat", "cats", "and", "sand", "dog"]
 * Output:
 * [
 *   "cats and dog",
 *   "cat sand dog"
 * ]
 */
public class WordBreakII {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        HashMap<String, List<String>> hashMap = new HashMap<>();

        for (String word : wordDict) {
            set.add(word);
        }
//        wordBreakUsingQueue(s, set, result);
//        return result;
        return wordBreakUsingRecursionAndMemoization(s, set, hashMap);
    }

    class Option {
        int index;
        List<String> listOfWords;

        public Option(int index, List<String> listOfWords) {
            this.index = index;
            this.listOfWords = new ArrayList<>();
            this.listOfWords.addAll(listOfWords);
        }
    }

    //Time limit exceeds
    private void wordBreakUsingQueue(String string, Set<String> set, List<String> result) {
        Queue<Option> optionQueue = new LinkedList<>();
        Option startOption = new Option(0, new ArrayList<>());
        optionQueue.add(startOption);

        while (!optionQueue.isEmpty()) {
            Option option = optionQueue.poll();
            if (option.index >= string.length()) {
                result.add(String.join(" ", option.listOfWords));
            }
            for (int i = option.index + 1; i <= string.length(); i++) {
                String word = string.substring(option.index, i);
                if (set.contains(word)) {
                    Option newOption = new Option(i, option.listOfWords);
                    newOption.listOfWords.add(word);
                    optionQueue.add(newOption);
                }
            }
        }
    }

    private List<String> wordBreakUsingRecursionAndMemoization(String string, Set<String> set, HashMap<String, List<String>> memo) {

        if (string.equals("")) {
            ArrayList<String> strings = new ArrayList<>();
            strings.add("");
            return strings;
        } else if (memo.containsKey(string))
            return memo.get(string);

        List<String> result = new ArrayList<>();
        for (int i = 1; i <= string.length(); i++) {
            if (set.contains(string.substring(0, i))) {
                List<String> stringList = wordBreakUsingRecursionAndMemoization(string.substring(i), set, memo);
                for (String str : stringList) {
                    result.add((string.substring(0, i) + " " + str).trim());
                }
            }
        }
        memo.put(string, result);
        return result;
    }
}
