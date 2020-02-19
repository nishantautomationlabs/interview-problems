package com.nal.leetcode.matrix;

/**
 * Created by nishant on 11/02/20.
 * 73. Set Matrix Zeroes
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.
 */
public class SetMatrixZeroes {

     //Constant space
    public void setZeroes2(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return;

        int rows = matrix.length, cols = matrix[0].length;
        boolean firstRowZero = false;
        boolean firstColZero = false;
        for (int i = 0; i < rows; i++)
            if (matrix[i][0] == 0) {
                firstColZero = true;
                break;
            }
        for (int j = 0; j < cols; j++)
            if (matrix[0][j] == 0) {
                firstRowZero = true;
                break;
            }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (firstColZero) {
            for (int i = 0; i < rows; i++)
                matrix[i][0] = 0;
        }

        if (firstRowZero) {
            for (int j = 0; j < cols; j++)
                matrix[0][j] = 0;
        }
    }

//    O(m + n) space
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return;
        int rows = matrix.length, cols = matrix[0].length;
        int[] rowpos = new int[rows];
        int[] colpos = new int[cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    rowpos[i] = 1;
                    colpos[j] = 1;
                }
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (rowpos[i] == 1 || colpos[j] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
