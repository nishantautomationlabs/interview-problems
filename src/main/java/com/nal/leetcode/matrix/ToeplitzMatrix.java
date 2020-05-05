package com.nal.leetcode.matrix;

/**
 * Created by nishant on 02/02/20.
 * 766. Toeplitz Matrix
 * A matrix is Toeplitz if every diagonal from top-left to bottom-right has the same element.
 * Now given an M x N matrix, return True if and only if the matrix is Toeplitz.
 * Example 1:
 * Input:
 * matrix = [
 *   [1,2,3,4],
 *   [5,1,2,3],
 *   [9,5,1,2]
 * ]
 * Output: True
 */
public class ToeplitzMatrix {

    public boolean isToeplitzMatrix(int[][] matrix) {
        if(matrix == null)
            return true;

        int rows = matrix.length;
        int cols = matrix[0].length;

        for(int i = 1; i < matrix.length; i++)
        {
            for(int j = 1; j < matrix[i].length; j++)
            {
                if(matrix[i][j] != matrix[i-1][j-1])
                    return false;
            }
        }
        return true;
    }
}
