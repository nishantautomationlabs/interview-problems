package com.nal.leetcode.matrix;

import java.util.HashSet;

/**
 * Created by nishant on 29/03/20.
 * 36. Valid Sudoku
 * Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0)
            return false;

        int rows = board.length;
        int cols = board[0].length;

        HashSet<String> uniqueValues = new HashSet<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == '.')
                    continue;
                if (!uniqueValues.add("Col " + j + " has value " + board[i][j]))
                    return false;
                if (!uniqueValues.add("Row " + i + " has value " + board[i][j]))
                    return false;
                if (!uniqueValues.add("Box " + i / 3 + "-" + j / 3 + " has value " + board[i][j]))
                    return false;
            }
        }
        return true;
    }
}
