package com.nal.leetcode.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nishant on 30/03/20.
 * 1222. Queens That Can Attack the King
 * On an 8x8 chessboard, there can be multiple Black Queens and one White King.
 * Given an array of integer coordinates queens that represents the positions of the Black Queens, and a pair of coordinates king that represent the position of the White King, return the coordinates of all the queens (in any order) that can attack the King.
 * Example 1:
 * Input: queens = [[0,1],[1,0],[4,0],[0,4],[3,3],[2,4]], king = [0,0]
 * Output: [[0,1],[1,0],[3,3]]
 */
public class QueensThatCanAttackTheKing {

    public static void main(String[] args) {
        QueensThatCanAttackTheKing solution = new QueensThatCanAttackTheKing();
        int[][] queens = new int[][] {{0,1},{1,0},{4,0},{0,4},{3,3},{2,4}};
        int[] king = new int[] {0,0};
        List<List<Integer>> lists = solution.queensAttacktheKing(queens, king);
        System.out.println(lists);
    }

    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[][] board = new boolean[8][8];
        for (int[] queen : queens) {
            board[queen[0]][queen[1]] = true;
        }
        int[] dirs = new int[]{-1, 0, 1};
        for (int x : dirs) {
            for (int y : dirs) {
                if (x == 0 && y == 0)
                    continue;
                findAllQueens(board, king[0], king[1], x, y, result);
            }
        }
        return result;
    }

    private void findAllQueens(boolean[][] board, int row, int col, int r, int c, List<List<Integer>> result) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return;
        }
        if (board[row][col]) {
            List<Integer> res = new ArrayList<>();
            res.add(row);
            res.add(col);
            result.add(res);
            return;
        }
        findAllQueens(board, row + r, col + c, r, c, result);
    }
}
