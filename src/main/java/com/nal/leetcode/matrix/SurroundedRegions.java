package com.nal.leetcode.matrix;

/**
 * Created by nishant on 30/03/20.
 * 130. Surrounded Regions
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 * Example:
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * After running your function, the board should be:
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 */
public class SurroundedRegions {
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0)
            return;

        int rows = board.length;
        int cols = board[0].length;
        for (int i = 0; i < cols; i++) {
            if (board[0][i] == 'O') {
                fillRegion(board, 0, i, rows, cols);
            }
            if (board[rows - 1][i] == 'O') {
                fillRegion(board, rows - 1, i, rows, cols);
            }
        }
        for (int i = 0; i < rows; i++) {
            if (board[i][0] == 'O') {
                fillRegion(board, i, 0, rows, cols);
            }
            if (board[i][cols - 1] == 'O') {
                fillRegion(board, i, cols - 1, rows, cols);
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == '*') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void fillRegion(char[][] board, int r, int c, int rows, int cols) {
        if (r < 0 || r >= rows || c < 0 || c >= cols || board[r][c] != 'O')
            return;

        board[r][c] = '*';
        fillRegion(board, r - 1, c, rows, cols);
        fillRegion(board, r + 1, c, rows, cols);
        fillRegion(board, r, c - 1, rows, cols);
        fillRegion(board, r, c + 1, rows, cols);

    }
}
