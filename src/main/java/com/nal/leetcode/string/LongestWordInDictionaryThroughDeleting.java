package com.nal.leetcode.string;

import java.util.*;

/**
 * Created by nishant on 15/02/20.
 * 524. Longest Word in Dictionary through Deleting
 * Given a string and a string dictionary, find the longest string in the dictionary that can be formed by deleting some characters of the given string. If there are more than one possible results, return the longest word with the smallest lexicographical order. If there is no possible result, return the empty string.
 * Example 1:
 * Input:
 * s = "abpcplea", d = ["ale","apple","monkey","plea"]
 * Output:
 * "apple"
 */
public class LongestWordInDictionaryThroughDeleting {
    public String findLongestWord(String s, List<String> d) {
        if (d == null || d.size() == 0 || s == null || s.length() == 0)
            return "";
        String result = "";
        int maxLength = 0;
        Map<Character, List<Integer>> strMap = createStrMap(s);
        for (String word : d) {
            if ((word.length() > maxLength || (word.length() == maxLength && word.compareTo(result) < 0))
                    && isSubString(strMap, word)) {
                result = word;
                maxLength = word.length();
            }
        }
        return result;
    }

    private Map<Character, List<Integer>> createStrMap(String str) {
        Map<Character, List<Integer>> result = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!result.containsKey(c)) {
                result.put(c, new ArrayList<>());
            }
            result.get(c).add(i);
        }
        return result;
    }

    private boolean isSubString(Map<Character, List<Integer>> strMap, String word) {
        int index = -1;
        for (char c : word.toCharArray()) {
            if (!strMap.containsKey(c)) {
                return false;
            }
            List<Integer> indexes = strMap.get(c);
            index = searchIndex(indexes, index + 1);
            if (index == -1) {
                return false;
            }
        }
        return true;
    }

    private int searchIndex(List<Integer> indexes, int index) {
        int res = Collections.binarySearch(indexes, index);
        if (res < 0) {
            res = -(res + 1);
        }
        if (res >= indexes.size()) {
            return -1;
        }
        return indexes.get(res);
    }

    private int searchIndex2(List<Integer> indexes, int index) {
        int start = 0;
        int end = indexes.size() - 1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(indexes.get(mid) == index) {
                return indexes.get(mid);
            }
            else if(indexes.get(mid) < index) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        return start >= indexes.size() || indexes.get(start) < index ? -1 : indexes.get(start);
    }

        private String findLongestWord2(String str, String[] dic) {
        if(dic == null || dic.length == 0 || str == null || str.length() == 0)
            return null;
        String result = null;
        int maxLength = 0;
        for(String word : dic) {
            if(word.length() > maxLength && isSubString2(str, word)) {
                result = word;
                maxLength = word.length();
            }
        }
        return result;
    }

    private boolean isSubString2(String str, String word) {
        int j = 0;
        for(int i = 0; i < str.length() && j < word.length(); i++) {
            if(str.charAt(i) == word.charAt(j)) {
                j++;
            }
        }
        return j == word.length();
    }
}
