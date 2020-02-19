package com.nal.leetcode;

import java.util.*;

/**
 * Created by nishant on 04/02/20.
 */
public class WordLadder {

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
