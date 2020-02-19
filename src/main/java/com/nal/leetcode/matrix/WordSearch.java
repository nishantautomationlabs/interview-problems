package com.nal.leetcode.matrix;

/**
 * Created by nishant on 10/02/20.
 * 79. Word Search
 * Given a 2D board and a word, find if the word exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
 * Example:
 * board =
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * Given word = "ABCCED", return true.
 * Given word = "SEE", return true.
 * Given word = "ABCB", return false.
 */
public class WordSearch {

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0)
            return false;

        int rows = board.length, cols = board[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (exist(board, word, 0, i, j))
                    return true;
            }
        }
        return false;
    }

    private boolean exist(char[][] board, String word, int index, int i, int j) {
        if (index == word.length())
            return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || word.charAt(index) != board[i][j])
            return false;
        char c = board[i][j];
        board[i][j] = '#';
        boolean result = exist(board, word, index + 1, i - 1, j) ||
                exist(board, word, index + 1, i + 1, j) ||
                exist(board, word, index + 1, i, j - 1) ||
                exist(board, word, index + 1, i, j + 1);
        board[i][j] = c;
        return result;
    }
}
