package com.nal.leetcode.matrix;

/**
 * Created by nishant on 14/03/20.
 * 867. Transpose Matrix
 * Given a matrix A, return the transpose of A.
 * The transpose of a matrix is the matrix flipped over it's main diagonal, switching the row and column indices of the matrix.
 * Example 1:
 * Input: [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [[1,4,7],[2,5,8],[3,6,9]]
 */
public class TransposeMatrix {
    public int[][] transpose(int[][] A) {
        if (A == null || A.length == 0 || A[0].length == 0)
            return A;

        int rows = A.length;
        int cols = A[0].length;
        int[][] result = new int[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[j][i] = A[i][j];
            }
        }
        return result;
    }
}
