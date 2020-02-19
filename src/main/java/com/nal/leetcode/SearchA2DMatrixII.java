package com.nal.leetcode;

/**
 * Created by nishant on 03/02/20.
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
