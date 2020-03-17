package com.nal.leetcode.matrix;

/**
 * Created by nishant on 17/03/20.
 */
public class TicTacToe {
    int size;
    int[] rowSum;
    int[] colSum;
    int diagonal;
    int antidiagonal;

    public TicTacToe(int n) {
        size = n;
        rowSum = new int[n];
        colSum = new int[n];
        diagonal = 0;
        antidiagonal = 0;
    }

    public int move(int row, int col, int player) {
        int playerVal = player == 1 ? 1 : -1;
        rowSum[row] += playerVal;
        colSum[col] += playerVal;
        if(row == col)
            diagonal += playerVal;
        if(row + col == size)
            antidiagonal += playerVal;

        if(Math.abs(rowSum[row]) == size ||
                Math.abs(colSum[col]) == size ||
                Math.abs(diagonal) == size ||
                Math.abs(antidiagonal) == size) {
            return player;
        }
        return 0;
    }
}
