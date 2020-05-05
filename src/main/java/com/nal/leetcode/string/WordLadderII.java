package com.nal.leetcode.string;

import java.util.*;

/**
 * Created by nishant on 07/04/20.
 * 126. Word Ladder II
 * Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s) from beginWord to endWord, such that:
 * Only one letter can be changed at a time
 * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 * Note:
 * Return an empty list if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 * Example 1:
 * Input:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * Output:
 * [
 * ["hit","hot","dot","dog","cog"],
 * ["hit","hot","lot","log","cog"]
 * ]
 */
public class WordLadderII {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        List<List<String>> result = new ArrayList<>();
        Set<String> wordDict = new HashSet<>(wordList);

        Queue<Path> queue = new LinkedList<>();
        List<String> beginPath = new ArrayList<>();
        beginPath.add(beginWord);
        queue.add(new Path(beginWord, beginPath));
        boolean stop = false;

        while (!queue.isEmpty() && !stop) {
            List<String> neighborsToRemove = new ArrayList();

            for (int i = queue.size() - 1; i >= 0; i--) {
                Path p = queue.poll();
                if (p.val.equals(endWord)) {
                    result.add(p.path);
                    stop = true;
                }

                List<String> neighbors = neighbors(p.val, wordDict);
                neighborsToRemove.addAll(neighbors);
                for (String neighbor : neighbors) {
                    ArrayList<String> path = new ArrayList<>(p.path);
                    path.add(neighbor);
                    queue.add(new Path(neighbor, path));
                }
            }

            for (String nei : neighborsToRemove) {
                wordDict.remove(nei);
            }
        }
        return result;
    }

    private class Path {
        String val;
        List<String> path;

        public Path(String value, List<String> path) {
            this.val = value;
            this.path = path;
        }
    }

    public List<String> neighbors(String s, Set<String> wordDict) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char[] chars = s.toCharArray();
            for (char ch = 'a'; ch <= 'z'; ch++) {
                chars[i] = ch;
                String word = new String(chars);
                if (wordDict.contains(word)) {
                    res.add(word);
                }
            }
        }
        return res;
    }
}
