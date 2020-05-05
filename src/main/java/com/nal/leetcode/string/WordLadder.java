package com.nal.leetcode.string;

import java.util.*;

/**
 * Created by nishant on 04/02/20.
 * 127. Word Ladder
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:
 * Only one letter can be changed at a time.
 * Each transformed word must exist in the word list.
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 * Example 1:
 * Input:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * Output: 5
 */
public class WordLadder {

//    O(LN) - L is the average length of the word and N is the number of words in the wordList
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord))
            return 0;
        int level = 0;
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);

        while (!queue.isEmpty()) {
            level++;
            for (int k = queue.size() - 1; k >= 0; k--) {
                String word = queue.poll();
                if (word.equals(endWord))
                    return level;
                for (int i = 0; i < word.length(); i++) {
                    char[] chars = word.toCharArray();
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        chars[i] = ch;
                        String s = new String(chars);
                        if (set.contains(s) && !s.equals(word)) {
                            queue.add(s);
                            set.remove(s);
                        }
                    }
                }
            }
        }
        return 0;
    }
}
