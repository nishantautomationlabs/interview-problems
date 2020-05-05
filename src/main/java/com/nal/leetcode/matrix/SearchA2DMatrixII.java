package com.nal.leetcode.matrix;

/**
 * Created by nishant on 03/02/20.
 * 240. Search a 2D Matrix II
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * Integers in each row are sorted in ascending from left to right.
 * Integers in each column are sorted in ascending from top to bottom.
 * Example:
 * Consider the following matrix:
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 */
public class SearchA2DMatrixII {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
        int rows = 0;
        int cols = matrix[0].length - 1;

        while (rows < matrix.length && cols >= 0) {
            if (target == matrix[rows][cols])
                return true;
            else if (target > matrix[rows][cols])
                rows++;
            else
                cols--;
        }
        return false;
    }
}
